let pedidos;
let info = [];


let estado;
let numPersonas;
let precio;
let roles;

let cargarPedidos=async()=>{
    let user = sessionStorage["username"];
    let url="elPeroli/v1/owner/getRoles/" +user;
    let res= await fetch(url);
    if (res.ok) {
        roles= await res.json();}
        console.log(roles);
    res=await fetch("elPeroli/v1/owner/viewPedidos");
    if (res.ok) {
        pedidos= await res.json();
    }
    if(!roles.includes(2) & !roles.includes(3)){

        let tabla = document.getElementById('pedidos');
        for(let i=0; i <pedidos.length; i++){

            let newRow = tabla.insertRow(tabla.length);
            let pedidoActual=json2array(pedidos[i]);
            for(let j=0; j<pedidoActual.length; j++){

                let cell = newRow.insertCell(j);
                if (j == 5) {
                    cell.innerHTML = '<button type="button" id="verArroz' + pedidoActual[0] + '" name="verArroz" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalArroz" onclick="loadArroz(' + pedidoActual[j] + ')">Ver arroz ' + pedidoActual[j] + '</button>';
                } else{
                    cell.innerHTML = pedidoActual[j];
                }

            }
        }
    }else if(!roles.includes(3) & roles.includes(2)){

        let header=document.getElementById("header");
        header.innerHTML='<tr>\n' +
            '        <td colspan="13">\n' +
            '            <input id="buscar" type="text" class="form-control" placeholder="Escriba algo para filtrar" onkeyup="buscaTabla()"/>\n' +
            '        </td>\n' +
            '    </tr>\n' +
            '        <th>ID</th>\n' +
            '        <th>EMAIL</th>\n' +
            '        <th>NOMBRE</th>\n' +
            '        <th>TELEFONO</th>\n' +
            '        <th>NUM.COMENSALES</th>\n' +
            '        <th>ARROZ</th>\n' +
            '        <th>FECHA</th>\n' +
            '        <th>COMIDA/CENA</th>\n' +
            '        <th>CIUDAD</th>\n' +
            '        <th>DIRECCION</th>\n' +
            '        <th>PRECIO</th>\n' +
            '        <th>ESTADO</th>'+
            '<th>ACTUALIZAR</th>';


        let tabla = document.getElementById('pedidos');
        for(let i=0; i <pedidos.length; i++){

            let newRow = tabla.insertRow(tabla.length+1);
            let pedidoActual=json2array(pedidos[i]);
            for(let j=0; j<pedidoActual.length+1; j++){
                let cell = newRow.insertCell(j);
                if(j==11){
                    if(pedidoActual[j]=="ACEPTADA"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1" checked>' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2">';
                    }else if(pedidoActual[j]=="RECHAZADA"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1">' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2" checked>'
                    }else if(pedidoActual[j]=="PENDIENTE"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1">' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2">'
                    }
                }else if(j==12) {
                        cell.innerHTML = '<button type="button" class="btn btn-primary" id="actualizarpedido' + pedidoActual[0] + '" name="actualizarpedido" onclick="actualizarPedido('+pedidoActual[0]+')">Actualizar</button>'
                } else if (j == 5) {
                    cell.innerHTML = '<button type="button" id="verArroz' + pedidoActual[0] + '" name="verArroz" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalArroz" onclick="loadArroz(' + pedidoActual[j] + ')">Ver arroz ' + pedidoActual[j] + '</button>';
                } else{
                    cell.innerHTML = pedidoActual[j];
                }

            }
        }
    }else if(roles.includes(3)&roles.includes(2)){

        let header=document.getElementById("header");
        header.innerHTML='<tr>\n' +
            '        <td colspan="13">\n' +
            '            <input id="buscar" type="text" class="form-control" placeholder="Escriba algo para filtrar" onkeyup="buscaTabla()"/>\n' +
            '        </td>\n' +
            '    </tr>\n' +
            '        <th>ID</th>\n' +
            '        <th>EMAIL</th>\n' +
            '        <th>NOMBRE</th>\n' +
            '        <th>TELEFONO</th>\n' +
            '        <th>NUM.COMENSALES</th>\n' +
            '        <th>ARROZ</th>\n' +
            '        <th>FECHA</th>\n' +
            '        <th>COMIDA/CENA</th>\n' +
            '        <th>CIUDAD</th>\n' +
            '        <th>DIRECCION</th>\n' +
            '        <th>PRECIO</th>\n' +
            '        <th>ESTADO</th>'+
            '<th>ACTUALIZAR</th>';

        let tabla = document.getElementById('pedidos');
        for(let i=0; i <pedidos.length; i++){

            let newRow = tabla.insertRow(tabla.length+1);
            let pedidoActual=json2array(pedidos[i]);
            for(let j=0; j<pedidoActual.length+1; j++) {
                let cell = newRow.insertCell(j);
                if (j == 11) {
                    if (pedidoActual[j] == "ACEPTADA") {
                        cell.innerHTML = '<input type="radio" id="aceptado' + pedidoActual[0] + '" name="pedido' + pedidoActual[0] + '" value="1" checked>' + '<input type="radio" id="rechazado' + pedidoActual[0] + '" name="pedido' + pedidoActual[0] + '" value="2">';
                    } else if (pedidoActual[j] == "RECHAZADA") {
                        cell.innerHTML = '<input type="radio" id="aceptado' + pedidoActual[0] + '" name="pedido' + pedidoActual[0] + '" value="1">' + '<input type="radio" id="rechazado' + pedidoActual[0] + '" name="pedido' + pedidoActual[0] + '" value="2" checked>'
                    } else if (pedidoActual[j] == "PENDIENTE") {
                        cell.innerHTML = '<input type="radio" id="aceptado' + pedidoActual[0] + '" name="pedido' + pedidoActual[0] + '" value="1">' + '<input type="radio" id="rechazado' + pedidoActual[0] + '" name="pedido' + pedidoActual[0] + '" value="2">'
                    }

                } else if (j == 4) {
                    cell.innerHTML = '<input type="number" class="form-control" id="numPersonas' + pedidoActual[0] + '" name="numPersonas" value="' + pedidoActual[j] + '">';
                } else if (j == 5) {
                    cell.innerHTML = '<button type="button" id="verArroz' + pedidoActual[0] + '" name="verArroz" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalArroz" onclick="loadArroz(' + pedidoActual[j] + ')">Ver arroz ' + pedidoActual[j] + '</button>';
                }else if (j == 10) {
                    cell.innerHTML = '<input type="text" id="precio' + pedidoActual[0] + '" name="precio" value="' + pedidoActual[j] + '">';
                }else if(j==12){
                    cell.innerHTML = '<button type="button" class="btn btn-primary" id="actualizarpedido' + pedidoActual[0] + '" name="actualizarpedido" onclick="actualizarPedido('+pedidoActual[0]+')">Actualizar</button>'
            }else{
                    cell.innerHTML = pedidoActual[j];
                }

            }
        }
    }
    if (roles.includes(4)) {
        let final = document.getElementById("final");
        final.innerHTML = '<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">\n' +
            '        Añadir un pedido\n' +
            '    </button>';
    }

}

