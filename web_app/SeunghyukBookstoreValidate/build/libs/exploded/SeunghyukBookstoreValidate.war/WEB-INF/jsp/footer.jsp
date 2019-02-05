<jsp:useBean id="p" scope="request" type="viewmodel.BaseViewModel"/>

<footer>


    <div class="leftFooter">
            <a href = "http://www.facebook.com">
                <img src="${p.siteImagePath}faceb.png" height="40px" width="40px" alt="Facebook Link"/></a>
            <a href = "http://www.tweeter.com">
                <img src="${p.siteImagePath}tweet.png" height="40px" width="40px" alt="Tweeter Link"/></a>

    </div>

    <div class = "midFooter">
            ©2017 Alice's WonderBooks, All RIGHTS RESERVED
    </div>

    <div class = "rightFooter">
            <a href ="">direction</a>
            |
            <a href ="">contact</a>
    </div>

</footer>
