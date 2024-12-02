<?php
require_once(dirname(__FILE__).'/../model/change.php');

// Crée l'objet pour gérer le change
$change = new Change('../data/exchangeRate.csv');

var_dump($change);

function testRate(string $from,string $to,float $changexpected): void {
  global $change;
  $rate = $change->getRate($from,$to);
  // Arrondi à 6 chiffres max aprè la virgule
  $rate = round($rate,6);
  if ($rate === $changexpected) {
    printf("OK: taux de change %s -> %s = %f\n",$from,$to,$rate);
  } else {
    exit("#ERREUR: taux de change $from -> $to = $rate attendu $changexpected\n");
  }

}

// Test quelques taux
testRate('EUR','EUR',1.0);
testRate('EUR','GBP',0.860733);
testRate('GBP','EUR',1.161800);

// Cas d'erreur
// Test si le fichier n'existe pas
$isTestOk = false;
try {
$rate = $change->getRate('EUR','XXX');
} catch (Exception $e) {
  // Test bien détecté
  printf("OK: change inconnu bien détecté. Message : %s\n",$e->getMessage());
  $isTestOk = true;
}
if (! $isTestOk) {
  exit("#Erreur: change inconnu non détecté\n");
}

// Test un calcul de change
$from = 'EUR';
$to = 'USD';
$amount = 150.0;
$change = $change->change('EUR','USD',150.0);
printf("Le change de %.2f %s en %s fait %.2f\n",$amount,$from,$to,$change);


?>
