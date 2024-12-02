<?php
$dataSourceName = 'sqlite:'.__DIR__.'/data/contact.db';
$db = new PDO($dataSourceName);
// récupère les informations de la query string
$city = $_GET['city'] ?? 'Dallas';
const QUERY = 'SELECT * FROM contact where city=:city';
try {
  $requete = $db->prepare(QUERY);
} catch (PDOException $e) {
  die('PDO query Error on "'.QUERY.'" '.$e->getMessage());
}
$requete->execute([':city' => $city]);
$data = $requete->fetchall();
 ?>
<!DOCTYPE html>
<html lang="fr" dir="ltr">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="design/style.css">
	<title>My contacts</title>
</head>

<body>
	<h1>My contacts from <?= $city ?></h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Phone</th>
		</tr>
		<?php foreach ($data as $contact): ?>
		<tr>
			<td>
				<?= $contact['name'] ?>
			</td>
		</tr>
		<?php endforeach; ?>
	</table>
</body>

</html>