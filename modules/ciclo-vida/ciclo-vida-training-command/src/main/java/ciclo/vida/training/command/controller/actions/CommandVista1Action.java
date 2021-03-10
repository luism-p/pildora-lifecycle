package ciclo.vida.training.command.controller.actions;

import ciclo.vida.training.command.constants.CicloVidaTrainingCommandPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + CicloVidaTrainingCommandPortletKeys.CICLO_VIDA_TRAINING_COMMAND,
			"javax.portlet.name=CicloVidaTrainingCommandAdvance",
			"mvc.command.name=action1Command"
		},
		service = MVCActionCommand.class
	)

public class CommandVista1Action implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		System.out.println("LLamada a action1Command");
		boolean result;
		
		if(Math.random()>0.5){
			SessionErrors.add(actionRequest, "error");
			result = false;
			System.out.println("SessionErrors=error");
		}else{
			SessionMessages.add(actionRequest, "success");
			result = true;
			System.out.println("SessionMessages=success");
		}
		
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", "render3Command");
		
		return result;
	}

}
