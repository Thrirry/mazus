$(function () {

    var TOKEN_KEY = "jwtToken"
    var $notLoggedIn = $("#notLoggedIn");
    var $loggedIn = $("#loggedIn").hide();
    var $loggedInBody = $("#loggedInBody");
    var $login = $("#login");
    var $userInfo = $("#userInfo").hide();
    var $userInfow = $('#userInfow').hide();
    var $loginbefor = $('#loginbefor');
    var $addordercover = $('#addordercover');
    var $dashboard = $('#dashboard');
    var $response = $("#response");
    var $logout = $("#logout").hide();

    var $showCart = $('#showCart');

    $dashboard.hide();

    var $addorder = $('#addorder');

    var $addordercoverbef = $('#addordercoverbef');
    $addordercover.hide();

    var $nnamecustomer = $('#nnamecustomer');


    function getJwtToken() {
        return localStorage.getItem(TOKEN_KEY);
    }

    function setJwtToken(token) {
        localStorage.setItem(TOKEN_KEY, token);
    }

    function removeJwtToken() {
        localStorage.removeItem(TOKEN_KEY);
    }

    function doLogin(loginData) {
        $.ajax({
            url: "/du",
            type: "POST",
            data: JSON.stringify(loginData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                setJwtToken(data.token);
                $login.hide();
                $notLoggedIn.hide();
                $loginbefor.hide();
                $logout.show();
                showTokenInformation();
                showUserInformation();
                showUserInformationNavmain();
                CartButton();
                getUsername();
                $dashboard.show();
                $addordercoverbef.hide();
                window.location.replace("/mazus");
            },
            error: function (jqXHR, textStatus, errorThrown) {

                if (jqXHR.status === 403) {
                    $('#loginErrorModal')
                        .modal("show")
                        .find(".modal-body")
                        .empty()
                        .html("<p>Spring exception:<br>" + jqXHR.responseJSON.exception + "</p>");
                } else {
                    throw new Error("an unexpected error occured: " + errorThrown);
                }
            }
        });
    }


    function doLogout() {
        removeJwtToken();
        $login.show();
        $userInfo
            .hide()
            .find("#userInfoBody").empty();
        $loggedIn.hide();
        $loggedInBody.empty();
        $notLoggedIn.show();
        $dashboard.hide();
        window.location.replace("/mazus");
    }

    function createAuthorizationTokenHeader() {
        var token = getJwtToken();
        if (token) {
            return {"Authorization": "Bearer " + token};
        } else {
            return {};
        }
    }

    function showUserInformation() {
        $.ajax({
            url: "/user",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                var $userInfoBody = $userInfo.find("#userInfoBody");

                $userInfoBody.append($("<div>").text("Username: " + data.username));
                $userInfoBody.append($("<div>").text("Email: " + data.email));
                $userInfoBody.append($("<div>").text("Pass: " + data.lastname));

                var $authorityList = $("<ul>");
                data.authorities.forEach(function (authorityItem) {
                    $authorityList.append($("<li>").text(authorityItem.authority));
                });
                var $authorities = $("<div>").text("Authorities:");
                $authorities.append($authorityList);

                $userInfoBody.append($authorities);
                $userInfo.show();

            }
        });
    }


    function showUserInformationNavmain() {
        $.ajax({
            url: "/user",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                var $userInfoBodys = $userInfow.find("#userlogged");

                $userInfoBodys.append($("<p>").text("Hi, " + data.username));
                $userInfow.show();

            }
        });
    }


    function CartButton() {
        $.ajax({
            url: "/user",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {

                var $userInfoBodys = $addordercover.find("#addorder");
                $userInfoBodys.append($("<span>").text("Add to Card"));
                $addordercover.show();

            }
        });
    }


    function getUsername() {
        $.ajax({
            url: "/user",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {

                var $userInfoBodys = $nnamecustomer.find("#namecustomer");
                $userInfoBodys.append($("<input id='customersname' style='display: none' value='" + data.username + "'>"));
                $nnamecustomer.show();
                showCart(data.username)

            }
        });
    }

    function showCart(datas) {

        var $nameCustomer = datas;
        $showCart.hide();

        $.ajax({
            url: "http://localhost:8080/ordered/"+ $nameCustomer,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                $showCart.show();

                var title = "";
                var price = "";
                var Subprice = "";

                title += '<a>' + data.nameproduct + '</a>';
                price += '<span class="price">'+ data.price + '</span>';
                Subprice += '<span class="price">'+ data.price + '</span>';

                document.getElementById("title").innerHTML = title;
                document.getElementById("price").innerHTML = price;
                document.getElementById("Subprice").innerHTML = Subprice;

            }
        });
    }



    function showTokenInformation() {
        var jwtToken = getJwtToken();

        var decodedToken = jwt_decode(jwtToken);

        $loggedInBody.append($("<h4>").text("Header.Payload.Verify Signature"));
        $loggedInBody.append($("<div style='padding-bottom: 3em'>").text(jwtToken).css("word-break", "break-all"));
        //  $loggedInBody.append($("<h4>").text("Token claims"));

        var $table = $("<table>")
            .addClass("table table-striped");
        appendKeyValue($table, "sub", decodedToken.sub);
        appendKeyValue($table, "aud", decodedToken.aud);
        appendKeyValue($table, "iat", decodedToken.iat);
        appendKeyValue($table, "exp", decodedToken.exp);

        //  $loggedInBody.append($table);

        $loggedIn.show();
    }

    function appendKeyValue($table, key, value) {
        var $row = $("<tr>")
            .append($("<td>").text(key))
            .append($("<td>").text(value));
        $table.append($row);
    }


    function showResponse(statusCode, message) {
        $response
            .empty()
            .text(message);
    }



    $("#loginForm").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            username: $form.find('input[name="username"]').val(),
            password: $form.find('input[name="password"]').val()
        };

        doLogin(formData);
    });

    $($logout).click(doLogout);

    $("#exampleServiceBtn").click(function () {
        $.ajax({
            url: "/mazuz",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                showResponse(jqXHR.status, JSON.stringify(data));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                showResponse(jqXHR.status, errorThrown);
            }
        });
    });


    $("#adminServiceBtn").click(function () {
        $.ajax({
            url: "/protected",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                showResponse(jqXHR.status, data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                showResponse(jqXHR.status, errorThrown);
            }
        });
    });

    $loggedIn.click(function () {
        $loggedIn
            .toggleClass("text-hidden")
            .toggleClass("text-shown");
    });

    if (getJwtToken()) {
        $login.hide();
        $notLoggedIn.hide();
        $loginbefor.hide();
        $logout.show();
        showTokenInformation();
        showUserInformation();
        showUserInformationNavmain();

        CartButton();
        getUsername();

        $addordercoverbef.hide();

        $dashboard.show();
    }
});