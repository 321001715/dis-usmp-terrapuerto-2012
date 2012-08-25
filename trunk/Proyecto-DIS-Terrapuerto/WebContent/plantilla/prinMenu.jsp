<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<sj:accordion id="accordion" autoHeight="false">
	<sj:accordionItem title="Empresa de Transporte">
		<ul>
			<li><a href="<s:url action='buscarclientes-%{1}'/>">Listar Empresas de Transportes</a></li>
			<li><a href="<s:url action='mantenerEmpresa'/>">Registrar Empresa de Transporte</a></li>
		</ul>
	</sj:accordionItem> 
	<sj:accordionItem title="Servicio" onClickTopics="loadAccordionDiv">
		<ul>
			<li><a href="#">Listar Servicios</a></li>
			<li><a href="#">Registrar Servicio</a></li>
		</ul>
	</sj:accordionItem>
</sj:accordion>
