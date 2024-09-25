<?php

// Liste des abréviations du domaine informatique
$abbr_computing = array(
  'ADSL' => 'Asymetric Digital Subscriber Line',
  'AJAX' => 'Asynchronous JavaScript and XML',
  'API' =>  'Application Programming Interface',
  'ASCII' => 'American Standard Code for Information Exchange',
  'CGI' => 'Common Gateway Interface',
  'CSS' => 'Cascading Style Sheets',
  'DNS' => 'Domain Name Server',
  'DOM' => 'Document Object Model',
  'FAQ' => 'Frequently asked questions',
  'FTP' => 'Files Transfert Protocol',
  'GIF' => 'Graphic Interchange Format',
  'HTML' => 'HyperText Mark-up Language',
  'HTTP' => 'HyperText Transfer Protocol',
  'IHM' => 'Inteface homme-machine',
  'IP' => 'Internet Protocol',
  'IRC' => 'Internet Relay Chat',
  'JPEG' => 'Join Photographic Experts Group',
  'LAN' => 'Local Area Network',
  'MIME' => 'Multipurpose Internet Mail Extensions',
  'MPEG' => 'Moving Picture Expert Group',
  'OS' => 'Operating System',
  'PDF' => 'Portable Document Format',
  'PHP' => 'PHP Hypertext PreProcessor',
  'PNG' => 'Portable Network Graphics',
  'POP' => 'Post Office Protocol',
  'RAM' => 'Random Acces Memory',
  'ROM' => 'Read Only Memory',
  'RSS' => 'Really Simple Syndication',
  'SMTP' => 'Simple Mail Transfer Protocol',
  'SQL' => 'Structured Query Language',
  'SSL' => 'Secure Socket Layer',
  'TCP/IP' => 'Transmission Control Protocol / Internet Protocol',
  'UML' => 'Unified Modeling Language',
  'URL' => 'Uniform Resource Locator',
  'VM' => 'virtual machine',
  'Wi-Fi' => 'Wireless Fidelity',
  'WYSIWYG' => 'What You See Is What You Get',
  'XML' => 'eXtensible Markup Language'
);

// Pour remplacer des abbréviations dans un texte de manière automatique
class Abbr {
  // La table de toutes les abréviations
  private $abbr = array();

  // Initialise la table des abréviations
  function __construct(Array $abbr) {
    $this->abbr = $abbr;
  }

  // Construit en HTML l'abréviation $abbr ou ressort simplement $abbr
  // si $abbr n'est pas une abréviation connue
  function show(string $abbr) : string {
    $beatiful = str_replace(",","",$abbr);
    if (array_key_exists($beatiful, $this->abbr)) {
      return '<abbr title="'.$this->abbr[$beatiful].'">'.$abbr.'</abbr>';
    } else {
      return $abbr;
    }
  }

  // Filtre un texte pour inserer les abréviations trouvées
  function filter(string $text): string {
    $out = '';
    $words = explode(' ', $text);
    foreach($words as $word) {
      $out .= $this->show($word).' ';
    }
    return $out;
  }

  // Donne le nombre d'abréviations connues
  function size() : int {
    return count($this->abbr);
  }

}

// L'objet abréviation pour le domaine informatique
$abbr = new Abbr($abbr_computing);

?>
<!DOCTYPE html>
<html lang=fr dir="ltr">

<head>
	<meta charset="utf-8">
	<title>Protocole HTTP</title>
</head>

<body>
	<h1>Protocole HTTP</h1>
	<p>
		<?= $abbr->filter('
      Le protocole HTTP permet au navigateur de demander des données à un serveur.
      Ces données sont principalement au format HTML codées
      en ASCII, mais cela peut être aussi des images en JPEG ou des vidéo en MPEG par exemple.
      Pour indiquer au client quel type de données il reçoit,
      cette information est codée en MIME dans l\'entête de la réponse.
      ' ) ?>
	</p>
	<p>Il y a <?= $abbr->size() ?> abréviations connues.</p>
</body>

</html>