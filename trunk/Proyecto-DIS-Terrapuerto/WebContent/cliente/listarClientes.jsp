<%@ taglib uri="/struts-tags" prefix="s" %>
<h2>Listado de Clientes</h2>
<table>
	<thead>
		<tr bgcolor="#CCCCCC">
			<th>&nbsp;</th>				
			<th><strong>Apellido Paterno</strong></th>
			<th><strong>Apellido Materno</strong></th>
			<th><strong>Nombre</strong></th>
			<th><strong>Direccion</strong></th>
			<th><strong>Telefono</strong></th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="listaClientes" status="clientesStatus">
			<tr bgcolor="<s:if test="#clientesStatus.odd == true ">#FFD1A8</s:if><s:else>#FFFFFF</s:else>">
				<td>
					
						<a href="<s:url action='mantenerCliente-%{idUsu}' method='editar'/>">Editar</a>					
						<a href="<s:url action='mantenerCliente-%{idUsu}' method='eliminar'/>">Eliminar</a>
										
						<a href="<s:url action='generarcontrolmovimiento'/>">Seleccionar</a>
					
					
					<a href="<s:url action='registrarpedido-%{codProd}' method='buscarproducto'/>">Seleccionar</a>
							
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


