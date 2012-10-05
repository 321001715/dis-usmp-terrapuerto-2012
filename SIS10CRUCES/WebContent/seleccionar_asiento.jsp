<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<%
	Viaje viaje=(Viaje)request.getAttribute("unviaje");
	
%>
<body>
<div class="ui-widget">
<table style="width: 100%; height: 100%; position: relative;">
<tr>
<td>
	<table cellpadding="8" cellspacing="8" align="center" style="width: 100%; height: 100%;">
		<tr>
			<td rowspan="3" align="center">
				<!-- GRÁFICO DE OMNIBUS -->
					<table border="3" style="background-color: #CC99CC;" cellpadding="5" cellspacing="5">
						<tr>
							<td colspan="4">
								<font style="font-family: 'Trebuchet MS'; font-size: medium;"><b>PISO 1</b></font>
							<table border="2" cellpadding="5" cellspacing="5" style="width: 300px; height: 300px;">
							<!-- AQUI ESTARÍA EL FOR PARA CREAR LOS TD PARA PISO 1-->
							<tr>	
								<td align="center">1</td>
								<td align="center">2</td>
								<td align="center">3</td>
								<td align="center">4</td>
							</tr>
							<tr>	
								<td align="center">5</td>
								<td align="center">6</td>
								<td align="center">7</td>
								<td align="center">8</td>
							</tr>
							<tr>	
								<td align="center">9</td>
								<td align="center">10</td>
								<td align="center">11</td>
								<td align="center">12</td>
							</tr>
							<tr>	
								<td align="center">13</td>
								<td align="center">14</td>
								<td align="center">15</td>
								<td align="center">16</td>
							</tr>
							<tr>	
								<td align="center">17</td>
								<td align="center">18</td>
								<td align="center">19</td>
								<td align="center">20</td>
							</tr>
							<!-- FIN DE FOR PARA PISO 1 -->
							</table>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<font style="font-family: 'Trebuchet MS'; font-size: medium;"><b>PISO 2</b></font>
							<table border="2" cellpadding="5" cellspacing="5" style="width: 300px; height: 300px;">
							<!-- AQUI ESTARÍA EL FOR PARA CREAR LOS TD PARA PISO 2-->
							<tr>	
								<td align="center">21</td>
								<td align="center">22</td>
								<td align="center">23</td>
								<td align="center">24</td>
							</tr>
							<tr>	
								<td align="center">25</td>
								<td align="center">26</td>
								<td align="center">27</td>
								<td align="center">28</td>
							</tr>
							<tr>	
								<td align="center">29</td>
								<td align="center">30</td>
								<td align="center">31</td>
								<td align="center">32</td>
							</tr>
							<tr>	
								<td align="center">33</td>
								<td align="center">34</td>
								<td align="center">35</td>
								<td align="center">36</td>
							</tr>
							<tr>	
								<td align="center">37</td>
								<td align="center">38</td>
								<td align="center">39</td>
								<td align="center">40</td>
							</tr>
							<!-- FIN DE FOR PARA PISO 2 -->
							</table>
						</tr>
					</table>
			</td>
			<td colspan="2">
				<!-- DETALLE DE RESERVA -->
				<table cellpadding="3" cellspacing="3">
				<tr>
					<td colspan="5">
						<div class="ui-corner-bottom ui-widget-content">   
		   					<font style="font-family: monospace; font-size: x-large;">Detalle de Reserva</font>
		   				</div>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td width="150px">Código de Viaje: </td>
					<td><input type="text" name="codViaje" disabled="disabled" value="<%=viaje.getCodViaje() %>"></td>
					<td></td>
					<td></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Origen: </td>
					<td><input type="text" name="origen" disabled="disabled"></td>
					<td width="150px">Destino: </td>
					<td><input type="text" name="destino" disabled="disabled"></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Fecha de Salida: </td>
					<td><input type="text" name="fecSalida" disabled="disabled"></td>
					<td>Fecha de Llegada: </td>
					<td><input type="text" name="fecLlegada" disabled="disabled"></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Costo S/.: </td>
					<td><input type="text" name="costo" disabled="disabled" value="<%=viaje.getPrecio() %>"></td>
					<td>Duración Hrs.: </td>
					<td><input type="text" name="duracion" disabled="disabled"></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Servicio: </td>
					<td colspan="3"><input type="text" name="servicio" size="73" disabled="disabled" value="<%=viaje.getServicio() %>"></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<!-- DETALLE DE VEHÍCULO -->
				<table cellpadding="3" cellspacing="3">
				<tr>
					<td colspan="5">
						<div class="ui-corner-bottom ui-widget-content">   
		   					<font style="font-family: monospace; font-size: x-large;">Detalle de Vehículo</font>
		   				</div>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td width="150px">Nº de Asiento: </td>
					<td>
						<select name="asientos">
							<option>21</option>
							<option>22</option>
							<option>23</option>
							<option>24</option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
	   			<tr>
	   				<td width="10%"></td>
					<td>Piso: </td>
					<td><input type="text" name="piso" disabled="disabled"></td>
					<td width="150px">Placa: </td>
					<td><input type="text" name="placa" disabled="disabled"></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right" width="20%">
				<!-- DETALLE DE LEYENDA -->
				<table border="4" cellpadding="4" cellspacing="4">
					<tr>
						<td width="30%" bgcolor="black"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> No Disponible</font></td>
					</tr>
					<tr>
						<td bgcolor="red"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> Vendido</font></td>
					</tr>
					<tr>
						<td bgcolor="orange"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> Reservado</font></td>
					</tr>
					<tr>
						<td bgcolor="blue"></td>
						<td><font style="font-family: fantasy; font-size:small;">Asiento <br> Disponible</font></td>
					</tr>
				</table>
			</td>
			<td align="center"  width="40%">
				<!-- BOTONES -->
				<input type="submit" value="RESERVAR"> 
				<br>
				<br>
				<input type="submit" value="COMPRAR BOLETO"> 
			</td>
		</tr>
	</table>
</td>
</tr>
</table>
</div>
</body>
</html>