<%@page import="pe.plazanorte.sisterra.seguridad.ServiceSeguridad"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
<%@page import="java.util.Vector"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validar(){
		if(document.registrar.ruc.value.length == 0){
			alert("Debe llenar el campo RUC.");
			document.registrar.ruc.focus();
			return false;
		}
		
		if( !(/^\d{11}$/.test(document.registrar.ruc.value))){
			alert("Debe ingresar un n�mero de RUC v�lido.");
			document.registrar.ruc.focus();
			return false;
		}
		if(document.registrar.razon_social.value.length == 0){
			alert("Debe llenar el campo Raz�n social.");
			document.registrar.razon_social.focus();
			return false;
		}
		if(document.registrar.razon_comercial.value.length == 0){
			alert("Debe llenar el campo Raz�n comercial.");
			document.registrar.razon_comercial.focus();
			return false;
		}
		if(document.registrar.direccion.value.length == 0){
			alert("Debe llenar el campo Direcci�n.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.telefono.value.length == 0){
			alert("Debe llenar el campo Tel�fono.");
			document.registrar.telefono.focus();
			return false;
		}
		if(isNaN(document.registrar.telefono.value)){
			alert("Debe ingresar un n�mero de tel�fono v�lido.");
			document.registrar.telefono.focus();
			return false;
		}	
		if((document.registrar.telefono.value.length) < 6){
			alert("Debe ingresar un n�mero de tel�fono v�lido.");
			document.registrar.telefono.focus();
			return false;
		}	
		if(document.registrar.idUsuario.selectedIndex==0){		
			window.alert("Debe seleccionar un usuario. Si no existen usuarios deber� primero registrar uno con el perfil PROVEEDOR.");						
			return false;
		}			
		return true;
	}	
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
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Mantener Proveedor</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Proveedor</font>
   </div>
	<form action="ServletProveedor" method="post" name="registrar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_PROVEEDOR%>">
		<table>	
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>RUC:</td>
				<td><input type="text" name="ruc" maxlength="11"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Raz�n Social:</td>
				<td><input type="text" name="razon_social" style="width: 240px"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Raz�n Comercial:</td>
				<td><input type="text" name="razon_comercial" style="width: 240px"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Direcci�n:</td>
				<td><input type="text" name="direccion" style="width: 240px"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Tel�fono:</td>
				<td><input type="text" name="telefono" maxlength="9"></td>			
			</tr>
			<tr>
				<td></td>
				<td>ID Usuario:</td>
				<td>
					<%

ServiceSeguridad servicioSeguridad=new ServiceSeguridad();
	
Vector<Usuario> usuarios = servicioSeguridad.listarUsuariosProveedores();

if(usuarios != null){
%>
					<select name="idUsuario">
						<option value="0">Seleccione</option>
<%
	for(int i=0; i<=usuarios.size()-1;i++){
%>
						<option value="<%=usuarios.get(i).getId()%>"><%=usuarios.get(i).getUsuario()%></option>
<%
	}
%>
					</select>
<%}else{ %>
				<b>No existen usuarios...</b>
<%} %>	
				</td>			
			</tr>
			<tr>
				<td></td>
				<td>Estado:</td>
				<td>
					<select name="estado">						
						<option value="<%=Constantes.ESTADO_ACTIVO%>" ><%=Constantes.ESTADO_ACTIVO%></option>
						<option value="<%=Constantes.ESTADO_INHABILITADO%>" ><%=Constantes.ESTADO_INHABILITADO%></option>
					</select>				
				</td>				
			</tr>	
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Registrar Proveedor" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>
		</table>
	</form>
</div>
<br><br><a href="index_seguridad.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atr�s...
	&nbsp;
</body>
</html>