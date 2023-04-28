<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/ICAStore.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/ICA.js"></script>
<title>Green Deli - Online Delivery Store</title>
</head>
<body>
	<header>
		<h1>GREEN DELI</h1>
	</header>
	<main>
		<section id="row">
			<nav>
				<ul>
					<li><a href="Product.jsp">Products</a></li>
					<li><a href="Order.jsp">Orders</a></li>
					<li><a href="Customer.jsp">Customers</a></li>
				</ul>
			</nav>
			<aside>
				<table>
					<tr>
						<th><span id="city"></span></th>
						<th><span></span></th>
						<th><span></span></th>
						<th><span id="ipNbr"></span></th>
					</tr>
					<tr>
						<td><span id="degree"></span></td>
						<td><span id="weather"></span></td>
						<td><span></span></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td colspan="4"><span id="sunrise"></span></td>
					</tr>
					<tr>
						<td colspan="4"><span id="sunset"></span></td>
					</tr>
				</table>
			</aside>
			<section id="main">
				<section id="content">
					<img src="https://assets.icanet.se/e_sharpen:80,q_auto,dpr_1.25,w_718,h_718,c_lfill/imagevaultfiles/id_181348/cf_259/fattoush_-_somrig_sallad_med_mynta_och_halloumi.jpg" alt="A delicious salad" 
					class="centered-image">
				</section>
			</section>
		</section>
		<footer>
			<p>&copy; - AUGUSTA IT</p>
		</footer>
</body>
</html>
