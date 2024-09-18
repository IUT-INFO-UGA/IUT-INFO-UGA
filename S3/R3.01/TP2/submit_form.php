<?php
// Récupération des valeurs
$nom = $_GET['name'] ?? "inconnu";
$age = $_GET['age'] ?? "inconnu";
$gender = $_GET['gender'] ?? "inconnu";

// Calculs
// Année de naissance
$year = date('Y') - $age;

// Liste des signes
// En 1921 c'était l'année du Coq
$signe = array('Coq', 'Chien', 'Cochon', 'Rat', 'Buffle', 'Tigre', 'Lapin', 'Dragon', 'Serpent', 'Cheval', 'Chèvre', 'Singe');
$pos = ($year-1921)%12;

$presentation = '';
switch($gender){
  case 'Femme':
    $presentation = 'Mme.';
    break;
  case 'Homme':
    $presentation = 'M.';
    break;
  default:
    $presentation = '';
    break;
}


?>
<!DOCTYPE html>
<html lang="fr" dir="ltr">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="styles.css">
	<title>Signe Chinois</title>
</head>

<body>
	<header>
		<h1>Signes Astrologiques Chinois</h1>
	</header>
	<main>
		<p>
			Bonjour <?= $presentation ?> <?= $nom ?>, vous êtes né en <?= $year ?>.
			Vous êtes du signe suivant :
		</p>
		<section>
			<img src=<?= 'img/'.strtolower($signe[$pos]).'.png' ?> />
			<p> <?= $signe[$pos] ?>
			</p>
		</section>

	</main>
	<footer>
		<p>&copy; 2024 Votre Site Astrologique</p>
	</footer>
	<button><a href="signe.html">recommencer</a></button>
</body>

</html>