<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="mantenerCliente">

<s:textfield name="cliente.apepatUsu" label="Apellido Paterno" />
<s:textfield name="cliente.apematUsu" label="apellido Materno"/>
<s:textfield name="cliente.nombreUsu" label="Nombres"/>	
<s:textfield name="cliente.dirUsu" label="Direccion"/>
<s:textfield name="cliente.distVend" label="Distrito"/>
<s:textfield name="cliente.nrodocUsu" label="Numero de Documento"/>
<s:textfield name="cliente.teleVend" label="Telefono"/>

<s:textfield name="cliente.usernameUsu" label="Username"/>
<s:textfield name="cliente.passwordUsu" label="Password"/>

<s:textfield name="cliente.fechamodUsu" label="Fecha Modificacion"/>
<s:textfield name="cliente.fechregUsu" label="Fecha Registro"/>

<%-- <s:radio name="producto.tipoProd" label="Tipo Producto" list="#{'B':'Balones','G':'Granel'}" value="'B'"/>
<s:select name="producto.unidadmedida.idUnimed" label="Unidad medida" list="unidadmedidas" listKey="idUnimed" listValue="nombreUnimed" required="true" onselect="true" /> --%>

<s:submit <%--  method="registrar" --%> align="center" value="Registrar" />

</s:form> 

