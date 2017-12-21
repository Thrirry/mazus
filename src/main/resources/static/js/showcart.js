$(function () {

    var $nameCustomer = JSON.stringify($('#customersname').val());

    $.ajax({
        url: "http://localhost:8080/ordered/"+ $nameCustomer,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {

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
});
