<?php

require 'fb/src/facebook.php';

// Create our Application instance (replace this with your appId and secret).
$facebook = new Facebook(array(
  'appId'  => '452712914831377',
  'secret' => '0fc29e3a753aec986f8b14037a496128',
));

// Get User ID
$user = $facebook->getUser();


if ($user) {
  try {
    // Proceed knowing you have a logged in user who's authenticated.
    $user_profile = $facebook->api('/me');
  } catch (FacebookApiException $e) {
    error_log($e);
    $user = null;
  }
}


if ($user) {
	//var_dump($user_profile);
	include("inc/connect.php");
	$q = mysql_query("select * from user where facebook ='".$user_profile['id']."'");
	// the user has already logged in with facebook
	if(mysql_num_rows($q)==1){
		$r = mysql_fetch_assoc($q);
		session_start();
		$_SESSION["username"] 	= $r['Username'];
		$_SESSION["id"] 		= $r['UserID'];
		$_SESSION["logged_in"] 	= 1;
	}
	else{
	
	// first time user log with facebook. Create accoount
	mysql_query("insert into user(name, surname, facebook)
		values('".$user_profile['first_name']."','".$user_profile['last_name']."','".$user_profile['id']."')
		");
		
		session_start();
		$_SESSION["username"] 	= $user_profile['username'];
		$_SESSION["id"] 		= mysql_insert_id();
		$_SESSION["logged_in"] 	= 1;	
	
	}
	///var_dump($_SESSION);
	header("location:./");
	
	
} else {
  $statusUrl = $facebook->getLoginUrl();
  $loginUrl = $facebook->getLoginUrl();
}

	if ($user):
	// do nothing
	else:
		header("Location:".$loginUrl);
	endif;

?>