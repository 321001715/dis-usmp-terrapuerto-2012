<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validar(){
	if(document.buscar.idProveedor.value.length == 0){
		alert("Debe llenar el campo de búsqueda.");
		document.buscar.idProveedor.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<form name="buscar" action="ServletProveedor" method="post" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="consultar">
	Buscar <input type="text" name="idProveedor" maxlength="9">
	<input type="submit" value="Buscar">
</form>

</body>
</html>