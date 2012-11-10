<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header" align="center"> 
   	<font style="font-family: monospace; font-size: x-large;">BETA: PROXIMAMENTE</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Encomienda</font>
   </div>
	<form action="ServletClasificacion" method="post" name="registrar" >
<%-- 		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_CLASIFICACION%>"> --%>
		<table>	
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td colspan="3"><u>Datos de Remitente</u></td>
				<td colspan="3"><u>Datos de Destinatario</u></td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td>DNI:</td>
				<td><input type="text" name="remitenteDni" maxlength="8" ></td>	
				
				<td width="20%"></td>
				<td>DNI:</td>
				<td><input type="text" name="destinatarioDni" maxlength="8" ></td>		
			</tr>
			<tr>
				<td></td>
				<td>Nombres:</td>
				<td><input type="text" name="remitenteNombre"></td>		
				<td></td>
				<td>Nombres:</td>
				<td><input type="text" name="destinatarioNombre"></td>	
			</tr>
			<tr>
				<td></td>
				<td>Apellido Paterno:</td>
				<td><input type="text" name="remitenteApePat"></td>		
				<td></td>
				<td>Apellido Paterno:</td>
				<td><input type="text" name="destinatarioApePat"></td>	
			</tr>
			<tr>
				<td></td>
				<td>Apellido Materno:</td>
				<td><input type="text" name="remitenteApeMat"></td>		
				<td></td>
				<td>Apellido Materno:</td>
				<td><input type="text" name="destinatarioApeMat"></td>	
			</tr>
			<tr>
				<td><br><br></td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td colspan="3"><u>Información de la Cuenta</u></td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td>Tipo:</td>
				<td>
					<select name="tipoEncomienda" >
						<option value="1">Sobre</option>
						<option value="2">Caja</option>
						<option value="3">Frágil</option> 
					</select>	
				</td>
			</tr>
			<tr>		
				<td width="20%"></td>
				<td>Peso (Kg.):</td>
				<td>
					<input type="text" name="pesoEncomienda" maxlength="3">
				</td>
			</tr>
			<tr>		
				<td width="20%"></td>
				<td>Volumen (rango):</td>
				<td>
					<select name="volumen" >
						<option value="1">Volumen A1-A2</option>
						<option value="2">Volumen B1-B2</option>
						<option value="3">Volumen C1-C2</option> 
					</select>	
				</td>
			</tr>
			<tr>
				<td><br><br></td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td colspan="3"><u>Viajes Disponibles</u></td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td>CÓD. VIAJE:</td>
				<td>
					<select name="idViaje" >
						<option value="1">ABC</option>
						<option value="2">Trujillo Lima 08.30</option>
						<option value="3">A Puno S/ida</option> 
					</select>	
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Registrar Encomienda" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>
		</table>
	</form>
</div>
<br><br><a href="index_proveedor.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atrás...
	&nbsp;
</body>
</html>