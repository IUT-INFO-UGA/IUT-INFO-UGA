<?php
$nom = $_GET['music'] ?? "inconnu";

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
		<h1>Plaing : <?= $nom ?></h1>
	</header>
	<main>
		<nav>
			<a href="staticJukebox.html">retour</a>
		</nav>
		<img src="data/<?= $nom ?>" />
		<audio src="data/<?= $nom ?>" controls="" autoplay=""></audio>
	</main>
	<footer>
		<p>&copy; 2024 Votre Site Astrologique</p>
	</footer>
</body>

</html>