# AMPJavaProject

This Java program takes three arguments:

1) first city name
2) second city name
3) a path to a text file containing comma-separated pairs of connected cities, one pair per line e.g. connections.txt OR C:\\Users\\ABCD\\Desktop\\connections.txt

If the cities specified by the first two arguments are connected then the program prints CONNECTED.  Otherwise, it prints NOT CONNECTED.

Steps:
	1. Download the jar file ConnectedCities.jar
	
	2. Execute java -jar ConnectedCities.jar Columbus Denver  connections.txt
		i. If the file is different location the put the file path with file name with in quotes. e.g. "C:\\Users\\ABCD\\Desktop\\connections.txt"
		
	3. Provide valid inputs
	
	4. If the number of arguments not mathced the program will exit
	
	5. IF the input cities are connected then it returns "CONNECTED"
	
	6. It will print as "NOT CONNECTED" when
		i. the cities are not connected OR
		ii. any or both cities are not present in the graph


For example, if the input file is:
New York, Chicago
Denver, Kansas City
Chicago, Los Angeles
Kansas City, Nashville

Sample outputs:
	> java ConnectedCities "New York" "Los Angeles" connections.txt
	CONNECTED
	> java ConnectedCities Denver Nashville connections.txt
	CONNECTED
	> java ConnectedCities "Los Angeles" Nashville connections.txt
	NOT CONNECTED
	> java ConnectedCities "New York" "New York" connections.txt
	CONNECTED
	> java ConnectedCities "New York" "Boston" connections.txt
	NOT CONNECTED