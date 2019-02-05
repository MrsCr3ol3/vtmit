<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="p" scope="request" type="viewmodel.CartViewModel"/>
<html>
<head>
    <title>Bookstore Cart Page</title>
    <meta charset="utf-8">
    <meta name="description" content="The cart page for a bookstore">

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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/cart.css"/>">

</head>
<body>
<jsp:include page="header.jsp"/>

<main>

    <section id="cartMain">

        <c:choose>
            <c:when test="${p.cart.numberOfItems == 0}">
                <p>Your shopping cart is empty</p>
                <a href="category?category=${selectedCategoryString}" class="boldButton">continue shopping</a>
            </c:when>

            <c:otherwise>

                <p>Your Cart Contains ${p.cart.numberOfItems} Items</p>
                <div id="cartButtons">
                    <a href="category?category=${selectedCategoryString}" class="boldButton">continue shopping</a>
                    <a href="checkout" class="boldButton">proceed to checkout</a>
                </div>
                <p>subtotal: <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${p.cart.subtotal/100.00}"/> </p>


                <table id="cartTable">

                    <c:forEach var="book" items="${p.cart.items}">

                        <tr>
                            <td>${book.book.title}</td>
                            <td><fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${book.book.price/100.00}"/>
                                <c:if test="${book.quantity > 1}">
                                    (X ${book.quantity})
                                </c:if>
                            </td>
                            <td>
                                <div class="incrDecrDiv">
                                    <form action="cart" method="post">

                                            <input class="increaseButton" type="image"
                                               src="${p.siteImagePath}cartincrease.png" atl="increase button">
                                            <input type="hidden" name="bookId" value="${book.book.bookId}"/>
                                            <input type="hidden" name="action" value="add"/>
                                    </form>
                                    <form action="cart" method="post">
                                        <div>
                                            <input class="decrementButton" type="image"
                                                   src="${p.siteImagePath}cartdecrease.png" atl="decrease button">
                                            <input type="hidden" name="bookId" value="${book.book.bookId}"/>
                                            <input type="hidden" name="action" value="out"/>
                                        </div>
                                    </form>
                                </div>
                            </td>
                        </tr>

                    </c:forEach>

                </table>

            </c:otherwise>

        </c:choose>

    </section>

</main>
<jsp:include page="footer.jsp"/>

</body>
</html>