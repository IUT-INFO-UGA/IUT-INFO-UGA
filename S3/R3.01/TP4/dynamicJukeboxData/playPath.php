<?php
$author = $_GET['author'] ?? "inconnu";
$name = $_GET['name'] ?? "inconnu";
?>
<!DOCTYPE html>
<html lang="fr" dir="ltr">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="style.css">
	<title>Mon jukebox static</title>
</head>

<body>
	<header>
		<h1>Plaing : <?= $name ?></h1>
	</header>
	<main>
		<nav>
			<a href="dynamicJukebox.php">retour</a>
		</nav>
		<img src="data/<?= $author ?>/<?= $name?>.jpeg" />
		<audio src="data/<?= $author ?>/<?= $name?>.mp3" controls autoplay></audio>
	</main>
	<footer>
		<p>&copy; 2024 Votre Site Astrologique</p>
	</footer>
</body>

</html>