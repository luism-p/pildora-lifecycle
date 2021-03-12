<%@ page import="com.liferay.training.ciclovida.event.constants.CicloVidaEventPortletKeys" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<portlet:actionURL var="actionEvent" name="event/action" />

<portlet:renderURL var="renderPortlet" >
	<portlet:param name="mvcRenderCommandName" value="event/render/portlet" />
	<portlet:param name="param" value="test" />
</portlet:renderURL>


<aui:button-row cssClass="d-flex justify-content-center">
	<aui:button type="button" name="action-first" href="${actionEvent}" value="Enviar evento"/>
	<aui:button type="button" name="render-portlet" href="${renderPortlet}" value="Render Portlet"/>
</aui:button-row>
