<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
<%
	String mensaje = (String)request.getAttribute("mensaje");
	Usuario usuario = (Usuario)session.getAttribute("usuario");	
%>

<%
	if(usuario == null){
%>
<form method="post" action="Login">
	<table align="right">
    	<tr>
        	<td><span class="Estilo7">Usuario </span></td>
            <td><input type="text" style="width:120px;" name="txt_usuario"/></td>
        </tr>
        <tr>
        	<td><span class="Estilo7">Password</span> </td>
            <td><input type="password" style="width:120px;" name="txt_clave"/></td>
        </tr>
        <tr>
        	<td colspan="2" class="contenedor_boton"><input type="submit" value="Entrar" class="boton"/></td>
        </tr>
        <tr>
        	<td colspan=2>
        		<%	if(mensaje != null){ %>	
        		<font color="red"><%=mensaje%></font>        		
        		<% } %>        		
        	</td>
        </tr>
    </table>
</form>

<% } %>
<% if(usuario != null){ %>
	<br>
	<table align="right" style="text-align: right;">
		<tr>
			<td colspan=2 class="Estilo7">Bienvenido <%=usuario.getNombres() %></td>
		</tr>
		<tr>
			<td></td><td class="Estilo7"><a href="Login">Cerrar sesion</a></td>
		</tr>
	</table>
	<br>
	<br>
	<br>	
<% } %>