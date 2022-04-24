const validateForm = async () => {
  let firstName = $("#firstName").val();
  if (!firstName) {
    alert("Por favor introduzca un nombre válido.");
    return false;
  }

  let lastName = $("#lastName").val();
  if (!lastName) {
    alert("Por favor introduzca un apellido válido.");
    return false;
  }

  let email = $("#email").val();
  if (!email) {
    alert("Por favor introduzca un correo electrónico válido.");
    return false;
  }

  let address = $("#address").val();
  if (!address) {
    alert("Por favor introduzca una direccion válida.");
    return false;
  }

  let country = $("#country").val();
  if (!country) {
    alert("Por favor introduzca un pais válido.");
    return false;
  }

  let state = $("#state").val();
  if (!state) {
    alert("Por favor introduzca un estado válido.");
    return false;
  }

  let zip = $("#zip").val();
  if (!zip) {
    alert("Por favor introduzca un código postal válido.");
    return false;
  }

  let tarifa = $("#tarifa").val();
  if (!tarifa) {
    alert("Por favor introduzca una tarifa válido.");
    return false;
  }

  let request = await fetch("/contacto", {
    method: "POST",
    credentials: "same-origin",
    headers: {
      "Content-type": "application/json"
    },
    body: JSON.stringify({
      firstname: firstName,
      lastname: lastName,
      email: email,
      address: address,
      country: country,
      state: state,
      zip: zip,
      tarifa: tarifa
    }),
    dataType: "json",
  });

  if (request.ok) {
    alert("Datos enviados");
    console.log(await request.json());
  }
}
$("#btn-submit").on("click", () => {
  validateForm();
});