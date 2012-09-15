<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validar(){
		
		if(document.buscar.idVehiculo.value.length == 0 && document.buscar.marca.value.length == 0 && document.buscar.modelo.value.length == 0 && document.buscar.placa.value.length == 0){		
			alert("Debe llenar alguna condici�n de b�squeda.");
			document.buscar.idVehiculo.focus();				
			return false;
		}else if(isNaN(document.buscar.idVehiculo.value)){		
			alert("C�digo de veh�culo no v�lido.");
			document.buscar.idVehiculo.focus();	
			return false;
		}	
		return true;
	}
</script>
</head>
<body>	
	<form action="ServletProveedor" method="post" name="buscar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_FILTRO_VEHICULO %>">
		<input type="hidden" name="destino" value="<%=Constantes.GESTIONAR_VEHICULO%>">
		<table>
			<tr>
				<td>C�digo de veh�culo</td>
				<td><input type="text" name="idVehiculo" d></td>
				
				<td>Modelo</td>
				<td><input type="text" name="modelo"></td>
				
				<td rowspan="2" valign="top"><input type="submit" value="Buscar"></td>
			</tr>
			<tr>
				<td>Marca</td>
				<td><input type="text" name="marca"></td>
				
				<td>Placa</td>
				<td><input type="text" name="placa"></td>
			</tr>			
		</table>
	</form>
</body>
</html>