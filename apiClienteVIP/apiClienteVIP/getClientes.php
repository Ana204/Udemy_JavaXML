<?php 
if($_SERVER['REQUEST_METHOD'] == "GET"){

    $token = $_GET['token'];
    echo $token;

    if ($token == "ana2021"){

        include_once "ConnectionDB.php";
        $sql = "SELECT * FROM cliente";
        $statement = $pdo->prepare($sql);
        $statement->execute();
        $results = $statement->fetchAll(PDO::FETCH_ASSOC);
        //echo "<pre>".print_r($results)."</pre";

        $json = json_encode($results);
        echo $json;

    } else{
        echo "Não autorizado";
    }

} else {
    echo "Falha na requisição";
}