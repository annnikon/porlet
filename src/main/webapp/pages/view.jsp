<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.aimprosoft.task5.model.Department"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<portlet:defineObjects />


<b>Task 5</b> portlet with <b>Hibernate</b>

<%String param = (String)request.getAttribute("s");
String deps = (String)request.getAttribute("deps");

%>
<h1>Init string is: <%=param%></h1>
<p>Deps: <%=deps%> </p>
