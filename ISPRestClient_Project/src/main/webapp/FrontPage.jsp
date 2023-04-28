<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
</script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/ICAStore.css">
<script src="js/ICA.js"></script>
<title>Rest Client</title>
</head>
<body>
<header>
<p>GREEN DELI</p>
</header>
<section id="row"> 
<nav>
<ul>
<li><a href="Product.jsp">Products</a></li>
<li><a href="Order.jsp">Orders</a></li>
<li><a href="Customer.jsp">Customer</a></li>

</ul>
</nav>
<aside>
<table id="asideTable">
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
<article>
<fieldset id="PersonalFS">
<legend>Product:</legend>
Id:<br>
<input type="text" name="id" id="id" value=""><br>
Name:<br>
<input type="text" name="title" id="title" value="">
<br>
Price:<br>
<input type="text" name="price" id="price" value="">
<br><br>
<input type="button" name="submitBtn" value="Find" id="FindBtn">
<input type="button" name="submitBtn" value="Add" id="AddBtn">
<input type="button" name="submitBtn" value="Delete" id="DeleteBtn">
<input type="button" name="submitBtn" value="Update" id="UpdateBtn">
</fieldset>
</article>
</section>
</section>
</section>
<footer>
<p>&copy; - AUGUSTA IT</p>
</footer>
</body>
</html>