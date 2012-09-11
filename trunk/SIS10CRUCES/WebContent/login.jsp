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
<script type="text/javascript" src="jquery/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="jquery/js/jquery-ui-1.7.3.custom.min.js"></script>
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<style type="text/css">
	@import "css/estilo.css";
body {
	background-color: #FFCC00;
	background-image: url(images/bgblack.jpg);
}
body,td,th {
	font-weight: bold;
}
</style>
<TITLE>:: Bienvenido al Sistema 10C+ ::</TITLE>
<script type="text/javascript">
function aUpperCase(field) {
        field.value = field.value.toUpperCase();
};
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
function validate( field, field2 )
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
<body bgcolor="FFCC00" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setfocus()">
<%
	Vector<TipoUsuario> tUsuario= (Vector<TipoUsuario>)application.getAttribute("tipoUsuarios");
%>
<div class="uicenter">
<form method="POST" action="Login" onsubmit="validate(this.usuario.value,this.password)">
	<div align="center" >
 <table border="1">
 	<tr>
  		<td width="370" height="350" rowspan="7">
  			<div align="center"><img src="images/sesion.gif" width="165" height="133" align="middle"></div>
		</td> 
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
  <td width="120" align="center"><input type="text" name="usuario" maxlength="10" size="10" class="contenido" onchange="aUpperCase(this)"></td>
 </tr>	
 <tr>
  <th height="20" class="presentacion">Password:</th>
  <td align="center"><input type="password" name="password" maxlength="10" size="10" class="contenido"></td>
 </tr>
 <tr>
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
   <input src="<%=request.getContextPath()%>/images/entrar.jpg" name="I1" width="80" height="20" type="image"></td>
 </tr>
 <tr>
  <td height="30" colspan="2" class="presentacion">
   <a href="<%=request.getContextPath()%>/Olvido.jsp" target="top"><font color="#FAFAEB">Olvidé mi Contrase&ntilde;a</font></a></td>
 </tr>
 <tr>
  <td colspan="2" height="60"></td>
 </tr>
 <tr>
 </tr>
 </table>
 
 </div>
</form>
</div>
</body>
</html>