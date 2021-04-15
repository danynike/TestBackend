<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer</title>
    </head>
    <body>
    	<div style="padding: 10px;"><a href="${pageContext.request.contextPath}/customer">Listado Cliente...</a></div>
        <h1>Agregar nuevo Cliente:</h1>
        <mvc:form modelAttribute="customer" action="create" method="POST">
            <table>
                <tr>
                    <td><mvc:label path="firstName">Nombre</mvc:label></td>
                    <td><mvc:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><mvc:label path="lastName">Apellido</mvc:label></td>
                    <td><mvc:input path="lastName"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                    	<mvc:hidden path="process" value="false"/>
                        <input type="submit" value="Enviar Cliente..."/>
                    </td>
                </tr>
            </table>
        </mvc:form>
    </body>
</html>
