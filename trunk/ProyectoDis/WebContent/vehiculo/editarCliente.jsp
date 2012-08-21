<%@ taglib uri="/struts-tags" prefix="s" %>
<!-- Modificando formularioa -->
<s:form action="mantenerproducto-%{producto.codProd}">
	<s:textfield name="producto.codProd" label="Codigo" readonly="true"/>
	<s:textfield name="producto.nomProd" label="Nombre"/>	
	<s:radio name="producto.tipoProd" label="Tipo Producto" list="#{'B':'Balones','G':'Granel'}" value="'B'"/>
	<s:select name="producto.unidadmedida.idUnimed" label="Unidad medida" list="unidadmedidas" listKey="idUnimed" listValue="nombreUnimed" required="true" onselect="true" />
	<s:submit  method="actualizar" align="center" value="Actualizar" />
</s:form> 