var id_for = 0;
var idTicket = null;
var fila = null;
var tds = null;
var ocultoCrear = false;
var ocultarMod = false;
var datosMod = null;

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

        if (ocultoCrear) {
            $("#form_crearTicket").hide();
            ocultoCrear = false;
        }
        else {
            $("#form_crearTicket").show();
            $("#form_modTicket").hide();
            ocultoCrear = true;
        }

        crearTicket();
    });

    //--------------------------------------------------------------------------
    //BOTTON CREAR TICKET SUBMIT
    $("#bttonTicketSubmit").click(function (e) {
        e.preventDefault();
        crearTicketSubmit();
    });

    //--------------------------------------------------------------------------
    //BOTTON ELIMINAR
    $("#bttonEliminar").click(function (e) {
        e.preventDefault();
        if (idTicket !== null) {
            let opcion = confirm("Estas seguro de eliminar el ticket");
            if (opcion) {
                eliminarTicket();
                id_for--;
                fila.parent().remove();
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
            if (ocultarMod) {
                $("#form_modTicket").hide();
                ocultarMod = false;
            }
            else {
                let datos = { id_ticket: idTicket, metodo: "update" };
                $.post("TicketAplication", datosMod, function (res, est, jqXHR) {
                    console.log(datosMod);
                });

                $("#form_modTicket").show();
                $("#form_crearTicket").hide();
                ocultarMod = true;               
            }
        }
        else {
            alert("Tienes que seleccionar un registro...")
        }
    });

    //--------------------------------------------------------------------------
    //BOTTON MODIFICAR TICKET SUBMIT
    $("#bttonModificarSubmit").click(function (e) {
        e.preventDefault();
        modificarTicket(); 
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
select.addEventListener("change", function () {
    let selectedOpcion = this.options[select.selectedIndex];


    let data = { metodo: "getUsuarios", optionId: selectedOpcion.value };

    $.post("TicketAplication", data, function (res, est, jqXHR) {
        let especialista = $("#especialista").empty();
        $("#especialista").append($("<option value='' disabled selected>Seleccione un especialista...</option>"));
        console.log(res);
        $.each(res, function (i, opcion) {
            $("#especialista").append($("<option value=" + opcion.id_usuario + ">").text(opcion.nombres));
        });
    });

    //alert(selectedOpcion.value + " : " + selectedOpcion.text);
});


/*METODOS------------------------------------------------------------------ */

//--------------------------------------------------------------------------
//METODO CREAR TICKET
function crearTicket() {
    if (idTicket !== -1) {
        let data = { metodo: "getGrupos" };
        $.post("TicketAplication", data, function (res, est, jqXHR) {
            let grupoEspecialista = $("#grupo_especialista").empty();
            $("#grupo_especialista").append($("<option value='' disabled selected>Seleccione una grupo...</option>"));

            $.each(res, function (i, opcion) {
                $("#grupo_especialista").append($("<option value=" + opcion.id_grupo_especialista + ">").text(opcion.nombre_grupo));
            });
        });
    }
    else {

        flag = false;
    }
}

//--------------------------------------------------------------------------
//METODO CREAR TICKET Submit
function crearTicketSubmit() {
    if (idTicket !== -1) {
        let datos = $("#form_crearTicket").serialize();
        let data = "metodo=create&" + datos;
        console.log("Datos envio: " + data);

        $.post("TicketAplication", data, function (res, estado, jqXHR) { //TicketAplication
            console.log("Datos retorno: " + res);            
            console.log("estado : " + estado + " ser " );
            //if (estado == "success") {
                alert("Se creo el ticket exitosamente...");

                $("<tr id='btonEliminar' class='bton'>").appendTo("#tabla_body")
                    .append($("<td id='id_ticket'>").text(res.id_ticket))
                    .append($("<td id='nombre_ticket'>").text(res.nombre_ticket))
                    .append($("<td id='descripcion'>").text(res.descripcion))
                    .append($("<td id='estado'>").text(res.estado))
                    .append($("<td id='solucion'>").text(res.solucion))
                    .append($("<td id='fecha_inicio'>").text(res.fecha_inicio))
                    .append($("<td id='fecha_aprox'>").text(res.fecha_aprox))
                    .append($("<td id='fecha_cierre'>").text(res.fecha_cierre))
                    .append($("<td id='comentarios'>").text(res.comentarios))
                    .append($("<td id='grupo_especialista'>").text(res.grupo_especialista))
                    .append($("<td id='usuario'>").text(res.usuario));

                id_for++;
            //}
           // else
            //    alert("No se pudo crear el ticket...");
        });
        //e.preventDefault();
    }
}

//--------------------------------------------------------------------------
//METODO MODIFICAR TICKET
function modificarTicket() {
    let flag = false;
    if (idTicket !== -1) {
        let datos = { id_ticket: idTicket, metodo: "update" };
        $.post("TicketAplication", datosMod, function (res, est, jqXHR) {
            console.log(datosMod);
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


