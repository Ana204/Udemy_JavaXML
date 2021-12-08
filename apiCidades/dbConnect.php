<?php 
define('HOST', 'localhost');

define('USER', '');

define('PASS', '');

define('DB', '');

$con = mysqli_connect(HOST, USER, PASS, DB)
or die('Algo não deu certo');

//try{
  //  if($con = mysqli_connect(HOST, USER, PASS, DB)){
   //     echo "<h2>Tudo certo, vamos em frente</h2>";
   // }
  //  else{
  //      echo "<h2>Nem tudo deu certo</h2>";
  //  }
//}catch(Exception $e){
 //   echo $e->getMessage();
//}

?>