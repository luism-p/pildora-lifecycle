package com.liferay.training.ciclovida.event.controller.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.training.ciclovida.event.constants.CicloVidaEventPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + CicloVidaEventPortletKeys.CICLOVIDAEVENT, //
				"javax.portlet.name=CicloVidaTrainingCommandAdvance", //
				"mvc.command.name=event/action", //
				"javax.portlet.supported-publishing-event=messsage;ciclovida" //
		},
		service = MVCActionCommand.class
	)

public class CommandVista1Action implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		System.out.println("LLamada a action1Command");
		boolean result = Boolean.TRUE;

		QName qName = new QName("ciclovida", "message");

		actionResponse.setEvent(qName, "mensaje enviado mediante evento desde ciclo-vida-training-event");
		
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", "\\");
		
		return result;
	}

}
