var xhr = new XMLHttpRequest();
xhr.open('GET', 'http://localhost:8080/contacts');
xhr.addEventListener('load', function() {
    var p = document.querySelector('#text');
    var c = document.querySelector('#text2');
    var b = document.querySelector('#text3');
    var data = JSON.parse(xhr.response);
    console.log(data);
    p.textContent = data.name;
    c.textContent = data.telephone;
    b.textContent = data.email;
});
xhr.send();