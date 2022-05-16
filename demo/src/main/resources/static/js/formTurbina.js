const validarFormTurbina = async () => {
    let idInput = document.getElementById("id-form");
    let anguloInput = document.getElementById("angulo-form");
    let alturaInput = document.getElementById("altura-form");
    let vmaxInput = document.getElementById("vmax-form");
    let encendidoInput = document.getElementById("encendido-form").checked;

    if(isNaN(anguloInput) || isNaN(alturaInput) || isNaN(vmaxInput)){
        alert("Valores mal introducidos, pruebe otra vez");
        return false;
    }

    let request = await fetch("/api/v1/turbina/" + idInput, {
        method: "GET",
      });
      if (request.ok) {
        //nos aseguramos de que existe la turbina
        let request2 = await fetch("/api/v1/turbina" + idInput, {
            method: "PUT",
            credentials: "same-origin",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
                id: idInput,
                angulo: anguloInput,
                altura: alturaInput,
                vmax: vmaxInput,
                encendido: encendidoInput
            }),

        });
        if(request2.ok){
            alert("Informacion enviada con exito")
        }
        
      }
}
