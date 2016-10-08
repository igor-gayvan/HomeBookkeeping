<%-- 
    Document   : book_list
    Created on : Oct 3, 2016, 9:34:39 PM
    Author     : Igor Gayvan
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of documents</title>
    </head>
    <body>
        <form action="index" method="Post">
            <br>
            <table>
                <tr>
                    <td>
                        <input type="submit" name="add" value="Добавить">
                    </td>
                    <td>
                        <input type="submit" name="refresh" value="Обновить">
                    </td>                    
                </tr>
                <tr>
                    <td><input type="submit" name="findByNote" value="Найти по Note (%)"></td>
                    <td><input type="text" name="textFindNote" value=""></td>
                </tr>
            </table>
        </form>

        <h1>Documents</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Is income</th>
                    <th>Note</th>
                    <th colspan="2">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="doc" items="${docs}">
                    <tr>
                        <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${doc.docDate}" /></td>
                        <td><c:out value="${doc.docAmount}" /></td>
                        <td><c:out value="  ${doc.isIncome}" /></td>
                        <td><c:out value="${doc.docNote}" /></td>
                        <td><a href="index?edit=${doc.docId}">Edit</a></td>
                        <td><a href="index?remove=${doc.docId}">Remove</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>        
    </body>
</html>
