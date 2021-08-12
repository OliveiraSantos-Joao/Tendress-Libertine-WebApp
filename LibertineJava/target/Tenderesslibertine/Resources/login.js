/*









function submit(){
    let mail = $('#InputEmail').attr(value);
    let pass = $('#InputPassword').attr(value);
}

function getValue() {
    // this line does the magic
    var mail = $('#InputEmail').val();
    var pass = $('#InputPassword').val();
    console.log(mail);
    console.log(pass);
}
function successCallback(response) {
    console.log(response +"mambo");
    console.log("deu");

}

function errorCallback(request, status, error) {
    console.log(request +"request");
    console.log("status: " + status);
    console.log("error: " + error);
}

function fetchEmailAndPassword() {
    let mail = $('#InputEmail').val();
    let pass = $('#InputPassword').val();

    console.log(mail);
    console.log(pass);
    $.ajax({
        url: 'http://localhost:8080/Tenderesslibertine/api/customerLogin',
        type: 'POST',
        data: JSON.stringify({
            email: mail,
            password:pass,
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    })


}

function Validate()
{
    var username = $('#InputEmail').attr('value');
    var password = $('#InputPassword').attr('value');
    var url = "http://localhost:8080/Tenderesslibertine/api/customerLogin";

    alert(username);
    $.ajax({                                // function calling
        url: url,
        data: { email: username, password: password },
        type: "POST",
        success: function (data)
        {
            if (data == "1")
            {
                //alert("Valid user Id ");
            }
            else
            {
                alert("Invalid user Id ");
            }
        },
        error: function (response)
        {
            alert("Invalid user ID");
        }
    });
}*/
