<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>My Supermarket</title>
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
	<div class="main-text">
    <h2>Latest News</h2>
<p>Introducing Our New Organic Produce Section</p>
<p>At the Fresh Food Market, we're always striving to provide our customers with the freshest and healthiest options available. That's why we're thrilled to announce the launch of our new organic produce section! We're partnering with local farmers and suppliers to bring you the best selection of organic fruits and vegetables. Whether you're looking for crisp greens, juicy berries, or sweet, ripe melons, you'll find it all in our new section.</p>
<p>Plus, to celebrate the launch of our organic produce section, we're offering a special promotion for our customers. For a limited time, when you purchase any item from our new organic produce section, you'll receive a free reusable shopping bag, perfect for your future visits to our store!</p>
<p>So come on down to the Fresh Food Market today and check out our new organic produce section. We can't wait to see you!</p>
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
