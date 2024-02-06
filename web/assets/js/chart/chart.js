$(function () {
  // Fonction pour récupérer les données depuis le servlet Java
  function fetchData() {
          $.ajax({
            url: 'http://localhost:8080/productionPoketra/ChargeDataJson', // Remplacez par l'URL réelle de votre servlet
            type: 'GET',
            dataType: 'json',
            success: function (data) {
              // Mettez à jour les données du graphique avec les nouvelles données reçues
              updateChartData(data);
            },
            error: function (error) {
              console.error('Erreur lors de la récupération des données : ', error);
            }
          });
  }

  // Fonction pour mettre à jour les données du graphique
  function updateChartData(newData) {
    // Mettez à jour les données du graphique avec les nouvelles données reçues
    doughnutPieData.datasets[0].data = newData.data;
    
    // Mettez à jour d'autres propriétés du graphique si nécessaire

    // Mettez à jour le graphique
    pieChart.update();
  }

 
  var doughnutPieData = {
    datasets: [{
      data: [30, 40, 30],
      backgroundColor: [
        'rgba(255, 99, 132, 0.5)',
        'rgba(54, 162, 235, 0.5)',
        'rgba(255, 206, 86, 0.5)',
        'rgba(75, 192, 192, 0.5)',
        'rgba(153, 102, 255, 0.5)',
        'rgba(255, 159, 64, 0.5)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
    }],

    // These labels appear in the legend and in the tooltips when hovering different arcs
    labels: [
      'Masculin',
      'Feminin',
    ]
  };
  var doughnutPieOptions = {
    responsive: true,
    animation: {
      animateScale: true,
      animateRotate: true
    }
  };

  if ($("#pieChart").length) {
    var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
    var pieChart = new Chart(pieChartCanvas, {
      type: 'pie',
      data: doughnutPieData,
      options: doughnutPieOptions
    });

    // Appel initial pour récupérer les données
    fetchData();

    // Mise en place d'une temporisation pour actualiser périodiquement les données
    setInterval(fetchData, 60000); // Actualisation toutes les 60 secondes (ajustez selon vos besoins)
  }
});
/*

$(function () {
 
  var doughnutPieData = {
    datasets: [{
      data: [30, 40, 30],
      backgroundColor: [
        'rgba(255, 99, 132, 0.5)',
        'rgba(54, 162, 235, 0.5)',
        'rgba(255, 206, 86, 0.5)',
        'rgba(75, 192, 192, 0.5)',
        'rgba(153, 102, 255, 0.5)',
        'rgba(255, 159, 64, 0.5)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
    }],

    // These labels appear in the legend and in the tooltips when hovering different arcs
    labels: [
      'Pink',
      'Blue',
      'Yellow',
    ]
  };
  var doughnutPieOptions = {
    responsive: true,
    animation: {
      animateScale: true,
      animateRotate: true
    }
  };

  if ($("#pieChart").length) {
    var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
    var pieChart = new Chart(pieChartCanvas, {
      type: 'pie',
      data: doughnutPieData,
      options: doughnutPieOptions
    });
  }
});*/