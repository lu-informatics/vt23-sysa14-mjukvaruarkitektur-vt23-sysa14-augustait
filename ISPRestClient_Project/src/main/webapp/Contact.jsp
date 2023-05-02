<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Contact</title>
    <link rel="stylesheet" type="text/css" href="css/ICAStore.css">
  </head>
  <body>
    <header>
    <div class="header-container">
		<img src="https://cdn.winsightmedia.com/platform/files/public/gb/News/The-Fresh-Market-Unveils-Refreshed-Logo-and-Stores/400x600/TheFreshMarket_PrimaryLogo.png" alt="ICA ERP logo" class="logo">
	</div>
	<div class="welcome-header">
		<h1>Welcome to the FRESH FOOD MARKET </h1>
		<p>Food with great taste!</p>
	</div>

	<nav>
        <ul>
          <li><a href="FrontPage.jsp">Home</a></li>
          <li><a href="Contact.jsp">Contact</a></li>
          <li><a href="Login.jsp">Customer Login</a></li>
        </ul>
      </nav>

    </header>
    <main>
      <!-- your main content here -->
       <section>
      <img
			src="https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/plant-based-food-mc-220323-02-273c7b.jpg"
			alt="A beautiful image" alt="Contentlogo" class="logoFood">
	</section>
	<div class="main-ContainerContact">
	
	<img src="https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/plant-based-food-mc-220323-02-273c7b.jpg"
		alt="A beautiful image" alt="Contentlogo" class="imageContact">

    <div class= "textContact">
    <h2>About Fresh Food Market</h2>
<p>At Fresh Food Market, we believe that everyone deserves access to fresh, high-quality food at affordable prices. That's why we're committed to providing our customers with the freshest produce, meats, and other products available.</p>
<p>We work directly with local farmers and suppliers to ensure that our products are always fresh and of the highest quality. Our knowledgeable staff is always on hand to help you find what you need and answer any questions you may have.</p>
<p>Whether you're looking for ingredients for a special meal, or just need to stock up on everyday essentials, Fresh Food Market is your one-stop-shop for all your grocery needs. Visit us today and experience the difference that fresh food can make!</p>
</div>
  <img src="https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/plant-based-food-mc-220323-02-273c7b.jpg"
	alt="A beautiful image" alt="Contentlogo" class="imageContact2">
  </div>
  
	
	<div class="main-textContact">
    <h2>Contact Us</h2>
    <p>For inquiries and assistance, please contact us through the following:</p>
    <ul>
        <li>Customer Service Hotline: 555-1234</li>
        <li>Email: info@freshfoodmarket.com</li>
        <li>Address: 123 Main St., Anytown, 12345</li>
    </ul>
</div>
     	
    </main>
    <footer>
      <div>
        <h3>FRESH FOOD MARKET</h3>
<p>Greenland Supermarket</p>
<p>32 Oak Street</p>
<p>City, State 12345</p>
      </div>
      <div class="weather-widget">
        <img src="weather-icon.png" alt="Current weather icon">
        <p>72&deg;F</p>
      </div>
    </footer>
    <script>
      window.addEventListener('scroll', function() {
        const header = document.querySelector('header');
        header.classList.toggle('scroll', window.scrollY > 0);
      });
    </script>
  </body>
</html>