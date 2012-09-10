<%@ page import="pe.plazanorte.sisterra.entidades.Usuario" %>
<html>
<head>
<SCRIPT>
function redirect()
{
 a = document.menPrin.opcion.value;
 switch(a){
 case "I":
    document.menPrin.action='<%=request.getContextPath()%>/principal2.jsp';
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
</head>
<body bgcolor="#630000" topmargin="0" leftmargin="0" rightmargin="0" ">
  <form action="" method="post" name="menPrin"  onsubmit="return redirect();" target="presinf">
  <%Usuario uu = (Usuario)session.getAttribute("BUsuario");%>
 <table width = "100%" border = "0" align = "center" cellpadding = "0" cellspacing = "0">
 <tr>
  <td height="50" width = "230" align="center">
   <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="230" height="50">
    <param name="movie" value="<%=request.getContextPath()%>/FLASH/barra.swf">
    <param name="quality" value="high">
    <embed src="<%=request.getContextPath()%>/FLASH/barra.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="230" height="50"></embed>
   </object></td>
  <td>
   <div align = "center"> 
   <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="41">
    <param name="movie" value="<%=request.getContextPath()%>/FLASH/banner.swf">
    <param name="quality" value="high">
    <embed src="<%=request.getContextPath()%>/FLASH/banner.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="41"></embed>
   </object>
   </div></td>
 </tr>
 <tr>
  <td height="25" colspan="2" bgcolor="#000000" align="center">
  <table border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="800" height="18">
      <param name="movie" value="<%=request.getContextPath()%>/FLASH/botones.swf">
      <param name="quality" value="high">
      <embed src="<%=request.getContextPath()%>/FLASH/botones.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="800" height="18"></embed>
    </object>
	</td>
  </tr>
  </table>
  </td>
 </tr>
</table>
<table width = "100%" border = "0" cellpadding = "0" cellspacing = "0" bgcolor = "#003300">
  <tr> 
     <td  bgcolor="#000000" width="40%">
	 <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="242" height="23">
        <param name="movie" value="<%=request.getContextPath()%>/FLASH/fecha.swf">
        <param name="quality" value="high"><param name="BGCOLOR" value="#000000">
        <embed src="<%=request.getContextPath()%>/FLASH/fecha.swf" width="242" height="23" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" bgcolor="#000000"></embed></object>
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
		<input type=hidden name=opcion value=""></td>
    <td width = "25%" height = "12" bgcolor = "#000000" nowrap> <font color = "#FFFFFF" size = "2" face = "arial"> 
      <b>Bienvenido, <%= uu.getApeMat() %>&nbsp;&nbsp;&nbsp;</b></font></td>
  </tr>
</table>
</form>
</body>
</html>
