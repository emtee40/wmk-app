<?php

$host="mysql.wmk-app.com"; // Host name 
$username="wmkapp"; // Mysql username 
$password="Where15TeHk1dd0"; // Mysql password 
$db_name="wmkapp"; // Database name 

// Connect to server and select databse.
mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

?>