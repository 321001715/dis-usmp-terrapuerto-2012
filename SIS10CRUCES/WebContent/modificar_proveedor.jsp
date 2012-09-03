<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
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
	Proveedor proveedor = (Proveedor)request.getAttribute("proveedor");
	String mensaje = (String)request.getAttribute("mensaje");
%>

<h2>Modificar proveedor</h2>

	<%@include file="buscar_proveedor.jsp" %>
	<br><hr><br>
	<form action="ServletProveedor" method="post">
		<input type="hidden" name="tipo" value="modificar">
		<%if(proveedor != null){ %>
		<table>
			<tr>
				<td>Codigo de Empresa</td>
				<td><input type="text" name="codigo" value="<%=proveedor.getIdProveedor() %>"></td>
				<td ></td>
				<td></td>
			</tr>
			<tr>
				<td>RUC</td>
				<td><input type="text" name="ruc" value="<%=proveedor.getRuc() %>"></td>
				<td><input value= Buscar type="submit" ></td>
				<td></td>
			</tr>
			<tr>
				<td>Razon Social</td>
				<td><input type="text" name="razon_social" value="<%=proveedor.getRazonSocial() %>"></td>
				<td colspan=2></td>
				
			</tr>
			<tr>
				<td>Razon Comercial</td>
				<td><input type="text" name="razon_comercial" value="<%=proveedor.getRazCom() %>"></td>
				<td colspan='2'></td>
				
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input type="text" name="direccion" value="<%=proveedor.getDirec() %>"></td>
				<td>Usuario</td>
				<td><select></select></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input type="text" name="telefono" value="<%=proveedor.getTel() %>"></td>
				<td>Estado</td>
				<td><select></select></td>
			</tr>
			<tr>				
				<td colspan="2"><input value=Modificar type="submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<%}else if(mensaje != null){ %>
			<font color="red"><%=mensaje %></font>
		<%} %>
	</form>
</body>
</html>