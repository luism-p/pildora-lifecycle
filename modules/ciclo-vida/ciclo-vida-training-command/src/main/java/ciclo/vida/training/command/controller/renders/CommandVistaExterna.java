package ciclo.vida.training.command.controller.renders;

import ciclo.vida.training.command.constants.CicloVidaTrainingCommandPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.ciclovida.event.constants.CicloVidaEventPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + CicloVidaTrainingCommandPortletKeys.CICLO_VIDA_TRAINING_COMMAND, //
				"javax.portlet.name=" + CicloVidaEventPortletKeys.CICLOVIDAEVENT, //
				"mvc.command.name=event/render/portlet" //
		},
		service = MVCRenderCommand.class
	)
public class CommandVistaExterna implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String param = ParamUtil.getString(renderRequest,"param", StringPool.BLANK);
		System.out.println("Este es el render command de viewExterna.jsp y tre el par&aacute;metro: " +param);
		return "/viewExterna.jsp";
	}

}
