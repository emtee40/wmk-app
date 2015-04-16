<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <title>Where's my kid?</title>
  <link rel="stylesheet" type="text/css" href="css/reset.css" /> 
  <link rel="stylesheet" type="text/css" href="css/main.css" />
  <link rel="stylesheet" type="text/css" href="css/contact.css" />
  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>

</head>
<body onload="">
<div id='container'>
<?php include("inc/top.php")?>
<div id='mapgraph' class='box'>
	<img id='map' src='img/map.png' alt="Map" />
	<img id='gplay' src='img/gplay.png' alt="Play Store" />
</div>
<div id='contact' class='box'>
	<form class='contact' id='cf' action="demo_form.asp">
		<input type="text" name="name" value="Name" onfocus="(this.value == 'Name') && (this.value = '')"
       onblur="(this.value == '') && (this.value = 'Name')" /><br/>
		<input type="text" name="email" value="Email" onfocus="(this.value == 'Email') && (this.value = '')"
       onblur="(this.value == '') && (this.value = 'Email')" /><br/>
		<textarea form='cf' class='feedback' type="text" name="Feedback" placeholder="Type your message here..." onfocus="(this.placeholder == 'Type your message here...') && (this.placeholder = '')"
       onblur="(this.placeholder == '') && (this.placeholder = 'Type your message here...')" ></textarea><br/>
		<input type="submit" class='btn' value='Submit'>
	</form>
</div>
<?php include("inc/bottom.php");?>
</div>
</body>
</html>