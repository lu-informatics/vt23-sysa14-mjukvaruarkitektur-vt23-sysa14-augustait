<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Entity.css">
	<title>Products</title>
</head>
<body>
	<h1>Products</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>Product 1</td>
				<td>$10.00</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Product 2</td>
				<td>$20.00</td>
			</tr>
			<tr>
				<td>3</td>
				<td>Product 3</td>
				<td>$30.00</td>
			</tr>
		</tbody>
	</table>
	<h1>Orders</h1>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Total Price</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>Product 1</td>
				<td>2</td>
			<td>$10.00</td>
			<td>$20.00</td>
			<td><a href="#">Edit</a></td>
			<td><a href="#">Delete</a></td>
		</tr>
		<tr>
			<td>2</td>
			<td>Product 2</td>
				<td>1</td>
			<td>$20.00</td>
			<td>$20.00</td>
			<td><a href="#">Edit</a></td>
			<td><a href="#">Delete</a></td>
		</tr>
		<tr>
			<td>3</td>
			<td>Product 3</td>
				<td>3</td>
			<td>$30.00</td>
			<td>$90.00</td>
			<td><a href="#">Edit</a></td>
			<td><a href="#">Delete</a></td>
		</tr>
	</tbody>
</table>

<fieldset id="ordersFieldset">
<legend>Orders:</legend>
<label>Customer Name:</label>
<input type="text" id="customerName" name="customerName">
<label>Product ID:</label>
<input type="text" id="productId" name="productId">
<label>Quantity:</label>
<input type="text" id="quantity" name="quantity">
<input type="button" value="Add" onclick="addOrder()">
<input type="button" value="Delete" onclick="deleteOrder()">
<input type="button" value="Update" onclick="updateOrder()">
</fieldset>

<script>
	<!-- Your CRUD functions HTML code here -->
	</script>

</body>
</html>