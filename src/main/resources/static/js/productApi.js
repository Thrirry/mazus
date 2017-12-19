var id = '';

/*
if (id = 'nc03') {

    xhr.open('GET', 'http://localhost:8080/list/' + id);
    xhr.addEventListener('load', function () {
        var a = document.querySelector('#details');
        var b = document.querySelector('#urlnc_01');
        var data = JSON.parse(xhr.response);
        console.log(data);
        a.textContent = data.details;
        b.textContent = data.url;

    });
}
*/


if (id = '3') {

    var xhr3 = new XMLHttpRequest();

    xhr3.open('GET', 'http://localhost:8080/list/3');
    xhr3.addEventListener('load', function () {
        var data = JSON.parse(xhr3.response);
        console.log(data);
        myFunction(xhr3);

        function myFunction(arr) {
            var $titles = '';
            var $img = '';

            $titles += '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            $img += 'url(' + data.imgs + ')';

            document.getElementById("details03").innerHTML = $titles;
            document.getElementById("image03").style.backgroundImage = $img;
        }

    });
    xhr3.send();

}


if (id = '2') {

    var xhr2 = new XMLHttpRequest();

    xhr2.open('GET', 'http://localhost:8080/list/' + id);
    xhr2.addEventListener('load', function () {
        //var a = document.querySelector('#name01');
        var data = JSON.parse(xhr2.response);
        console.log(data);
        //a.textContent = data.name;
        // b.textContent = data.url;

        myFunction(xhr2);

        function myFunction(arr) {
            var title2 = "";
            var img2 = "";

            title2 += '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            img2 += 'url(' + data.imgs + ')';

            document.getElementById("details02").innerHTML = title2;
            document.getElementById("image02").style.backgroundImage = img2;
        }

    });
    xhr2.send();

}


if (id = '1') {

    /*var xhr = new XMLHttpRequest();

    xhr.open('GET', 'http://localhost:8080/list/' + id);
    xhr.addEventListener('load', function () {
        //var a = document.querySelector('#name01');
        var data = JSON.parse(xhr.response);
        console.log(data);

        function myFunction(data) {
            //$userInfoBody.append($("<div>").text("Email: " + data.email));
            //$loggedInBody.append($("<h4>").text("Header.Payload.Verify Signature"));
            //offset += '"' + data.imgs + '"';

            var img;
            var title

            title = '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            img = 'url(' + data.imgs + ')';


            document.getElementById("image01").style.backgroundImage = img;
            document.getElementById("details01").innerHTML = title;

        }

    });
    xhr.send();*/



}
