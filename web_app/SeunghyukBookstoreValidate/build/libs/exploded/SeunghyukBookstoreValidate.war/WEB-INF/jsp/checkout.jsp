<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="p" scope="request" type="viewmodel.CheckoutViewModel"/>

<!doctype html>
<html>
<head>
    <title>My Bookstore - Category</title>
    <meta charset="utf-8">
    <meta name="description" content="The category page for My Bookstore">

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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/checkout.css"/>">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="<c:url value="/js/jquery.validate.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/additional-methods.js"/>" type="text/javascript"></script>

    <script>
        $(document).ready(function() {
            $("#checkoutForm").validate({
                rules: {
                    phone: {
                        required: true,
                        phoneUS: true
                    },

                    email: {
                        required: true,
                        email: true,
                    },

                    creditCard: {
                        required: true,
                        creditcard: true,
                    }
                }
            });
        });
    </script>

</head>

<body class="home">
<jsp:include page="header.jsp"/>

<main>

    <section id="checkoutMain">

        <p style="font-weight:bold; font-size: 30px">Checkout</p>

        <div id="checkoutFormErrors">
            <c:if test="${p.hasValidationError}">
                <c:if test="${p.customerForm.hasNameError}">
                    ${p.customerForm.nameErrorMessage}<br>
                </c:if>
                <c:if test="${p.customerForm.hasPhoneError}">
                    ${p.customerForm.phoneErrorMessage}<br>
                </c:if>
                <c:if test="${p.customerForm.hasEmailError}">
                    ${p.customerForm.emailErrorMessage}<br>
                </c:if>
                <c:if test="${p.customerForm.hasCcExpDateError}">
                    ${p.customerForm.ccExpDateErrorMessage}<br>
                </c:if>
                <c:if test="${p.customerForm.hasCcNumberError}">
                    ${p.customerForm.ccNumerErrorMessage}<br>
                </c:if>
            </c:if>
            <c:if test="${p.hasTransactionError}">
                Transactions have not been implemented yet.<br>
            </c:if>
        </div>
        <div id="checkoutFormAndInfo">
            <div id="checkoutFormBox">
                <form id="checkoutForm" action="<c:url value='checkout'/>" method="post">
                    <table id="checkOutTable">
                        <tr>
                            <td class="tableLabel">
                                Name
                            </td>
                            <td>
                                <input class="textField" type="text" size="20" maxlength="45" name="name"
                                value="${p.customerForm.name}" required/>
                            </td>
                        </tr>

                        <tr>
                            <td class="tableLabel">
                                Address
                            </td>
                            <td>
                                <input class="textField" type="text" size="20" maxlength="45" name="address" required/>
                            </td>
                        </tr>

                        <tr>
                            <td class="tableLabel">
                                Phone
                            </td>
                            <td>
                                <input class="textField" type="text" size="20" maxlength="45" id="phone" name="phone"
                                value="${p.customerForm.phone}" required/>
                            </td>
                        </tr>

                        <tr>
                            <td class="tableLabel">
                                Email
                            </td>
                            <td>
                                <input class="textField" type="text" size="20" maxlength="45" id="email" name="email"
                                       value="${p.customerForm.email}" required/>
                            </td>
                        </tr>

                        <tr>
                            <td class="tableLabel">
                                Credit card
                            </td>
                            <td>
                                <input class="textField" type="text" size="20" maxlength="45" id="creditCard" name="ccNumber" required/>
                            </td>
                        </tr>

                        <tr>
                            <td class="tableLabel">
                                Exp. date
                            </td>
                            <td>
                                <select class="selectMenu" name="ccMonth">
                                <c:set var="montharr"
                                value="${['January','February','March','April','May','June','July','August','September','October','November','December']}"/>

                                <c:forEach begin="1" end="12" var="month">
                                <option value="${month}"
                                    <c:if test="${1 eq month}">selected</c:if>>
                                    ${month}-${montharr[month - 1]}
                                </option>
                                </c:forEach>
                                </select>

                                <select class="selectMenu" name="ccYear">
                                <c:forEach begin="2016" end="2027" var="year">
                                    <option value="${year}"
                                    <c:if test="${2016 eq year}">selected</c:if>>
                                    ${year}
                                    </option>
                                </c:forEach>
                    </select>
                    <input id="boldSubmitButton" type="submit" value="Submit">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>




            <div id="checkoutInfo">
        <span id="checkoutInfoText">
            Your credit card will be charged <strong>total <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${p.cart.subtotal/100.00 + 5}"/></strong><br>
            (<strong>subtotal(<fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${p.cart.subtotal/100.00}"/>)</strong> + <strong>surcharge($5)</strong> shipping)
        </span>
            </div>

        </div>
    </section>

</main>
<jsp:include page="footer.jsp"/>

</body>
</html>
