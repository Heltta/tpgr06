<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <% System.out.print(""); %>
    <% System.out.print(response.getHeader("mensaje")); %>
    <% if (request.getAttribute("exito") != null) {%>
		<div class="alert alert-danger" role="alert">
		  <%=request.getAttribute("mensaje")%>
		</div>
	<% } else if (request.getParameter("mensaje") != null) {  %>
		<div class="alert alert-success" role="alert">
		  <%=request.getParameter("mensaje").replace("%20"," ")%>
		</div>
	<% } %>	