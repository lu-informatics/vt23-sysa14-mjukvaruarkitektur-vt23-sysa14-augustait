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
          <li><a href="Customer.jsp">Customer Login</a></li>
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
    <h2>About us</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quis eros elit. Donec vitae ligula malesuada, tempor ex quis, auctor sapien. Donec posuere euismod facilisis. Fusce tristique diam nec justo bibendum dignissim. Pellentesque sed pulvinar dolor. Sed aliquet lacus nunc, ut pharetra metus commodo sit amet. Suspendisse rutrum, magna at finibus pharetra, libero sapien convallis nisl, ut semper ex est id est. Morbi convallis arcu a turpis bibendum, ut posuere sapien congue. Sed id venenatis turpis. Sed quis vehicula leo. Aliquam erat volutpat.</p>
    <p>Nam quis suscipit dolor. Integer in vestibulum odio. Vestibulum vel felis laoreet, placerat velit a, posuere turpis. Sed tristique interdum libero in molestie. Suspendisse feugiat, sem ut vestibulum feugiat, dui odio bibendum ante, eu rhoncus nibh turpis eget lectus. Nam ullamcorper justo id orci porttitor, nec consectetur mi dapibus. Etiam tristique nunc vitae erat consequat, quis elementum arcu congue. Fusce vel libero euismod, imperdiet enim nec, feugiat ante. Nullam quis felis eleifend, varius risus eget, bibendum elit. Proin pellentesque sit amet metus vel lacinia. Sed ac aliquet arcu, in hendrerit quam. Fusce feugiat, eros ut placerat pretium, purus augue convallis nisi, vel varius lorem eros ut purus. Nam eu sapien tortor. </p>
  </div>
  <img src="https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/plant-based-food-mc-220323-02-273c7b.jpg"
	alt="A beautiful image" alt="Contentlogo" class="imageContact2">
  </div>
  
	
	<div class="main-textContact">
    <h2>Contact Us</h2>
        <form>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required>

            <label for="message">Message:</label>
            <textarea id="message" name="message" required></textarea>

            <input type="submit" value="Submit">
        </form>
          </div>
     	
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