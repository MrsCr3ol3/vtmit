<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="css/category.css">

</head>

<body>
<main>
    <jsp:include page="WEB-INF/jsp/header.jsp"/>

    <div id="categoryContainer">
        <nav style= "width: 250px;">
            <div class="vertical-menu" id="sideMenu">
                <a href="index.jsp">Home</a>
                <a href="category.jsp">Business</a>
                <a href="category.jsp">Fiction</a>
                <a href="category.jsp">Children</a>
                <a href="category.jsp">Text & Manual</a>
            </div>


        </nav>

        <article>
        <h1 style="padding-left: 60px">Fictions</h1>
            <div id="book" style="margin-top: 20px;">
                <a href="category.jsp">
                    <img src="${initParam.bookImages}the-hobbit.gif" alt="The Hobbit"/>
                </a>
                <div style ="width: 110px;">
                    <h2>The Hobbit</h2>
                    <h3>by J R R Tolkin</h3>
                    <h4>$9.99</h4>

                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}add2cart.png" alt="add to cart" width="80px" height="35px" align="middle" style="padding-left: 5px">
                    </a></br>
                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}readnowok.png" alt="Read Now" width="80px" height="35px" align="middle">
                    </a>

                </div>


                <a href="category.jsp">
                    <img src="${initParam.bookImages}alllightwecant.png" alt="all the lights"/>
                </a>
                <div style ="width: 110px;">
                    <h2>The Hobbit</h2>
                    <h3>by J R R Tolkin</h3>
                    <h4>$9.99</h4>

                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}add2cart.png" alt="add to cart" width="80px" height="35px" align="middle" style="padding-left: 5px">
                    </a></br>
                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}readnowok.png" alt="Read Now" width="80px" height="35px" align="middle">
                    </a>
                </div>

                <a href="category.jsp">
                    <img src="${initParam.bookImages}frankenstein.png" alt="frankenstein"/>
                </a>
                <div style ="width: 110px;">
                    <h2>The Hobbit</h2>
                    <h3>by J R R Tolkin</h3>
                    <h4>$9.99</h4>

                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}add2cart.png" alt="add to cart" width="80px" height="35px" align="middle" style="padding-left: 5px">
                    </a></br>
                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}readnowno.png" alt="NOt Read Now" width="80px" height="35px" align="middle">
                    </a>
                </div>

                <a href="category.jsp">
                    <img src="${initParam.bookImages}mockingbird.png" alt="mockingbird"/>
                </a>
                <div style ="width: 110px;">
                    <h2>The Hobbit</h2>
                    <h3>by J R R Tolkin</h3>
                    <h4>$9.99</h4>

                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}add2cart.png" alt="add to cart" width="80px" height="35px" align="middle" style="padding-left: 5px">
                    </a></br>
                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}readnowok.png" alt="Read Now" width="80px" height="35px" align="middle">
                    </a>
                </div>

                <a href="category.jsp">
                    <img src="${initParam.bookImages}greatgetby.png" alt="the great getsby"/>
                </a>
                <div style ="width: 110px;">
                    <h2>The Hobbit</h2>
                    <h3>by J R R Tolkin</h3>
                    <h4>$9.99</h4>

                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}add2cart.png" alt="add to cart" width="80px" height="35px" align="middle" style="padding-left: 5px">
                    </a></br>
                    <a href="cart.jsp">
                        <img src="${initParam.siteImages}readnowno.png" alt="NO Read Now" width="80px" height="35px" align="middle">
                    </a>
                </div>

            </div>
        </article>
    </div>
    <jsp:include page="WEB-INF/jsp/footer.jsp"/>
</main>
</body>
</html>
