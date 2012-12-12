<?php

require_once 'includes/constants.php';

class sql{
	
	private $connection;
	
	function __construct(){
	  $this ->connection = new mysqli(HOST, DB_USER, DB_PASSWORD, DB_NAME) or die("There was a problem connecting to the database");
	  mysql_connect(HOST, DB_USER, DB_PASSWORD)or die("cannot connect.. Error: (" . mysql_errno() . ") " . mysql_error()); 
	  mysql_select_db(DB_NAME)or die("cannot select DB.. Error: (" . mysql_errno() . ") " . mysql_error());
	}
	
	//searching method
	//very long, but it's because of the dynamic query
	function doSearch($name, $hasParking, $acceptingNew, $type, $handicap, $appointments, $creditCard, $zip, $lat, $long, $distance){
		
		//START CREATING QUERY
		$query = "SELECT * FROM `providers`";
		$flag = 1;
		if(!empty($hasParking)){
			if($flag == 1){
				$flag = 2;
				$query = $query." WHERE ";
			} else {
				$query = $query." AND ";
			}
			$query = $query."has_parking = '$hasParking' ";
		}
		if(!empty($acceptingNew)){
			if($flag == 1){
				$flag = 2;
				$query = $query." WHERE ";
			} else {
				$query = $query." AND ";
			}
			$query = $query."accepting_new = '$acceptingNew' ";
		}
		if(!empty($type)){
			if($flag == 1){
				$flag = 2;
				$query = $query." WHERE ";
			} else {
				$query = $query." AND ";
			}
			$types = explode(" ", $type); 
                        $query = $query."("; 
			foreach ($types as &$value) {
                            $query = $query."type = '$value' OR ";
                        }
                        $query = substr($query, 0, -4);
                        $query = $query.")";	
		}
		if(!empty($handicap)){
			if($flag == 1){
				$flag = 2;
				$query = $query." WHERE ";
			} else {
				$query = $query." AND ";
			}
			$query = $query."handicap_access = '$handicap' ";
		}
		if(!empty($appointments)){
			if($flag == 1){
				$flag = 2;
				$query = $query." WHERE ";
			} else {
				$query = $query." AND ";
			}
			$query = $query."appointment_only = '$appointments' ";
		}
		if(!empty($creditCard)){
			if($flag == 1){
				$flag = 2;
				$query = $query." WHERE ";
			} else {
				$query = $query." AND ";
			}
			$query = $query."credit_cards = '$creditCard' ";
		}
		if(!empty($zip)){
			if($flag == 1){
				$flag = 2;
				$query = $query." WHERE ";
			} else {
				$query = $query." AND ";
			}
			$query = $query."zip = $zip ";
		}
		//FINISH CREATING QUERY
		
		//execute and format result
		$result = mysql_query($query);
		$arr = array();
		$found = "no";
		//format result
		while($row = mysql_fetch_array($result)){
			if($lat != 0 && $long != 0 && $distance != 0){
				if($this->distanceLatLongPair($lat, $long, $row['lat'], $row['long']) < $distance){
					$found = "yes";
					$temp = array();
					if(!empty($name)){
						$name = ucwords($name);
						if(strpos($row["name"], $name) === false)
							continue;
					}
					$temp['pid'] = $row['pid'];
					$temp['name'] = $row['name'];
					$temp['address'] = $row['address'];
					$temp['city'] = $row['city'];
					$temp['state'] = $row['state'];
					$temp['zip'] = $row['zip'];
					$temp['phone'] = $row['phone'];
					$temp['accepting_new'] = $row['accepting_new'];
					$temp['has_parking'] = $row['has_parking'];
					$temp['type'] = $row['type'];
					$temp['latitude'] = $row['latitude'];
					$temp['longitude'] = $row['longitude'];
					$temp['credit_cards'] = $row['credit_cards'];
					$temp['handicap_access'] = $row['handicap_access'];
					$temp['appointment_only'] = $row['appointment_only'];
					$temp['website'] = $row['website'];
					$temp['hours'] = $row['hours'];
					$temp['average_rating'] = $this->getAvgOverallRating($row['pid']);
					$temp['average_friendliness_rating'] = $this->getAvgFriendlinessRating($row['pid']);
					$temp['average_environment_rating'] = $this->getAvgEnvironmentRating($row['pid']);
					$temp['average_communication_rating'] = $this->getAvgCommunicationRating($row['pid']);
					$temp['average_professional_rating'] = $this->getAvgProfessionalRating($row['pid']);
					$temp['average_costs_rating'] = $this->getAvgCostsRating($row['pid']);
					$temp['average_availability_rating'] = $this->getAvgAvailabilityRating($row['pid']);
					$arr[] = $temp;
				}
			} else {
				$found = "yes";
				$temp = array();
				if(!empty($name)){
					$name = ucwords($name);
					if(strpos($row["name"], $name) === false)
						continue;
				}
				$temp['pid'] = $row['pid'];
				$temp['name'] = $row['name'];
				$temp['address'] = $row['address'];
				$temp['city'] = $row['city'];
				$temp['state'] = $row['state'];
				$temp['zip'] = $row['zip'];
				$temp['phone'] = $row['phone'];
				$temp['accepting_new'] = $row['accepting_new'];
				$temp['has_parking'] = $row['has_parking'];
				$temp['type'] = $row['type'];
				$temp['latitude'] = $row['latitude'];
				$temp['longitude'] = $row['longitude'];
				$temp['credit_cards'] = $row['credit_cards'];
				$temp['handicap_access'] = $row['handicap_access'];
				$temp['appointment_only'] = $row['appointment_only'];
				$temp['website'] = $row['website'];
				$temp['hours'] = $row['hours'];
				$temp['average_rating'] = $this->getAvgOverallRating($row['pid']);
				$temp['average_rating'] = number_format($temp['average_rating'], 2);
				if($temp['average_rating'] === "0") $temp['average_rating'] = "0.0";
				$temp['average_friendliness_rating'] = $this->getAvgFriendlinessRating($row['pid']);
				$temp['average_friendliness_rating'] = number_format($temp['average_friendliness_rating'], 2);
				if($temp['average_friendliness_rating'] === "0") $temp['average_friendliness_rating'] = "0.0";
				$temp['average_environment_rating'] = $this->getAvgEnvironmentRating($row['pid']);
				$temp['average_environment_rating'] = number_format($temp['average_environment_rating'], 2);
				if($temp['average_environment_rating'] === "0") $temp['average_environment_rating'] = "0.0";
				$temp['average_communication_rating'] = $this->getAvgCommunicationRating($row['pid']);
				$temp['average_communication_rating'] = number_format($temp['average_communication_rating'], 2);
				if($temp['average_communication_rating'] === "0") $temp['average_communication_rating'] = "0.0";
				$temp['average_professional_rating'] = $this->getAvgProfessionalRating($row['pid']);
				$temp['average_professional_rating'] = number_format($temp['average_professional_rating'], 2);
				if($temp['average_professional_rating'] === "0") $temp['average_professional_rating'] = "0.0";
				$temp['average_costs_rating'] = $this->getAvgCostsRating($row['pid']);
				$temp['average_costs_rating'] = number_format($temp['average_costs_rating'], 2);
				if($temp['average_costs_rating'] === "0") $temp['average_costs_rating'] = "0.0";
				$temp['average_availability_rating'] = $this->getAvgAvailabilityRating($row['pid']);
				$temp['average_availability_rating'] = number_format($temp['average_availability_rating'], 2);
				if($temp['average_availability_rating'] === "0") $temp['average_availability_rating'] = "0.0";
				$arr[] = $temp;
			}
		}
		//if we have information, format it and output it
		if($found == "yes"){
			$result = array();
			$result["providers"] = $arr;
			
			echo json_encode($result);
		} else 
			echo "No results found";
	}
	
