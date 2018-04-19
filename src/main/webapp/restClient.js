function doGet(){
	$.ajax({
    	type: "GET",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/proxibanque/services/clientservice/Clients/"+$('#clientID').val()
    }).then(function(data) {
       $('#clientID').val(data.id);
       $('#clientNom').val(data.nom);
       $('#clientPrenom').val(data.prenom)
       $('#clientAdresse').val(data.adresse);
       $('#clientCodePostal').val(data.codepostal);
       $('#clientVille').val(data.ville);
       $('#clientTelephone').val(data.telephone);
    });
}
	
function doPost(){
$.ajax({
	type: "POST",
	 contentType: "application/json; charset=utf-8",
     dataType: "json",
     data: JSON.stringify({nom:$('#clientNom').val(),
     prenom:$('#clientPrenom').val(),
     adresse:$('#clientAdresse').val(),
     codepostal:$('#clientCodePostal').val(),
     ville:$('#clientVille').val(),
     telephone:$('#clientTelephone').val()}),
    url: "http://localhost:8080/proxibanque/services/clientservice/Clients"
    	
	}).then(function(data) {
		 $('#clientID').val(data.id);
	      $('#clientNom').val(data.nom);
	       $('#clientPrenom').val(data.prenom)
	       $('#clientAdresse').val(data.adresse);
	       $('#clientCodePostal').val(data.codepostal);
	       $('#clientVille').val(data.ville);
	       $('#clientTelephone').val(data.telephone);
	});
    
}

function doPut(){
	$.ajax({
    	type: "PUT",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/proxibanque/services/clientservice/Clients/"
    }).then(function(data) {
    	 $('#clientID').val(data.id);
         $('#clientNom').val(data.nom);
         $('#clientPrenom').val(data.prenom)
         $('#clientAdresse').val(data.adresse);
         $('#clientCodePostal').val(data.codepostal);
         $('#clientVille').val(data.ville);
         $('#clientTelephone').val(data.telephone);
    });
}
	
function doDelete(){
	$.ajax({
    	type: "DELETE",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/proxibanque/services/clientservice/Clients/"+$('#clientID').val()
    }).then(function(data) {
       alert('Client supprimé de Proxibanque');
    });
}