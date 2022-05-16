const updateGeneradorJoin = async () =>{
    let request = await fetch("/api/v1/generador/join", {
        method: "GET",
      });
    if(!request.ok){
        alert("Problema con la petición, intenta ser más educado");
        return null;
    }
    datos = await request.json();
    let tabla = document.getElementById("cuerpo-generador-join");
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