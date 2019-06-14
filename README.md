# Console-based-book-management-system
Console Based Book Management System ( using JDBC)
The Book Management System (BMS) provides user the following functionalities
•	Add a Book
•	Search a Book based on Book Title
•	Search Books based on Category
•	Search Books based on Author
•	List All Books along with author information
•	Issue Book to Student
•	List Books issued to Student  based on USN number (Print Book title, Student Name and return date) 
•	List books which are to be returned for current date
Add Book : A user can add book by providing the following information, title, ISBN ( Book Number), category and Author information ( Author Name and Phone Number)
Search Book: Book search can be based on book title, or category or Author, when a book is found, entire information has to be printed on the screen. Partial searches to be supported for example, if user searches by ‘ja’,  ‘Java Complete Reference’, ‘Head First Java’ books should be displayed.
List Books : List All Books
Issue Book to Student:  While issuing a book to a student, first select a book and then issue the book. Take the student USN No and Student Name while issuing. Each book will be issued for a maximum of 7 days. System should calculate the return date and display to the user. If the book is not in library, you should inform the user of the unavailability of the book.
Implementation Details
Classes : You should create following entity Classes – Book ,Author, Student, Issue
Book : Has an Author
Student : Has a List of books issued 
Note: Create new workspace and new project. Please follow Package Naming, Class Naming and variable naming conventions. Exceptions have to be handled, and program should not terminate abruptly. 
Please use only the Tables mentioned in the Database design section. Please refer to JDBC PPT for Auto Increment syntax and Foreign Key constraint. DO NOT CREATE additional tables!

DATABASE Design
Book Table	 
Book ISBN	Primary Key
Book Title	Varchar
Category	Varchar
No Of Books	Int

Author Table	 
Author Name	Varchar
Author Mail Id	Varchar
Book ISBN	Foreign KEY, References Book

Student Table	 
USN	Varchar Primary Key
Name	Varchar

Book ISSUE Table	 
Issue ID	Auto Increment Primary Key
USN	Foreign Key,References Student
Issued Date	Date
Return Date	Date
Book ISBN	Foreign Key,References Book 

Refer to below blog for converting from String to Date
https://www.javatpoint.com/java-string-to-date

For converting Util date to SQL Date 
java.sql.Date sDate = new java.sql.Date(utilDate.getTime());



The main method is in the file TestBMS.java
