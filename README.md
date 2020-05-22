# Terkwaz-TestAutomation

### Technologies used to build the framework
* Java 8
* Maven 3
* TestNG
* Selenium
* Rest Assured (for API Automation)
* Extent Report (for Reporting)

## Project structure 

	- The project uses the "Page object model" design pattern so:
	1. Each page of the scenario have a class that contains all elements and all functional Methods for all actions in the page.
	2. Each test case have a class to execute the relevant test case.
  
	- There is an xml file "TestNGExecution.xml" to execute all test cases sequentially.
	- All URLs are included in a properties file "Environment.properties" it also contains the browser name.
	- "Driver.java" class is the testBase class which all the test clases inherit it.

**To Run the project**
1. Clone the project
2. Open the project using your IDE (Eclipse/ Intellij)
3. Accept the import to import all dependencies
4. To run all test cases in sequance, Right click on `TestNGExecution.xml` file
5. Select Run/ Run As TestNG
![Run Test Cases](https://github.com/mohammed-a-ali/Terkwaz-TestAutomation/blob/master/Images/RunTestCases.png)

6. After the Test is done A new folder `Reports` will be created
7. Expand the folder and Right click on _"index.html"_
8. Select "Open in browser" then select "Default"
![Run Test Cases](https://github.com/mohammed-a-ali/Terkwaz-TestAutomation/blob/master/Images/OpenReport.png)
9. The Report is displayed for each test case and a screenshot is attached
![Run Test Cases](https://github.com/mohammed-a-ali/Terkwaz-TestAutomation/blob/master/Images/GUIReportView.png)
10. For the API report select "GET one random cat fact" you can see the response body attached
![Run Test Cases](https://github.com/mohammed-a-ali/Terkwaz-TestAutomation/blob/master/Images/APIReportView.png)
11. You also can check the API Response in the _"output.txt"_ file
![Run Test Cases](https://github.com/mohammed-a-ali/Terkwaz-TestAutomation/blob/master/Images/APIResponse.png)
12. Also you can switch to dashboard view by selecting _"Dashboard"_ from the left side menu
![Run Test Cases](https://github.com/mohammed-a-ali/Terkwaz-TestAutomation/blob/master/Images/DashboardReportView.png)
