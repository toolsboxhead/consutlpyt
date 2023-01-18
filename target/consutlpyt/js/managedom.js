


function transitionDataCons (url, vista){
    var req = new XMLHttpRequest();

    req.open("GET",  url, false);
    req.send(null);
    vista.innerHTML = req.responseText;
}

function loadDataText () {
    transitionDataCons("data_cons.jsp", document.getElementById("link_data"));
}

function loadDataGraph() {
    transitionDataCons("grap_cons.jsp", document.getElementById("link_data"));
}



 	$(document).ready(function() {
		$('#submit').click(function(event) {
			var anno1 = $('#sel_anoini').val();
			var mees1 = $('#sel_mesini').val();
			var anno2 = $('#sel_anofin').val();
			var mees2 = $('#sel_mesfin').val();
			var lcons = $('#list_sel').value;
			//alert("Entrando a Listado!");
			var arrayCon = document.getElementById("list_sel");
			var consbusc = [];
			for (var i = 0; i <= arrayCon.options.length - 1; i++){
				consbusc[i] = arrayCon.options[i].value;
			}
			//alert("valores : A1 : " + anno1 + "M1 : " +  mees1 + "A2 : " + anno2 + "M2 : "+ mees2);
			//alert("Consult" + consbusc[1]);
			
			if (consbusc.length > 0 ){
	        $.post('./receitas', {
				annoi : anno1,
				meesi : mees1,
				annof : anno2,
				meesf : mees2,
				consu : consbusc

			}, function(responseText) {
				$('#sec-data').html(responseText);
			});
		    }else{
				alert("No hay Datos Seleccionados!");
			}

		});


		$('#btn_graph').click(function(event) {
			alert("graficas!");
			/* let grapCanvas = document.getElementById("graf-pic");
		   const lbl_text = [];
		   const dat_util = {
			   label: "Utilidades x Mes",
			   data: [],
			   backgroundColor: '',
			   borderColor: '',
			   borderWidth: 1,
   
		   }; */
	
		 $.post('./graficas',  function(responseText) {
			   var infodat = JSON.parse(responseText);
			   $('#sec-data').html(responseText);
			   //alert("entroG");
			  
			   var codcons ="";
			   var nombr = [];
			   var label = [];
			   var datos = [];
			   var valor = [];
			   var tot_val = 0;
			   var meses  = ['Ene',  'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep','Oct','Nov','Dic'];
			   /* for(let i = 0; i <= infodat.length; i++ ){ */
			    for( i of infodat){
					if (codcons == "") { 
						codcons = i.co_usuario
					    nombr.push(i.no_usuario)
					}else  if(codcons !== i.co_usuario) {
						codcons = i.co_usuario;
						nombr.push(i.no_usuario);
						valor.push(tot_val);
					}else{
						label.push(meses[i.dt_meesuti]);
						valor.push(i.mo_tolucro);
						tot_val = tot_val + i.mo_tolucro;
						//console.log(i.co_usuario + " " + meses[i.dt_meesuti] + " " +i.mo_tolucro);
						//alert(i.co_usuario + " " + meses[i.dt_meesuti] + " " +i.mo_tolucro);
					}
			   } // End del FOR

		   });  

   
	   });
	}); 

	
    
 

   // ! FUNCTON PARA MOVER LOS CONSULTORES SELECIONADOS 
   // ! A LA LISTA DE BUSQUEDA
	function move(valor) {
		
    if (valor === 1) {
		
	  var arrayUno = document.getElementById("list-cons");
      var arrayDos = document.getElementById("list_sel");
      var seleccionar = arrayUno.selectedIndex;
	  var seleccionarDos = arrayDos.options.length;
      var mover = arrayUno.options[seleccionar];
     
		
        
        arrayDos.options[seleccionarDos] = new Option(mover.text, mover.value);
        arrayUno.options[seleccionar] = null;

		
    } else if (valor === 2) {
		
		var arrayUno = document.getElementById("list_sel");
		var arrayDos = document.getElementById("list-cons");
		var seleccionar = arrayUno.selectedIndex;
	    var seleccionarDos = arrayDos.options.length;
        var mover = arrayUno.options[seleccionar];
		
  
		arrayDos.options[seleccionarDos] = new Option(mover.text, mover.value);
        arrayUno.options[seleccionar] = null;

    }

	
  }
