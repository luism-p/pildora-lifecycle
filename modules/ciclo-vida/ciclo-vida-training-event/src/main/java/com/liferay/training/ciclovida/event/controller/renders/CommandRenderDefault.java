package com.liferay.training.ciclovida.event.controller.renders;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.ciclovida.event.constants.CicloVidaEventPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + CicloVidaEventPortletKeys.CICLOVIDAEVENT //
				,"mvc.command.name=/" //
		},
		service = MVCRenderCommand.class
	)
public class CommandRenderDefault implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String messageEvent = ParamUtil.getString(renderRequest,CicloVidaEventPortletKeys.MESSAGE_RECEIVED, StringPool.BLANK);
		if(Validator.isNotNull(messageEvent)){
			renderRequest.setAttribute(CicloVidaEventPortletKeys.MESSAGE_RECEIVED, messageEvent);
			System.out.println("Render por defecto cargado desde event");
		}else{
			System.out.println("Este es el render por defecto que carga el view.jsp");
		}
		
		return "/view.jsp";
	}

}
