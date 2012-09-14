<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body>
<%
	Vector<Proveedor> proveedores = (Vector<Proveedor>)request.getAttribute("proveedores");
%>
 
<%
	if(proveedores.size() != 0){
%>

<table border="1" cellspacing="1px" cellpadding="5px">
	<tr>
		<th>Codigo</th>
		<th>Nombre de Ruta</th>
		<th>Origen</th>
		<th>Destino</th>
		<th>Duracion</th>
		<th>Estado</th>
	</tr>
	<%for(int i=0; i<proveedores.size(); i++){ %>
	<tr>
		<td align="right"><%=proveedores.get(i).getIdProveedor() %></td>
		<td><%=proveedores.get(i).getRuc() %></td>
		<td><%=proveedores.get(i).getRazonSocial() %></td>
		<td><%=proveedores.get(i).getRazCom()%></td>
		<td align="center"><%=proveedores.get(i).getEstado()%></td>
		<td><a href="ServletProveedor?tipo=<%=Constantes.ACCION_CONSULTAR_PROVEEDOR %>&destino=<%=Constantes.MODIFICAR_PROVEEDOR %>&idProveedor=<%=proveedores.get(i).getIdProveedor()%>">Modificar</a></td>		
	</tr>
	<%} %>
</table>
<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>
