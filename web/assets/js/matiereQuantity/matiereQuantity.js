function getMatiereQuantityTemplate(matiere, quantity) {
    return `
         <tr class="matiere">
            <td>`+matiere+`</td>
            <td>`+quantity+`</td>
            <td>
                <span><a type="button" onclick="deleteMatiereQuantity(this)" class="text-danger"><i
                    class="action-icon mdi mdi-close"></i></a></span>
            <td>
        </tr>
    `;
}

// fonction pour une nouvelle quantite
function addNewMatiereQuantity() {
    var matiereValue = $('#matiereInput').val();
    var quantiteValue = $('#quantityInput').val();
    
    // envoyer une ajax vers le controller
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/productionPoketra/AddQuantity',
        data: {
            matiere: matiereValue,
            quantity: quantiteValue
        },
        dataType: 'text',
        success: function (response) {
            console.log(response);
              var responseJson = JSON.parse(response);
              if(responseJson.error != null) {
                  console.log(responseJson.error);
              } else {
                  console.log(responseJson);
                  if(responseJson.exist == true) {
                      updateTableListMatiere(responseJson.matiere, responseJson.quantity);
                  } else {
                      
                        // add template to the quiz container
                        var matiereList = $('#matiereList');
                        var matiereTemplate = $(getMatiereQuantityTemplate(responseJson.matiere, responseJson.quantity));
                        matiereList.append(matiereTemplate);
                        matiereTemplate.attr('id', responseJson.idMatiere);        // Redonner l'ID aux nouvelles éléments
                  }
              }
        },
        error: function (response) {
            console.log("ERREUR , voici la reponse");
            console.log("TEXT : " + response);
            var jsonResponse = JSON.parse(response);
            console.log("JSON : " + jsonResponse);
        }
    });
}

//Fonction pour changer les valeurs du table article ajoutes
function updateTableListMatiere(name, quantity) {
    // Obtenez la référence de l'élément table par son ID
    var matiereList = document.getElementById('matiereList');

    // Vérifiez si l'élément avec l'ID spécifié existe
    if (matiereList) {
        // Obtenez toutes les lignes de la table (éléments tr)
        var rows = matiereList.getElementsByTagName('tr');

        // Parcourez toutes les lignes de la table
        for (var i = 0; i < rows.length; i++) {
            // Obtenez toutes les cellules de la ligne actuelle (éléments td)
            var cells = rows[i].getElementsByTagName('td');

            if(cells[0].textContent == name) {
                cells[1].textContent = quantity;
            }
        }
    } else {
        console.log("L'élément avec l'ID 'matiereList' n'a pas été trouvé.");
    }
}


// fonction pour supprimé un article ajoute
function deleteMatiereQuantity(bouton) {
    var matiere = bouton.closest('.matiere');
    var id = matiere.id;
    console.log(id);
    // Ensuite supprimé du session
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/productionPoketra/DeleteMatiereQuantity',
        data: {
            idMatiere: id
        },
        success: function (reponse) {
            matiere.remove();
        },
        error: function () {
            alert("Une erreur est survenue lors du suppression !");
        }
    });
}