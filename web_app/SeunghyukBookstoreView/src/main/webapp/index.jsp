<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <link rel="stylesheet" href="css/normalize-and-reset.css">

    <!--
        cascading appropriately, we have:

        main.css    --  all things common
        header.css  --  header-specific rules
        footer.css  --  footer-specific rules
        <page>.css  --  page-specific rules
        extras.css  --  extras you may want
    -->

    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/homepage.css">

</head>

<body>
<main>
    <jsp:include page="WEB-INF/jsp/header.jsp"/>
    <section id = "welcomeMessage">
        Welcome to the <span style = "font-family: Papyrus; color: red">Alice’s</span> <span style="font-family: 'Tempus Sans ITC';color:lawngreen">Wonder</span><span style="font-family: 'Times New Roman';color: yellow">Books</span>, where you can find the most wondrous books in this planet!</br>
        We provide 4 categories of books (Business, Fictions, Textbooks &Manuals and Children).</br>
        Navigate yourself using category drop down menu located at upper left corner.</br>
    </section>

    <section id = "bestSellers">
        <div id = "sectionTitle">
            <h1 style="color:#ff6a6a; font-size: 45px;font-weight: bold;font-style: oblique">Best Sellers</h1>
        </div>
        <div id = "bestSellingBooks">
            <a href = "category.jsp">
                <img src="${initParam.bookImages}alllightwecant.png" atl = "Best Seller1"/>
            </a>
            <a href = "category.jsp">
                <img src="${initParam.bookImages}frankenstein.png" atl = "Best Seller2"/>
            </a>
            <a href = "category.jsp">
                <img src="${initParam.bookImages}the-hobbit.gif" atl = "Best Seller13"/>
            </a>
        </div>
    </section>
    <jsp:include page="WEB-INF/jsp/footer.jsp"/>
</main>
</body>
</html>
