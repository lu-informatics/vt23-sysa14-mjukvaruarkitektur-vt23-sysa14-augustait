<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>My Supermarket</title>
    <link rel="stylesheet" type="text/css" href="css/ICAStore.css">
        <link rel="stylesheet" type="text/css" href="Style.css">
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
          <li><a href="Customer.jsp">Customer Login</a></li>
        </ul>
      </nav>

    </header>
    <main>
      <section>
      <img
			src="https://png.pngtree.com/thumb_back/fh260/background/20200821/pngtree-pure-white-minimalist-background-wallpaper-image_396581.jpg"
			alt="A beautiful image" alt="Contentlogo" class="logoCustomer">
	</section>
  <section class="login-section">
    <div class="login-form">
      <h2>Login</h2>
      <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <input type="submit" value="Login">
      </form>
    </div>
  </section>
  <section>
    <!-- your other content here -->
  </section>
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
    <script>
      window.addEventListener('scroll', function() {
        const header = document.querySelector('header');
        header.classList.toggle('scroll', window.scrollY > 0);
      });
    </script>
  </body>
</html>

