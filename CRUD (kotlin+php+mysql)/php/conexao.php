<?php
	$dsn = "mysql:host=localhost; dbname=crud; charset=utf8";
	$usuario = "root";
	
	
	try{
		$PDO = new PDO($dsn, $usuario);
	//	echo "conectado com sucesso";

	}catch(PDOException$erro){
	//	echo "erro";
	}
		
?>