let loadArroz=async (rice_id) => {
    let url = "elPeroli/v1/arroz/loadArroz/" + rice_id;
    let res = await fetch(url);
    if (res.ok) {
        let arroz=await res.json();
        let nombre=arroz.name;
        let descripcion=arroz.description;
        let ingredientes= arroz.ingredients;
        let modal=document.getElementById("modalBody");
        let mod='Nombre: '+nombre+ '<br>' + 'Descripcion del arroz: '+descripcion+ '<br>' + 'Ingredientes por persona: '+ingredientes+ '<br>';
        console.log(mod);
        modal.innerHTML=mod;
    }
}

let actualizarPedido=(id)=>{
    let url="elPeroli/v1/owner/updatePedido/"+id;
    if(getData(id)){
        fetch(url, {
            method: "PUT",
            headers: {
                "content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify({
                "personas":numPersonas,
                "precio":precio,
                "estado":estado

            })
        }).then(res => {
            if (res.ok) {
                alert("Pedido actualizado");
            }
        }).catch(error => {
            alert("Por favor compruebe los datos");
        });
    }
    else {
        alert("Porfavor rellena todos los campos")
    }
}

let getData=(id)=>{

    let aceptado = document.getElementById("aceptado"+id+"");
    let rechazado = document.getElementById("rechazado"+id+"");
    if (aceptado.checked){
        estado= "ACEPTADA";
    }else if (rechazado.checked){
        estado= "RECHAZADA";
    }else{
        estado="PENDIENTE";
    }


    if (roles.length ==3) {
        numPersonas = document.getElementById("numPersonas" + id + "").value;
        precio = document.getElementById("precio" + id + "").value;
        if (numPersonas!= '' & precio!= '') {
            return true;
        }
        else {
            return false;
        }
    }
    else (
        pedidos.forEach(pedido => {
            pedido = json2array(pedido);
            if (pedido[0] == id){
                precio = pedido[10];
                numPersonas = pedido[4];
            }
        })
    )
    return true;

}



let json2array=(json)=>{
    let result = [];
    let keys = Object.keys(json);
    keys.forEach(function(key){
        result.push(json[key]);
    });
    return result;
}




let buscaTabla=()=>{
    let table = document.getElementById("pedidos");
    let texto = document.getElementById('buscar').value.toLowerCase();
    let r = 0;
    let row= table.rows[r];
    console.log(row);
    while (row != null) {
        if (row.innerText.toLowerCase().indexOf(texto) !== -1){
            row.style.display = null;}
        else{
            row.style.display = 'none';}
        row=table.rows[r++];
    }
}

let guardarDat = () =>  {


    if (document.getElementById('arroz1').checked) {
        info[0]=1;
    } else if (document.getElementById('arroz2').checked) {
        info[0]= 2;
    }else if (document.getElementById('arroz3').checked) {
        info[0]= 3;
    }
    info[1]= document.getElementById('numPersonas').value;
    info[2]= document.getElementById('fecha').value;
    info[4] = document.getElementById("Ciudad").value;
    info[3] = document.getElementById('Dir1').value;
    if (document.getElementById('comida').checked) {
        info[5]="COMIDA";
    } else {
        info[5]= "CENA";
    }
    info[6] = document.getElementById('email').value;
    info[7] = document.getElementById('nombre').value;
    info[8] = document.getElementById('telf').value
    console.log(info);
    if(!info.includes('')) {
        return true;
    }
    else {
        return false;
    }

}

let mandarForm = async () => {
    if (guardarDat()) {
        fetch("elPeroli/v1/owner/newPedido", {
            method: "POST",
            headers: {
                "content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify({
                "email": info[6],
                "fullname": info[7],
                "tel": info[8],
                "personas": info[1],
                "arroz": info[0],
                "fecha": info[2],
                "momento": info[5],
                "ciudad": info[4],
                "dir1": info[3]
            })
        }).then(res => {
            if (res.ok) {
                alert("Todo correcto");
                location.reload(true);
            } else {
                return res.text().then(text => {
                    throw new Error(text)
                })
            }
        })
            .catch(error => {
                alert("Por favor compruebe los datos");
            });
    }
    else {
        alert("Porfavor rellena todos los campos")
    }
}