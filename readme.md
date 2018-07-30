Interview Test for Peloton.

This should help explain where and how to start the test and serve as a general documentation for this project.

Task 1 Objective:
- Create an automation test that does the following:
  1. Add the bike to cart and verify that it was added
  2. Try to login with a valid and invalid credentials 

Every base, helper, and test class are in src folder. 
* testng.xml - Launching this will start the two test. 
* TestBikePurchase.java - is your adding the bike to cart tests. 
* TestLoin.java - are your login tests. 
* Base.java - is your base class that has the driver and starts at the home page. 
* Login - is your login helper. This has all the login related methods and their definitions. 
* Peloton - is your site helper. This has adding to cart, and general navigation. 

Areas of Improvement: 
There are some nice to haves that would have made this better and a little more complete. 
- Improved a build script - there is a xml that will build and start testing, it would be be nice if it worked from command line. 
- Configure with TestNG - help view results more elegantly in an results html out put file.
- Organize the files - into helpers and tests. General organization of the project could have been better.  

PrerequisitEclipse IDE for Java Developers

IDE: Eclipes Version: Photon Release (4.8.0)
Build id: 20180619-1200e: 
JRE: 1.8.0_152-release-1136-b39 amd64
Windows 10 10.0
 - Make sure your IDE has all the selenium IDE dependencies. 
 - Make sure your IDE has the testng plugin installed

Starting the automation: 
1. Download the project file.
2. Open the project on your IDE
3. Open project Peloton
4. Go to testng.xml
5. Trigger Run as/Build as TestNG suite
6. Observe results in console. I've put in success messages. Would have been better to I could connect it to test
annotation. 
Note:I was not able to build an xml that worked from command line. 
All the jars needed get run are in the lib folder.  

Task 2: 
Create a script that takes in a city, references the openweathermap.org api, and returns that cities max and min. 
Located: in the TaskTwo folder
Currently its not working as intended. 