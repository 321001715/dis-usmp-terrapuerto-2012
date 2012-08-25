<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="mantenerEmpresa">
	<s:textfield name="empresaTrans.idEmptrans" label="Codigo" readonly="true" />
	<s:textfield name="empresaTrans.rucEmptrans" label="RUC" />
	<s:textfield name="empresaTrans.razsocialEmptrans" label="Razon Social" />
	<s:textfield name="empresaTrans.dirEmptrans" label="Direccion" />
	<s:textfield name="empresaTrans.calificacionEmptrans" label="Calificacion" />
	<s:textfield name="empresaTrans.telefEmptrans" label="Telefono" />
	<s:submit  method="registrar" align="center" value="Registrar" />
</s:form> 

