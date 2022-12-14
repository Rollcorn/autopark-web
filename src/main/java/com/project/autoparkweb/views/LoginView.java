package com.project.autoparkweb.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.Collections;

@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
	// TODO Might be replaced by custom login form
	private final LoginForm loginForm = new LoginForm();
	
	public LoginView() {
		addClassName("login-view");
		setSizeFull();
		
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);
		
		loginForm.setAction("login");
		
		add(new H1("Autopark Login Page"), loginForm);
	}
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (event.getLocation()
		         .getQueryParameters()
		         .getParameters()
		         .getOrDefault("error", Collections.emptyList()).isEmpty()) {
			loginForm.setError(true);
		}
	}
}
