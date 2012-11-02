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
<%
	Usuario reservador = (Usuario)session.getAttribute("BUsuario");	
	Perfil usuarioPerfil = (Perfil)session.getAttribute("BPerfil");	
	int idReserva = (Integer)request.getAttribute("idReserva");	
	Viaje viaje = (Viaje)request.getAttribute("viaje");	
	Ruta ruta = (Ruta)request.getAttribute("ruta");	
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
				<font style="font-family: monospace; font-size: x-large;" >BOLETO DE VIAJE</font>
</div>

<table width="559" height="318" border="0">
  <tr>
    <td width="138">Fecha</td>
    <td colspan="3"><script>
var f = new Date();
document.write(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
</script> </td>
  </tr>
  <tr>
    <td>N° Reserva:</td>
    <td width="92">&nbsp;</td>
    <td width="125">&nbsp;</td>
    <td width="176">&nbsp;</td>
  </tr>
  <tr>
    <td>Cod Viaje:</td>
    <td></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Origen:</td>
    <td>&nbsp;</td>
    <td>Destino:</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Fecha de Salida:</td>
    <td>&nbsp;</td>
    <td>Hora de Salida:</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Empresa:</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Servicio:</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Costo:</td>
    <td><%=viaje.getPrecio() %></td>
    <td>Nro Asiento:</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>N° Documento:</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Nombre:</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Apellido Pat.:</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Apellido Mat.:</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Fecha Nacimiento:</td>
    <td>&nbsp;</td>
    <td>Edad:</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><form id="form1" name="form1" method="post" action="">
      <a href="javascript:imprSelec('seleccion')" >Imprimir</a>
    </form></td>
    <td>&nbsp;</td>
  </tr>
</table>
</div>
</body>
</html>