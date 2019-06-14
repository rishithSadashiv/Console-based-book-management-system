package in.ac.sit.cs.bms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import in.ac.sit.cs.bms.exceptions.BMSException;

public class TestBMS {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String choice = null;
		String bookChoice = null;//used in 1st block of option6
		String title = null;
		int ISBN = 0;
		String catagory = null;
		int noOfBooks = 0;
		String aName = null;
		String aPhNo = null;
		final String zeroBooks = "0";
		BookDAO dao = new BookDAO();
		List<Book> bookList = null;
		final int usingtitle = 1,usingcatagory = 2,usingauthor = 3,listall = 4;
		String studName = null,studUsn = null,issueDate = null;
		Date iDate=null;
		IssueDAO iDao = new IssueDAO();
		Date rDate = null;
		int selectISBN = 0;

		do {
			System.out.println("\nPlease select your choice : ");
			System.out.println("1. Add a book");
			System.out.println("2. Search a book based on book title");
			System.out.println("3. Search books based on catagory");
			System.out.println("4. Search books based on author");
			System.out.println("5. List all books along with author information");
			System.out.println("6. Issue book to a student");
			System.out.println("7. List books issued to student based on USN number");
			System.out.println("8. List books which are to be returned for current date");
			System.out.println("9. Exit");
			
			choice = sc.nextLine();
			System.out.println("You chose option "+choice+"\n");
			
			switch (choice) {
			case "1":
				System.out.println("Give the details of the book");
				System.out.println("    1)Title");
				try {
					title = sc.nextLine();
					if(title.equals("") || title.equals(null)){
						throw new BMSException("title field cannot be empty");
					}
				}catch(BMSException e){
					while(title.equals("") || title.equals(null)){
						System.out.println("Invalid title, null\nEnter the title again");
						title = sc.nextLine();						
					}
				}
				System.out.println("    2)ISBN (Book number)");
				try {
					ISBN = sc.nextInt();sc.nextLine();
					if(ISBN<=0){
						throw new BMSException("ISBN cannot be zero or negative");
				    }
				}catch(BMSException e){
					while(ISBN < 0 || ISBN == 0){
						System.out.println("Invalid ISBN,\nEnter ISBN again ");
						ISBN = sc.nextInt();sc.nextLine();
					}
				}catch(InputMismatchException e) {
					System.out.println("Invalid input, ISBN should be a string value, please enter again");
					ISBN = sc.nextInt();sc.nextLine();
				}
				System.out.println("    3)Catagory");
				try {
					catagory = sc.nextLine();
					if(catagory.equals("") || catagory.equals(null)){
						throw new BMSException("catagory field cannot be empty");
					}
				}catch(BMSException e){
					while(catagory.equals("") || catagory.equals(null)){
						System.out.println("Invalid catagory, null\nEnter the catagory again");
						catagory = sc.nextLine();
					}
				}
				System.out.println("    4)Number of books being added");
				try {
					noOfBooks = sc.nextInt();sc.nextLine();
					if(noOfBooks <= 0){
						throw new BMSException("Number of books cannot be zero or negative number");
					}
				}catch(BMSException e){
					while(noOfBooks <= 0 ){
						System.out.println("Invalid number, null\nEnter the Number of books again");
						noOfBooks = sc.nextInt();sc.nextLine();
					}
				}catch(InputMismatchException e) {
					System.out.println("Invalid entry, It should be an integer value, \nEnter number again ");
					noOfBooks = sc.nextInt();sc.nextLine();
				}
				System.out.println("Give the details of the Author");
				System.out.println("    1)Name");
				try {
					aName = sc.nextLine();
					if(aName.equals("") || aName.equals(null)){
						throw new BMSException("Author name cannot be empty");
					}
				}catch(BMSException e){
					while(aName.equals("") || aName.equals(null)){
						System.out.println("Invalid name, null\nEnter the Author name again");
						aName = sc.nextLine();
					}
				}
				System.out.println("    2)Phone number or Mail ID");
				try {
					aPhNo = sc.nextLine();
					if(aPhNo.equals("") || aPhNo.equals(null)){
						throw new BMSException("This field cannot be empty");
					}
				}catch(BMSException e){
					while(aPhNo.equals("") || aPhNo.equals(null)) {
						System.out.println("Invalid entry, null\nEnter the Phone number or Mail ID again");
						aPhNo = sc.nextLine();
					}
				}
				
				dao.addBook(new Book(title,ISBN,catagory,noOfBooks, new Author(aName, aPhNo)));
				
				System.out.println("The book has been added");
				
				break;
				
			case "2":
				System.out.println("Enter book title");
				try {
					title = sc.nextLine();
					if(title.equals("") || title.equals(null)){
						throw new BMSException("Book title field cannot be empty");
					}
				}catch (BMSException e) {
					while(title.equals("") || title.equals(null)) {
						System.out.println("Invalid Book title\nEnter the Book title again");
						title = sc.nextLine();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				bookList = null;
				bookList = dao.searchUsingTitle(title,usingtitle);
				for(Book i : bookList){
					System.out.println(i.toString());
				}
				
				break;
				
			case "3":
				System.out.println("Enter book Catagory");
				try {
					catagory = sc.nextLine();
					if(catagory.equals("") || catagory.equals(null)){
						throw new BMSException("Book catagory field cannot be empty");
					}
				}catch (BMSException e) {
					while(catagory.equals("") || catagory.equals(null)) {
						System.out.println("Invalid Book catagory\nEnter the Book title again");
						catagory = sc.nextLine();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				bookList = null;
				bookList = dao.searchUsingTitle(catagory,usingcatagory);
				for(Book i : bookList){
					System.out.println(i.toString());
				}
	
				break;
	
			case "4":
				System.out.println("Enter Author name");
				try {
					aName = sc.nextLine();
					if(aName.equals("") || aName.equals(null)){
						throw new BMSException("Author name field cannot be empty");
					}
				}catch (BMSException e) {
					while(aName.equals("") || aName.equals(null)) {
						System.out.println("Invalid Author name\nEnter the Book title again");
						aName = sc.nextLine();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				bookList = null;
				bookList = dao.searchUsingTitle(aName,usingauthor);
				for(Book i : bookList){
					System.out.println(i.toString());
				}
				break;
	
			case "5":
				bookList = null;
				bookList = dao.searchUsingTitle(zeroBooks,listall);
				for(Book i : bookList){
					System.out.println(i.toString());
				}
				break;
	
			case "6":
				/*bookList = null;
				bookList = dao.searchUsingTitle(zeroBooks,listall);
				for(Book i : bookList){
					System.out.println(i.toString());
				}
				System.out.println("Enter the Student name");
				studName = sc.nextLine();
				System.out.println("Enter the Student USN");
				studUsn = sc.nextLine();
				System.out.println("Enter issue date (dd/mm/yyyy)");
				issueDate = sc.nextLine();
				try {
					iDate = new SimpleDateFormat("dd/MM/yyyy").parse(issueDate);
				} catch (ParseException e) {
					System.out.println("Incorrect format, Enter as dd/mm/yyyy");
					issueDate = sc.nextLine();
					try {
						iDate = new SimpleDateFormat("dd/MM/yyyy").parse(issueDate);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				System.out.println(iDate);
				do {
					int selectISBN;
					System.out.println("Please enter the ISBN(Book number) of the book you want");
					try {
						selectISBN = sc.nextInt();sc.nextLine();
					}catch(InputMismatchException e) {
						System.out.println("Input should be an integer value");
						selectISBN = sc.nextInt();sc.nextLine();
					}
					iDao.issueBook(new Student(studName, studUsn), iDate, selectISBN );
					System.out.println("Do you want another book? (Y/n), \nPress any key for 'Yes' and 'N' or 'n' for No");
					bookChoice = sc.nextLine();
				}while(!(bookChoice.equals("N") || bookChoice.equals("n")));*/
				
				bookList = null;
				bookList = iDao.displayAllRecordedBooks();
				for(Book i : bookList){
					System.out.println(i.toString());
				}
				System.out.println("\nPlease enter the ISBN of the book you need");
				try {
					selectISBN = sc.nextInt();sc.nextLine();
					if(selectISBN<=0){
						throw new BMSException("ISBN cannot be zero or negative");
				    }
				}catch(BMSException e){
					while(selectISBN < 0 || selectISBN == 0){
						System.out.println("Invalid ISBN,\nEnter ISBN again ");
						ISBN = sc.nextInt();sc.nextLine();
					}
				}catch(InputMismatchException e) {
					System.out.println("Invalid input, ISBN should be a string value, please enter again");
					ISBN = sc.nextInt();sc.nextLine();
				}
				
				int available = iDao.bookAvailability(ISBN);
				if(available == 0){
					System.out.println("This book is unavailable");
				}else{
					System.out.println("Enter the Student name");
					try {
						studName = sc.nextLine();
						if(studName.equals("") || studName.equals(null)){
							throw new BMSException("Name cannot be empty");
						}
					}catch (BMSException e) {
						while(studName.equals("") || studName.equals(null)) {
							System.out.println("Enter valid name");
							studName = sc.nextLine();
						}
					}
					System.out.println("Enter the Student USN");
					try {
						studUsn = sc.nextLine();
						if(studUsn.equals("") || studUsn.equals(null))
						{
							throw new BMSException("USN cannot be empty");
						}
					}catch (BMSException e) {
						while(studUsn.equals("") || studUsn.equals(null)) {
							System.out.println("Enter Valid USN");
							studUsn = sc.nextLine();
						}
					}
					System.out.println("Enter issue date (dd/mm/yyyy)");//checks for incorrect format only once. find a way to loop it
					try {
						issueDate = sc.nextLine();
						if(issueDate.equals("") || issueDate.equals(null))
						{
							throw new BMSException("Date cannot be empty");
						}
					}catch(BMSException e)
					{
						while(issueDate.equals("") || issueDate.equals(null))
						{
							System.out.println("Enter valid date (dd/mm/yyyy)");
							issueDate = sc.nextLine();
						}
					}
					try {
						iDate = new SimpleDateFormat("dd/MM/yyyy").parse(issueDate);
					} catch (ParseException e) {
						System.out.println("Incorrect format, Enter as dd/mm/yyyy");
						issueDate = sc.nextLine();
						try {
							iDate = new SimpleDateFormat("dd/MM/yyyy").parse(issueDate);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
					iDao.issueBook(new Student(studName, studUsn), iDate, selectISBN );
				}
	
				System.out.println("Book issued");
				break;
	
			case "7":
				System.out.println("Enter the USN");
				try {
					studUsn = sc.nextLine();
					if(studUsn.equals("") || studUsn.equals(null))
					{
						throw new BMSException("USN cannot be empty");
					}
				}catch (BMSException e) {
					while(studUsn.equals("") || studUsn.equals(null)) {
						System.out.println("Enter Valid USN");
						studUsn = sc.nextLine();
					}
				}
				iDao.listStudentBooks(studUsn);
				break;
	
			case "8":
				System.out.println("Enter the current date");
				try {
					issueDate = sc.nextLine();
					if(issueDate.equals("") || issueDate.equals(null))
					{
						throw new BMSException("Date cannot be empty");
					}
				}catch(BMSException e)
				{
					while(issueDate.equals("") || issueDate.equals(null))
					{
						System.out.println("Enter valid date (dd/mm/yyyy)");
						issueDate = sc.nextLine();
					}
				}
				try {
					rDate = new SimpleDateFormat("dd/MM/yyyy").parse(issueDate);
				} catch (ParseException e) {
					System.out.println("Incorrect format, Enter as dd/mm/yyyy");
					issueDate = sc.nextLine();
					try {
						rDate = new SimpleDateFormat("dd/MM/yyyy").parse(issueDate);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				iDao.booksToBeReturned(rDate);
				break;
	
			case "9":
					System.out.println("Exiting program");
				break;
				
			default:
				System.out.println("Invalid choice!");
				break;
			}
					
		}while(!choice.equals("9"));
	
		sc.close();
	}

}
