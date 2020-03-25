<html>
<head>
<style>
table {
	border: 2px solid black;
	background-color: green;
	margin: 100px 80px 100px 400px;
}

th, td {
	padding: 10px;
}

div {
	background-color: red;
}
</style>
</head>
<body bgcolor="yellow" onload = "document.getElementById('user').focus()">
	<form action="loginServlet" method = "post">

		<table>
			<caption>
				<b>Log on</b>
			</caption>

			<tr>
				<td>username : <input type="text" name="user" id = "user"><br>
				<br>
				<br>
				</td>
			</tr>

			<tr>
				<td>password : <input type="password" name="pass"><br>
				<br>
				<br>
				</td>
			</tr>

			<tr>
				<td align="center">login <input type="submit" value="login">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>
