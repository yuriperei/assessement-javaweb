<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true" %>
<input id="${id}" name="lancamento" class="form-control" readonly="true" type="datetime"/>
<script>
$( function() {
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
  } );

</script>