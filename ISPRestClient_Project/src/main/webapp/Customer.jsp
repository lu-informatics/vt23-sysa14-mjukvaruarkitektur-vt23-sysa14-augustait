<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" type="text/css" href="css/ICAStore.css">
         <link rel="stylesheet" type="text/css" href="css/Style.css">
    
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
                <li><a href="Contact.jsp">View Products</a></li>
                <li><a href="Contact.jsp">Find your Order</a></li>
                <li><a href="Customer.jsp">Customer settings</a></li>
                <li><a href="FrontPage.jsp">LOG OUT</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
     <section>
      <img
			src="https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/plant-based-food-mc-220323-02-273c7b.jpg"
			alt="A beautiful image" alt="Contentlogo" class="logoFood">
	</section>
	
        <div class="customer-info">
  <h2>Find Your Customer Information</h2>
  <form method="post" action="CustomerInfo.jsp">
    <label for="customer-id">Enter Your Customer ID:</label>
    <input type="text" id="customer-id" name="customerID" required>
    <br>
    <input type="submit" value="Find Information">
  </form>
</div>

<div id="customer-info-container"></div>
        
    </main>
    
    <footer>
        <div>
            <h3>Supermarket Address</h3>
            <p>123 Main St.</p>
            <p>Anytown, USA 12345</p>
        </div>
        <div class="weather-widget">
            <img src="weather-icon.png" alt="Current weather icon">
            <p>72&deg;F</p>
        </div>
    </footer>
    
</body>
</html>
