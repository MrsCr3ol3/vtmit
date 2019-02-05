<header>
    <section id = "leftHeader">
        <div id="log">
            <a href="index.jsp">
                <img src="${initParam.siteImages}logo.png" alt="Bookstore Logo"/>
            </a>
        </div>

        <div class="dropdown">
            <button class="dropbtn" style="margin-left: 50px; margin-top: 97px">Categories</button>
            <div class="dropdown-content">
                <a href="category.jsp">Business</a>
                <a href="category.jsp">Fiction</a>
                <a href="category.jsp">Children</a>
                <a href="category.jsp">Text & Manuals</a>
            </div>
        </div>
    </section>

    <section id = "midHeader">
        <div id = "title">
            <a href = "index.jsp">
                <img src="${initParam.siteImages}title.png" atl = "Head Title"/>
            </a>
        </div>
    </section>

    <section>
        <div id ="rightHeader">

            <div id = "searchBoxandIcon">
                <form>
                    <input type = "text" name="BookTitle" value="search...">
                </form>
                <div id = "searchIcon">
                    <a href = "index.jsp">
                        <img src="${initParam.siteImages}searchicon2.png" atl = "Search Icon" style="margin-left: -30px"/>
                    </a>
                </div>
            </div>

            <div id = "cartIconandNumber" style= "width: 230px; margin-left: -60px">
                    <a href = "cart.jsp" atl="Log In Information">Hello, John</a>
                    |
                <a href = "index.jsp">
                    <img src="${initParam.siteImages}cart.png" atl = "Cart Icon"/>
                </a>
                (0)
            </div>



        </div>
    </section>


</header>
