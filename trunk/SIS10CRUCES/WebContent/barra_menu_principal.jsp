<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page import="pe.plazanorte.sisterra.entidades.*" %>
<%@ page import="pe.plazanorte.sisterra.entidades.Proveedor" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<SCRIPT>
function redirect()
{
 a = document.menPrin.opcion.value;
 switch(a){
 case "I":
    document.menPrin.action='<%=request.getContextPath()%>/principal.jsp';
    //document.menPrin.action='/servlet/DatosPersonales.servlets.GrabaDatPersoS';
	//document.menPrin.target='_self';
	return true;
    break; 
 case "C":
    document.menPrin.action='';
    //document.menPrin.target='_self';
	return true;
    break;
 case "D":
    document.menPrin.action='';
    //document.menPrin.target='_blank';
	return true;
    break;	
 case "B":
    document.menPrin.action='';
    //document.menPrin.target='_blank';
	return true;
    break;		
 case "P":  
    document.menPrin.action='';
	//  document.menPrin.target='_blank';
	return true;
    break;
  case "S": 
    document.menPrin.action='<%= request.getContextPath()%>/servlet/DatosPersonales.servlets.VeriHost_ip';
	return true;
	break;
	}
	return false;
	}
</SCRIPT>

<style>
 .presentacion{font-family:Arial;font-size:10px;color:#FFFFFF;text-align:center}
 .out {font-family: Arial;font-weight:bold; font-size:12px;color:#FFFFFF;text-align:center}
 .similar {font-family: Arial;font-weight:bold; font-size:10px;color:#FFFFFF;text-align:center}
</style>

<base target = "principal">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body bgcolor="black" topmargin="0" leftmargin="0" rightmargin="0">
<form action="Login" method="post" name="menPrin" target="presinf">
  	<%Usuario uu = (Usuario)session.getAttribute("BUsuario");%>
  	<%Perfil perfil = (Perfil)session.getAttribute("BPerfil");%>
	<%Proveedor proveedor = (Proveedor)session.getAttribute("BProveedor");%>
 <table style="width:100%; height: 35">
 <tr>
  	<td height="50" width = "50%" align="left">
		<img style="width: 8%" alt="" src="<%=request.getContextPath()%>/images/logo_terra.png">
	</td>
	<td height="50" width = "50%" align="right" valign="top">
		<img style="background-color: #F8F8F8; width: 8%" alt="" src="<%=request.getContextPath()%>/images/logo.png">
	</td>
 </tr>
 <tr>
  <td height="25" colspan="3" bgcolor="#999999">
  <table style="width: 100%">
  <tr>
    <td align="center" valign="top">
    	<a href="presentacion.jsp"><img style="width: 34px;" src="<%=request.getContextPath()%>/images/house.jpg"></a>
	</td>
    <td align="left">
		<font style="font-family: monospace; font-size: medium; color: white;">
			<b>Bienvenido, Sr. <br>
			<%=uu.getApePat()%> <%=uu.getApeMat()%>, <%=uu.getNombres()%><input type="hidden" name="usuario"  value="<%=uu.getId() %>"></b>			
		</font>
	</td>
	<td align="right" style="width: 55%">
		<font style="font-family: monospace; font-size: medium; color: white;">
			<b>Perfil: <%=perfil.getDescripcion()%></b><br>
<%
	if(perfil.getNombre().equals("PROVEEDOR")){
%>
		<b>Razón Social: <%=proveedor.getRazSocial()%></b>
		<br/>		
<%	
	}
%>
		</font>
		<a href="Login?tipo=<%=Constantes.CERRAR_SESION%>"  style="">Cerrar sesi&oacute;n</a>
	</td>
  </tr>
  </table>
  </td>
 </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#003300">
	<tr>
		<td width="40%"><input type=hidden name=server value=localhost>
			<input type=hidden name=port value=143> 
			<input type=hidden name=namespace> 
			<input type=hidden name=maildomain value=usmp.edu.pe> 
			<input type=hidden name=protocol value=imap/notls> 
			<input type=hidden name=realm> 
			<input type=hidden name=folders value=INBOX> 
			<input type=hidden name=new_lang value=es_ES> 
			<input type=hidden name=usuario value="<%=uu.getUsuario()%>"> 
			<input type=hidden name=password value="<%=uu.getClave()%>"> 
			<input type=hidden name=pw value="">
		</td>
	</tr>
</table>
</form>
</body>
</html>
