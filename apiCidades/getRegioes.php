<?php
header('Content-type: application/json');

ini_set('default_charset', 'utf-8');


$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    require_once('dbConnect.php');

    mysqli_set_charset($con, "utf8");

    $statement = mysqli_prepare($con, "SELECT * FROM regiao");

    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);

    mysqli_stmt_bind_result($statement, $id, $nome);

    if (mysqli_stmt_num_rows($statement) > 0 ){

        while (mysqli_stmt_fetch($statement)){

            array_push($response, array(
                "Id"=>$id,
                "Nome"=>$nome )
            );
        }

        echo json_encode($response);
    }
}
?>