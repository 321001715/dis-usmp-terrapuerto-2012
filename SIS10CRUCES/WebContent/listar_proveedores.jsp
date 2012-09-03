<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Vector<Proveedor> proveedores = (Vector<Proveedor>)request.getAttribute("proveedores");
%>

<%
	if(proveedores.size() != 0){
%>

<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th>C&oacute;digo</th>
		<th>RUC</th>
		<th>Razón social</th>
		<th>Razón comercial</th>
		<th colspan="2">Acci&oacute;n</th>
	</tr>
	<%for(int i=0; i<proveedores.size(); i++){ %>
	<tr>
		<td><%=proveedores.get(i).getIdProveedor() %></td>
		<td><%=proveedores.get(i).getRuc() %></td>
		<td><%=proveedores.get(i).getRazonSocial() %></td>
		<td><%=proveedores.get(i).getRazCom()%></td>
		<td><a href="ServletProveedor?tipo=consultar" target="_blank">Consultar</a></td>
		<td><a href="ServletProveedor?tipo=eliminar">Deshabilitar</a></td>
	</tr>
	<%} %>
</table>
<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>
</html>