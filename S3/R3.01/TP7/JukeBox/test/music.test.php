<?php
require_once(__DIR__.'/../model/music.class.php');
$class = 'Music';
function assert_failure($file, $line, $assertion, $message)
{ global $class; echo "*** La classe '$class' n'est pas correcte.\n*** L'assertion à la ligne $line a échoué pour $assertion $message\n";}
// Active les assertions
assert_options(ASSERT_ACTIVE,true);
// Arrete dès qu'un assert est faux
assert_options(ASSERT_BAIL,true);
assert_options(ASSERT_WARNING,false);
assert_options(ASSERT_CALLBACK, 'assert_failure');

const URL='http://www-info.iut2.upmf-grenoble.fr/intranet/enseignements/ProgWeb/data/musiques/';

$music = new $class(1,'Passenger','Community Centre','1.jpg','1.mp3','Acoustic');

// Récupère les méthodes disponibles de cette classe
$methodes = get_class_methods($class);

// Si __get() est disponible alors test d'acces en lecture des paramètres */
if (in_array('__get',$methodes)) {
  // Test d'acces direct à l'attribut privé
  $value = $music->id; $expected = 1; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->author; $expected = 'Passenger'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->title; $expected = 'Community Centre'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->cover; $expected = URL.'img/1.jpg'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->mp3; $expected = URL.'mp3/1.mp3'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->category; $expected = 'Acoustic'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
} else {
  // Test l'acces avec un getteur
  $value = $music->getId(); $expected = 1; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getAuthor(); $expected = 'Passenger'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getTitle(); $expected = 'Community Centre'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getCover(); $expected = URL.'img/1.jpg'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getMp3(); $expected = URL.'mp3/1.mp3'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
  $value = $music->getCategory(); $expected = 'Acoustic'; assert($value == $expected,"'$value'.\n Valeur attendue : '$expected'");
}


echo "OK : la classe '$class' a passé les tests\n";

 ?>
