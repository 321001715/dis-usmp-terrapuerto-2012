<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="mantenerCliente">
<s:textfield name="producto.codProd" label="Codigo" readonly="true"/>
<s:textfield name="producto.nomProd" label="Nombre"/>	
<s:radio name="producto.tipoProd" label="Tipo Producto" list="#{'B':'Balones','G':'Granel'}" value="'B'"/>
<s:select name="producto.unidadmedida.idUnimed" label="Unidad medida" list="unidadmedidas" listKey="idUnimed" listValue="nombreUnimed" required="true" onselect="true" />
<s:submit  method="registrar" align="center" value="Registrar" />
</s:form> 

