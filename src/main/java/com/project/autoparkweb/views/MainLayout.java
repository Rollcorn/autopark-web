package com.project.autoparkweb.views;

import com.project.autoparkweb.utill.Security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
@AnonymousAllowed
public class MainLayout extends AppLayout {
    private SecurityService securityService;
    public MainLayout(@Autowired SecurityService securityService) {
        this.securityService = securityService;
        H1 logo = new H1("Home View");
        logo.addClassName("logo");
        HorizontalLayout header;
        if(securityService.getAuthenticatedUser() != null) {
            Button logout = new Button("Logout", click -> securityService.logout());
            header = new HorizontalLayout(logo, logout);
        } else {
            header = new HorizontalLayout(logo);
        }

        // Other page components omitted.

        addToNavbar(header);
    }
}
