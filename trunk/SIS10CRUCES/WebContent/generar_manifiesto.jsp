<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css" />
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css" />
<link rel="stylesheet"
	href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%

Vector<Viaje> listaViajes=(Vector<Viaje>)request.getAttribute("viaje");
%>
<title>Generar Manifiesto</title>

</head>
<body>
<div class="ui-widget">
		<h3 class="ui-corner-top ui-widget-header">
			<font style="font-family: monospace; font-size: x-large;">Generar Manifiesto de Pasajeros</font>
		</h3>
		
<div class="ui-corner-bottom ui-widget-content">
				<font style="font-family: monospace; font-size: x-large;">Filtros de Busqueda</font>
</div>
	<table>
	<tr>
	<td>Nombre de Viaje:</td>
	<td><select name="sel_viaje">
						<% for (int i=0;i<listaViajes.size();i++){ %>
							<option value="<%=listaViajes.get(i).getId() %>"> <%=listaViajes.get(i).getNomViaje() %> </option>
						<%} %>
					</select></td>
	<td>Numero de Reserva</td>
	<td><input type="text" name="txt_reserva"></td>
	<td><input type="submit" name="tipoSubmit" value="Buscar" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
	</tr>
	</table>
	
	<br>
	<br>
	<br>
<table  id="table" class="sortable">
		<thead>
			<tr>
				<th><h3 align="center">N° Reserva</h3></th>
				<th><h3 align="center">Cod Viaje</h3></th>
				<th><h3 align="center">N° Boleto</h3></th>
				<th><h3 align="center">N° Documento</h3></th>
				<th><h3 align="center">Apellido Paterno</h3></th>
				<th><h3 align="center">Apellido Materno</h3></th>
				<th><h3 align="center">Nombres</h3></th>
				<th><h3 align="center"></h3></th>
			</tr>
		</thead>
		<tbody>
	</tbody>
	</table>
<table border="0" >
      <tr>
        <td>Total Pasajeros</td>
        <td><form name="form4" method="post" action="">
          <input type="text" name="textfield2" id="textfield2">
        </form></td>
        <td>&nbsp;</td>
      </tr>
</table>
<table width="656" border="0" align="center">
      <tr>
        <td width="173">&nbsp;</td>
        <td width="96"><form name="form1" method="post" action="">
             
        </form></td>
        <td width="90"><form name="form2" method="post" action="">
           <a href="javascript:print()" _fcksavedurl="javascript:print()">Imprimir</a>
        </form></td>
        <td width="169">&nbsp;</td>
      </tr>
</table>
</body>
</html>