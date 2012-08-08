<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!--Aca vamos hacer el login -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
<s:property value="%{getText('loginsicogas.title')}"/>
</title>
<link rel="stylesheet" href="css/estilo.css" type="text/css">
</head>
<body>
	<div class="uicenter">
		<span class="errorMensage"><s:property value="mensaje"/></span>
		<s:form action="loginsicogas" validate="true">
			<s:select name="usuarioBean.empresa.codEmp" label="Empresa" list="empresas" listKey="codEmp" listValue="razsocialEmp" required="true" onselect="true" />
			<s:select name="usuarioBean.local.codLoc" label="Local" list="locales" listKey="codLoc" listValue="razsocialLoc" required="true" onselect="true"/>
			<s:textfield name="usuarioBean.usuario.nomConex" label="%{getText('loginsicogas.usuario.nomConex')}" required="true"/>
			<s:password name="usuarioBean.usuario.pass" label="%{getText('loginsicogas.usuario.pass')}" required="true"/>
			<s:submit value="%{getText('loginsicogas.ingresar')}" method="validar"/>
		</s:form>
	</div>	
</body>
</html>