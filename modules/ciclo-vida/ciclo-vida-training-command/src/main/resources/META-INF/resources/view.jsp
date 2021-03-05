<%@ include file="/META-INF/resources/init.jsp" %>

<portlet:renderURL var="vista1URL" >
	<portlet:param name="mvcRenderCommandName" value="render1Command" />
</portlet:renderURL>

<portlet:renderURL var="vista2URL" >
	<portlet:param name="mvcRenderCommandName" value="render2Command" />
</portlet:renderURL>

<br>
<h3>${messageReceived}</h3>
<br>

<aui:button-row cssClass="d-flex justify-content-center">
	<aui:button type="button" name="render-first" href="${vista1URL}" value="Vista 1"/>
	<aui:button type="button" name="render-second" href="${vista2URL}" value="Vista 2"/>
</aui:button-row>

