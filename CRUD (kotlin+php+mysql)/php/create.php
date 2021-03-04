<?php
include "conexao.php";
$nome = $_POST['nome'];
$telefone = $_POST['telefone'];
$email = $_POST['email'];


$sql_insert = "INSERT INTO contatos (nome, telefone, email) VALUES (:NOME, :TELEFONE, :EMAIL)";

$stmt = $PDO->prepare($sql_insert);

$stmt->bindParam(':NOME',$nome);
$stmt->bindParam(':TELEFONE',$telefone);
$stmt->bindParam(':EMAIL',$email);

if($stmt->execute()){
	$id = $PDO->lastInsertId();
	$dados = array("create"=>"ok","ID"=>$id);
}else{
	$dados = array("create"=>"erro");
}

echo json_encode($dados);

?>
