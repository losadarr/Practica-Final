const validarFormTurbina = async () => {
    let idInput = document.getElementById("id-form");
    let anguloInput = document.getElementById("angulo-form");
    let alturaInput = document.getElementById("altura-form");
    let vmaxInput = document.getElementById("vmax-form");
    let encendidoInput = document.getElementById("encendido-form").checked;

    /*if(isNaN(anguloInput) || isNaN(alturaInput) || isNaN(vmaxInput)){
        alert("Valores mal introducidos, pruebe otra vez");
        return false;
    }*/

    let request = await fetch("/api/v1/turbina/"+idInput, {
        method: "GET",
      });
      
      if (request.ok) {
        //nos aseguramos de que existe la turbina
        let request2 = await fetch("/api/v1/turbina/"+idInput, {
            method: "PUT",
            credentials: "same-origin",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "id": idInput,
                "angulo": anguloInput,
                "altura": alturaInput,
                "vmax": vmaxInput,
                "encendido": encendidoInput
            }),

        });
        if(request2.ok){
            alert("Informacion enviada con exito")
        }
        
      }
}



const updateTurbina = async () =>{
  let request = await fetch("/api/v1/turbina", {
      method: "GET",
    });
  if(!request.ok){
      alert("Problema con la p, intenta ser más educado");
      return null;
  }
  datos = await request.json();
  let tabla = document.getElementById("cuerpo-turbina-join");
  if(tabla.length !=0){
      tabla.innerHTML="";
  }
  for(let i=0; i<datos.length; i++){
      let newRow = tabla.insertRow(tabla.length);
      let filaActual = json2array(datos[i]);
      for(let j=0; j<filaActual.length; j++){
          let celda = newRow.insertCell(j);
          celda.innerHTML = filaActual[j];
      }
  }
}

const json2array=(json)=>{
  let result = [];
  let keys = Object.keys(json);
  keys.forEach(function(key){
      result.push(json[key]);
  });
  return result;
}




