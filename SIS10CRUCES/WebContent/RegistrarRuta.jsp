<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form>
		<table>
			<tr>
				<td>Codigo de Empresa</td>
				<td><input></td>
				<td><input type="submit"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>RUC</td>
				<td><input></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Razon Social</td>
				<td><input></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan='5'><table width="100%" border="1" cellspacing="0"
						bordercolor="CDB4A7">
						<tr>
							<th width="20%" height="20" class="cabeceraTabla"
								bgcolor="#CDB4A7">CODIGO</th>
							<th width="39%" class="cabeceraTabla" bgcolor="#CDB4A7">ORIGEN</th>
							<th width="13%" class="cabeceraTabla" bgcolor="#CDB4A7">DESTINO</th>
							<th width="15%" class="cabeceraTabla" bgcolor="#CDB4A7">KM</th>
							<th width="13%" class="cabeceraTabla" bgcolor="#CDB4A7">DURACION</th>
						</tr>
						<%Vector listaC=new Vector(); %>
						<%for(int i=0;i<listaC.size();i++){ %>
						<%Curso cu=listaC.getCurso(i); %>
						<tr align="center">
							<td height="20" class="cuerpoTabla"><%=cu.getCodCur()%></td>
							<td class="cuerpoTabla"><div align="left">
									&nbsp;&nbsp;<%=cu.getDesCur()%></div></td>
							<td class="cuerpoTabla"><%=cu.getCodSec()%></td>
							<td class="cuerpoTabla"><%=cu.getNumCre()%></td>
							<td class="cuerpoTabla"><%=cu.getCicEst()%></td>
						</tr>
						<%}%>
					</table></td>

				
			</tr>
			<tr>
				<td>Nombre de Ruta</td>
				<td></td>
				<td>Codigo Ruta</td>
				<td><input></td>
				<td><input type="submit"></td>
			</tr>
			<tr>
				<td>Origen</td>
				<td></td>
				<td>Km</td>
				<td><input></td>
				<td></td>
			</tr>
			<tr>
				<td>Destino</td>
				<td></td>
				<td>Duracion</td>
				<td><input></td>
				<td>Hrs</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>Estado</td>
				<td><select></select></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input value=Agregar type="submit"></td>
				<td><input value=Modificar type="submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>