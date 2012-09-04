<%@page import="pe.plazanorte.sisterra.entidades.Proveedor"%>
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
		if(document.registrar.razon_social.value.length == 0){
			alert("Debe llenar el campo Razón social.");
			document.registrar.razon_social.focus();
			return false;
		}
		if(document.registrar.razon_comercial.value.length == 0){
			alert("Debe llenar el campo Razón comercial.");
			document.registrar.razon_comercial.focus();
			return false;
		}
		if(document.registrar.direccion.value.length == 0){
			alert("Debe llenar el campo Dirección.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.telefono.value.length == 0){
			alert("Debe llenar el campo Teléfono.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.usuario.value.length == 0){
			alert("Debe llenar el campo usuario.");
			document.registrar.usuario.focus();
			return false;
		}
		if(document.registrar.clave.value.length == 0){
			alert("Debe escribir una clave.");
			document.registrar.clave.focus();
			return false;
		}
		if(document.registrar.clave.value.length < 5){
			alert("Su clave debe tener más de 5 dígitos.");
			document.registrar.clave.focus();
			return false;
		}
		return true;
	}	
</script>

</head>
<body>

<%
	Proveedor proveedor = (Proveedor)request.getAttribute("proveedor");
	String mensaje = (String)request.getAttribute("mensaje");
%>

<h2>Modificar proveedor</h2>

	<%@include file="buscar_proveedor.jsp" %>
	<br><hr>
	<form action="ServletProveedor" method="post">
		<input type="hidden" name="tipo" value="modificar">
		<%if(proveedor != null){ %>
		<table cellspacing="10px">
			<tr>
				<td colspan="2"><h3>Datos del Proveedor</h3></td>					
			</tr>
			<tr>
				<td>C&oacute;digo</td>
				<td><input type="text" name="codigo" maxlength="11" value="<%=proveedor.getIdProveedor() %>" readonly="readonly"></td>				
			</tr>
			<tr>
				<td>RUC</td>
				<td><input type="text" name="ruc" maxlength="11" value="<%=proveedor.getRuc() %>" readonly="readonly"></td>				
			</tr>		
			<tr>
				<td>Razon Social</td>
				<td><input type="text" name="razon_social" value="<%=proveedor.getRazonSocial()%>"></td>			
			</tr>
			<tr>
				<td>Razon Comercial</td>
				<td><input type="text" name="razon_comercial" value="<%=proveedor.getRazCom()%>"></td>			
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input type="text" name="direccion" value="<%=proveedor.getDireccion()%>"></td>				
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input type="text" name="telefono" value="<%=proveedor.getTel()%>" maxlength="9"></td>				
			</tr>
			<tr>
				<td>Estado del proveedor</td>
				<td>
					<select name="estado">						
						<option value="<%=Constantes.ESTADO_ACTIVO%>" <%if(proveedor.getEstado().equals(Constantes.ESTADO_ACTIVO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_ACTIVO%></option>
						<option value="<%=Constantes.ESTADO_INHABILITADO%>" <%if(proveedor.getEstado().equals(Constantes.ESTADO_INHABILITADO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_INHABILITADO%></option>
					</select>				
				</td>				
			</tr>			
			<tr>				
				<td colspan="2"><input value=Modificar type="submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>		
	</form>
	<%}else if(mensaje != null){ %>
			<font color="red"><%=mensaje %></font>
		<%} %>
</body>
</html>