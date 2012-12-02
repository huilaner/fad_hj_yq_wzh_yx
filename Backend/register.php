<?php
require_once('classes/users.php');
$users = new users();

//user info
$mode = $_GET['mode'];
$name = $_GET['name'];
$provider_name = $_GET['provider_name'];
$password = $_GET['password'];
$philosophy = $_GET['philosophy'];
$address = $_GET['address'];
$email = $_GET['email'];
$gender = $_GET['gender'];
$phone = $_GET['phone'];

//register the user
if($mode == "user"){
    $users -> registerUser($name, $address, $email, $gender, $phone);
}
else if($mode == "provider"){
    $users -> updatePhilosophy($provider_name, $password, $philosophy);
}
else {
	echo "Please pass in either 'insert' or 'view' as a mode parameter.";	
}