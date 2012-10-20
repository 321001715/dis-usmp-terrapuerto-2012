<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Reserva"%>

<%@page import="java.util.Vector"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<%
Vector<Reserva> reservas=(Vector<Reserva>)request.getAttribute("reservas");


if(reservas.size() != 0){
%>

<div class="ui-widget">
	<div class="ui-corner-bottom ui-widget-content">
		<font style="font-family: monospace; font-size: x-large;">Resultado de Búsqueda</font>
	</div>
&nbsp;
&nbsp;
<form action="ServletBoletaje">
<table align="center" id="table" class="sortable">
	
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
			<td align="left"><input type="checkbox" name="idReserva" value="<%=reservas.get(i).getId() %>"></td>	
		</tr>
<%} %>
		
		<tr><td colspan="9"></td></tr>
		<tr>
			<td align="center" colspan="9">
				<input type="submit" name="tipo" value="<%=Constantes.ACCION_CONFIRMAR_RESERVA%>">
				<input type="submit" name="tipo" value="<%=Constantes.ACCION_ANULAR_RESERVA%>">
			</td>
		</tr>
		</tbody>
	</table>
</form>	
</div>
	<div id="controls">
		<div id="perpage">
			<select onchange="sorter.size(this.value)">
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="20" selected="selected">20</option>
			</select>
			<span>Registros por Página</span>
		</div>
		<div id="navigation">
			<img src="images/first.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1,true)" />
			<img src="images/previous.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1)" />
			<img src="images/next.gif" width="16" height="16" alt="First Page" onclick="sorter.move(1)" />
			<img src="images/last.gif" width="16" height="16" alt="Last Page" onclick="sorter.move(1,true)" />
		</div>
		<div id="text">Página <span id="currentpage"></span> de <span id="pagelimit"></span></div>
	</div>
&nbsp;
 	<% 
 }else{
%> 
	<font color="red">No se encontraron resultados para la consulta.</font>
 <% 
 }
%>

<script type="text/javascript">
  		var sorter = new TINY.table.sorter("sorter");
		sorter.head = "head";
		sorter.asc = "asc";
		sorter.desc = "desc";
		sorter.even = "evenrow";
		sorter.odd = "oddrow";
		sorter.evensel = "evenselected";
		sorter.oddsel = "oddselected";
		sorter.paginate = true;
		sorter.currentid = "currentpage";
		sorter.limitid = "pagelimit";
		sorter.init("table",2);
</script>
</body>