<?php
//Start session
session_start();
 
//Check whether the session variable SESS_MEMBER_ID is present or not
if(!isset($_SESSION['sess_user_id'])) {
	header("location: index.php");
	exit();
}
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
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBgyA-ys957WzW25om4GJYAJw0PTwATWTg&sensor=true" type="text/javascript"></script>
  <script type='text/javascript'>
   <?php
 include("inc/connect.php");
	$userID = $_SESSION["sess_user_id"];
	$loc = mysql_query("SELECT * FROM device WHERE `UserID`='$userID'");
	$maploc = mysql_fetch_object($loc);
	$lat = $maploc->Latitude;
	$long = $maploc->Longitude;

	$final = "(".$lat.",".$long.")";
 ?>
  function initialize() {
 var mapOptions = {
    zoom: 16,
    center: new google.maps.LatLng<?php echo($final);?>,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  var cent = new google.maps.LatLng<?php echo($final);?>;
  var marker = new google.maps.Marker({
  animation: google.maps.Animation.DROP,
  position: cent,
  labelContent: "A",
   labelAnchor: new google.maps.Point(3, 30),
   labelClass: "labels",
   labelInBackground: false,
  map: map,
  });

  google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(map,marker);
  });


}
</script>

 

<?php
	


echo("</head>
<body onload=\"initialize();\">");
?>
<div id='container'>
<div id='topmenu'>
	<a href='index.php'><img id='logo' src='img/logo.png' alt="Logo" /></a>
	<div id='logout'><A HREF = logout.php>Log out</A></div>
</div>
<div id="map-canvas"></div>
</div>
</body>
</html>