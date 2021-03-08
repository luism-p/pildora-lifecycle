<%@ include file="./init.jsp" %>

<liferay-ui:success key="success" message="Greeting saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your greeting"/>


<h1>Vista 3</h1>

<portlet:renderURL var="renderDefault" />


<aui:button-row cssClass="d-flex justify-content-center">
    <aui:button type="button" name="render-default" onClick="${renderDefault}" value="Vista por defecto"/>
</aui:button-row>