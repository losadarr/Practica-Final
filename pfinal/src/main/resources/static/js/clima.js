const updateClima = async () =>{
    let request = await fetch("/api/v1/clima", {
        method: "GET",
      });
    if(request.ok){
        let datos = await request.json();
        let tempDatos = datos.temperatura;
        let descDatos = datos.descripcion;
        let precDatos = datos.precipitacion;
        let windDatos = datos.velocidad-viento;

        let temperatura = $("#temp");
        let descripcion = $("#desc");
        let precipitacion = $("#prec");
        let viento = $("#wind");

        temperatura.html(tempDatos);
        descripcion.html(descDatos);
        precipitacion.html(precDatos);
        viento.html(windDatos);

    }
}
$("#btn-clima").on("click", () => {
    updateClima();
  });