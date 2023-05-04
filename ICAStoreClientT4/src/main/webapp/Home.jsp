<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>
	<header>
		<div class="header-container">
    <a href="Home.jsp">
        <img src="https://scontent-ams2-1.xx.fbcdn.net/v/t1.15752-9/255161930_578347089889978_5226102132254144149_n.jpg?stp=dst-jpg_p206x206&_nc_cat=110&ccb=1-7&_nc_sid=aee45a&_nc_ohc=XevF6FAHeGMAX-WoqJK&_nc_ht=scontent-ams2-1.xx&oh=03_AdSMY3-Xh9GXaPX0ZYjDn0X5XirLLQUVLSzcsUrU5Mg3LQ&oe=64748A8E" alt="ICA ERP logo" class="logo">
    </a>
</div>
</header>
		<div class="welcome-header">
			<h1>Welcome to the ICA Order Management System</h1>
			<p>Here, you can manage and track all your orders efficiently and effectively.</p>
		</div>
	

	<main>
		
		<div class="boxes-container">
			<div class="box box1">
				<h3>Create an Order</h3>
				
				<form id="order-form" action="/ICAStoreClientT4/MainServlet" method="POST">
				
	<label for="orderId">Order ID:</label>
	<input type="number" id="orderId" name="orderId"><br><br>
	
	<label for="orderDate">Order Date:</label>
	<input type="text" id="orderDate" name="orderDate"><br><br>
	
	<label for="paymentMethod">Payment Method:</label>
	<input type="text" id="paymentMethod" name="paymentMethod"><br><br>
	
	<label for="customerId">Customer ID:</label>
	<input type="number" id="customerId" name="customerId"><br><br>
	
	<label for="supermarketId">Supermarket ID:</label>
	<input type="number" id="supermarketId" name="supermarketId"><br><br>
	
	<button type="submit">Create</button>
</form>
			</div>
			<div class="box box2">
				<h3>Products</h3>
				<p>Do you wish to see the products? Click down below.</p>
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

	

</body>
</html>
