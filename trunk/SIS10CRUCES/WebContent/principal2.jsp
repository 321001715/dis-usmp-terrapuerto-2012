<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="pe.plazanorte.sisterra.entidades.*" %>

<script language="JavaScript">

  </script>
 
<html>
<head>
<SCRIPT> 
if (history.forward(1))
    {
    location.replace(history.forward(1));
    }
</SCRIPT>

<title>Menu Principal &sect;&cent; </title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<STYLE TYPE = "text/css">
	a.menu2:link{color: white;text-decoration: none}
	a.menu2:visited{color: #FFE3B5;text-decoration: none}
	a.menu2:active{color: #CE9A63;text-decoration: none}
	a.menu2:hover{color: #FFE3B5;text-decoration: none;font-weight: bold }
</STYLE>
</head>

<% Usuario uu = (Usuario)session.getAttribute("BUsuario"); %>
<%--body bgcolor="#630000" modificado por la sgte linea 2011/08/29--%>
<body bgcolor="#FFCC00"> 
<form action="" method="post" name="menPrin" onsubmit="return redirect();">
<div align="center">
  <table border="2" style="width: 100%">
  	<tr>
  		<td colspan = 3>
  			Bienvenido al nuevo portal que les ofrece el Terminal Terrestre Plaza Norte
  		</td>
  	</tr>
  	<tr align="center">
  		<td>
  			Módulo de Proveedor
  		</td>
  		<td>
  			Módulo de Ventas
  		</td>
  		<td>
  			Módulo de Seguridad
  		</td>
  	</tr>
  </table>
    <table border="2" width="600" height="320" bgcolor="#114E7A" cellpadding="0" cellspacing="0">
      <tr> 
        <td width="430" height="300" rowspan="12" bgcolor="#666666">
		 <div align="center"> 
            <center>
              <table border="0" width="420" height="303" cellpadding="0" cellspacing="0">
                <tr> 
                  <td width="420" height="7" colspan="4" bgcolor="#FFE3B5"></td>
                </tr>
                <tr>
                  <td width="420" height="30" colspan="4" align="center">&nbsp;</td>
                </tr>
                <tr> 
                  <td width="60" height="230"></td>
                  <td width="145" height="230" align="justify"><font size="1" face="Arial">
					</font></td>
                  <td width="155" height="230" align="center">&nbsp;</td>
                  <td width="60" height="230"></td>
                </tr>
                <tr> 
                  <td width="420" height="30" colspan="4" align="center"></td>
                </tr>
              </table>
            </center>
          </div></td>
        <td width="151" height="15" colspan="2"></td>
        <td width="10" height="15"></td>
      </tr>
      <tr> 
        <td width="10" height="290" rowspan="11">&nbsp;</td>
        <td width="141" height="14" background="<%=request.getContextPath()%>/imagenes/esc_inf006.gif">&nbsp;</td>
        <td width="10" height="305" rowspan="12">&nbsp;</td>
      </tr>
      <tr> 
        <td width="141" height="12" bgcolor="#666666"></td>
      </tr>
      <tr> 
        <td width="141" height="30" bgcolor="#666666" align="center">
		<!--input  style="background-color:#630000 ; color:#FFFFFF; border:0px #630000 solid; cursor:hand" 
		        type="submit" value="Gestión Académica" name="gestion" onclick="document.menPrin.opcion.value='G';"-->
		<font size="2" face="Arial">
		<a href="<%=request.getContextPath()%>/index.jsp" target="_self" class = "menu2">Gestion Interna</a></font>
	  </td>
      </tr>
      <tr> 
        <td width="141" height="30" bgcolor="#666666" align="center"> 
		<input  style="background-color:#630000 ; color:#FFFFFF; border:0px #630000 solid; cursor:hand" 
		        type="submit" value="MAS" name="correo" onclick="document.menPrin.opcion.value='C';">
		</td>
      </tr>
      <tr> 
        <td width="141" height="30" bgcolor="#666666" align="center">
		<input  style="background-color:#630000 ; color:#FFFFFF; border:0px #630000 solid; cursor:hand" 
		        type="submit" value="MAS" name="datperso" onclick="document.menPrin.opcion.value='D';">
	  </td>
      </tr>
      <tr> 
        <td width="141" height="30" bgcolor="#666666" align="center">
		<input  style="background-color:#630000 ; color:#FFFFFF; border:0px #630000 solid; cursor:hand" 
		        type="submit" value="MAS" name="gradTit" onclick="document.menPrin.opcion.value='GT';">
	  </td>
      </tr>
      <tr> 
        <td width="141" height="30" bgcolor="#666666" align="center">
    <font size="2" face="Arial">
		<a href="<%=request.getContextPath()%>/servlet/EventosyEncuestas.servlets.MenuEnc" target="_self" class = "menu2">
		&nbsp;&nbsp;&nbsp;&nbsp;MAS</a></font>
	    </td>
      </tr>
      <tr> 
         <td width="141" height="30" bgcolor="#666666" align="center">
    <font size="2" face="Arial">
		<a href="<%=request.getContextPath()%>/servlet/Publi.servlets.MenuPubli" target="_self" class = "menu2">
		&nbsp;&nbsp;&nbsp;&nbsp;MAS</a></font>
	    </td>
      </tr>
      <tr> 
        <td width="141" height="10" bgcolor="#666666"></td>
      </tr>
      <tr> 
        <td width="141" height="14" bgcolor="#666666"630000>
		<!--componentes de las ventanas a enviar-->
		<input type=hidden name=server value=localhost>
		<input type=hidden name=port value=143> 
		<input type=hidden name=namespace > 
		<input type=hidden name=maildomain value=usmp.edu.pe> 
		<input type=hidden name=protocol value=imap/notls> 
		<input type=hidden name=realm>
		<input type=hidden name=folders value=INBOX>
		<input type=hidden name=new_lang value=es_ES>
        <input type=hidden name=user value="<%=uu.getUsuario()%>">
		<input type=hidden name=pass value="<%=uu.getClave()%>">
		<input type=hidden name=pw value="<%=uu.getClave()%>">
		<input type=hidden name=opcion value="">
		</td>
      </tr>
      <tr> 
        <td width="141" height="60" bgcolor="#666666">&nbsp;</td>
      </tr>
      <tr> 
        <td width="590" height="15" colspan="3"></td>
      </tr>
    </table>
  </center>
</div>
</form>
</body>
<SCRIPT>
function redirect()
{
 a = document.menPrin.opcion.value;
 switch(a){
 case "G":
    document.menPrin.action='<%=request.getContextPath()%>/servlet/GestionAcademica.servlets.GesAcaS';
    document.menPrin.target='_self';
	return true;
    break; 
 case "C":
    document.menPrin.action='http://mail.usmp.edu.pe/horde/imp/redirect.php?Horde=6a86f3009472eba58667c9756d1a3496';
    document.menPrin.target='_self';
	return true;
    break;
 case "D":
    document.menPrin.action='./EventosYEncuestas/FrameEveyEncuPrinc.html';
    document.menPrin.target='_self';
	return true;
    break;	
 case "GT":
    document.menPrin.action='<%=request.getContextPath()%>/GradosYTitulos/FrameGraTit.html';
    document.menPrin.target='_self';
	return true;
    break;		
 case "B":
    document.menPrin.action='http://www.derecho.usmp.edu.pe/bolsatrabajo/aut_verifica.inc.php';
	document.menPrin.target='_blank';
	return true;
    break;
  case "P": 
    document.menPrin.action='<%=request.getContextPath()%>/Publicaciones/FramePubliPrinc.html';
    document.menPrin.target='_self';
	return true;
    break;
  }
  return false;
 }	
</SCRIPT>
</html>