	//get information regarding a single provider
	function getProviderInfo($pid){
		$query = "SELECT * FROM `providers` WHERE `pid` = '$pid'";

		$result = mysql_query($query);
		//get information and format it
		if($row = mysql_fetch_array($result)){
				$temp = array();
				$temp['pid'] = $row['pid'];
				$temp['name'] = $row['name'];
				$temp['address'] = $row['address'];
				$temp['city'] = $row['city'];
				$temp['state'] = $row['state'];
				$temp['zip'] = $row['zip'];
				$temp['phone'] = $row['phone'];
				$temp['accepting_new'] = $row['accepting_new'];
				$temp['has_parking'] = $row['has_parking'];
				$temp['type'] = $row['type'];
				$temp['latitude'] = $row['latitude'];
				$temp['longitude'] = $row['longitude'];
				$temp['credit_cards'] = $row['credit_cards'];
				$temp['handicap_access'] = $row['handicap_access'];
				$temp['appointment_only'] = $row['appointment_only'];
				$temp['website'] = $row['website'];
				$temp['hours'] = $row['hours'];
				$temp['average_rating'] = $this->getAvgOverallRating($row['pid']);
				$temp['average_rating'] = number_format($temp['average_rating'], 2);
				if($temp['average_rating'] === "0") $temp['average_rating'] = "0.0";
				$temp['average_friendliness_rating'] = $this->getAvgFriendlinessRating($row['pid']);
				$temp['average_friendliness_rating'] = number_format($temp['average_friendliness_rating'], 2);
				if($temp['average_friendliness_rating'] === "0") $temp['average_friendliness_rating'] = "0.0";
				$temp['average_environment_rating'] = $this->getAvgEnvironmentRating($row['pid']);
				$temp['average_environment_rating'] = number_format($temp['average_environment_rating'], 2);
				if($temp['average_environment_rating'] === "0") $temp['average_environment_rating'] = "0.0";
				$temp['average_communication_rating'] = $this->getAvgCommunicationRating($row['pid']);
				$temp['average_communication_rating'] = number_format($temp['average_communication_rating'], 2);
				if($temp['average_communication_rating'] === "0") $temp['average_communication_rating'] = "0.0";
				$temp['average_professional_rating'] = $this->getAvgProfessionalRating($row['pid']);
				$temp['average_professional_rating'] = number_format($temp['average_professional_rating'], 2);
				if($temp['average_professional_rating'] === "0") $temp['average_professional_rating'] = "0.0";
				$temp['average_costs_rating'] = $this->getAvgCostsRating($row['pid']);
				$temp['average_costs_rating'] = number_format($temp['average_costs_rating'], 2);
				if($temp['average_costs_rating'] === "0") $temp['average_costs_rating'] = "0.0";
				$temp['average_availability_rating'] = $this->getAvgAvailabilityRating($row['pid']);
				$temp['average_availability_rating'] = number_format($temp['average_availability_rating'], 2);
				if($temp['average_availability_rating'] === "0") $temp['average_availability_rating'] = "0.0";
				$return = array();
				$return["provider"] = $temp;
				echo json_encode($return);
		} else {
			echo "Invalid PID";
		}
	}
	
