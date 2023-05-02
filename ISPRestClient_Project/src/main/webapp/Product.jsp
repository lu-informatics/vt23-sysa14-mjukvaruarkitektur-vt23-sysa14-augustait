<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="css/ICAStore.css">
         <link rel="stylesheet" type="text/css" href="css/Style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
  <div class="product-container">
    <h2>All Products</h2>
    <button id="view-all-btn">View All Products</button>
<table>
  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Price</th>
      <th>Category</th>
    </tr>
  </thead>
  <tbody id="products-table"></tbody>
</table>
  
</div>

<div id="customer-info-container"></div>
        
    </main>
    
   
   
    <footer>
        <div>
             <h3>FRESH FOOD MARKET</h3>
<p>Greenland Supermarket</p>
<p>32 Oak Street</p>
<p>City, State 12345</p>
        </div>
        
       
    </footer>
    
</body>
</html>