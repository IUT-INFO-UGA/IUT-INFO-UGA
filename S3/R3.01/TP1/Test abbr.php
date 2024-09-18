<?php
  $abbr = array('PHP'=>'Hypertext PreProcessor',
                'HTML'=>'HyperText Markeup Language',
                'XML'=>'eXtended Markeup Language', 
                'CSS'=>'Cascading Style Sheets');
	?>

<!DOCTYPE html>
<html lang="fr" dir="ltr">

<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Test abbr</title>
	<style media="screen">
	abbr,
	th {
		color: blue;
	}
	</style>
</head>

<body>

	<h1>Exemple d'utilisation des abréviations en HTML</h1>


	<p>Le langage <abbr title="Hypertext PreProcessor">PHP</abbr> produit généralement
		du <abbr title="HyperText Markeup Language">HTML</abbr> mais peu produire aussi
		du <abbr title="eXtended Markeup Language">XML</abbr> ou même
		du <abbr title="Cascading Style Sheets">CSS</abbr>.
	</p>
	<p>Voici toutes les abbréviations connues : </p>
	<table>
		<?php 
      foreach ($abbr as $key => $value) {
        echo "<tr><th>$key</th><td>$value</td></tr>";
    }
    ?>
		</tbody>
	</table>


</body>

</html>