<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#FFCCCC">
<table width="100%">
	<tr>
		<td width="20%"></td>
		<td>
			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Ventas</b> <br><br><br><br>
  			</font>
  			<table cellpadding="2">
  				<tr>
					<td align="center">
						<a href="<%=application.getContextPath() %>/ServletBoletaje?tipo=<%=Constantes.VENDER_BOLETO %>">
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/venta_boleto.png">
						</a>
						<br>
			  			<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
							Venda sus Boletos
						</font>
					</td> 
					<td width="10%"></td> 				
					<td align="center">
		            	<a href="<%=application.getContextPath() %>/ServletProveedor?tipo=listar_ruta">
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/___.png">
						</a>
						<br>
						<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
							...
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
			<img src="<%=request.getContextPath()%>/images/ventas.png">
		</td>
	</tr>     
</table>        
</body>
</html>