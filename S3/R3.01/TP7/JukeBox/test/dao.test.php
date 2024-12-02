<?php
require_once(__DIR__.'/../model/music.class.php');
require_once(__DIR__.'/../model/dao.class.php');
$class = 'DAO';
function assert_failure($file, $line, $assertion, $message)
{ global $class; echo "*** La classe '$class' n'est pas correcte.\n*** L'assertion à la ligne $line a échoué : $assertion $message\n";}
// Active les assertions
assert_options(ASSERT_ACTIVE,true);
// Arrete dès qu'un assert est faux
assert_options(ASSERT_BAIL,true);
assert_options(ASSERT_WARNING,false);
assert_options(ASSERT_CALLBACK, 'assert_failure');

const URL='http://www-info.iut2.upmf-grenoble.fr/intranet/enseignements/ProgWeb/data/musiques/';

// Creation de l'instance DAO
$dao = new DAO();

// Test la valeur min
$value = $dao->minId(); $expected = 1;assert( $value === $expected,"Le min des id doit être $expected (trouvé $value)\n");

// Récupère les méthodes disponibles de cette classe
$methodes = get_class_methods('Music');

$music = $dao->get(1);
// Si __get() est disponible alors test d'acces en lecture des paramètres */
if (in_array('__get',$methodes)) {
  // Test d'acces direct à l'attribut privé
  $value = $music->id; $expected = 1; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->author; $expected = 'Passenger'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->title; $expected = 'Community Centre'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->cover; $expected = URL.'img/1.jpg'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->mp3; $expected = URL.'mp3/1.mp3'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->category; $expected = 'Acoustic'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
} else {
  // Test l'acces avec un getteur
  $value = $music->getId(); $expected = 1; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getAuthor(); $expected = 'Passenger'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getTitle(); $expected = 'Community Centre'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getCover(); $expected = URL.'img/1.jpg'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getMp3(); $expected = URL.'mp3/1.mp3'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getCategory(); $expected = 'Acoustic'; assert($value === $expected,"'$value'.\n Valeur attendue : '$expected'");
}

$music = $dao->get(554);
if (in_array('__get',$methodes)) {
  // Test d'acces direct à l'attribut privé
  $value = $music->id; $expected = 554; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->author; $expected = 'Scambo'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->title; $expected = 'Mundo Branco'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->cover; $expected = URL.'img/default_album_medium.png'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->mp3; $expected = URL.'mp3/554.mp3'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->category; $expected = '90s'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
} else {
  // Test l'acces avec un getteur
  $value = $music->getId(); $expected = 554; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getAuthor(); $expected = 'Scambo'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getTitle(); $expected = 'Mundo Branco'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getCover(); $expected = URL.'img/default_album_medium.png'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getMp3(); $expected = URL.'mp3/554.mp3'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getCategory(); $expected = '90s'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
}

// Test la valeur min
$value = $dao->minId(); $expected = 1;assert( $value === $expected,"Le min des id doit être $expected (trouvé $value)\n");

// Test la valeur max
$value = $dao->maxId(); $expected = 554;assert( $value === $expected,"Le max des id doit être $expected (trouvé $value)\n");


print("OK : la classe '$class' semble fonctionner.\n");
var_dump($music);

 ?>
