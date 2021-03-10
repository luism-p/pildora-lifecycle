package com.liferay.training.ciclovida.event.controller;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.ciclovida.event.constants.CicloVidaEventPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author LuisMiguelPerezPache
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.css-class-wrapper=ciclovida-event-portlet",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=CicloVidaEvent",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + CicloVidaEventPortletKeys.CICLOVIDAEVENT,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CicloVidaEventPortlet extends MVCPortlet {
}