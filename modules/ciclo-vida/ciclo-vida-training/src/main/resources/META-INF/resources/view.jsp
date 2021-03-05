<%@ include file="./init.jsp" %>


<portlet:actionURL var="actionURL"/>
<portlet:resourceURL var="resourceURL"/>

<br>
<h3 class="resource"></h3>
<br>


<aui:button-row cssClass="d-flex justify-content-center">
    <aui:button type="button" name="render-first" href="${actionURL}" value="LLamar a actionURL"/>
    <aui:button type="button" name="resource" onClick="getResource()" value="LLamar a resourceURL"/>
</aui:button-row>


<script>
    function getResource () {
        AUI().use('aui-io-request', function (A) {
            A.io.request('${resourceURL}', {
                method: 'get',
                dataType: 'text',
                data: {},
                on: {
                    success: function () {
                        var text = this.get('responseData')
                        console.log(text);
                        $('.resource').text(text);
                    }
                }
            });
        });
    }
</script>