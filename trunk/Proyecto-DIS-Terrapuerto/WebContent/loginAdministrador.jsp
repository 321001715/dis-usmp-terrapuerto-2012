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

<div id="contenedor">

<div id="izquierda">

	<s:form action="loginAdmin" >
		<s:textfield name="usuario.usernameUsu" label="Usuario" id="form_login_input"/>
		<s:password name="usuario.passwordUsu" label="Password" id="form_login_input"/>
		<s:submit value="" cssClass="btn_iniciar_sesion"/>
	</s:form>
</div>

<div id="derecha_login" >
	<img src="<s:url value='/img/persona_login.png'/>" />
	<img src="<s:url value='/img/btn_registrar_login.png'/>" class="btn_registrar" />
</div>


</div>


<div id="footer"></div>
</body>
</html>