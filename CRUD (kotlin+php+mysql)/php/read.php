<?php
	include "conexao.php";

	$sql_read = "SELECT * FROM contatos";
	$dados = $PDO->query($sql_read);	

	$resultado = array();

	while($c = $dados->fetch(PDO::FETCH_OBJ)){
		$resultado[] = array("id"=>$c->id,"nome"=>$c->nome,"telefone"=>$c->telefone,"email"=>$c->email);
	}
	echo json_encode($resultado);
?>