var id_for = 0;
var idTicket = null;
var fila = null;
var tds = null;
var ocultoCrear = false;

$(function () {
    'use strict'

    //--------------------------------------------------------------------------
    //SE ACTUALIZA LA TABLA
    actualizarTabla();
    //console.log("despues actualizar pagina " + id);  

    //--------------------------------------------------------------------------
    //BOTTON TICKET
    $("#bttonTicket").click(function (e) {
        e.preventDefault();
        actualizarTabla();
    });

      //--------------------------------------------------------------------------
    //BOTTON CREAR
    $("#bttonCrear").click(function (e) {
        e.preventDefault();
       
        if(ocultoCrear)
        {
            alert("Entro 1");
            $("#form_crearTicket").hide();   
            ocultoCrear = false;
        }
        else
        {
            alert("Entro 2");
            $("#form_crearTicket").show(); 
            ocultoCrear = true;
        }

        crearTicket();
    });
     
    //--------------------------------------------------------------------------
    //BOTTON ELIMINAR
    $("#bttonEliminar").click(function (e) {
        e.preventDefault();
        if (idTicket !== null) {
            let opcion = confirm("Estas seguro de eliminar el ticket");
            console.log("Antes: " + id_for);
            if (opcion) {
                eliminarTicket()
                id_for--;
                fila.parent().remove();
                console.log("desp: " + id_for);
                idTicket = null;
            }
        }
        else {
            alert("Tienes que seleccionar un registro...")
        }
    });

    //--------------------------------------------------------------------------
    //BOTTON MODIFICAR
    $("#bttonModificar").click(function (e) {
        e.preventDefault();
        if (idTicket !== null) {
            console.log("Antes: " + id_for);
            modificarTicket();
            /*
            tds.find("#nombre_ticket").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#descripcion").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#estado").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#solucion").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#fecha_inicio").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#fecha_aprox").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#fecha_cierre").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#comentarios").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#grupo_especialista").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));
            tds.find("#usuario").append($('<textarea rows="10" cols="10" class="input_dimanic"></textarea>'));

            for(let i; i < tds[0].cells.length; i++){
                tds[0].cells[i].innerText = ""
            }*/
                        //modificarTicket();
            //fila.parent().remove();
            idTicket = null;
        }
        else {
            alert("Tienes que seleccionar un registro...")
        }
    });
    //--------------------------------------------------------------------------
    //METODO OBTENER EL ID CUANDO SELECCIONAS UN ROW
    $("#tabla_body").on("click", "tr.bton", function (e) {
        //e.preventDefault();
        tds = $(this);
        fila = $(this).find("#id_ticket");
        idTicket = fila.text();
    });

    //--------------------------------------------------------------------------
    //METODO CREAR UN SELECCIONADOR TEMPORAL
    $("#tabla_body").on("click", "tr", function () {
        $(this).addClass("selected").siblings().removeClass("selected");
    });
});

    //--------------------------------------------------------------------------
    //METOD QUE OBTIENE EL VALUE DEL SELECTOR
    var select = document.getElementById("grupo_especialista");
    select.addEventListener("change", function(){
        let selectedOpcion = this.options[select.selectedIndex];


        let data = {metodo: "getUsuarios", optionId:  selectedOpcion.value};
        $.post("TicketAplication", data, function (res, est, jqXHR) {
            let especialista = $("#especialista").empty();
            $.each(res, function (i, opcion) {
                // Iterate over the JSON array.
                $("#especialista").append($("<option value="+opcion.nombres+">").text(opcion.nombres));
            });
        });

        //alert(selectedOpcion.value + " : " + selectedOpcion.text);
    });
//--------------------------------------------------------------------------
//METODO CREAR TICKET
function crearTicket() {
    if (idTicket !== -1) {
        let data = {metodo: "getGrupos" };
        $.post("TicketAplication", data, function (res, est, jqXHR) {
            let grupoEspecialista = $("#grupo_especialista").empty();
            $.each(res, function (i, opcion) {
                // Iterate over the JSON array.
                $("#grupo_especialista").append($("<option value="+opcion.id_grupo_especialista+">").text(opcion.nombre_grupo));
            });
        });
        
    }
    else {

        flag = false;
    }
}

//--------------------------------------------------------------------------
//METODO MODIFICAR TICKET
function modificarTicket() {
    let flag = false;
    if (idTicket !== -1) {
        let data = { id_ticket: idTicket, metodo: "update" };
        $.post("TicketAplication", data, function (res, est, jqXHR) {
        });
    }
    else {
        alert("Tienes que seleccionar un registro...");
    }
}

//--------------------------------------------------------------------------
//METODO ELIMINAR TICKET
function eliminarTicket() {
    let data = { id_ticket: idTicket, metodo: "delete" };
    $.post("TicketAplication", data, function (res, est, jqXHR) {
    });
}

//--------------------------------------------------------------------------
//METODO ACTUALIZAR TABLA
function actualizarTabla() {
    $.post("TablaRegistrosTickets", function (responseJson) {

        //alert(responseJson.length + " : " + id_for);

        if ((responseJson.length) != id_for) {
            //alert(responseJson);
            $.each(responseJson, function (i, ticket) {
                // Iterate over the JSON array.
                $("<tr id='btonEliminar' class='bton'>").appendTo("#tabla_body")
                    .append($("<td id='id_ticket'>").text(ticket.id_ticket))
                    .append($("<td id='nombre_ticket'>").text(ticket.nombre_ticket))
                    .append($("<td id='descripcion'>").text(ticket.descripcion))
                    .append($("<td id='estado'>").text(ticket.estado))
                    .append($("<td id='solucion'>").text(ticket.solucion))
                    .append($("<td id='fecha_inicio'>").text(ticket.fecha_inicio))
                    .append($("<td id='fecha_aprox'>").text(ticket.fecha_aprox))
                    .append($("<td id='fecha_cierre'>").text(ticket.fecha_cierre))
                    .append($("<td id='comentarios'>").text(ticket.comentarios))
                    .append($("<td id='grupo_especialista'>").text(ticket.grupo_especialista))
                    .append($("<td id='usuario'>").text(ticket.usuario));

                id_for++;
            });

        }
       // alert(responseJson.length + " : " + id_for);

    });
}


