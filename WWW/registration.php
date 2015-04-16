<?php
session_start();
if(isset($_SESSION['logged_in'])):
	header("Location: ./");
	exit();
endif;
//if($_POST):
	if(isset($_POST['newuser'])){
	
	$username2 = $_POST['username'];
	$password2 = $_POST['password'];
	$email2 = $_POST['email'];
	$name2 = $_POST['name'];
	$surname2 = $_POST['surname'];
	
	
	//var_dump($_POST);

	/*
	foreach($_POST as $k=>$v):
		$d[$k] = mysql_real_escape_string($v);
	endforeach;
	*/
	//include("inc/connect.php");
	
	if(strlen($username2) > 4){
	include("inc/connect.php");
	
	$exist = mysql_query("SELECT * FROM user WHERE `Email`='$email2'");
	if(mysql_num_rows($exist) == 0){
	mysql_query("INSERT INTO user (`UserName`, `Password`, `Email`, `Name`, `Surname`) VALUES ('$username2', '$password2', '$email2', '$name2', '$surname2')");
	}
	else{
	echo("<script type=\"text/javascript\">alert('This user already exists') </script>");
	}
	}
	}
	
	/*
	if($d['username']!="" && $d['password']):
		mysql_query("
		insert into user(`username`, `password`, `email`, `name`, `surname`)
		values('".$d['username']."','".$d['password']."','".$d['email']."','".$d['name']."','".$d['surname']."')
		");
	endif;
	
	if(mysql_affected_rows()==1):
		session_start();
		$_SESSION["username"] 	= $d['username'];
		$_SESSION["id"] 		= $d['UserID'];
		$_SESSION["logged_in"] 	= 1;
		header("location:./?registered=1");
		
	
	else:
		header("Location:registration.php?error=1");
	endif;
	*/
	
	
	
//else:
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <title>Where's my kid?</title>
  <link rel="stylesheet" type="text/css" href="css/reset.css" /> 
  <link rel="stylesheet" type="text/css" href="css/main.css" />
  <link rel="stylesheet" type="text/css" href="css/registration.css" />
  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
	$(".registration").validate();

});
</script>
</head>
<body onload="">
<div id='container'>
<?php include("inc/top.php")?>
<div id='mapgraph' class='box'>
	<img id='map' src='img/map.png' alt="Map" />
	<img id='gplay' src='img/gplay.png' alt="Play Store" />
</div>
<div id='registration' class='box'>
	<form class='registration' action="registration.php" method="post" onsubmit="valida();">
    	<input type="text" placeholder="Username" name="username" data-rule-required="true" /><br/>
		<input type="text" placeholder="Name" name="name" data-rule-required="true" /><br/>
	   <input type="text" name="surname" placeholder="Surname" data-rule-required="true" /><br/>
		<input type="email" name="email" id="email" placeholder="Email" data-rule-required="true" /><br/>
		<input type="password" name="password" placeholder="Password" id="pass" data-rule-required="true" /><br/>
	   <input type="password" name="password2" placeholder="Password" data-rule-required="true" data-rule-equalto="#pass" /><br/>
		<input type="submit" name="newuser" class='btn' value='Submit' />
	</form>

     <?php
    //if(isset($_GET['error'])) echo "<script type=\"text/javascript\">alert('This user already exists') </script>";
	?>
</div>
<div style="clear:both"></div>
<?php include("inc/bottom.php");?>
</div>
</body>
</html>
<?php 
//endif;
?>