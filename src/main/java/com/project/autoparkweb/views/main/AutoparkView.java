package com.project.autoparkweb.views.main;

import com.project.autoparkweb.mvc.VehicleService;
import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.vaadin.flow.component.charts.model.Title;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Autopark")
@Route(value = "/autopark")
public class AutoparkView extends VerticalLayout {
    private final VehicleService vehicleService;
    private Grid<Vehicle> vehicleGrid = new Grid<>(Vehicle.class);
    private Grid<CarBrand> brandGrid = new Grid<>(CarBrand.class);

    @Autowired
    public AutoparkView(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        add("AUTOPARKS VEHICLES");
        add(vehicleGrid);
        vehicleGrid.setItems(vehicleService.getAllVehicles());
        add("ALL BRANDS WE HAVE");
        add(brandGrid);
        brandGrid.setItems(vehicleService.getAllBrands());
    }
}

