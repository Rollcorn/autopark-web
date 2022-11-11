package com.project.autoparkweb.utill.Security;

import com.project.autoparkweb.views.LoginView;
import com.project.autoparkweb.views.main.AutoparkView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.springframework.stereotype.Component;

@Component
public class ConfigureUIServiceListener implements VaadinServiceInitListener {
	@Override
	public void serviceInit(ServiceInitEvent event) {
		event.getSource().addUIInitListener(uiEvent -> {
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::beforeEnter);
		});
	}
	
	private void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		if (!LoginView.class.equals(beforeEnterEvent.getNavigationTarget()) && !SecurityUtils.isUserLoggedIn()) {
			beforeEnterEvent.rerouteTo(LoginView.class);
		}
	}

}
