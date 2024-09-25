<?php

// Analyse le fichier de nom $filename
// Ce fichier contient des informations séparées par $delimiter
// Le résultat est un tableau de tableau.
// Chaque element du premier tableau est produit à partir d'une ligne.
// Chaque ligne est découpée et placée dans un tableau.
// Par exemple : le fichier
//   Dads|Groin Twerk
//   The Black Eyed Peas|I Gotta Feeling
// Produit le tableau :
// array(2) {
//  [0]=> array(2) {
//      [0]=> string(4) "Dads"
//      [1]=> string(11) "Groin Twerk"
//      }
//  [1]=> array(2) {
//      [0]=> string(19) "The Black Eyed Peas"
//      [1]=> string(15) "I Gotta Feeling"
//      }
// }
function readDelimitedData(string $filename, string $delimiter) : array {
  // Initialise le tableau des résultats
  $jukeboxData = array();
  $jukebox = fopen('jukeboxData.txt', 'r');
  while (!feof($jukebox))
  {
    $ligne = rtrim(fgets($jukebox));
    if($ligne != "")
      array_push($jukeboxData,$ligne  );
  }
  fclose($jukebox);

  // Initialise le tableau des résultats
  $tab = array();
  foreach ($jukeboxData as $line) {
    // Découpe la ligne
    $tabLine = explode($delimiter, $line);
    // Ajoute le tableau de la ligne au tableau des résultats
    array_push($tab, $tabLine);
  }
  // Retourne le tableau
  return $tab;
}


 ?>