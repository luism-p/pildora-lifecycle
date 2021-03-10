package ciclo.vida.training.command.controller.renders;

import ciclo.vida.training.command.constants.CicloVidaTrainingCommandPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
		immediate = true,
		property = {
			
			"javax.portlet.name=" + CicloVidaTrainingCommandPortletKeys.CICLO_VIDA_TRAINING_COMMAND,
			"mvc.command.name=render3Command"
		},
		service = MVCRenderCommand.class
	)
public class CommandVista3Render implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		System.out.println("Este es el render command de vista3.jsp");
		return "/vista3.jsp";
	}

}
