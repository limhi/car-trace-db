#!/usr/bin/perl -w
use strict;
#print ("start\n\n");
my $int1=$#ARGV+1;
#print ("int1 = ".$int1."\n");

if( $#ARGV+1 != 1 ){
	print ("error!!!!!!!\n");
	exit;
}

my $inStr = $ARGV[0];

if ($inStr !~ /^[A-Z]/){
	print ("error!!!!!!!\n");
	exit;
}else{
	if ($inStr =~ /[^A-Za-z0-9]/){	
		print ("error!!!!!!!\n");
		exit;
	}else{
		#print ("args OK!!!!!!!\n");
	}
}

#print length($inStr);
if(length($inStr) > 0){
	#print ("length OK!!!!!!!\n");
}else{
	print ("error!!!!!!!\n");
	exit;
}

my $myChar;
my $myFlag = 0;
my $outStr = substr($inStr, 0, 1);

for(my $i=1;$i<length($inStr);$i++){
	$myChar = ord(substr($inStr, $i, 1));
	$myFlag = ( ( $myChar >= ord('A') ) and ( $myChar <= ord('Z')))?1:0 ;
	#print ($myChar."-".$myFlag."\n");
	if($myFlag){
		$outStr = $outStr."_".substr($inStr, $i, 1);
	}else{
		$outStr = $outStr."".uc(substr($inStr, $i, 1));
	}
}

#print ("outStr = ".$outStr);
print ($outStr."\n");

#print ("\nend\n");

