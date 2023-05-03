$(document).ready(function() {
  console.log("Ready!");

  // VIEW ALL
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
  
  function parseJsonFileProducts(results) {
  $("#products-table").find("tr:gt(0)").remove();
  // Loop through the results and append them to the table
  for (var i = 0; i < results.length; i++) {
    var product = results[i];

    $("#products-table").append(
      "<tr data-product-id='" + product.id + "'><td>" +
      product.id +
      "</td><td>" +
      product.title +
      "</td><td>" +
      product.price +
      "</td></tr>"
    );
  }
}

 // Delete button click event
$("#delete-btn").click(function(event) {
  event.preventDefault(); // prevent form submission
  var productId = $("#productId").val();
  if (productId !== "") {
    $.ajax({
      method: "DELETE",
      url: "http://localhost:8080/RestServerISPProject/ICAStore/products/" + productId,
      success: function(result, status, xhr) {
        console.log("Product deleted successfully");
        clearFields(); // clear form fields
        $("#message-container").text("Product deleted successfully"); // set message text

        // Remove the deleted product row from the table
        var deletedRow = $("#products-table").find("tr[data-product-id='" + productId + "']");
        if (deletedRow.length > 0) {
          deletedRow.remove();
        }
      },
      error: function(xhr, status, error) {
        console.log("Error deleting product");
        alert("Error deleting product: " + error);
      }
    });
  }
});

});


