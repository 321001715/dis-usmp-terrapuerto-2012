<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
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
Vector<Perfil> perfiles = (Vector<Perfil>)request.getAttribute("perfiles");
 
if(perfiles.size() != 0){
%>

<div class="ui-widget">
	<div class="ui-corner-bottom ui-widget-content">
		<font style="font-family: monospace; font-size: x-large;">Resultado de B�squeda</font>
	</div>
&nbsp;
&nbsp;

<table align="center" id="table" class="sortable">
		<thead>
			<tr>
				<th><h3 align="center">C�digo</h3></th>
				<th><h3 align="center">Nombre</h3></th>
				<th><h3 align="center">Descripci�n</h3></th>
				<th><h3 align="center">Modificar</h3></th>
			</tr>
		</thead>
		<tbody>
<%
	for(int i=0; i<perfiles.size(); i++){ 
%>

	<tr>
		<td align="center"><%=perfiles.get(i).getId() %></td>
		<td align="right"><%=perfiles.get(i).getNombre() %></td>
		<td align="right"><%=perfiles.get(i).getDescripcion() %></td>
		<td align="left">
			<div class="ui-state-default ui-corner-all cajaicono">
				<a href="ServletSeguridad?tipo=<%=Constantes.ACCION_CONSULTAR_PERFIL %>&destino=<%=Constantes.MODIFICAR_PERFIL %>&idPerfil=<%=perfiles.get(i).getId()%>">
					<span class="ui-icon ui-icon-pencil"></span>
				</a>
			</div>
		</td>		
	</tr>

<%} %>
		</tbody>
	</table>
</div>
	<div id="controls">
		<div id="perpage">
			<select onchange="sorter.size(this.value)">
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="20" selected="selected">20</option>
			</select>
			<span>Registros por P�gina</span>
		</div>
		<div id="navigation">
			<img src="images/first.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1,true)" />
			<img src="images/previous.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1)" />
			<img src="images/next.gif" width="16" height="16" alt="First Page" onclick="sorter.move(1)" />
			<img src="images/last.gif" width="16" height="16" alt="Last Page" onclick="sorter.move(1,true)" />
		</div>
		<div id="text">P�gina <span id="currentpage"></span> de <span id="pagelimit"></span></div>
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