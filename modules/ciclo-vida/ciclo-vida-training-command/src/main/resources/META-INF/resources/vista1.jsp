<%@ include file="./init.jsp" %>

<h1>Vista 1</h1>

<br>
<h3 class="resourceCommand"></h3>
<br>

<portlet:resourceURL id="resource1Command" var="resource1URL"/>
<portlet:renderURL var="renderDefault" />

<aui:button-row cssClass="d-flex justify-content-center">
    <aui:button type="button" name="resourceCommand" onClick="getResourceCommand ()" value="LLamar a resourceCommand"/>
    <aui:button type="button" name="render-default" onClick="${renderDefault}" value="Vista por defecto"/>
</aui:button-row>

<script>
    function getResourceCommand () {
        AUI().use('aui-io-request', function (A) {
            A.io.request('${resource1URL}', {
                method: 'get',
                dataType: 'text',
                data: {},
                on: {
                    success: function () {
                        const json = JSON.parse(this.get('responseData'));
                        console.dir(json);
                        $('.resourceCommand').text(json.hasOwnProperty('respuesta')?json.respuesta:'');
                    }
                }
            });
        });
    }
</script>