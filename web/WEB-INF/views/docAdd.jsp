<%-- 
    Document   : docAdd
    Created on : Oct 3, 2016, 10:09:35 PM
    Author     : Igor Gayvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding</title>
    </head>
    <body>
        <form action="add" method="Post"> 
            <br>
            <input type="submit" name="cancel" value="Отменить">
            <input type="reset" name="clear" value="Очистить">
            <input type="submit" name="confirm" value="Принять"> 

            <h1>Document</h1>

            <table border="1">
                <tbody>
                    <tr>
                        <td>Amount</td>
                        <td><input type="text" name="docAmount" 
                                   value="<c:out value="${param.docAmount}" />"/> <span style="color: red;">${errors.errAmount}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Date</td>
                        <td><input type="text" name="docDate" 
                                   value="<fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${doc.docDate}" />"/> <span style="color: red;">${errors.errDate}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Note</td>
                        <td><input type="text" name="docNote" 
                                   value="<c:out value="${param.docNote}" />"/> <span style="color: red;">${errors.errNote}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Income</td>
                        <td><input type="checkbox" name="isIncome"                                    
                                   <c:if test="${param.isIncome == 'true'}">
                                       checked 
                                   </c:if>
                                   /> 
                            <span style="color: red;">${errors.errIncome}</span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
