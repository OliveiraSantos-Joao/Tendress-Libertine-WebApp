

let email;
let password;
window.addEventListener("load",function(){

    email = $("#InputEmail").val();
    password = $("#InputPassword").val();

    let button = document.getElementById("form");

    button.addEventListener("submit",function(event){
        event.preventDefault();
        email = $("#InputEmail").val();
        password = $("#InputPassword").val();


    })

})

function successCallback(response) {
    window.location.href = response;
}

function Regista() {
    window.location.href = 'http://localhost:8080/Tenderesslibertine/RegisterPage';
}

function errorCallback(request, status, error) {
    alert("faz favor de preencher bem essa merda");

    alert(request.statusMessage);
    alert(status.statusMessage);
    alert(error);
    console.log(request.status + "  request");
    console.log("status: " + status);
    console.log("error: " + error);
}
function fetchEmailAndPassword() {


    email = $("#InputEmail").val();
    password = $("#InputPassword").val();

    console.log(email);
    console.log(password);

    $.ajax({
        url: 'http://localhost:8080/Tenderesslibertine/api/customerLogin',
        type: 'POST',
        data: JSON.stringify({
            email: email,
            password: password,
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback,
    })

}

