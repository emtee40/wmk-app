<?php
include("inc/verify.php");
include("inc/connect.php");
$q = mysql_query("select * from device 
			where Userid='".$_SESSION['id']."'
");
$r = mysql_fetch_array($q);
$lat = $r['Latitude'];
$long = $r['Longitude'];
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <title>Where's my kid?</title>
  <link rel="stylesheet" type="text/css" href="css/reset.css" /> 
  <link rel="stylesheet" type="text/css" href="css/main.css" />
  <link rel="stylesheet" type="text/css" href="css/home.css" />
  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBgyA-ys957WzW25om4GJYAJw0PTwATWTg&sensor=true"
  type="text/javascript"></script>
  <script type='text/javascript' src='js/map.js'></script>
</head>
<body onload="initialize(<?php echo $lat?>,<?php echo $long?>);">
<div id='container'>
<div id='topmenu'>
	<a href='index.php'><img id='logo' src='img/logo.png' alt="Logo" /></a>
	<div id='logout'><A HREF = logout.php>Log out</A></div>
</div>
<div id="map-canvas"></div>
</div>
</body>
</html>