<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>
    <header>
        <div class="header-container">
    <a href="Home.jsp">
        <img src="https://scontent-ams2-1.xx.fbcdn.net/v/t1.15752-9/255161930_578347089889978_5226102132254144149_n.jpg?stp=dst-jpg_p206x206&_nc_cat=110&ccb=1-7&_nc_sid=aee45a&_nc_ohc=XevF6FAHeGMAX-WoqJK&_nc_ht=scontent-ams2-1.xx&oh=03_AdSMY3-Xh9GXaPX0ZYjDn0X5XirLLQUVLSzcsUrU5Mg3LQ&oe=64748A8E" alt="ICA ERP logo" class="logo">
    </a>
    </header>

    <div class="welcome-header">
        <h1>Overview</h1>
        <p>Welcome to the overview page.</p>
    </div>

    <div class="box-overview">
        <div class="box-content">
            <table>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Payment Method</th>
                    <th>Customer ID</th>
                    <th>Supermarket ID</th>
                </tr>
                <%@ page import="ics.ICAStoreT4.Order_" %>
                <%@ page import="java.util.List" %>
                <% List<Order_> orders = (List<Order_>) request.getAttribute("orders"); %>
              <% if (orders != null) { %>
    <% for (Order_ order : orders) { %>
        <tr>
            <td><%= order.getOrderId() %></td>
            <td><%= order.getOrderDate() %></td>
            <td><%= order.getPaymentMethod() %></td>
            <td><%= order.getCustomer().getCustomerId() %></td>
            <td><%= order.getStore().getSupermarketId() %></td>
        </tr>
    <% } %>
<% } else { %>
    <tr>
        <td colspan="5">No orders found.</td>
    </tr>
<% } %>
            </table>
        </div>
    </div>

    
    
</body>
</html>
