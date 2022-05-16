const validateUser = async () => {

  let correoInput = $("#login").value;
  let passwordInput = $("#password").value;

  let request = await fetch("/api/v1/usuarios/" + correoInput, {
    method: "GET",
  });
  if (request.ok) {
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
