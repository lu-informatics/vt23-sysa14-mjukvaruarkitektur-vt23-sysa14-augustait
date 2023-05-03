$(document).ready(function(){
  console.log("Ready!");

 
  $.ajax({
    method: "GET",
    url: "http://api.ipstack.com/check?access_key=6809bc387365e7e5543c3d4b7a2fdc40",
    error: ajaxReturn_Error,
    success: ajaxReturn_Success
  })

  
  function ajaxReturn_Success(result, status, xhr) {
    ParseJsonFile(result);
  }
 

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
  
});

