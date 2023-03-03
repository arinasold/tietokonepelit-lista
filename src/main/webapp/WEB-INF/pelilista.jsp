<%@ page language="java" contentType="text/html; ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
<title>Tietokonepelit</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
	<h1>Pelit</h1>
	<span class="button"><a href="/lisaa-peli">Lis‰‰ peli</a></span>
	<table class="table table_striped">
		<tr>
			<th>Id</th>
			<th>Pelin nimi</th>
			<th>Hinta</th>
			<th>Julkaisupaiva</th>
			<th>Lajityyppi</th>
			<th>Kehittaja</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			

		</tr>
		<%-- t‰m‰ on jsp-komentti  --%>
		<%-- ${asiakkaat} viittaa keyword-arvolla request-olion Map-tietorakenteessa olevaan asiakaslistaan(ArrayList) --%>
		<c:forEach items="${tietokonepelit}" var="tietokonepeli">

			<tr>
				<td><c:out value="${tietokonepeli.id}" /></td>
				<td><c:out value="${tietokonepeli.nimi}" /></td>
				<%-- lyhennysmerkint‰ metodikutsulle ${asiakas.getAsiakastunnus()} --%>
				<td><c:out value="${tietokonepeli.hinta}" /></td>
				<td><c:out value="${tietokonepeli.julkaisupaiva}" /></td>
				<td><c:out value="${tietokonepeli.lajityyppi}" /></td>
				<td><c:out value="${tietokonepeli.kehittaja}" /></td>
				<td><a href="/poista-peli?peliid=<c:out value='${tietokonepeli.id}'/>">Poista</a></td>
				<td><a href="/muokkaa-peli?peliid=<c:out value='${tietokonepeli.id}'/>">Muokkaa</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>