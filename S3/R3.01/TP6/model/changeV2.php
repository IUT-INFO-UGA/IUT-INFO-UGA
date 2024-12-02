<?php
require_once(dirname(__FILE__).'/devise.php');
require_once(dirname(__FILE__).'/../helper/readCSV.php');

class ChangeV2 {
    private $rates = [];
    private $devises = [];

    public function __construct(string $deviseFile, string $exchangeFile) {
        $this->loadRates($exchangeFile);
        $this->loadDevises($deviseFile);
    }

    private function loadRates(string $filename) {
        $data = readCSV($filename);
        foreach ($data as $row) {
            if(isset($row['from'], $row['to'], $row['rate']) && is_float((float)$row['rate']))
            {
                $from = $row['from'];
                $to = $row['to'];
                $rate = (float)$row['rate'];
                $this->rates["$from $to"] = $rate;
            }else{
                throw new Exception("Invalid rate data format");
            }
        }
    }

    private function loadDevises(string $filename) {
        $data = readCSV($filename);
        foreach ($data as $row) {
            $this->devises[$row['idf']] = new Devise($row['idf'], $row['name']);
        }
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