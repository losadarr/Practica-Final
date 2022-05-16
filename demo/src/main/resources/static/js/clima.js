const updateClima = async () =>{
    let request = await fetch("/api/v1/clima", {
        method: "GET",
      });
    if(request.ok){
        let datos = await request.json();
        let tempDatos = datos.temperatura;
        let descDatos = datos.descripcion;
        let precDatos = datos.precipitacion;
        let windDatos = datos.velocidad_viento;
        
        document.getElementById("temp").innerHTML=tempDatos;
        document.getElementById("desc").innerHTML=descDatos;
        document.getElementById("prec").innerHTML=precDatos;
        document.getElementById("wind").innerHTML=windDatos;
    }
}
