<?php
class Change {
    private $rates = [];
    private $devises = [];

    public function __construct(string $filename) {
        $this->load($filename);
    }

    private function load(string $filename) {
        if (!file_exists($filename) || !is_readable($filename)) {
            throw new Exception("Le fichier de taux de change est introuvable ou non lisible.");
        }

        $file = fopen($filename, 'r');
        $firstLine = true;

        while (($line = fgetcsv($file)) !== false) {
            if ($firstLine) {
                $firstLine = false;
                continue;
            }

            [$from, $to, $rate] = $line;
            $this->rates["$from $to"] = (float)$rate;
            if (!in_array($from, $this->devises)) {
                $this->devises[] = $from;
            }
            if (!in_array($to, $this->devises)) {
                $this->devises[] = $to;
            }
        }
        fclose($file);
    }

    public function getRate(string $from, string $to): float {
        if($from == $to)
        return 1.0;
        $key = "$from $to";
        if (isset($this->rates[$key])) {
            return $this->rates[$key];
        }
        if (isset($this->rates["$to $from"])) {
            return 1 / $this->rates["$to $from"];
        }
        throw new Exception("ERREUR : taux de $from vers $to inconnu");
    }

    public function change(string $from, string $to, float $amount): float {
        $rate = $this->getRate($from, $to);
        return $amount * $rate;
    }

    public function getDevises(): array {
        return $this->devises;
    }
}
?>