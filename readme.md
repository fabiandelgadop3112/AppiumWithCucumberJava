# AUTOMATION OF AN ANDROID APP WITH APPIUM STARTING ABOUT A DEFINED TEST CASES 

The actual automation tool, executes some test cases for an Android app. This app was built to control personal finances and allows to the user adds his expenses or his incomes.

In the actual process, the high priority test cases was automated with the next methodology and technical process:

***Automation model:*** Page Object Model.

***Methodology:*** Thinking on GUI Level, cucumber was used to helps the process, writing the high-level scenarios on user histories in a Gherkin language.

***Language code:*** Java

***Framework:***  Appium

This was the best way to automate this process having the actual conditions as a final user of a third party app.

_“Please have in mind that automation process never replaces the manual testing, it’s only a big help.”_

### **How automation was built**

First, in a feature file we write in gherkin the high-level scenarios:

``` Gherkin
#Author: Fabian Delgado
@Alltestcases
Feature: Add registers from home
  As I user i want to add expenses or incomes from home

  @Addincomes
  Scenario: Add incomes
    Given Staying in home screen
    When I push button plus
    And I enter a value in the calculator
    And I Choose a category
    Then I View the amount reflected on the label to incomes

  @Addexpenses
  Scenario: Add expenses
    Given Staying in home screen for add expense
    When I push button minus
    And I enter a value in the expenses calculator
    And I Choose a category of expense
    Then I view the amount reflected on the label to expenses
    
   @Addinividualexpenses
   Scenario: Add individial expenses from home.
   	Given Staying in home screen for add individual expenses
   	Then I could add expenses individualy
   
   @Balancevalidation
   	Scenario: Validate Balance about an income and an expense
   	Given Staying in home screen to validate balance
   	When I add an income
   	And I add an expense
   	Then The Balance have to print the difference between both records 
```

With a class runner, we reference the feature file, we can change the tag if we want to run only one of this cases, the actual process execute all cases. 

The feature file communicates with class or classes “definition” through “regexp”. Once the class is invoked, the communication with the logic or script process (PageObject class) is realized through class step (So the steps classes are the bridge between the definition classes and page object classes).

A necessary class was created to make the connection to Appium and to the device: “AppiumResources.java”, also this class have a method to simulate a swipe in the app.

The next flow was built to validate the high-level test cases on the automation:

#### **Add income or Add expense**

1. Find by id the object of the add income or expense button and click it.
   
2. In the calculator, to enter any value, a random process was implemented to generates number between zero and nine, and these numbers are sent to the xpath. (taking advantage of the logical sequence and the pattern of the button’s xpath in this screen.
   
3. Add the income or expense selecting a category.
   
4. Finally to validate the test cases, the automation process evaluate the initial value of the central labels in the app, and its was compared with the entered value.

#### **Add individual expenses**

To be able to evaluate this process, first, the grid of the buttons of expense is iterated, however, when a expense have been registered, this expense is moving randomly around the grid. To control this behavior and only add expenses that have not been get into the flow, in the iterated process, the label that have the percentage also is evaluated. Then, if the label have a percentage, the process don’t add more value to this expense and pass to other empty expense.

Considering, that in the app, some or all individual expenses have been filled, previously to this process, the automation clean registered on the side options menu (through a swipe function).

When all individual expenses have been filled, the test case is ok.

#### **Evaluate balance**

This process integrates the add income and expense process and assert the test case evaluating the difference between the expenses and incomes labels.

# INSTALATION GUIDE

## **Prerequisites**

Install the next items on your system

- JDK 12.0.0 or greater.

- Appium: you can download it from the next link: http://appium.io/downloads.html

- Appium server. If you have node.js installed in your system, you can install Appium typing this command in the command line:

    ` $ npm install -g appium `

- Maven: you can download from the next link: https://maven.apache.org/download.cgi

- SDK Tool (If you already have Android studio, you can download and install from this framework).

## **Atlernative requisites:**

If you want to use eclipse to validate the process you should have the next requisites:

- Cucumber for eclipse.

- Juit Tools for eclipse.

These requisites can be installed from Eclipse from the “Eclipse Market Place”

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95024596-a8d76600-0649-11eb-8307-f4bf5f0ccf36.png"></p>

Once you have installed the plugins in eclipse, you should restart it.

## **Prerequisites configurations or installation**

For windows OS.

Configure the next environment variables:
**Java**

***JAVA_HOME*** _C:\Program Files\Java\jdk-11.0.8_
    
Add to the path: _%JAVA_HOME%\bin_
    
To check that java is installed type the next   command in the command line:

`$ Java -version`

**MAVEN**

***M2_HOME*** _C:\Maven\apache-maven-3.6.3
    
***M2*** _%M2_HOME%\bin_

Add to the path: 
_%M2_HOME%\bin_

To check that mvn  is installed type the next command in the command line:

`$ mvn -version`

This have to show the actual version of Maven in the system.

**SDK**

***ANDROID_HOME*** _C:\Users\Nertor Delgado\AppData\Local\Android\Sdk_

Add to the path:

_%ANDROID_HOME%\platform-tools_
_%ANDROID_HOME%\tools_
_%ANDROID_HOME%\platforms_

To check that its works, type in the command line the next command:

`$ adb version `

And it shows the actual version of SDK
    
***Note:*** _The reference that the named paths only are a reference, verify your local paths of each named prerequisites._
    
<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95022737-ba674080-063e-11eb-9d88-7c9e505afb05.png"></p>

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95022736-b9ceaa00-063e-11eb-8767-ec9ab5a677b4.png"></p>

## ***Preparing the environment and device***

Before running the automation you need the known the android’s version and something information of your device. (This process was built and tested in a Motorola Moto g8 plus).

1. On your device go to settings.

2.	 Search for the developer options.

3.	Turn on the developer mode

Also we need to know the device name and the andriod’s actual version.

4. On your device, in settings section  go to “System” option:

5. Later select “About phone”

6. Check the device name and android version

This two last items will help us to configure our capabilities in tue automation project.

To know the udid, connect your device via USB and type the next command in the command line:

`$ adb devices `

An it shows the udid of your device

## **Configure device information on the project to run the process**


In the root path of the project “testSuiteMonefy”, edit file “project.properties” an add the information device finded in the previous step:

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95022738-ba674080-063e-11eb-827e-56c9abc3730f.png"></p>

On this way, you can run the project using your Android device.

### **EXECUTION PROCESS**

Clone the repository to a local path

On eclipse impor the project as a maven project.

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95025397-15a12f00-064f-11eb-867a-b6693659dcd6.png"></p>

Select yout local path.

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95025398-1639c580-064f-11eb-9a79-5c21203d6e8c.png"></p>

Run the tests, running the Alltestcases.java class as a Junit test, if you are using eclipse you can execute tests on this way:

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95022739-baffd700-063e-11eb-8fc2-0035aebc8176.png"></p>

If eclips ask you what launcher do you want to execute the test, you could select _Eclipse Junit Lancher_

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95025399-16d25c00-064f-11eb-8c32-a085082ef9ac.png"></p>

***Note:*** _If you want execute only one thest cases, you must change the tag in the Alltestcases.java class accord to tags of the feture file_ 


<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95023061-842ac080-0640-11eb-8cb1-038acd611a15.png"></p>


And .... enjoy the test cases running.

<p align="center"><img width="400" alt="gesture sample" src="https://user-images.githubusercontent.com/55062262/95024484-dec81a80-0648-11eb-9f0f-55bcf8c3b6c8.gif"></p>



