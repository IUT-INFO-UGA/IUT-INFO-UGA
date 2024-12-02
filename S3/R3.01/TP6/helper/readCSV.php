<?php
function readCSV(string $filename, string $delimiter = ','): array {
    if (!file_exists($filename)) {
        throw new Exception("Error file '$filename' not found");
    }

    $file = fopen($filename, 'r');
    if ($file === false) {
        throw new Exception("Error file '$filename' cannot be opened");
    }

    $data = [];
    $header = fgetcsv($file, 1000, $delimiter);
    if ($header === false) {
        fclose($file);
        throw new Exception("Error file '$filename' is empty");
    }

    if (count($header) < 1) {
        fclose($file);
        throw new Exception("Error file '$filename' has only one line");
    }

    while (($line = fgetcsv($file, 1000, $delimiter)) !== false) {
        if (count($line) < count($header)) {
            throw new Exception("Error line " . (count($data) + 2) . " has " . count($line) . " fields, " . count($header) . " expected in '" . implode(',', $line) . "'");
        }

        if (count($line) > count($header)) {
            trigger_error("Warning line " . (count($data) + 2) . " has " . count($line) . " fields, only " . count($header) . " expected, extra is ignored in '" . implode(',', $line) . "'", E_USER_WARNING);
        }

        $data[] = array_combine($header, array_slice($line, 0, count($header)));
    }

    fclose($file);
    return $data;
}
?>