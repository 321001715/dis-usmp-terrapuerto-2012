<%@ taglib uri="/struts-tags" prefix="s" %>
<h2>Listado de Productos</h2>
<table>
	<thead>
		<tr bgcolor="#CCCCCC">
			<th>&nbsp;</th>				
			<th><strong>Codigo</strong></th>
			<th><strong>Nombre</strong></th>
			<th><strong>Tipo</strong></th>	
			<th><strong>Unidad</strong></th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="listaproductos" status="productosStatus">
			<tr bgcolor="<s:if test="#productosStatus.odd == true ">#FFD1A8</s:if><s:else>#FFFFFF</s:else>">
				<td>
					<s:if test="tipoBuscar == 1 ">
						<a href="<s:url action='mantenerproducto-%{codProd}' method='editar'/>">Editar</a>					
						<a href="<s:url action='mantenerproducto-%{codProd}' method='eliminar'/>">Eliminar</a>
					</s:if>
					<s:elseif test="tipoBuscar == 2 ">
						<a href="<s:url action='generarcontrolmovimiento'/>">Seleccionar</a>
					</s:elseif>	
					<s:else>
					<a href="<s:url action='registrarpedido-%{codProd}' method='buscarproducto'/>">Seleccionar</a>
					</s:else>			
				</td>
				
				<td>
					<s:property value="codProd"/>		</td>
				<td>
					<s:property value="nomProd"/>		</td>
				<td>
					<s:if test="%{tipoProd=='B'}">Balones</s:if>
					<s:else>Galones</s:else>					</td>
				<td>
					<s:property value="unidadmedida.nombreUnimed"/>		</td>
			</tr>	
		</s:iterator>
	</tbody>
</table>


