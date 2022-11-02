package com.project.autoparkweb.views.components;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.repository.CarBrandRepository;
import com.project.autoparkweb.mvc.model.repository.VehicleRepository;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringComponent
@UIScope
public class VehicleEditor extends VerticalLayout implements KeyNotifier  {
    private final VehicleRepository vehicleRepository;
    private final CarBrandRepository carBrandRepository;

    private Vehicle vehicle;
    private ComboBox<CarBrand> idCarBrand = new ComboBox("Car brand");

    private TextField carId = new TextField("Car ID");
    private TextField mileage = new TextField("Mileage");
    private TextField owner = new TextField("owner");
    private TextField price = new TextField("Price");
    private TextField releaseDate = new TextField("Release Date");

    private Button save = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    private Binder<Vehicle> binder = new Binder<>(Vehicle.class);
    @Setter
    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    @Autowired
    public VehicleEditor(VehicleRepository vehicleRepository, CarBrandRepository carBrandRepository) {
        this.vehicleRepository = vehicleRepository;
        this.carBrandRepository = carBrandRepository;

        List<CarBrand> carsBrands = carBrandRepository.findAll();
        Map<Long, CarBrand> carBrandMap = new HashMap<>();
        carsBrands.forEach(carBrand -> carBrandMap.put(carBrand.getBrandId(), carBrand));
//        idCarBrand.setItems(carsBrands.stream().map(CarBrand::getCarBrandName).collect(Collectors.toList()));
        idCarBrand.setItems(carsBrands);

        add(idCarBrand, carId, mileage, owner, price, releaseDate, actions);

        binder.bindInstanceFields(this);
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editVehicle(vehicle));
        setVisible(false);
    }

    public void editVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            setVisible(false);
            return;
        }
        if (vehicle.getVehicleId() != null) {
            this.vehicle = vehicleRepository.findById(vehicle.vehicleId).orElse(vehicle);
        } else {
            this.vehicle = vehicle;
        }
        binder.setBean(vehicle);
        setVisible(true);
        releaseDate.focus();
    }

    private void delete() {
        vehicleRepository.delete(vehicle);
        changeHandler.onChange();
    }

    private void save() {
//        Vehicle newVehicle = new Vehicle();
        if (vehicle.idCarBrand == null) {
            vehicle.setIdCarBrand(idCarBrand.getValue());
        }
        vehicleRepository.save(vehicle);
        changeHandler.onChange();
    }
}
