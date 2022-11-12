package com.project.autoparkweb.views.main;

import com.project.autoparkweb.views.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@PageTitle("Autopark")
@RolesAllowed("USER")
@Route(value = "", layout = MainView.class)
public class OrganizationView  extends VerticalLayout {

}
