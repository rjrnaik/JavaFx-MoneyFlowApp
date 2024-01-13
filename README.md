# JavaFx-MoneyFlowApp

Basic JavaFX code to generate an app to track expenses &amp; income

PROJECT OVERVIEW & DESCRIPTION

The project involves creation of a money management application with main functions
i) Entering user expenses or income
ii) Storing the details based on category
iii) Generating graphical statistics based on the entries

The main functionality of the application is tracking of transactions for end users. The entire application deals with two types of transactions, Expense & Income. The application stores the data of the transaction into separate files and the data can be reused for searching and visually representing the same.
File Handling is being handled using PrintWriter and Scanner and exception handling was incorporated for IOExceptions. Files used are delimited (comma-separated values) files. ArrayLists and ObservableLists have been used from java Collections framework to handle the data.

GUI Page1
![image](https://github.com/rjrnaik/JavaFx-MoneyFlowApp/assets/50843052/c97e99d8-0f72-44b6-93f2-26468e3841a0)

GUI Page2
![image](https://github.com/rjrnaik/JavaFx-MoneyFlowApp/assets/50843052/c03f9377-1ba1-4f7d-b294-34b5624882d2)

GUI Page 3
![image](https://github.com/rjrnaik/JavaFx-MoneyFlowApp/assets/50843052/a4c038f9-3290-48fb-90ac-f885ba1c10c1)


WORKFLOW
Upon entering details of the expense or incomes, the program will use an ArrayList object to collect the data and using I/O operations like PrintWriter, the details will be stored in files (CSV) with file name of randomly generated transaction number.
Using Read operation (Scanner), that is reading from the file stored the details will be displayed on the screen upon click of search button based on the filter.
Show statistics button when clicked will display the details as a pie chart with the summation of expenses/ income for the particular category.

JAVA CLASSES:
Transaction.java – Parent class to Expense and Income classes with common properties of the entries.
Expense.java – Will consist of details of the expenses, sending 
Income.java – Will contain details of the income entries
Record.java - Will consist of methods to add entries to a Data Structure like Array List or Hashmap and will perform I/O operations, search for the transactions and generate expenses.

UML
![image](https://github.com/rjrnaik/JavaFx-MoneyFlowApp/assets/50843052/17ed8cac-18c5-415a-9d86-d1981d6cb117)

