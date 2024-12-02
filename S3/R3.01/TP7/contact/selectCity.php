<?php
$dataSourceName = 'sqlite:'.__DIR__.'/data/contact.db';
$db = new PDO($dataSourceName);

const QUERY = 'SELECT DISTINCT city FROM contact';
try {
  $requete = $db->prepare(QUERY);
} catch (PDOException $e) {
  die('PDO query Error on "'.QUERY.'" '.$e->getMessage());
}

$requete->execute();
$data = $requete->fetchAll();
?>
<!DOCTYPE html>
<html lang="fr" dir="ltr">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="design/style.css">
	<title>My contacts</title>
</head>

<body>
	<h1>My contacts: select a city</h1>
	<form action="contact.php" method="post">
		<table>
			<?php foreach ($data as $contact): ?>
			<tr>
				<td>
					<input type="radio" name="city" id="<?= htmlspecialchars($contact['city']) ?>" value="<?= htmlspecialchars($contact['city']) ?>">
					<label for="<?= htmlspecialchars($contact['city']) ?>"><?= htmlspecialchars($contact['city']) ?></label>
				</td>
			</tr>
			<?php endforeach; ?>
		</table>
		<button type="submit">Submit</button>
	</form>
</body>

</html>