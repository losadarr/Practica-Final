const updateGeneradorJoin = async () =>{
    let request = await fetch("/api/v1/generador/join", {
        method: "GET",
      });
    if(!request.ok){
        alert("Problema con la petición, intenta ser más educado");
        return null;
    }
    datos = await request.json();
    let tabla = $("#cuerpo-generador-join");
    for(let i=0; i<datos.length; i++){
        let newRow = tabla.insertRow(tabla.length);
        let filaActual = json2array(datos[i]);
        for(let j=0; j<filaActual.length; j++){
            let celda = newRow.insertCell(j);
            celda.html(filaActual[j]);
        }
    }
}
$("#btn-generador").on("click", () => {
    updateGeneradorJoin();
  });