package ciclo.vida.training.command.controller;

import ciclo.vida.training.command.constants.CicloVidaTrainingCommandPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;

/**
 * @author jfernach
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample", //
			"com.liferay.portlet.instanceable=true", //
			"com.liferay.portlet.header-portlet-css=/css/main.css", //
			"com.liferay.portlet.header-portlet-javascript=/js/main.js", //
			"com.liferay.portlet.css-class-wrapper=ciclovida-avanzado-portlet", //
			"javax.portlet.display-name=ciclo-vida-training-command Portlet", //
			"javax.portlet.init-param.template-path=/", //
			"javax.portlet.init-param.view-template=/view.jsp", //
			"javax.portlet.name=" + CicloVidaTrainingCommandPortletKeys.CICLO_VIDA_TRAINING_COMMAND, //
			"javax.portlet.resource-bundle=content.Language", //
			"javax.portlet.security-role-ref=power-user,user", //
			"javax.portlet.supported-processing-event=message;ciclovida" //
	},
	service = Portlet.class
)
public class CicloVidaTrainingCommandPortlet extends MVCPortlet {


	@ProcessEvent(qname = "{ciclovida}message")
	public void receivedEvent(EventRequest eventRequest, EventResponse eventResponse) throws  IOException, PortletException{
		Event event = eventRequest.getEvent();
		String message = (String) event.getValue();

		System.out.println("Recibidor de Eventos");
		eventResponse.getRenderParameters().setValue(CicloVidaTrainingCommandPortletKeys.MESSAGE_RECEIVED, message);
	}
	
}