/* */

(function() {
    'use strict'
    
    let radio_agregar = document.getElementById("radio_agregar");
    radio_agregar.addEventListener('change', validarRadios); 

    let radio_crear = document.getElementById("radio_crear");
    radio_crear.addEventListener('change', validarRadios);    
    
    let radio_temp = document.getElementById("radio_temp");
    radio_temp.addEventListener('change', validarRadios);    
    
    let tr = document.getElementsByClassName("tr_login");
        
    function validarRadios(e){
        if(!e.target.checked)
        {
            console.log("Error tienes que seleccionar un radiobutton");
            //se puede hacer con alert
        }
        else
        {
            if(radio_agregar.checked)
            {
                for(let i = 0; i < tr.length-1; i++)
                    tr[i].style.display = "table-row";
                tr[tr.length-1].style.display = "none";
                    
                console.log("Seleccion radio_agreagar");
            }
            else if(radio_crear.checked)
            {
                for(let i = 0; i < tr.length; i++)
                    tr[i].style.display = "table-row";
                
                console.log("Seleccion radio_crear");
            }
            else
            {
                for(let i = 0; i < tr.length; i++)
                    tr[i].style.display = "none";
                
                console.log("Seleccion radio_temp");
            }
        }
        console.log("resultado ");
    }
        
})();