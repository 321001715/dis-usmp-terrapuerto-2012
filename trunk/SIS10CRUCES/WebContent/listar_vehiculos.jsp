<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Vehiculo"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body>
<%
	Vector<Vehiculo> vehiculos = (Vector<Vehiculo>)request.getAttribute("vehiculos");
%>
 
<%
	if(vehiculos.size() != 0){
%>

<table border="1" cellspacing="1px" cellpadding="5px">
	<tr>
		<th>C&oacute;digo</th>
		<th>RUC</th>
		<th>Razón social</th>
		<th>Razón comercial</th>
		<th>Estado</th>
		<th>Acci&oacute;n</th>
	</tr>
	<%for(int i=0; i<vehiculos.size(); i++){ %>
	<tr>
		<td align="right"><%=vehiculos.get(i).getIdVehiculo() %></td>
		<td><%=vehiculos.get(i).getRuc() %></td>
		<td><%=vehiculos.get(i).getRazonSocial() %></td>
		<td><%=vehiculos.get(i).getRazCom()%></td>
		<td align="center"><%=vehiculos.get(i).getEstado()%></td>
		<td><a href="ServletProveedor?tipo=consultar&destino=<%=Constantes.MODIFICAR_PROVEEDOR %>&idVehiculo=<%=vehiculos.get(i).getIdProveedor()%>">Modificar</a></td>		
	</tr>
	<%} %>
</table>
<%}else{%>
<font color="red">No se encontraron resultados para la consulta.</font>
<%} %>
</body>
