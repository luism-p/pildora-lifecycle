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

<liferay-ui:success key="success" message="Greeting saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your greeting"/>


<h1>Vista 3</h1>


<aui:button-row cssClass="d-flex justify-content-center">
    <aui:button type="button" name="render-default" href="<%=url%>" value="Vista por defecto"/>
</aui:button-row>