	//calculate and return the average overall rating for a given provider
	function getAvgOverallRating($pid){
		//create and executequery
		$query = "SELECT * FROM `ratings` WHERE `pid` = $pid";
		$result = mysql_query($query);
		
		//calculate average
		$total = 0;
		$count = 0;
		while($row = mysql_fetch_array($result)){
			$total += $row['rating'];
			$count++;
		}
		
		if($count == 0){
			return 0;
		} else {
			return $total/$count;
		}
	}
	
	//calculate and return the average friendliness rating for a given provider
	function getAvgFriendlinessRating($pid){
		//create and executequery
		$query = "SELECT * FROM `ratings` WHERE `pid` = $pid";
		$result = mysql_query($query);
		
		//calculate average
		$total = 0;
		$count = 0;
		while($row = mysql_fetch_array($result)){
			$total += $row['friendliness'];
			$count++;
		}
		
		if($count == 0){
			return 0;
		} else {
			return $total/$count;
		}
	}
	
	//calculate and return the average office environment rating for a given provider
	function getAvgEnvironmentRating($pid){
		//create and executequery
		$query = "SELECT * FROM `ratings` WHERE `pid` = $pid";
		$result = mysql_query($query);
		
		//calculate average
		$total = 0;
		$count = 0;
		while($row = mysql_fetch_array($result)){
			$total += $row['office_environment'];
			$count++;
		}
		
		if($count == 0){
			return 0;
		} else {
			return $total/$count;
		}
	}
	
	//calculate and return the average communication rating for a given provider
	function getAvgCommunicationRating($pid){
		//create and executequery
		$query = "SELECT * FROM `ratings` WHERE `pid` = $pid";
		$result = mysql_query($query);
		
		//calculate average
		$total = 0;
		$count = 0;
		while($row = mysql_fetch_array($result)){
			$total += $row['communication'];
			$count++;
		}
		
		if($count == 0){
			return 0;
		} else {
			return $total/$count;
		}
	}
	
	//calculate and return the average professional skills rating for a given provider
	function getAvgProfessionalRating($pid){
		//create and executequery
		$query = "SELECT * FROM `ratings` WHERE `pid` = $pid";
		$result = mysql_query($query);
		
		//calculate average
		$total = 0;
		$count = 0;
		while($row = mysql_fetch_array($result)){
			$total += $row['professional'];
			$count++;
		}
		
		if($count == 0){
			return 0;
		} else {
			return $total/$count;
		}
	}
	
	//calculate and return the average costs rating for a given provider
	function getAvgCostsRating($pid){
		//create and executequery
		$query = "SELECT * FROM `ratings` WHERE `pid` = $pid";
		$result = mysql_query($query);
		
		//calculate average
		$total = 0;
		$count = 0;
		while($row = mysql_fetch_array($result)){
			$total += $row['costs'];
			$count++;
		}
		
		if($count == 0){
			return 0;
		} else {
			return $total/$count;
		}
	}
	
	//calculate and return the average availability rating for a given provider
	function getAvgAvailabilityRating($pid){
		//create and executequery
		$query = "SELECT * FROM `ratings` WHERE `pid` = $pid";
		$result = mysql_query($query);
		
		//calculate average
		$total = 0;
		$count = 0;
		while($row = mysql_fetch_array($result)){
			$total += $row['availability'];
			$count++;
		}
		
		if($count == 0){
			return 0;
		} else {
			return $total/$count;
		}
	}
	
	//calculate distance between 2 points
	function distanceLatLongPair($lat1, $long1, $lat2, $long2){
   		$pi80   = M_PI / 180;
	  	$lat1  *= $pi80;
      	$long1 *= $pi80;
    	$lat2  *= $pi80;
    	$long2 *= $pi80;
   
	  	$r = 6372.797; // mean radius of Earth in km
    	$dlat = $lat2 - $lat1;
    	$dlong = $long2 - $long1;
   	  	$a = sin($dlat / 2) * sin($dlat / 2) + cos($lat1) * cos($lat2) * sin($dlong / 2) * sin($dlong / 2);
    	$c = 2 * atan2(sqrt($a), sqrt(1 - $a));
    	$km = $r * $c;
   
	  	return $km * 0.621371192;
	}
}