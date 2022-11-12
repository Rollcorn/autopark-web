package com.project.autoparkweb.views;

import com.project.autoparkweb.mvc.model.services.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@AnonymousAllowed
//@CssImport("./styles/views/main/main-view.css")
//@JsModule("./styles/shared-styles.js")
public class MainView extends AppLayout {
	private final SecurityService securityService;

	public MainView(@Autowired SecurityService securityService) {
		this.securityService = securityService;
		createHeader();
	}

	private void createHeader() {
		H1 logo = new H1("Vaadin CRM");
		logo.addClassNames("text-l", "m-m");
		Button logout = new Button("Log out", e -> securityService.logout());
		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

		header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
		header.expand(logo);
		header.setWidth("100%");
		header.addClassNames("py-0", "px-m");

		addToNavbar(header);
	}
}