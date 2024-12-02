<?php
require_once('model/music.class.php');
require_once('model/dao.class.php');

$id = isset($_GET['id']) ? (int)$_GET['id'] : 1;
$music = Music::read($id);
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="design/style.css">
	<title>Playing: <?php echo $music->getTitle(); ?> by <?php echo $music->getAuthor(); ?></title>
</head>

<body>
	<header>
		<h1>Playing: <?php echo $music->getTitle(); ?> from <?php echo $music->getAuthor(); ?></h1>
	</header>
	<nav>
		<a href="jukebox.php?page=1&pageSize=8">Back</a>
	</nav>
	<section>
		<figure>
			<img src="<?php echo $music->getCover(); ?>" alt="<?php echo $music->getTitle(); ?>">
			<audio src="<?php echo $music->getMp3(); ?>" controls autoplay></audio>
		</figure>
	</section>
	<br />
</body>

</html>