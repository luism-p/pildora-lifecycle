<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="./init.jsp" %>

<%
    String url = "#";
    try {
        url = PortalUtil.getLayoutURL(themeDisplay);
    }
    catch (PortalException e) {
        e.printStackTrace();
    }
%>
<h1>Vista 2</h1>

<portlet:actionURL name="action1Command" var="action1URL"/>


<aui:button-row cssClass="d-flex justify-content-center">
    <aui:button type="button" name="action" href="${action1URL}" value="LLamar a actionCommand"/>
    <aui:button type="button" name="render-default" href="<%=url%>" value="Vista por defecto"/>
</aui:button-row>
