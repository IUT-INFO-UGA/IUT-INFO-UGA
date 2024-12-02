<?php
require_once(dirname(__FILE__).'/model/change.php');

$change = new Change('data/exchangeRate.csv');

$result = '';
if ($_SERVER["REQUEST_METHOD"] === "GET" && isset($_GET['montant'], $_GET['source'], $_GET['cible'])) {
    $montant = floatval($_GET['montant']);
    $source = $_GET['source'];
    $cible = $_GET['cible'];

    try {
        $convertedAmount = $change->change($source, $cible, $montant);
        $result = "Le change de $montant $source en $cible fait " . number_format($convertedAmount, 2);
    } catch (Exception $e) {
        $result = $e->getMessage();
    }
}
?>

<!DOCTYPE html>
<html lang="fr" dir="ltr">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="design/w3.css">
	<link rel="stylesheet" href="design/style.css">
	<title>Convertisseur de Devises</title>
</head>

<body>

	<header class="w3-container w3-teal">
		<h1>Outil de conversion de devises</h1>
	</header>

	<main class="w3-container">
		<p>
			Boursomachin met à votre disposition ce convertisseur de devises...
		</p>

		<h2>Convertisseur</h2>
		<div>
			<form id="convertisseur" action="indexV1.php" method="get" class="w3-panel w3-card-2">
				<input id="montant" type="number" name="montant" placeholder="Montant"
					value="<?= isset($_GET['montant']) ? htmlspecialchars($_GET['montant']) : '' ?>" required>
				<select id="source" name="source">
					<?php foreach ($change->getDevises() as $devise): ?>
					<option value="<?= $devise ?>"
						<?= (isset($_GET['source']) && $_GET['source'] === $devise) ? 'selected' : '' ?>><?= $devise ?>
					</option>
					<?php endforeach; ?>
				</select>
				<img src="design/arrow-icon.png" alt="">
				<select id="cible" name="cible">
					<?php foreach ($change->getDevises() as $devise): ?>
					<option value="<?= $devise ?>"
						<?= (isset($_GET['cible']) && $_GET['cible'] === $devise) ? 'selected' : '' ?>><?= $devise ?>
					</option>
					<?php endforeach; ?>
				</select>
				<button name="button" type="submit" class="w3-button w3-teal">Convertir</button>
			</form>

			<output for="montant source cible" form="convertisseur" name="target_amount"
				class="w3-container w3-teal w3-xlarge">
				<?= $result ?>
			</output>
		</div>
	</main>

</body>

</html>