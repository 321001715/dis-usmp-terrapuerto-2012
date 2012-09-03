<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema 10 cruces </title>
</head>
<body>

	<h2>Men&uacute; principal</h2>
		<ul>
              <li><a href="<%=application.getContextPath() %>/ServletSeguridad?tipo=listar&origen=<%=Constantes.MENU_PRINCIPAL%>">Gestion de Usuarios</a></li>
			<li><a href="<%=application.getContextPath() %>/ServletProveedor?tipo=listar&destino=<%=Constantes.MANTENER_PROVEEDOR%>">Gestion de Proveedores</a></li>
			<li><a href="gestion_empresas.jsp" class="invoices">Gestion de Perfiles</a></li>
        </ul>
</body>
</html>