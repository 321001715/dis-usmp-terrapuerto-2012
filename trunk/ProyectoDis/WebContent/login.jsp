<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Usuario Administrador</title>
<link rel="stylesheet" href="css/style_admin.css" type="text/css">	
</head>
<body>
<div id="bg"></div>
<div id="login">
	<s:form action="loginTerrapuerto">
		<s:textfield name="usuario.usernameUsu" label="Usuario"/>
		<s:password name="usuario.passwordUsu" label="Password"/>
		<s:submit value="Ingresar"/>
	</s:form>
</div>
<div id="footer"></div>
</body>
</html>