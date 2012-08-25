<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<s:property value="mensaje"/>
<%-- Datos Pedido --%>
<s:div name="pedido">
	<fieldset>
		<legend style="font-weight:bold;">Datos Pedidos</legend>
		<s:textfield name="registroPedido.pedido.nropedido" label="%{getText('registroPedido.pedido.nropedido')}" />
		<sj:datepicker name="registroPedido.pedido.fechEntrega" label="%{getText('registroPedido.pedido.fechEntrega')}" />
	</fieldset>
</s:div>
<%-- FIN Datos Pedido --%>

<%-- Buscar Cliente --%>
<s:div name="cliente" label="%{getText('')}">
	<fieldset>
	<legend style="font-weight:bold;">Datos Cliente</legend>
		
	<s:form action="buscarclientes-%{2}" id="buscarcli">
		<s:textfield name="registroPedido.cliente.codCli" label="%{getText('registroPedido.cliente.codCli')}" disabled="true"/>
		<s:textfield name="registroPedido.cliente.nomCli" label="%{getText('registroPedido.cliente.nomCli')}" disabled="true"/>
		<s:textfield name="registroPedido.cliente.dniCli" label="%{getText('registroPedido.cliente.dniCli')}" disabled="true"/>
		<s:submit  value="%{getText('registroPedido.cliente.button')}" />
	</s:form>
	</fieldset>
</s:div>

<%-- Buscar Producto --%>
<s:div name="producto" label="Datos Producto">
	<fieldset>	
	<legend style="font-weight:bold;">Datos Productos</legend>
	
	<s:form action="buscarproductos-%{3}">
		<s:textfield name="registroPedido.producto.codProd" label="%{getText('registroPedido.producto.codProd')}" disabled="true"/>
		<s:textfield name="registroPedido.producto.nomProd" label="%{getText('registroPedido.producto.nomProd')}" disabled="true"/>
		<s:textfield name="registroPedido.producto.unidadmedida.nombreUnimed" label="%{getText('registroPedido.producto.unidadmedida.nombreUnimed')}" disabled="true"/>
		<s:submit value="%{getText('registroPedido.producto.button')}" />
	</s:form>
	
	<s:form action="registrarpedido-%{1}">
		<s:textfield name="registroPedido.cantidad" label="%{getText('registroPedido.cantidad')}" required="true"/>
		<s:textfield name="registroPedido.precio" label="%{getText('registroPedido.precio')}" required="true"/>
		<s:submit value="Agregar" method="agregar"/>
	</s:form>
	
	<s:div name="detalle" label="Detalle Producto">	
		<table>
			<thead>
				<tr bgcolor="#CCCCCC">
					<th><strong>Item</strong></th>
					<th><strong>Producto</strong></th>
					<th><strong>UM</strong></th>	
					<th><strong>Cantidad</strong></th>
					<th><strong>Precio</strong></th>
					<th><strong>Accion</strong></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="registroPedido.listaDetPedido" status="pedidoStatus">
					<tr bgcolor="<s:if test="#pedidoStatus.odd == true ">#FFD1A8</s:if><s:else>#FFFFFF</s:else>">
						
						<td>
							<s:property value="id.codItem"/>	</td>
						<td>
							<s:property value="producto.nomProd"/>	</td>
						<td>
							<s:property value="producto.unidadmedida.nombreUnimed"/>	</td>
						<td>
							<s:property value="cantidad"/>	</td>
						<td>
							<s:property value="precio"/>	</td>
						<td>
							<a href="<s:url action='registrarpedido-%{id.codItem}' method='eliminar'/>">%{getText('registroPedido.list.Eliminar')}</a>	<td>			
					</tr>	
				</s:iterator>
			</tbody>
		</table>
	</s:div>		
	</fieldset>
</s:div>

<%-- Datos Pedido --%>
<s:div name="pedidos">		
	<s:form action="registrarpedido" id="registrar">
		<s:submit method="registrar"  value="%{getText('registroPedido.registrar')}" />
	</s:form>
</s:div>
<%-- FIN Datos Pedido --%>


