<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/Style.css">
        <link rel="stylesheet" type="text/css" href="css/ICAStore.css">
    
</head>

<body>
<header>
    <div class="header-containerCustomer">
		<img src="https://cdn.winsightmedia.com/platform/files/public/gb/News/The-Fresh-Market-Unveils-Refreshed-Logo-and-Stores/400x600/TheFreshMarket_PrimaryLogo.png" alt="ICA ERP logo" class="logo">
	</div>
	<nav>
        <ul>
          <li><a href="FrontPage.jsp">Home</a></li>
          <li><a href="Contact.jsp">Contact</a></li>
        </ul>
      </nav>

    </header>
	<div class="container">
			<form action="Product.jsp" method="post">
			<h2>Login</h2>
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" required>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required>
			<button type="submit">Login</button>
			<button type="button" id="help-btn">Help</button>
		</form>
	</div>
</body>
</html>
