<?php
require_once('model/music.class.php');
require_once('model/dao.class.php');

$pageSize = isset($_GET['pageSize']) ? (int)$_GET['pageSize'] : 8;
$page = isset($_GET['page']) ? (int)$_GET['page'] : 1;
$offset = ($page - 1) * $pageSize;

$dao = new DAO();
$stmt = $dao->prepare("SELECT * FROM music LIMIT :offset, :pageSize");
$stmt->bindValue(':offset', $offset, PDO::PARAM_INT);
$stmt->bindValue(':pageSize', $pageSize, PDO::PARAM_INT);
$stmt->execute();
$results = $stmt->fetchAll(PDO::FETCH_ASSOC);

$musics = [];
foreach ($results as $data) {
    $musics[] = new Music($data['id'], $data['author'], $data['title'], $data['cover'], $data['mp3'], $data['category']);
}

?>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
	<meta charset="utf-8">
	<title>&#x1F399; Mon jukebox avec BD</title>
	<link rel="stylesheet" type="text/css" href="design/style.css">
</head>

<body>
	<header>
		<h1>Ma musique dans mon Jukebox</h1>
	</header>
	<nav>
		<p>
			<a href="jukebox.php?page=1&pageSize=<?php echo $pageSize; ?>">
				<span class="arrow left"></span><span class="arrow left"></span>
			</a>
			<a href="jukebox.php?page=1&pageSize=<?php echo $pageSize; ?>">
				<span class="arrow left"></span>
			</a>
			<?php for ($i = 1; $i <= ceil(Music::maxId() / $pageSize); $i++): ?>
			<a class="<?php echo ($i == $page) ? 'selected' : ''; ?>"
				href="jukebox.php?page=<?php echo $i; ?>&pageSize=<?php echo $pageSize; ?>"><?php echo $i; ?></a>
			<?php endfor; ?>
			<a
				href="jukebox.php?page=<?php echo ceil(Music::maxId() / $pageSize); ?>&pageSize=<?php echo $pageSize; ?>">
				<span class="arrow right"></span>
			</a>
		</p>
		<form action="" method="get">
			<p>Musiques/page</p>
			<input type="hidden" name="page" value="<?php echo $page; ?>">
			<input type="number" name="pageSize" value="<?php echo $pageSize; ?>" maxlength="4" size="2" min="1"
				required>
			<input type="submit" value="Update">
		</form>
	</nav>

	<main>
		<section>
			<?php foreach ($musics as $music): ?>
			<figure>
				<a
					href="playId.php?id=<?php echo $music->getId(); ?>&page=<?php echo $page; ?>&pageSize=<?php echo $pageSize; ?>">
					<img src="<?php echo $music->getCover(); ?>" alt="<?php echo $music->getTitle(); ?>" />
				</a>
				<figcaption>
					<music-song><?php echo $music->getTitle(); ?></music-song>
					<music-group><?php echo $music->getAuthor(); ?></music-group>
					<music-category><?php echo $music->getCategory(); ?></music-category>
				</figcaption>
			</figure>
			<?php endforeach; ?>
		</section>
	</main>
	<footer>
		Jukebox IUT
	</footer>
</body>

</html>