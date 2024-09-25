<?php
// Test de la lecture du fichier des données de musiques
include('readDelimitedData.php');

$musics = readDelimitedData('jukeboxData.txt');

var_dump($musics);

 ?>
