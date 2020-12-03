
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> Add an Dev entry</h1>
	<form action="addDev">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
	<br>
	<h1> Del an Dev entry</h1>
	<form action="delDev">
		<input type="text" name="id"><br>
		<input type="submit"><br>
	</form>
	<br>
	<h1> Search an Dev entry by Id</h1>
	<form action="getDev">
		<input type="text" name="id"><br>
		<input type="submit"><br>
	</form>
	<h1> Search an Dev entry by Tech</h1>
	<form action="getDevByTech">
		<input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
	<h1> See all Dev entry</h1>
	<form action="allDev">
		<input type="submit"><br>
	</form>
	<h1> See all Dev entry Sorted By name</h1>
	<form action="allDevSortedName">
		<input type="submit"><br>
	</form>
</body>
</html>