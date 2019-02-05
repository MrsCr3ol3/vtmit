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
<jsp:include page="header.jsp"/>

<main>
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

            <c:forEach var="book" items="${p.selectedCategoryBooks}">
                <div class="bookDisplay imgDisplay" style="padding: 10px">
                    <img src="${p.bookImagePath}bookid${book.bookId}.jpg" alt="bookid: ${book.bookId}">
                    <div style="padding-top: 10px;margin-left:5px;max-width: 120px">
                        <h3>${book.title}</h3>
                        <h4>${book.author}</h4>
                        <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${book.price/100.0}"/>
                        <c:if test="${book.isPublic}">
                            <a href="category?category=${category.name}">
                            <img class="imgDisplay" src="${p.siteImagePath}readnowok.png" atl="read now">
                            </a>
                        </c:if>

                        <button class="addToCartButton"
                                data-book-id="${book.bookId}"
                                data-action="add">
                            Add to Cart
                        </button>
                    </div>
                </div>
            </c:forEach>

    </div>
</main>
<jsp:include page="footer.jsp"/>

</body>

<script src="<c:url value="/js/ajax-functions.js"/>" type="text/javascript"></script>

<script>
    var addToCartButtons = document.getElementsByClassName("addToCartButton");
    for (var i = 0; i < addToCartButtons.length; i++) {
        addToCartButtons[i].addEventListener("click", function(event) {
            addToCartEvent(event.target) });
    }

    function addToCartEvent(button) {
        //alert("Inside AddToCartEvent");
        var data = {"bookId":button.dataset.bookId,
            "action":button.dataset.action
        };

        ajaxPost('category', data, function(text, xhr) {
            addToCartCallback(text, xhr)
        });
    }

    function addToCartCallback(responseText, xhr) {
        //alert('Response text: ' + responseText + '; Ready state is ' + xhr.readyState);
        var cartCount = JSON.parse(responseText).cartCount;
        document.getElementById('cartCount').textContent = '' + cartCount;
    }
</script>

</html>
