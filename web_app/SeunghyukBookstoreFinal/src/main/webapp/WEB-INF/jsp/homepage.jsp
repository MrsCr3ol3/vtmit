<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="p" scope="request" type="viewmodel.HomepageViewModel"/>


<!doctype html>
<html>
<head>
    <title>My Bookstore</title>
    <meta charset="utf-8">
    <meta name="description" content="The homepage for My Bookstore">

    <!--
        normalize-and-reset.css is a basic CSS reset; useful for starting from ground zero.
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
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/css/category.css"/>">--%>
</head>

<body>
<jsp:include page="header.jsp"/>

<main>
    <section id = "welcomeMessage" style="margin-bottom: 20px">
        Welcome to the <span style = "font-family: Papyrus; color: red">Alice’s</span> <span style="font-family: 'Tempus Sans ITC';color:lawngreen">Wonder</span><span style="font-family: 'Times New Roman';color: yellow">Books</span>, where you can find the most wondrous books in this planet!</br>
        We provide 4 categories of books (Business, Fictions, Textbooks &Manuals and Children).</br>
        Navigate yourself using category drop down menu located at upper left corner.</br>
    </section>

    <section id = "bestSellers">
        <div id = "sectionTitle">
            <h1 style="color:#0fff00; font-size: 45px;font-weight: bold;font-style: oblique; margin-bottom: 20px">Best Sellers</h1>
        </div>
        <div id = "bestSellingBooks">

            <a href = "category?category=classic literature" >
                <img src="${initParam.bookImages}bookid3.jpg" atl = "Best Seller1" style="margin-right: 60px; border: double" />
            </a>
            <a href = "category?category=sci-fi" >
                <img src="${initParam.bookImages}bookid7.jpg"  atl = "Best Seller2" style="margin-right: 60px; border: double"/>
            </a>
            <a href = "category?category=children">
                <img src="${initParam.bookImages}bookid14.jpg"  atl = "Best Seller13" style="border: double"/>
            </a>
        </div>
    </section>
</main>
<jsp:include page="footer.jsp"/>

</body>
</html>
