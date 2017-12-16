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

if(id ='2'){

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
            var title = "";
            var img = "";

            title += '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            img += 'url(' + data.imgs + ')';

            document.getElementById("details02").innerHTML = title;
            document.getElementById("image02").style.backgroundImage = img;
        }

    });
    xhr2.send();

}


if (id = '1') {

    var xhr = new XMLHttpRequest();

    xhr.open('GET', 'http://localhost:8080/list/' + id);
    xhr.addEventListener('load', function () {
        //var a = document.querySelector('#name01');
        var data = JSON.parse(xhr.response);
        console.log(data);
        myFunction(xhr);

        function myFunction(arr2) {
            var img = "";
            var title = "";
            var offset = "";

            img += 'url(' + data.imgs + ')';
            title += '<a href="mazus/' + data.url + '">' + data.details + '</a>';
            // offset += '"' + data.imgs + '"';
            //  <img src="../image/inner-1.jpg" alt="Urku Portfolio"/>
            document.getElementById("image01").style.backgroundImage = img;
            document.getElementById("details01").innerHTML = title;



        }
    });
    xhr.send();
}
