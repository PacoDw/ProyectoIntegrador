'use strict'

function actualizarTabla() {
    $.post("TablaRegistrosTickets", function (responseJson) {

        //alert(responseJson.length + " : " + id);

        if ((responseJson.length-1) != id) {
            $.each(responseJson, function (i, ticket) {
                // Iterate over the JSON array.

                $("<tr>").appendTo("#tabla_body")
                        .append($("<td>").text(ticket.id_ticket))
                        .append($("<td>").text(ticket.nombre_ticket))
                        .append($("<td>").text(ticket.descripcion))
                        .append($("<td>").text(ticket.estado))
                        .append($("<td>").text(ticket.solucion))
                        .append($("<td>").text(ticket.fecha_inicio))
                        .append($("<td>").text(ticket.fecha_aprox))
                        .append($("<td>").text(ticket.fecha_cierre))
                        .append($("<td>").text(ticket.comentarios))
                        .append($("<td>").text(ticket.grupo_especialista))
                        .append($("<td>").text(ticket.usuario));

                id = ticket.id_ticket;
            });
            console.log("dentro " + id);
        }
    });
}

var id = -1;

(function () {

    actualizarTabla();
    console.log("despues actualizar pagina " + id);

    document.getElementById("bttonTicket").addEventListener("click", function (e) {
        actualizarTabla();
        console.log("despues del listener " + id);
    });

    
})();