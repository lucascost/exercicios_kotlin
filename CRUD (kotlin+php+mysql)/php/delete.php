<?php
include "conexao.php";

$id = $_POST['id'];

$sql_delete = "DELETE FROM contatos WHERE id=:id";

$stmt = $PDO->prepare($sql_delete);

$stmt->bindParam(':id',$id);

if($stmt->execute()){
	$dados =  array("delete"=>"ok");
} else {
	$dados =  array("delete"=>"erro");
}
echo json_encode($dados);
?>