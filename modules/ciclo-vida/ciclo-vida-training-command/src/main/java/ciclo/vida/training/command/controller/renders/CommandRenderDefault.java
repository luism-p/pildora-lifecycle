package ciclo.vida.training.command.controller.renders;

import ciclo.vida.training.command.constants.CicloVidaTrainingCommandPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + CicloVidaTrainingCommandPortletKeys.CICLO_VIDA_TRAINING_COMMAND
				,"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)
public class CommandRenderDefault implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		renderResponse.reset();
		String messageEvent = ParamUtil.getString(renderRequest,CicloVidaTrainingCommandPortletKeys.MESSAGE_RECEIVED, StringPool.BLANK);
		if(Validator.isNotNull(messageEvent)){
			renderRequest.setAttribute(CicloVidaTrainingCommandPortletKeys.MESSAGE_RECEIVED, messageEvent);
			System.out.println("Render por defecto cargado desde event");
		}else{
			System.out.println("Este es el render por defecto que carga el view.jsp");
		}
		
		return "/view.jsp";
	}

}
