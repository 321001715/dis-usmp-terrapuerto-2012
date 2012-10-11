<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Reserva"%>

<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Vector<Reserva> reservas=(Vector<Reserva>)request.getAttribute("reservas");
if(reservas.size() != 0){
%>


<table align="center" id="table"  >
		<thead>
			<tr>
				<th><h3 align="center">Nº de Reserva</h3></th>
				<th><h3 align="center">Cód. Usuario</h3></th>
				<th><h3 align="center">Fecha</h3></th>
				<th><h3 align="center">Estado</h3></th>
				<th><h3 align="center"></h3></th>
			</tr>
		</thead>
		<tbody>
		
<% 
	for(int i=0; i<reservas.size(); i++){ 
%> 

		<tr>
			<td align="center"> <%=reservas.get(i).getId() %></td>
			<td align="center"> <%=reservas.get(i).getIdusuario() %></td>
			<td align="center"> <%=reservas.get(i).getFecha() %></td>
			<td align="center"> <%=reservas.get(i).getEstado()%></td>
			<td align="left"><input type="checkbox" name=""></td>	
		</tr>
<%}} %>
		
		</tbody>
	</table>

</body>
</html>