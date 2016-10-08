<%-- 
    Document   : index
    Created on : Oct 3, 2016, 9:29:12 PM
    Author     : Igor Gayvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setStatus(301);
    response.setHeader("Location", "index");
    response.setHeader("Connection", "close");
%>