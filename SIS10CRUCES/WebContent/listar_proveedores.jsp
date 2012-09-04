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
		<th>C&oacute;digo</th>
		<th>RUC</th>
		<th>Razón social</th>
		<th>Razón comercial</th>
		<th colspan="2">Acci&oacute;n</th>
	</tr>
	<%for(int i=0; i<proveedores.size(); i++){ %>
	<tr>
		<td align="right"><%=proveedores.get(i).getIdProveedor() %></td>
		<td><%=proveedores.get(i).getRuc() %></td>
		<td><%=proveedores.get(i).getRazonSocial() %></td>
		<td><%=proveedores.get(i).getRazCom()%></td>
		<td><a href="ServletProveedor?tipo=consultar&destino=<%=Constantes.MODIFICAR_PROVEEDOR %>&idProveedor=<%=proveedores.get(i).getIdProveedor()%>">Modificar</a></td>
		<td><a href="ServletProveedor?tipo=eliminar&idProveedor=<%=proveedores.get(i).getIdProveedor()%>">Deshabilitar</a></td>
	</tr>
	<%} %>
</table>
<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>
