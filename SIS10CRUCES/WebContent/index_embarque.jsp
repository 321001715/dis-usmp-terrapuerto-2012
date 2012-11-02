<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<%
	String mensaje = (String)request.getAttribute("mensaje");
	
%>
<body bgcolor="#996666">
<table width="100%">
	<tr>
		<td width="20%"></td>
		<td>
			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Embarque</b> <br><br><br><br>
  			</font>
  			<table cellpadding="2">
  				<tr>
					<td align="center">
						
		            <a href="ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_VIAJE %>&destino=<%=Constantes.LISTAR_PASAJEROS%> "> 
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/embarque_registro.png">
						</a>
						<br>
						<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
						Registre su Embarque
						</font>
					</td>  	
					<td width="5%"></td> 		
  					<td align="center">
  						<a href="ServletBoletaje?tipo=<%=Constantes.ACCION_LISTAR_RESERVA%>&destino=<%=Constantes.CONFIRMAR_RESERVA%>">
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/embarque_boleto.png">
						</a>
						<br>
						<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
						Imprima sus Boletos (opcional)
						</font>
  					</td>
  					<td align="center">
  						 <a href="ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_VIAJE %>&destino=<%=Constantes.GENERAR_MANIFIESTO_DE_PASAJEROS %>"> 
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/pasajeros.png">
						</a>
						<br>
						<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
						Manifiesto de Pasajeros
						</font>
  					</td>
  				</tr>
  			</table>
  			
		</td>
		<td></td>
	</tr>	
	<tr>
		<td colspan="2"></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/embarque.png">
		</td>
	</tr>     
</table>        
</body>
<% if(mensaje != null){ %>	
		<h1><font color="red"><%= mensaje%></font></h1>
		<br>
	<%} %>	
</html>