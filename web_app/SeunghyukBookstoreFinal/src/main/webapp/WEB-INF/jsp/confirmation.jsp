<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="p" scope="request" type="viewmodel.ConfirmationViewModel"/>


<html>
<head>
    <title>My Bookstore - Confirmation</title>
    <meta charset="utf-8">
    <meta name="description" content="The Checkout Page for My Bookstore">

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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/confirmation.css"/>">

 </head>

<body>
<jsp:include page="header.jsp"/>

<main>

    <section id="confirmationMain">

        <div id="confirmationInfo">

            <table id="confirmationTable">
                <tr>
                    <td  class="tableTitle">
                        Your Transaction Is Confirmed!
                    </td>
                </tr>

                <tr>
                    <td>
                        Confirmation Number: ${p.order.confirmationNumber}
                    </td>
                </tr>
                <tr>
                    <td>
                        ${p.order.dateCreated.toGMTString()}
                    </td>
                </tr>

            </table>

            <table id="cartTable">
                <tr class="tableTitle">
                    <td>
                        Book
                    </td>
                    <td>
                        Quantity
                    </td>
                    <td>
                        Price
                    </td>
                </tr>

                <c:forEach var="item" items="${p.lineItem}">
                    <tr>
                        <c:forEach var="book" items="${p.books}">
                            <c:if test="${book.bookId == item.bookId}">
                                <td>${book.title}</td>
                                <td>${item.quantity}</td>
                                <td><fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${book.price/100}"/></td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>

                <tr>
                    <td>
                        Surcharge
                    </td>
                    <td>

                    </td>
                    <td>
                        <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="5.00"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        Total Amount
                    </td>
                    <td>

                    </td>
                    <td>
                        <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${p.order.amount/100}"/>
                    </td>
                </tr>
            </table>

            <table id="customerInfo">
                <tr>
                    <td class="tableTitle">
                        Customer Information
                    </td>
                </tr>
                <tr>
                    <td>
                    Name: ${p.customer.customerName}
                    </td>
                </tr>
                <tr>
                    <td>
                    Email: ${p.customer.email}
                    </td>
                </tr>
                <tr>
                    <td>
                    ${p.customer.address}
                    </td>
                </tr>
                <tr>
                    <td>
                        <c:set var="length" value="${p.customer.ccNumber.length()}"/>
                        <c:set var="month" value="${p.customer.ccExpDate.toGMTString().substring(2,5)}"/>
                        <c:set var="year" value="${p.customer.ccExpDate.toGMTString().substring(6,10)}"/>
                    Credit Card: **** **** **** ${p.customer.ccNumber.substring(length-4,length)} (exp date: ${p.customer.ccExpDate.month + 1}/${p.customer.ccExpDate.year +1900})
                    </td>
                </tr>
            </table>





        <%--<span id="checkoutInfoText">--%>
            <%--Your credit card will be charged <strong>total <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${p.cart.subtotal/100.00 + 5}"/></strong><br>--%>
            <%--(<strong>subtotal(<fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${p.cart.subtotal/100.00}"/>)</strong> + <strong>surcharge($5)</strong> shipping)--%>
        <%--</span>--%>

        </div>
    </section>

</main>
<jsp:include page="footer.jsp"/>

</body>
</html>
