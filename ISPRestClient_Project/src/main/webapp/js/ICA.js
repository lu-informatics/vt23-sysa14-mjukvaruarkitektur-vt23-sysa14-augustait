$(document).ready(function(){
  console.log("Ready!");

  /*
  $.ajax({
    method: "GET",
    url: "http://api.ipstack.com/check?access_key=0265e412145bd1eeafe31da0d5ae844b",
    error: ajaxReturn_Error,
    success: ajaxReturn_Success
  })

  //Commented out
  function ajaxReturn_Success(result, status, xhr) {
    ParseJsonFile(result);
  }
  */

  function ajaxReturn_Error(result, status, xhr) {
    console.log("Ajax-find movie: "+status);
  }

  function ParseJsonFile(result) {
    var lat = result.latitude;
    var long = result.longitude;
    var city = result.city;
    var ipNbr = result.ip;
    $("#city").text(city);
    $("#ipNbr").text(ipNbr);
    $.ajax({
      method: "GET",
      url: "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + long + "&units=metric&APPID=60d1e29ab699b441330da90420732b8e",
      error: ajaxWeatherReturn_Error,
      success: ajaxWeatherReturn_Success
    });
  }

  function ajaxWeatherReturn_Success(result, status, xhr) {
    var sunrise = result.sys.sunrise;
    var sunset = result.sys.sunset;
    var sunriseDate = new Date(sunrise*1000);
    var timeStrSunrise = sunriseDate.toLocaleTimeString();
    var sunsetDate = new Date(sunset*1000);
    var timeStrSunset = sunsetDate.toLocaleTimeString();
    $("#sunrise").text("Sunrise: "+timeStrSunrise);
    $("#sunset").text("Sunset: "+timeStrSunset);
    $("#weather").text(result.weather[0].main);
    $("#degree").text(result.main.temp+" \u2103");
  }

  function ajaxWeatherReturn_Error(result, status, xhr) {
    alert("Error i OpenWeaterMap Ajax");
    console.log("Ajax-find movie: "+status);
  }

  function ParseJsonFileMovie(result) {
   
    $("#id").val(result.productId);
    $("#title").val(result.productName);
    $("#price").val(result.productPrice);
    $("#category").val(result.productCategory);
  }

  function clearFields() {
    $("#id").val("");
    $("#title").val("");
    $("#price").val("");
    $("#category").val("");
  }

  //FIND--->
  $("#FindBtn").click( function() {
    var strValue = $("#id").val();
    if (strValue != "") {
      $.ajax({
        method: "GET",
        url: "http://localhost:8080/RestServerISPProject/ICAStore/"+strValue,
        error: ajaxFindReturnError,
        success: ajaxFindReturnSuccess
      })
    }
  });

  function ajaxFindReturnSuccess(result, status, xhr) {
    ParseJsonFileMovie(result);
  }

  function ajaxFindReturnError(result, status, xhr) {
    alert("Error");
    console.log("SOMETHING "+status);
  }

});

//FIND ALL
function parseJsonFileProducts(results) {
    $("#products-table").find("tr:gt(0)").remove();
  // Loop through the results and append them to the table
  for (var i = 0; i < results.length; i++) {
    var product = results[i];
        console.log(product); // add this line

    $("#products-table").append(
      "<tr><td>" +
        product.productId +
        "</td><td>" +
        product.productName +
        "</td><td>" +
        product.productPrice +
        "</td><td>" +
        product.productCategory +
        "</td></tr>"
    );
  }
}

function clearTable() {
  $("#products-table tr").not(":first").remove();
}

$("#view-all-btn").click(function () {
    console.log("View All button clicked!"); // Add this line
  // Clear the table before loading the products
  clearTable();

  $.ajax({
    method: "GET",
    url: "http://localhost:8080/RestServerISPProject/ICAStore",
    
    success: function (result, status, xhr) {
          console.log(result); // Add this line
      parseJsonFileProducts(result);
    },
    
    error: function (result, status, xhr) {
      alert("Error");
      console.log("SOMETHING " + status);
    },
  });
});

