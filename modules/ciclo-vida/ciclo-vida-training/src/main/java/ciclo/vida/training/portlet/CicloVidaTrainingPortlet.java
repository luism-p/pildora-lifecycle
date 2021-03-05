package ciclo.vida.training.portlet;

import ciclo.vida.training.constants.CicloVidaTrainingPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.namespace.QName;

/**
 * @author jfernach
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample", //
        "com.liferay.portlet.instanceable=true", //
        "com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.header-portlet-javascript=/js/main.js", "com.liferay.portlet.css-class-wrapper=ciclovida-portlet", "javax.portlet.display-name=ciclo-vida-training Portlet", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + CicloVidaTrainingPortletKeys.CICLO_VIDA_TRAINING, "javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user", "javax.portlet.supported-publishing-event=messsage;ciclovida" }, service = Portlet.class)
public class CicloVidaTrainingPortlet extends MVCPortlet {

    @Override
    public void init(PortletConfig config) throws PortletException {
        System.out.println("Se ha desplegado nuestro Portlet y esto es la llamada al init()");
        super.init(config);
    }

    @Override
    public void destroy() {
        System.out.println("Se ha eliminado el portlet del contenedor y esto es la llamada al destroy()");
        super.destroy();
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        String param1 = ParamUtil.get(renderRequest, "param1", "defaultValue");

        if ("value1".equals(param1)) {
            System.out.println("Render desde action con param1");
        }
        else {
            System.out.println("Render por defecto MVCPortlet");
        }

        super.render(renderRequest, renderResponse);
    }

    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

        System.out.println("Action por defecto MVCPortlet");
        actionResponse.getRenderParameters().setValue("param1", "value1");

        QName qName = new QName("ciclovida", "message");
        actionResponse.setEvent(qName, "mensaje enviado mediante evento desde ciclo-vida-training");
        super.processAction(actionRequest, actionResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
        System.out.println("ServeResource por defecto MVCPortlet");

        resourceResponse.getWriter().println("Respuesta del serveResource");
        resourceResponse.setContentType(ContentTypes.TEXT);
        super.serveResource(resourceRequest, resourceResponse);
    }

}