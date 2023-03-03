<%@ page language="java" contentType="text/html; ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />

<link href="styles/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Muokkaa Peli</title>
<style type="text/css">
label {
	display: block;
	width: 8em;
	float: left;
}
</style>
</head>

<body>

	<h1>Muokkaa Peli</h1>
	<form action="/muokkaa-peli" method="post">

			<p>
			<label>Pelin id:</label> <input type="text" value="" name="id"
				size="50" />
			</p>
			<p>
				<label>Pelin nimi:</label> <input type="text" value="" name="nimi"
					size="50" />
			</p>
			<p>
				<label>Hinta:</label> <input type="text" value="" name="hinta"
					size="50" />
			</p>
			<p>
				<label>Julkaisupaiva:</label> <input type="text" value=""
					name="julkaisupaiva" size="50" />
			</p>
			<p>
				<label>Lajityyppi:</label> <input type="text" value=""
					name="lajityyppi" size="50" />
			</p>
			<p>
				<label>Kehittaja:</label> <input type="text" value=""
					name="kehittaja" size="50" />
			</p>

			<p>
				<span class="button"><a href="/listaa-pelit">Peruuta</a></span> <input
					type="submit" name="submit-button" class="btn btn-success"
					value="Tallenna" />
			</p>
	</form>

</body>
</html>