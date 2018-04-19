function doGet(){
	$.ajax({
    	type: "GET",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/proxibanque/services/clientservice/Clients/"+$('#ClientID').val()
    }).then(function(data) {
       $('#ClientID').val(data.id);
       $('#ClientNom').val(data.nom);
       $('#ClientPrenom').val(data.prenom)
       $('#ClientAdresse').val(data.adresse);
       $('#ClientCodePostal').val(data.codepostal);
       $('#ClientVille').val(data.ville);
       $('#ClientTelephone').val(data.telephone);
    });
}
	
function doPost(){
$.ajax({
	type: "POST",
	 contentType: "application/json; charset=utf-8",
     dataType: "json",
     data: JSON.stringify({name:$('#ClientName').val()}),
    url: "http://localhost:8080/proxibanque/services/clientservice/Clients"
    	
	}).then(function(data) {
		 $('#ClientID').val(data.id);
	       $('#ClientNom').val(data.nom);
	       $('#ClientPrenom').val(data.prenom)
	       $('#ClientAdresse').val(data.adresse);
	       $('#ClientCodePostal').val(data.codepostal);
	       $('#ClientVille').val(data.ville);
	       $('#ClientTelephone').val(data.telephone);
	});
    
}

function doPut(){
	$.ajax({
    	type: "PUT",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/proxibanque/services/clientservice/Clients/"
    }).then(function(data) {
    	 $('#ClientID').val(data.id);
         $('#ClientNom').val(data.nom);
         $('#ClientPrenom').val(data.prenom)
         $('#ClientAdresse').val(data.adresse);
         $('#ClientCodePostal').val(data.codepostal);
         $('#ClientVille').val(data.ville);
         $('#ClientTelephone').val(data.telephone);
    });
}
	
function doDelete(){
	$.ajax({
    	type: "DELETE",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/proxibanque/services/clientservice/Clients/"+$('#ClienttID').val()
    }).then(function(data) {
       alert('Client supprimé de Proxibanque');
    });
}