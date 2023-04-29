<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>
	<header>
		<div class="header-container">
			<img src="https://scontent-ams2-1.xx.fbcdn.net/v/t1.15752-9/255161930_578347089889978_5226102132254144149_n.jpg?stp=dst-jpg_p206x206&_nc_cat=110&ccb=1-7&_nc_sid=aee45a&_nc_ohc=XevF6FAHeGMAX-WoqJK&_nc_ht=scontent-ams2-1.xx&oh=03_AdSMY3-Xh9GXaPX0ZYjDn0X5XirLLQUVLSzcsUrU5Mg3LQ&oe=64748A8E" alt="ICA ERP logo" class="logo">
		</div>
		<div class="welcome-header">
			<h1>Welcome to the ICA Order Management System</h1>
			<p>Here, you can manage and track all your orders efficiently and effectively.</p>
		</div>
	</header>

	<main>
		
		<div class="boxes-container">
			<div class="box box1">
				<h3>Create an Order</h3>
				<form action="Products.jsp">
					<label for="order-id">Order ID:</label>
					<input type="number" id="order-id" name="order-id"><br><br>
					<label for="order-date">Order Date:</label>
					<input type="text" id="order-date" name="order-date"><br><br>
					<label for="payment-method">Payment Method:</label>
					<input type="text" id="payment-method" name="payment-method"><br><br>
					<label for="customer-id">Customer ID:</label>
					<input type="number" id="customer-id" name="customer-id"><br><br>
					<label for="supermarket-id">Supermarket ID:</label>
					<input type="number" id="supermarket-id" name="supermarket-id"><br><br>
					<button type="submit">Create</button>
				</form>
			</div>
			<div class="box box2">
				<h3>Existing Order ID</h3>
				<p>For customers who already have an existing Order ID.</p>
				<form action="Products.jsp">
					<button type="submit">Go to Products</button>
				</form>
			</div>
			<div class="box box3">
				<h3>Overview of Orders</h3>
				<p>For employees who want to see an overview of all orders.</p>
				<form action="Overview.jsp">
					<button type="submit">Go to Overview</button>
				</form>
			</div>
		</div>
	</main>

	<footer>
		<p>&copy; 2023 ICA ERP Management System</p>
	</footer>
</body>
</html>
