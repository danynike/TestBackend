<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h1>Listado de Clientes</h1>
        <div style="padding: 10px;"><a href="${pageContext.request.contextPath}/customer/form">Agregar Cliente...</a></div>
        <mvc:form modelAttribute="customerList" method="POST" action="process">
	        <table border="1">
	            <tr>
	            	<th style="width:  50px;">No</th>
	                <th style="width: 250px;">Nombre</th>
	                <th style="width: 150px;">Apellido</th>
	                <th style="width: 150px;">Procesado</th>
	                <th style="width: 100px;"></th>
	            </tr>
	            <c:forEach var="customer" 
	                       items="${customerList.customers}"
	                       varStatus="status">
	                <tr>
	                    <td><b>${status.index + 1}</b><mvc:hidden path="customers[${status.index}].id" value="${customer.id}"/></td>
	                    <td>${customer.firstName}<mvc:hidden path="customers[${status.index}].firstName" value="${customer.firstName}"/></td>
	                    <td>${customer.lastName}<mvc:hidden path="customers[${status.index}].lastName" value="${customer.lastName}"/></td>
	                    <td><mvc:checkbox path="customers[${status.index}].process" value="${customer.process}"/></td>
	                    <td><a href="${pageContext.request.contextPath}/customer/delete/${customer.id}">Borrar</a></td>
	                </tr>
	            </c:forEach>
	            <tr>
	            	<td colspan="5"><input type="submit" value="Procesar..."/></td>
	            </tr>
	        </table>
        </mvc:form>
    </body>
</html>
