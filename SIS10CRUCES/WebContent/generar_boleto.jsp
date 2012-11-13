<%@page import="pe.plazanorte.sisterra.entidades.Persona"%>
<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
<%@page import="pe.plazanorte.sisterra.entidades.Viaje"%>
<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
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
<title>Generar Boleto</title>

</head>
<script type="text/javascript">
function imprSelec(nombre)

{

var ficha = document.getElementById(nombre);

var ventimp = window.open(' ', 'popimpr');

ventimp.document.write( ficha.innerHTML );

ventimp.document.close();

ventimp.print( );

ventimp.close();

}

</script>
<style type="text/css">
<!--
#apDiv1 {

	left:18px;
	top:28px;
	width:700px;
	height:300px;
	z-index:1;
	background-image: url(images/principal/banner_logo.png);
}
-->
</style>
<%
	Usuario reservador = (Usuario)session.getAttribute("BUsuario");	
	Perfil usuarioPerfil = (Perfil)session.getAttribute("BPerfil");	
	int idReserva = (Integer)request.getAttribute("idReserva");	
	Viaje viaje = (Viaje)request.getAttribute("viaje");	
	Ruta ruta = (Ruta)request.getAttribute("ruta");	
	int edad = (Integer)request.getAttribute("edad");	
	int piso = (Integer)request.getAttribute("piso");	
	int asiento = (Integer)request.getAttribute("asiento");	
	String nombreProveedor = (String)request.getAttribute("nombreProveedor");
	String busqueda = (String)request.getAttribute("busqueda");
	String mensaje = (String)request.getAttribute("mensaje");
	Persona persona = (Persona)request.getAttribute("persona");	
%>
<body>
<div id="seleccion">
<div class="ui-corner-bottom ui-widget-content">
				<font  style="font-family: monospace; font-size: x-large;" >BOLETO DE VIAJE</font>
</div>

<h1 align="center">Sistema 10 Cruces Gracias por utilizar este servicio</h1>
<div align="center">
	<img align="top" src="images/logo_terra.png">
</div>
<table width="559" height="318" border="0" align="center">
  <tr>
    <td colspan="4"><h3 >
    DATOS DEL VIAJE</h3></td>
  </tr>
  <tr>
    <td width="138"><b><font color="#243960">Fecha</font></b></td>
    <td width="92"><script>
var f = new Date();
document.write(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
</script> </td>
    <td width="125">&nbsp;</td>
    <td width="176">&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">N° Reserva:</font></b></td>
    <td><%=idReserva %></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Nombre Viaje:</font></b></td>
    <td><%=viaje.getNomViaje() %></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Origen:</font></b></td>
    <td><%=ruta.getOrigen() %></td>
    <td><b><font color="#243960">Destino:</font></b></td>
    <td><%=ruta.getDestino() %></td>
  </tr>
  <tr>
    <td><b><font color="#243960">Fecha de Salida:</font></b></td>
    <td><%=viaje.getFecSalida() %></td>
    <td><b><font color="#243960">Hora de Salida:</font></b></td>
    <td><%=viaje.getHorSalida() %></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><h3>DATOS DE LA EMPRESA</h3></td>
  </tr>
  <tr>
    <td><b><font color="#243960">Empresa:</font></b></td>
    <td><%=nombreProveedor %></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Servicio:</font></b></td>
    <td><%=viaje.getServicio() %></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Costo:</font></b></td>
    <td><%=viaje.getPrecio() %></td>
    <td><b><font color="#243960">Nro Asiento:</font></b></td>
    <td><%=asiento %></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><h3>DATOS DEL PASAJERO</h3></td>
  </tr>
  <tr>
    <td><b><font color="#243960">N° Documento:</font></b></td>
    <td><%=persona.getDni() %></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Nombre:</font></b></td>
    <td><%=persona.getNombre() %></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Apellido Pat.:</font></b></td>
    <td><%=persona.getApePat() %></td>
    <td>
   </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Apellido Mat.:</font></b></td>
    <td><%=persona.getApeMat() %></td>
    <td></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b><font color="#243960">Fecha Nacimiento:</font></b></td>
    <td><%=persona.getFecNac() %></td>
    <td><b><font color="#243960">Edad:</font></b></td>
    <td><%=edad %></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</div>
<div align="center">
	<img align="middle" src="images/principal/banner_logo.png" width="550" height="150">
</div>
<form id="form1" name="form1" method="post" action="">
      <p align="Center"><a href="javascript:imprSelec('seleccion')" >Imprimir</a></p> </form>

<br>
<br>
</body>
</html>