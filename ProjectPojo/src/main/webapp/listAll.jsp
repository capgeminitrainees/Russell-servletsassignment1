<%@page import="com.capgemini.dao.ProductDaoImpl"%>
<%@page import="com.capgemini.dao.ProductDao"%>
<%@page import="com.capgemini.service.ProductService"%>
<%@page import="com.capgemini.service.ProductServiceImpl"%>
<%@page import="com.capgemini.controller.listServlet"%>
<%@page import="java.util.List"%>
<%@page import="com.capgemini.service.LoginService"%>
<%@page import="com.capgemini.service.LoginServicecImpl"%>
<%@page import="com.capgemini.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP List</title>
</head>
<body>
<%!

	private ProductDao prodservice = new ProductDaoImpl();
	

%>
<h1>List of Products</h1>

<%
	List<Product> products = prodservice.getAllProducts();
%>

<table>
	<tr>
		<th>Product Id</th>
		<th> Product Name</th>
		<th> Description</th>
		<th>Quantity</th>
		<th>Price</th>	
	</tr>
<%
	for(Product p:products){
		%>
		<tr>
			<td><%=p.getProductId()%></td>
			<td><%=p.getProductName()%></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getQuantity()%></td>
			<td><%=p.getPrice()%></td>
			
			</tr>
			<% 
	}
%>


</table>

</body>
</html>