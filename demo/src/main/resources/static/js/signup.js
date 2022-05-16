

const maquinarRegistro = async () => {
    let correo1 = $("#login");
    let correo2 = $("#login-repeat");
    let passw1 = $("#password");
    let passw2 = $("#password-repeat");
    let clave = $("#clave-secreta");

    if(!guardarDatos()){
        return null;
    }
    let request = await fetch("/api/v1/usuario",{
        method: "POST",
        headers: {
            "content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify({
            "correo": correo1,
            "password": passw1
        })
    }).then(res => {
        if(res.ok){
            alert("Todo ha ido bien. Que alivio")
        }
    })
}

const guardarDatos = () => {
    if(correo1 != correo2){
        alert("Los correos no coinciden, vuelva a intentarlo");
        return false;
    }
    else if(passw1 != passw2){
        alert("Las contraseñas no coinciden, vuelva a intentarlo");
        return false;
    }
    else if(clave != "123456789"){
        alert("Clave secreta no encontrada, vuelva a intentarlo");
        return false;
    }
    else if((correo1 === "")||(correo2 === "")||(passw1 === "")||(passw1 === "")){
        alert("Hay campos vacíos, rellénelos");
        return false;
    }
    return true;
}