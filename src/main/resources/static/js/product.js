$(function () {
    $.ajax({
        url: "http://localhost:8080/list/1",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {

            var title1 = "";
            var img1 = "";

            title1 += '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            img1 += 'url(' + data.imgs + ')';

            document.getElementById("details01").innerHTML = title1;
            document.getElementById("image01").style.backgroundImage = img1;

        }
    });
});

$(function () {
    $.ajax({
        url: "http://localhost:8080/list/2",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {

            var title1 = "";
            var img1 = "";

            title1 += '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            img1 += 'url(' + data.imgs + ')';

            document.getElementById("details02").innerHTML = title1;
            document.getElementById("image02").style.backgroundImage = img1;

        }
    });
});


$(function () {
    $.ajax({
        url: "http://localhost:8080/list/3",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {

            var title1 = "";
            var img1 = "";

            title1 += '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            img1 += 'url(' + data.imgs + ')';

            document.getElementById("details03").innerHTML = title1;
            document.getElementById("image03").style.backgroundImage = img1;

        }
    });
});
