package com.project.autoparkweb.views.main;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.pojo.VehiclePojo;
import com.project.autoparkweb.mvc.model.services.VehicleService;
//import com.project.autoparkweb.views.MainLayout;
import com.project.autoparkweb.views.MainView;
import com.project.autoparkweb.views.components.VehicleEditor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;


@PageTitle("Autopark")
@RolesAllowed("ADMIN")
@Route(value = "/autopark", layout = MainView.class)
public class AutoparkView extends VerticalLayout {
    private final VehicleService vehicleService;
    private final VehicleEditor vehicleEditor;
    private Grid<Vehicle> vehicleGrid = new Grid<>(Vehicle.class);
    private Grid<CarBrand> brandGrid = new Grid<>(CarBrand.class);
    
    private final TextField filter = new TextField("","Type to filter");
    private final Button addNewButton = new Button("New vehicle", VaadinIcon.PLUS.create());
    private final HorizontalLayout toolBar = new HorizontalLayout(filter, addNewButton);
    
    @Autowired
    public AutoparkView(VehicleService vehicleService, VehicleEditor editor) {
        this.vehicleService = vehicleService;
        this.vehicleEditor = editor;
        
        add("AUTOPARKS VEHICLES");
        add(toolBar, vehicleGrid, this.vehicleEditor);
        
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(event -> showVehicles(event.getValue()));
        
        vehicleGrid.asSingleSelect().addValueChangeListener(event -> {
            vehicleEditor.editVehicle(event.getValue());
        });
        addNewButton.addClickListener(e -> vehicleEditor.editVehicle(new Vehicle()));
        
        vehicleEditor.setChangeHandler(() -> {
            vehicleEditor.setVisible(false);
            showVehicles(filter.getValue());
        });
        
        showVehicles( "");
        
        add("ALL BRANDS WE HAVE");
        add(brandGrid);
        brandGrid.setItems(vehicleService.getAllBrands());
    }
    
    private void showVehicles(String name) {
        if (name == null || name.isEmpty()) {
            vehicleGrid.setItems(vehicleService.getAllVehicles());
        } else {
            vehicleGrid.setItems(vehicleService.getVehicleByName(name));
        }
    }
}
