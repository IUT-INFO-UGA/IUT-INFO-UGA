<?php
class Devise {
    private $idf;
    private $name;

    public function __construct(string $idf, string $name) {
        $this->idf = $idf;
        $this->name = $name;
    }

    public function getIdf(): string {
        return $this->idf;
    }

    public function getName(): string {
        return $this->name;
    }
}
?>