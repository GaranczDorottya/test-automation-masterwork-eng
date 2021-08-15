## The theme of my masterwork project
For my project, I choose a blog that runs with a WordPress engine.
On the website, you can register, read blog posts and write comments.

Check out the web application here: [Greenfox test-automation-blog](http://test-automation-blog.greenfox.academy/)
***
## Manual test cases
You can read my manual test case documentation by clicking on the link below\
[Manual test cases - Google Spreadsheets](https://docs.google.com/spreadsheets/d/1iuAAzr0N7xzElvqXV-cDUVTxn1tbk-pf_NY88QUWSG8/edit?usp=sharing)
***
## Information about my automated tests
My tests were written in JAVA language using IntelliJ IDEA development environment, Gradle project structure and Selenium WebDriver.

The finished tests are compatible with the following browsers:
* Google Chrome
* Mozilla Firefox
* Microsoft Edge

### Tested features:
* Registration
* Login
* Data listing
* User data management
* Commenting
* Data extracting
* Logout

All the automated tests were based on the above linked manual test documentation. The tests were designed to be run in order, one after another. This is particularly true in the following cases because they all cover part of the same feature.

* #TC08_DATA_INPUT_01
* #TC12_DATA_MODIFICATION
* #TC13_DELETING_DATA

With the following test cases, use different input data every time you repeat them.

* #TC02_REGISTRATION_02

***
## Method of running
To run the automated tests, you will need IntelliJ IDEA with JAVA SE 15, one of the above-listed browsers and the blog_input_data.csv file for the parameterized tests.

### Running the automated tests:
1. Clone this repository to your computer
2. Open the cloned `automated-tests` Gradle project with IntelliJ IDEA
3. Open the terminal at the bottom of your screen\
(In most cases, this will open up a PowerShell terminal.)
4. Type `.\gradlew clean test` into the terminal
5. Press `Enter`

If you would like to run the test package with a different web driver, follow the steps below

1. Open the `automated-tests` Gradle project with IntelliJ IDEA
2. Find and open `test.properties` file in the `resources` folder
3. Change `chrome` to `firefox` or `edge`
4. Close the `test.properties` file
5. Run your tests by implementing steps 3 - 5 from `Running the automated tests` above.
***
## Reporting method and how you can access reports
For the test reporting part of my project, I used Allure. Allure is an open-source framework designed to create test execution reports that are clear to everyone.

This project already contains the allure set up so you don't have to download it.
However, if the allure folders are missing, do the following steps (assuming you have IntelliJ IDEA already opened)

1. Open the terminal at the bottom of your screen
2. Type `.\gradlew downloadAllure` into the terminal\
(This command will download Allure to the currently opened project)
3. Press `Enter`

To get an Allure test report, run your test according to `Method of running`. When the tests are finished, do the following steps.

1. Open the terminal at the bottom of your screen
2. Type `.\gradlew allureServe` into the terminal
3. Press `Enter`

Allure will open a browser window containing the report of your tests.
Here you can find all your test suites detailed. You can open them one by one and see if there are any files attached. If there are, it will appear under the test cases description.
After you are done with reading the report, just close the browser window.

### Important information for test running and reporting
Sometimes, IntelliJ IDEA will open another terminal that is not PowerShell.
If the above given terminal commands are not working, try them without `.\`.