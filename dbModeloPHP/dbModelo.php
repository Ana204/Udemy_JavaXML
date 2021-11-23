<?php
/**
 * Script PHP para efetuar uma conexão
 * com o Banco de Dados MySQL utilizando
 * PDO em um servidor LOCALHOST (127.0.0.1)
 */

// Cuidados Rede Wifi, Hospedagem, Endereço IP, DNS
$servername = "informe_o_endereco_ip_url_do_servidor_sgbd";
$dbname 	= "informe_o_nome_do_banco_de_dados";
$username 	= "informe_o_nome_do_usuario_do_banco_de_dados";
$password 	= "informe_a_senha_do_usuario_do_banco";

try {
	// Conexão com SGDB MySQL
	$pdo = new PDO(
		"mysql:host=$servername;dbname=$dbname",
		$username,
		$password,
		array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8")
	);
	$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
	// Cuidado para não expor dados de acesso
	echo "<pre>" . $e . "</pre>";
	die("Lamento, algo não está funcionando 100% (DB)");
}
