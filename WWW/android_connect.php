<?php
	include("inc/connect.php");
$action = $_GET['action'];
switch($action){
case "login":
$email = $_POST['email'];
$pass = $_POST['pass'];


$login_acc = mysql_query("SELECT * FROM user WHERE `Email`='$email' AND `Password`='$pass'");
if(mysql_num_rows($login_acc) != 0){
$loginID = mysql_fetch_object($login_acc);
echo($loginID->UserID);
}
else{
echo("0");
}
break;

case "imei":
$id = $_POST['id'];
$imei = $_POST['imei'];
if($id != 0){
$mysql_count = mysql_query("SELECT * FROM device WHERE `DeviceID`='$id'");
if(mysql_num_rows($mysql_count) == 0){
mysql_query("INSERT INTO device (`DeviceID`, `UserID`) VALUES ('$imei', '$id')");
}
}
break;

case "gps":
$id = $_POST['id'];
$lat = $_POST['Lat'];
$long = $_POST['Long'];
mysql_query("UPDATE device SET `Latitude`='$lat', `Longitude`='$long' WHERE `UserID`='$id'");
break; 



}


?>