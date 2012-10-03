<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#FFFFCC">
<table width="100%">
	<tr>
		<td width="20%"></td>
		<td>
			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Seguridad</b> <br><br><br><br>
  			</font>
  			<table cellpadding="2">
  				<tr>
					<td align="center">
						<a href="<%=application.getContextPath() %>/ServletClasificacion?tipo=<%=Constantes.ACCION_LISTAR_CLASIFICACION %>&destino=<%=Constantes.MANTENER_CLASIFICACION%>">
							<img style="width: 70%" alt="" src="<%=request.getContextPath()%>/images/seguridad_clasificacion.png">
						</a>
						<br>
			  			<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
							Gestione sus Clasificaciones
						</font>
					</td> 
					<td width="5%"></td> 				
					<td align="center">
		            	<a href="<%=application.getContextPath() %>/ServletProveedor?tipo=<%=Constantes.ACCION_LISTAR_PROVEEDOR %>&destino=<%=Constantes.MANTENER_PROVEEDOR%>">
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/seguridad_proveedores.png">
						</a>
						<br>
						<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
							Gestione a sus Proveedores
						</font>
					</td>  	
					<td width="5%"></td> 	
					<td align="center">
		            	<a href="<%=application.getContextPath() %>/ServletSeguridad?tipo=listar&origen=<%=Constantes.MENU_PRINCIPAL%>">
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/seguridad_usuario.png">
						</a>
						<br>
						<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
							Gestione a sus Usuarios
						</font>
					</td>  				
  				</tr>
  				<tr><td height="5%"><br></td></tr> 	
  				<tr>
  					<td align="center">
  						<a href="<%=application.getContextPath() %>/ServletSeguridad?tipo=listarPerfiles&origen=<%=Constantes.MENU_PRINCIPAL%>">
							<img style="width: 50%" alt="" src="<%=request.getContextPath()%>/images/seguridad_perfil.png">
						</a>
						<br>
						<font style="font-family: 'Trebuchet MS'; font-size: small; font-style: oblique;">
							Gestione sus Perfiles
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
			<img src="<%=request.getContextPath()%>/images/seguridad.png">
		</td>
	</tr>     
</table>   
</body>
</html>