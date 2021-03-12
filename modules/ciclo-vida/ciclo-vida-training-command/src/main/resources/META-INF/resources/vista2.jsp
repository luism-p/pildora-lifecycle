<%@ include file="./init.jsp" %>

<h1>Vista 2</h1>

<portlet:actionURL name="action1Command" var="action1URL"/>

<portlet:renderURL var="renderDefault"/>


<aui:button-row cssClass="d-flex justify-content-center">
    <aui:button type="button" name="action" href="${action1URL}" value="LLamar a actionCommand"/>
    <aui:button type="button" name="render-default" onClick="${renderDefault}" value="Vista por defecto"/>
</aui:button-row>
