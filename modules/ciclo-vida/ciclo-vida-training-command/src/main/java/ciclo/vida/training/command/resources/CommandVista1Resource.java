package ciclo.vida.training.command.resources;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import ciclo.vida.training.command.constants.CicloVidaTrainingCommandPortletKeys;


@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + CicloVidaTrainingCommandPortletKeys.CICLO_VIDA_TRAINING_COMMAND,
			"mvc.command.name=resource1Command"

		},
		service = MVCResourceCommand.class
	)
public class CommandVista1Resource implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		System.out.println("Llamada a resource1Command");
		
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("respuesta", "Respuesta del serveResourceCommand");
			resourceResponse.getWriter().print(json);
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		return false;
	}

}
