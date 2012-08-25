<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.:Sistema Terrapuerto:.</title>
<link rel="stylesheet" href="css/plantilla.css" type="text/css">	
<sj:head jqueryui="true" jquerytheme="humanity"/>
</head>
<body>
<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header" /> 
	</div>
	<div id="left" style="width: 20%; margin-left: 15px;margin-top: 30px;">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="right">
		<tiles:insertAttribute name="body" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</div>
</body>
</html>