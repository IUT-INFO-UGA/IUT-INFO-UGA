<?php
	$var1 = $_GET['a'] ?? "inconnu";
	$var2 = $_GET['b'] ?? "inconnu";
	$operator = $_GET['op'] ?? "inconnu";
	?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>calcul</title>
</head>
<body>
	<h1>calcul</h1>
	<?php
	
	switch($operator){
		case "-":
			echo("$var1 - $var2 = ".($var1 - $var2));
			break;
		case urldecode("+"):
			echo("$var1 + $var2 = ".($var1 + $var2));
			break;
		case "/":
			echo("$var1 / $var2 = ".($var1 / $var2));
			break;
		case "*":
			echo("$var1 * $var2 = ".($var1 * $var2));
			break;
		default:
			echo("operator $operator unknown");
			break;
	}
	?>
</body>
</html>