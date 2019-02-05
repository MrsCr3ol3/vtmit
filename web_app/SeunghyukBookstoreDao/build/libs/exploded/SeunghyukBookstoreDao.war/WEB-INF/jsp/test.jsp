<%--
  Created by IntelliJ IDEA.
  User: HYUK
  Date: 9/25/2017
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<h1>Seunghyuk's Bookstore Database!</h1>


    <li><a href="test?category=fictions">fictions</a></li>
    <li><a href="test?category=textbook">textbook</a></li>
    <li><a href="test?category=business">business</a></li>
    <li><a href="test?category=children">children</a></li>

<h2 style="font-size:60px">
${fn:toUpperCase(fn:substring(selectedCategoryName, 0, 1))}${fn:toLowerCase(fn:substring(selectedCategoryName, 1,fn:length(selectedCategoryName)))}
</h2>
<table border="1">
    <tr>
        <th>book_id</th>
        <th>title</th>
        <th>author</th>
        <th>price</th>
        <th>is_public</th>
        <th>category_id</th>
    </tr>

    <c:forEach var="books" items="${bookList}">
    <tr>
        <td><c:out value="${books.bookId}"/></td>
        <td><c:out value="${books.title}"/></td>
        <td><c:out value="${books.author}"/></td>
        <td><c:out value="${books.price}"/></td>
        <td><c:out value="${books.isPublic}"/></td>
        <td><c:out value="${books.categoryId}"/></td>
    </tr>
    </c:forEach>
</table>


<%--

<sql:query var="result" dataSource="jdbc/SeunghyukBookstore">
    SELECT * FROM category, book
    WHERE category.category_id = book.category_id
</sql:query>
<table border="1">
    <!-- column headers -->
    <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

--%>

</body>
</html>
