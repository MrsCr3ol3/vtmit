<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="p" scope="request" type="viewmodel.BaseViewModel"/>


<header>
    <section id = "leftHeader">
        <div id="log">
            <a href="home">
                <img src="${p.siteImagePath}logo.png" alt="Bookstore Logo"/>
            </a>
        </div>

        <div class="dropdown">
            <button class="dropbtn" style="margin-left: 50px; margin-top: 97px">Categories</button>
            <div class="dropdown-content">

                <c:forEach var="category" items="${p.categories}">

                    <a href="category?category=${category.name}">
                        <span style="text-transform: capitalize">${category.name} </span>
                    </a>

                </c:forEach>


                <%--<a href="category?category=classic literature">Classic</a>--%>
                <%--<a href="category?category=sci-fi">Sci-Fi</a>--%>
                <%--<a href="category?category=fantasy">Fantasy</a>--%>
                <%--<a href="category?category=children">Children</a>--%>
            </div>


        </div>
    </section>

    <section id = "midHeader">
        <div id = "title">
            <a href = "home">
                <img src="${p.siteImagePath}title.png" atl = "Head Title"/>
            </a>
        </div>
    </section>

    <section id ="rightHeader">

            <div id = "searchBoxandIcon">
                <form>
                    <input type = "text" name="BookTitle" value="search...">
                </form>
                <div id = "searchIcon">
                    <a href = "homepage.jsp">
                        <img src="${p.siteImagePath}searchicon2.png" atl = "Search Icon" style="margin-left: -30px"/>
                    </a>
                </div>
            </div>

            <div id = "cartIconandNumber" style= "width: 230px;">
                    <a href = "cart" atl="Log In Information">Hello, John</a>
                    |
                <a href = "cart">
                    <img src="${p.siteImagePath}cart.png" atl = "Cart Icon"/>
                </a>
                 (${p.cart.numberOfItems})
            </div>



    </section>


</header>
