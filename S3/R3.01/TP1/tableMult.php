<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>table multiplication</title>
</head>
<style>
	table {
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid black;
		padding: 5px;
	}
</style>
<body>
	<h1>Table de multiplication</h1>
	<table>
		<tr>
		<?php
		for ($i = 0; $i <= 10; $i++) {
			echo "<tr>";
			for ($j = 0; $j <= 10; $j++) {
				if($i == 0 && $j == 0){
					echo "<th></th>";
				}else if($i == 0){
					echo "<th>$j</th>";
				}else if($j == 0){
					echo "<th>$i</th>";
				}else{
					echo "<td>" . ($i * $j) . "</td>";
				}
			}
			echo "</tr>";
		}
		?>
		</tr>
	</table>
</body>
</html>