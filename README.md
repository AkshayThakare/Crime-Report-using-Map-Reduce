# Crime-Report-using-Map-Reduce
This repository contains the source code for Crime Report project using the Map Reduce framework
General Information:

1. The Folder CrimeReport is having all the required files for Map Reduce program.
2. The CrimeReportMapper class uses the first digit of the coordinates only to define a region.
3. The Folder CrimeReportMapper_1 has CrimeReportMapper class which uses the first 3 digits of the coordinates to define a region.
4. The Folder CrimeReportMapper_2 has CrimeReportMapper class which uses the first 5 digits of the coordinates to define a region.
5. If you want to test any mapper class just copy the respective mapper class code into the eclipse.


How to run:

1. You have to just use the jar file provided.
2. Command to run on hdfs:
	hadoop jar CrimeReportCount.jar (address of files) (address of folder to store output)
3. You can check the output into the specified output folder.
