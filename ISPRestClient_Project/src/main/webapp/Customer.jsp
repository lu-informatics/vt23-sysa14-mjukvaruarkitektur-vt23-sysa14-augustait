<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Customers</title>
  <link rel="stylesheet" type="text/css" href="css/Entity.css">
</head>
<body>
  <h1>Customers</h1>

  <!-- CRUD buttons -->
  <div class="crud-buttons">
    <button class="crud-btn">Create</button>
    <button class="crud-btn">Read</button>
    <button class="crud-btn">Update</button>
    <button class="crud-btn">Delete</button>
  </div>

  <!-- customer form -->
  <form id="customer-form">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">

    <label for="email">Email:</label>
    <input type="email" id="email" name="email">

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone">

    <label for="address">Address:</label>
    <textarea id="address" name="address"></textarea>

    <input type="submit" value="Submit">
  </form>

  <!-- subscription section -->
  <div id="subscription-section">
    <h2>Subscribe to Our Newsletter</h2>

    <form id="subscription-form">
      <label for="subscription-email">Email:</label>
      <input type="email" id="subscription-email" name="subscription-email">

      <input type="submit" value="Subscribe">
    </form>
  </div>

</body>
</html>
