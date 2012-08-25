<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<sj:accordion id="accordion" autoHeight="false">
	<sj:accordionItem title="Menu Principal">
		<ul>
			<li><a href="<s:url action='buscarclientes-%{1}'/>">Buscar Clientes</a></li>
			<li><a href="<s:url action='buscarproductos-%{1}'/>">Buscar Productos</a></li>
			<li><a href="<s:url action='buscarvehiculos-%{1}'/>">Buscar Vehiculos</a></li>
			<li><a href="<s:url action='buscarencargados'/>">Buscar Encargados</a></li>
		</ul>
	</sj:accordionItem>
	<sj:accordionItem title="Distribucion" onClickTopics="loadAccordionDiv">
		<ul>
			<li><a href="<s:url action='mantenerproducto'/>">Registrar Producto</a></li>
			<li><a href="<s:url action='generarcontrolmovimiento'/>">Generar Guía de Control de Movimiento</a></li>
			<li><a href="<s:url action='registrarcomprobantepago'/>">Registrar Comprobante de Pago</a></li>
			<li><a href="<s:url action='registrarpedido-%{1}'/>">Registrar Pedido</a></li>
			<li><a href="<s:url action='asignarpedido'/>">Asignar Pedido</a></li>
		</ul>
	</sj:accordionItem>
</sj:accordion>
