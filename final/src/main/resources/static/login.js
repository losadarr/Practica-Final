const validateUser = async () => {
  //let usuarioInput=document.getElementById("nombreUsuarioInicio").value;
  //let contrasenyaInput=document.getElementById("contrasenyaInicio").value;

  let correoInput = $("#login").value;
  let passwordInput = $("#login").value;

  let request = await fetch("/api/v1/usuarios/" + correoInput, {
    method: "GET",
  });
  if (request.ok) {
    //console.log(await request.json());
    datos = await request.json();
    let id = datos.id;
    let correo = datos.correo;
    let password = datos.password;

    if (password == passwordInput) {
      console.log("Iniciaste sesión como usuario");
    }
  }
};

$("#login-button").on("click", () => {
  validateUser();
});
