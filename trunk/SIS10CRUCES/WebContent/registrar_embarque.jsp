<%@page import="pe.plazanorte.sisterra.entidades.Pasajero"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
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
Vector<Pasajero> listaPasajeros = (Vector<Pasajero>)request.getAttribute("listaPasajeros");
long idViaje = (Long)request.getAttribute("idViaje");

if(listaPasajeros.size() != 0){
%> 

<div class="ui-widget">
	<div class="ui-corner-bottom ui-widget-content">
		<font style="font-family: monospace; font-size: x-large;">Resultado de Búsqueda</font>
	</div>


<form action="ServletEmbarque" method="post">
<input type="hidden" name="idViaje" value="<%=idViaje%>">
<input type="hidden" name="tipo" value="<%=Constantes.REGISTRAR_EMBARQUE%>">
<table align="center" id="table" class="sortable">
		<thead>
			<tr>			
				<th><h3 align="center">Boleto Nro.</h3></th>				
				<th><h3 align="center">DNI</h3></th>
				<th><h3 align="center">Nombres</h3></th>
				<th><h3 align="center">Apellido Paterno</h3></th>
				<th><h3 align="center">Apellido Materno</h3></th>
				<th><h3 align="center">Abordo</h3></th>
			</tr>
		</thead>
		<tbody>
		
<%
	for(Pasajero pasajero : listaPasajeros){ 
%> 

		<tr>			
			<td align="center"><%=pasajero.getIdBoleto() %></td>
			<td align="center"><%=pasajero.getDni() %></td>
			<td align="center"><%=pasajero.getNombres() %></td>
			<td align="center"><%=pasajero.getApellidoPat() %></td>
			<td align="center"><%=pasajero.getApellidoMat() %></td>
			<td align="center"><input type="checkbox" name="idBoleto" value="<%=pasajero.getIdBoleto()%>"></td>			
		</tr>
		<tr>
			<input type="submit" value="Registrar Abordaje">
		</tr>
<%} %>
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