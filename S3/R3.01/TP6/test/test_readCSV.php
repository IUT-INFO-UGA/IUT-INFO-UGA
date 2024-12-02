<?php
require_once('../helper/readCSV.php');

// Test si le fichier n'existe pas
$isTestOk = false;
try {
$a = readCSV('doNotExists.cvs');
} catch (Exception $e) {
  // Test bien détecté
  printf("OK: fichier inconnu bien détecté. Message : %s\n",$e->getMessage());
  $isTestOk = true;
}
if (! $isTestOk) {
  exit("#Erreur: fichier inconnu non détecté\n");
}

// Test si le fichier vide est bien détecté
$isTestOk = false;
try {
$a = readCSV('empty.cvs');
} catch (Exception $e) {
  // Test bien détecté
  printf("OK: fichier vide bien détecté. Message : %s\n",$e->getMessage());
  $isTestOk = true;
}
if (! $isTestOk) {
  exit("#Erreur: fichier vide non détecté\n");
}

// Test si le fichier à une ligne bien détecté
$isTestOk = false;
try {
$a = readCSV('oneLine.cvs');
} catch (Exception $e) {
  // Test bien détecté
  printf("OK: fichier à une ligne bien détecté. Message : %s\n",$e->getMessage());
  $isTestOk = true;
}
if (! $isTestOk) {
  exit("#Erreur: fichier à une ligne non détecté\n");
}

// Test si une ligne trop courte détectée
$isTestOk = false;
try {
$a = readCSV('incorrect.cvs');
} catch (Exception $e) {
  // Test bien détecté
  printf("OK: fichier avec une ligne trop courte bien détecté. Message : %s\n",$e->getMessage());
  $isTestOk = true;
}
if (! $isTestOk) {
  exit("#Erreur: fichier avec une ligne trop courte non détecté\n");
}


// Test affichage de juste un warning
try {
$a = readCSV('incorrectButOk.cvs');
} catch (Exception $e) {
  // Test bien détecté
  printf("#Erreur: une erreur détectée. Message : %s\n",$e->getMessage());
  exit(1);
}

var_dump($a);

// Test lecture correcte
try {
$a = readCSV('devise.csv');
} catch (Exception $e) {
  // Test vide bien détecté
  printf("#Erreur: une erreur détectée. Message : %s\n",$e->getMessage());
  exit(1);
}

var_dump($a);



 ?>
