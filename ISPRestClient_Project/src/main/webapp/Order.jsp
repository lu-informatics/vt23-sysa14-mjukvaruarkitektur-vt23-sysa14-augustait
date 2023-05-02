<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order</title>
    <link rel="stylesheet" type="text/css" href="css/ICAStore.css">
    <link rel="stylesheet" type="text/css" href="css/Style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="js/test.js"></script>
</head>
<body>

<header>
    <div class="header-container">
        <img src="https://cdn.winsightmedia.com/platform/files/public/gb/News/The-Fresh-Market-Unveils-Refreshed-Logo-and-Stores/400x600/TheFreshMarket_PrimaryLogo.png" alt="ICA ERP logo" class="logo">
    </div>
    <div class="welcome-header">
        <h1>FRESH FOOD MARKET </h1>
    </div>
    <nav>
        <ul>
            <li><a href="Product.jsp">View Products</a></li>
            <li><a href="Order.jsp">Find your Order</a></li>
            <li><a href="Customer.jsp">Customer settings</a></li>
            <li><a href="FrontPage.jsp">LOG OUT</a></li>
        </ul>
    </nav>
</header>

<main>

    <section>
        <img src="https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/plant-based-food-mc-220323-02-273c7b.jpg"
             alt="A beautiful image" alt="Contentlogo" class="logoFood">
    </section>

    <div class="customer-info">
        <h2>Find Your Order Information</h2>
        <form method="post" id="customer-info-form">
            <label for="customer-id">Enter Your Customer ID:</label>
            <input type="text" id="customer-id" name="customerID" required>
            <br>
            <input type="submit" value="Find Information">
        </form>
    </div>
    <section>
      <h2>Customer Information</h2>
    <div id="customer-info-container"></div>
    </section>

</main>

<footer>
    <div>
        <h3>Supermarket Address</h3>
        <p>123 Main St.</p>
        <p>Anytown, USA 12345</p>
    </div>
</footer>

</body>
</html>

