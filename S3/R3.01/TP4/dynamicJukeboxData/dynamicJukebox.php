<?php
include('readDelimitedData.php');
// Lecture de toutes les musiques

 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
	<meta charset="utf-8">
	<title>&#x1F399; Mon jukebox static</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<header>
		<h1>Ma musique dans mon Jukebox</h1>
	</header>
	<main>
		<?php
      $jukeboxData = readDelimitedData("jukeboxData.txt", "|");
      foreach ($jukeboxData as $song) {
        echo "<section>
                <figure>
                  <a href='playPath.php?author=" . urlencode($song[0]) . "&name=". urlencode($song[1])."'>
                    <img src='data/" . $song[0] . "/". htmlspecialchars($song[1]) .".jpeg' />
                  </a>
                  <figcaption>
                    <music-song>" . $song[0] . "</music-song>
                    <music-group>" . htmlspecialchars($song[1]) . "</music-group>
                  </figcaption>
                </figure>";
      }
      ?>
	</main>
	<footer>
	</footer>
</body>

</html>