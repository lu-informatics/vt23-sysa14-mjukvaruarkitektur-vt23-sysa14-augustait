$(document).ready(function() {
  console.log("Ready!");

//FIND ORDERS
  function ajaxReturn_Error_Order(result, status, xhr) {
    console.log("Ajax-find order: " + status);
  }

  function ParseJsonFileOrder(result) {
    var table = "<table><tr><th>Order ID</th><th>Order Date</th><th>Supermarket ID</th><th>Customer ID</th><th>Payment Method</th></tr>";
    for (var i = 0; i < result.length; i++) {
      var order = result[i];
      table += "<tr><td>" + order.OrderID + "</td><td>" + order.OrderDate + "</td><td>" + order.SupermarketID + "</td><td>" + order.CustomerID + "</td><td>" + order.PaymentMethod + "</td></tr>";
    }
    table += "</table>";
    $("#order-info-container").html(table);
  }

  function clearFields() {
    $("#order-id").val("");
  }

  //FIND--->
  $("#customer-info-form").submit(function(event) {
    event.preventDefault();
    var strValue = $("#customer-id").val();
    if (strValue != "") {
      $.ajax({
        method: "GET",
        url: "http://localhost:8080/RestServerISPProject/ICAStore/orders/" + strValue,
        error: ajaxReturn_Error_Order,
        success: function(result, status, xhr) {
          console.log(result);
          ParseJsonFileOrder(result);
          clearFields();
        }
      })
    }
  });
});

  
  function ajaxReturn_Error(result, status, xhr) {
    console.log("Ajax-find movie: " + status);
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
  $("#FindBtn").click(function() {
    var strValue = $("#id").val();
    if (strValue != "") {
      $.ajax({
        method: "GET",
        url: "http://localhost:8080/RestServerISPProject/ICAStore/products/" + strValue,
        error: ajaxReturn_Error,
        success: function(result, status, xhr) {
          ParseJsonFileMovie(result);
        }
      })
    }
  });

  //VIEW ALL
  function parseJsonFileProducts(results) {
  $("#products-table").find("tr:gt(0)").remove();
  // Loop through the results and append them to the table
  for (var i = 0; i < results.length; i++) {
    var product = results[i];
    console.log(product); // add this line

    $("#products-table").append(
      "<tr><td>" +
      product.id +
      "</td><td>" +
      product.title +
      "</td><td>" +
      product.price +
      "</td></tr>"
    );
  }
}

  function clearTable() {
    $("#products-table tr").not(":first").remove();
  }

  $("#view-all-btn").click(function() {
    console.log("View All button clicked!"); // Add this line
    // Clear the table before loading the products
    clearTable();

    $.ajax({
      method: "GET",
      url: "http://localhost:8080/RestServerISPProject/ICAStore/products",
      success: function(result, status, xhr) {
        console.log(result); // Add this line
        parseJsonFileProducts(result);
      },
      error: function(result, status, xhr) {
        alert("Error");
        console.log("SOMETHING " + status);
      },
    });
  });
});

