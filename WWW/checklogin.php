<?php

include("inc/connect.php");

// username and password sent from form 
$username=$_POST['username']; 
$password=$_POST['password']; 

// To protect MySQL injection (more detail about MySQL injection)
$username = stripslashes($username);
$password = stripslashes($password);
$username = mysql_real_escape_string($username);
$password = mysql_real_escape_string($password);
$sql="SELECT * FROM user WHERE username='$username' and Password='$password'";
$result=mysql_query($sql);

// Mysql_num_row is counting table row
$count=mysql_num_rows($result);
// If result matched $myusername and $mypassword, table row must be 1 row
if($count==1){
// Register $myusername, $mypassword and redirect to file "login_success.php"
session_start();

$r = mysql_fetch_assoc($result);


$_SESSION["username"] 	= $r['Username'];
$_SESSION["id"] 		= $r['UserID'];
$_SESSION["logged_in"] 	= 1;
header("location:./");
}
else {
header("location:login.php?message=Wrong Password");
}
?>