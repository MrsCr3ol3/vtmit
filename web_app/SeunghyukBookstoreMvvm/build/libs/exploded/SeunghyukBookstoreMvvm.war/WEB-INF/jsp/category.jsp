<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="p" scope="request" type="viewmodel.CategoryViewModel"/>


<!doctype html>
<html>
<head>
    <title>Bookstore Category Page</title>
    <meta charset="utf-8">
    <meta name="description" content="The category page for a bookstore">

    <!--
        normalize-and-reset.css.css is a basic CSS reset; useful for starting from ground zero.
        always include this first.
    -->

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/normalize-and-reset.css"/>">


    <!--
        cascading appropriately, we have:

        main.css    --  all things common
        header.css  --  header-specific rules
        footer.css  --  footer-specific rules
        <page>.css  --  page-specific rules
        extras.css  --  extras you may want
    -->

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/category.css"/>">


</head>

<body>
<main>
    <jsp:include page="header.jsp"/>
    <h1 style="padding-left: 60px"><span style="text-transform: capitalize">${p.selectedCategory.name}</span></h1>


    <div id="categoryContainer">

        <div class="vertical-menu">

                <c:forEach var="category" items="${p.categories}">
                    <c:choose>
                        <c:when test="${category.name == p.selectedCategory.name}">
                            <a href="category?category=${category.name}" class="active">
                                <span style="text-transform: capitalize">${category.name} </span>
                            </a>
                        </c:when>

                        <c:otherwise>
                            <a href="category?category=${category.name}">
                                <span style="text-transform: capitalize">${category.name} </span>
                            </a>
                        </c:otherwise>

                    </c:choose>
                </c:forEach>
            </div>

            <c:forEach var="books" items="${p.selectedCategoryBooks}">
                <div class="bookDisplay imgDisplay" style="padding: 10px">
                    <img src="${initParam.bookImages}bookid${books.bookId}.jpg" alt="${initParam.siteImages}bookid${books.bookId}">
                    <div style="padding-top: 10px; max-width: 120px">
                        <h3>${books.title}</h3>
                        <h4>${books.author}</h4>
                        <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${books.price/100.0}"/>
                        <c:if test="${books.isPublic}">
                            <a href="category?category=${category.name}">
                            <img class="imgDisplay" src="${initParam.siteImages}readnowok.png" atl="read now">
                            </a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>

    </div>
    <jsp:include page="footer.jsp"/>
</main>
</body>
</html>
