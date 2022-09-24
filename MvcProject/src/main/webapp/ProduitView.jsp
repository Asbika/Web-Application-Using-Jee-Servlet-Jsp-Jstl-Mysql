<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="controleur.php" method="post">
		 Mot Cle:<input type="text" name="motCle" value="${modele.motCle}">
			     <input type="submit" value="ok">
		</form>
		<br>
		<table border="1" width="80%">
			<tr>
				<th>ID</th><th>NOM<th>PRIX</th>
			</tr>
			<c:forEach items="${modele.produits}" var="p">
				<tr>
					<td>${p.idProduit}</td>
					<td>${p.nomProduit}</td>
					<td>${p.prix}</td>
				</tr>
			</c:forEach>
		</table>
   </center>
</body>
</html>