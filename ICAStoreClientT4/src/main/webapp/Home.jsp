<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supermarket Homepage</title>
<link rel="stylesheet" type="text/css" href="Management.css">
</head>
<body>

<header>
  <img src="logo.png" alt="Supermarket Logo">
  <nav>
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">About</a></li>
    </ul>
  </nav>
</header>

<main>
  <div class="slideshow-container">
    <div class="mySlides fade">
      <img src="slide1.png" style="width:100%">
      <div class="hero-text">
        <h1>Welcome to our Supermarket</h1>
        <p>Discover our wide selection of products and unbeatable prices</p>
        <button>Shop Now</button>
      </div>
    </div>

    <div class="mySlides fade">
      <img src="slide2.png" style="width:100%">
      <div class="hero-text">
        <h1>Save More With Our Promotions</h1>
        <p>Check out our latest promotions and save big on your favorite products</p>
        <button>View Promotions</button>
      </div>
    </div>

    <div class="mySlides fade">
      <img src="slide3.png" style="width:100%">
      <div class="hero-text">
        <h1>Get Free Delivery on Your First Order</h1>
        <p>Place your first order today and enjoy free delivery to your doorstep</p>
        <button>Shop Now</button>
      </div>
    </div>

    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
  </div>

  <br>

  <div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span>
    <span class="dot" onclick="currentSlide(2)"></span>
    <span class="dot" onclick="currentSlide(3)"></span>
  </div>
  
  <section class="featured-products">
    <h2>Featured Products</h2>
    <div class="product">
      <img src="product1.png" alt="Product 1">
      <h3>Product 1</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sed risus vel nulla dignissim eleifend.</p>
      <button>Add to Cart</button>
    </div>
    <div class="product">
      <img src="product2.png" alt="Product 2">
      <h3>Product 2</h3>
      <p>Integer eget mi ornare, dignissim nunc eu, bibendum enim. Sed posuere eleifend sapien, ac maximus felis vestibulum id.</p>
      <button>Add to Cart</button>
    </div>
    <div class="product">
      <img src="product3.png" alt="Product 3">
      <h3>Product 3</h3>
      <p>Nam malesuada justo vel quam consectetur, vitae consectetur elit euismod</p>
      <button>Shop Now</button>
    </div>
  </section>
</main>
    <footer>
        &copy; 2023 Supermarket Inc.
    </footer>
</body>
</html>
