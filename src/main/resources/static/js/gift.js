$(function () {

    var $showgift = $('#showgift');

    $.ajax({
        url: "http://localhost:8080/gifts/",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (showgift) {
            $.each(showgift, function (i, showgifts) {
                $showgift.append('<article class="grid-item product" >' +

                    '<div class="image">' +

                    '<a class="image-link" href="#" title="'+ showgifts.name + '">' +

                    '<img src="'+ showgifts.img +'" alt="'+ showgifts.name +'"/></a>' +

                    '<a class="badge '+showgifts.namestock+'" href="' + showgifts.url +'"></a>' +
                    '</div>' +

                    '<div class="detail">' +

                    '<h3 style="font-size: 17px">' +

                    '<a href="'+ showgifts.url +'" title="'+ showgifts.name +'">' + showgifts.details + '</a>' +
                    '</h3>' +

                    '<h4 style="font-size: 13px" class="brand-price">' + showgifts.name + '<span class="price">' + showgifts.price + '</span>' + '</h4>'

                    + '<a class="quick-view" href="#" title="'+ showgifts.name +'" data-id="244601"></a>' +
                    '</div>'
                    + '</article>')

            });
        }
    });
});
