<jsp:useBean id="p" scope="request" type="viewmodel.BaseViewModel"/>

<footer>


    <div class="leftFooter">
        <div class="facebookIcon">
            <a href = "http://www.facebook.com">
                <img src="${p.siteImagePath}faceb.png" alt="Facebook Link"/></a>
        </div>

        <div class="twitterIcon">
            <a href = "http://www.tweeter.com">
                <img src="${p.siteImagePath}tweet.png" alt="Tweeter Link"/></a>
        </div>

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
