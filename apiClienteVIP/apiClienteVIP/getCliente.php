<?php 
if($_SERVER['REQUEST_METHOD'] == "GET"){

    $token = $_GET['token'];
    $clienteID = $_GET['clienteID'];
    echo $token;
    echo $clienteID;

    if ($token == "ana2021"){

        include_once "ConnectionDB.php";

        $sql = "SELECT * FROM cliente WHERE id = ?";

        $statement = $pdo->prepare($sql);
        $statement->bindParam(1, $clienteID);
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