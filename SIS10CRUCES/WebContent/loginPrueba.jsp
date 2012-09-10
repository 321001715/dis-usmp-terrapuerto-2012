<%@ page info="Es la pagina del menu principal para los usuarios" %>
<%@ page import="pe.plazanorte.sisterra.entidades.TipoUsuario"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body {
	background-color: #114E7A;
}
</style>
<HEAD>
<TITLE>Sistema Terrapuerto</TITLE>
<script type="text/javascript">
function setfocus()
 {
  document.logeo.usuario.focus();
 }
//Abre una nueva ventana con unas dimensiones, y le asigna la URl en location.
function winopen()
{
 msg=open("","NewWindow","height=400,width=400")
 msg.location="<%=request.getContextPath()%>/Olvido.html" 
}
//notificaciones de usuario y password 
function validateNUM( field, field2 )
{
 if(field2.value == "" )
 {
  alert("Ingrese su password, por favor");
  return false;
 }
 if(field.value == "" )
 {
  alert("Ingrese su usuario, por favor");
  return false;
 }
 return true;
}
</SCRIPT>
<style>
.presentacion{font-family:Arial;font-size:12px;color:#FAFAEB;text-align:right}
.contenido{font-family:Arial;font-size:12px;color:#630000;background-color:white; border:1px solid #CFC5B8;width:75%}
</style>
</HEAD>
<body bgcolor="#114E7A" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setfocus()">
<%
	Vector<TipoUsuario> tUsuario= (Vector<TipoUsuario>)application.getAttribute("tipoUsuarios");


%>

<form name="logeo" method = "POST" action = "loginPrueba" onsubmit = "return validateNUM(this.usuario.value,this.password)">
<div align="center">
<center>

 <img src="images/login.JPG" width="360" height="123" />
 <table width="610" height="428" cellpadding="0" cellspacing="0">
 <tr>
  <td width="370" height="350" rowspan="7">&nbsp;</td>
  <td width="40" height="350" rowspan="7"></td>
  <td width="200" height="150" colspan="2"></td>
 </tr>
 <% String ip;
    String host;
    ip = request.getHeader("X-FORWARDED-FOR");
    host = request.getHeader("VIA");
    if(ip==null){
        ip=request.getRemoteAddr();
    }
    if(host==null){
        host=request.getRemoteHost();
    }
    %>
 <input type="hidden" name="ip" value="<%=ip%>">
 <input type="hidden" name="host" value="<%=host%>">
 <tr>
  <th width="80" height="20" class="presentacion">Usuario:</th>
  <td width="120" align="center"><input type="text" name="usuario" maxlength="10" size="10" class="contenido" onChange="javascript:this.value=this.value.toUpperCase();"></td>
 </tr>	
 <tr>
  <th height="20" class="presentacion">Password:</th>
  <td align="center"><input type="password" name="password" maxlength="10" size="10" class="contenido"></td>
 </tr>
 <tr>
  <!--td height="30"></td--> 
  <td  height="30" colspan="2" align="center">
   <select name="esc" class="contenido">
   
   
   <%if(tUsuario!=null){ 
	for (int i=0; i<tUsuario.size(); i++) { 
		TipoUsuario esc = tUsuario.get(i);
       if (esc.getPerfil().equals("Administrador")){%>
          <option value="<%=esc.getId()%>" selected><%=esc.getPerfil()%></option>
       <%}else{%>
          <option value="<%=esc.getId()%>"><%=esc.getPerfil()%></option>
       <%}%>
   <%}%>
   <%}%>
   </select></td>
 </tr>	
 <tr>
  <td height="20" colspan="2" align="center">
   <input border="0" src="<%=request.getContextPath()%>/images/entrar.gif" name="I1" width="80" height="20" type="image"></td>
 </tr>
 <tr>
  <td height="30" colspan="2" class="presentacion">
   <a href="<%=request.getContextPath()%>/Olvido.jsp" target="top"><font color="#FAFAEB">Ayuda, Olvide mi Contrase&ntilde;a</font></a></td>
 </tr>
 <tr>
  <td colspan="2" height="60"></td>
 </tr>
 <tr>
  <td colspan="4" height="30"><img src="<%=request.getContextPath()%>/images/pie1.gif"></td>
 </tr>
 </table>
 </center>
 </div>
</form>
</body>
</html>