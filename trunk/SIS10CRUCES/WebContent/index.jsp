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
            <li><a href="<%=application.getContextPath() %>/ServletSeguridad?tipo=listar&origen=<%=Constantes.MENU_PRINCIPAL%>">Gesti&oacute;n de Usuarios</a></li>
			<li><a href="<%=application.getContextPath() %>/ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_PROVEEDOR %>&destino=<%=Constantes.MANTENER_PROVEEDOR%>">Gesti&oacute;n de Proveedores</a></li>
			<li><a href="<%=application.getContextPath() %>/ServletSeguridad?tipo=listarPerfiles&origen=<%=Constantes.MENU_PRINCIPAL%>">Gesti&oacute;n de Perfiles</a></li>
			<li><a href="<%=application.getContextPath() %>/ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_VEHICULO %>&destino=<%=Constantes.GESTIONAR_VEHICULO%>">Gesti&oacute;n de Veh&iacute;culos</a></li>
			<li><a href="<%=application.getContextPath() %>/ServletClasificacion?tipo=<%=Constantes.ACCION_LISTAR_CLASIFICACION %>&destino=<%=Constantes.MANTENER_CLASIFICACION%>">Gesti&oacute;n de Clasificaci�n</a></li>
            <li><a href="<%=application.getContextPath() %>/ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_RUTA %>&destino=<%=Constantes.GESTIONAR_RUTA%>">Gesti&oacute;n de Rutas</a></li>
        </ul>
</body>
</html>