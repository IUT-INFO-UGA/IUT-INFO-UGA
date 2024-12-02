<?php
require_once(__DIR__ . "/dao.class.php");

class Music
{
    private int $id;
    private string $author;
    private string $title;
    private string $cover;
    private string $mp3;
    private string $category;

    private const URL = 'http://www-info.iut2.upmf-grenoble.fr/intranet/enseignements/ProgWeb/data/musiques/';

    public function __construct(int $id, string $author, string $title, string $cover, string $mp3, string $category)
    {
        $this->id = $id;
        $this->author = $author;
        $this->title = $title;
        $this->cover = $cover;
        $this->mp3 = $mp3;
        $this->category = $category;
    }

    public function getId(): int {
        return $this->id;
    }

    public function getAuthor(): string {
        return $this->author;
    }

    public function getTitle(): string {
        return $this->title;
    }

    public function getCover(): string {
        return self::URL . "img/" . $this->cover;
    }

    public function getMp3(): string {
        return self::URL . "mp3/" . $this->mp3;
    }

    public function getCategory(): string {
        return $this->category;
    }

    public static function read(int $id): Music
    {
        $dao = new DAO();
        $stmt = $dao->prepare("SELECT * FROM music WHERE id = :id");
        $stmt->execute([':id' => $id]);
        $data = $stmt->fetch(PDO::FETCH_ASSOC);

        return new Music($data['id'], $data['author'], $data['title'], $data['cover'], $data['mp3'], $data['category']);
    }

    public static function maxId(): int
    {
        return 554;
    }
}
?>