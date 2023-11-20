import java .util.*;
import java.util.ArrayList;
import java.util.Scanner;

class LibBook {
	
    private String Heading;
    private String Writter;
    private boolean SearchingOut;

    public LibBook(String head, String writter) {
        this.Heading = head;
        this.Writter = writter;
        this.SearchingOut = false;
    }

    public LibBook(String next) {
  // TODO Auto-generated constructor stub
 }

 public String getHead() {
        return Heading;
    }

    public String getWritter() {
        return Writter;
    }

    public boolean isSearchingOut() {
        return SearchingOut;
    }

    public void SearchingOut() {
        SearchingOut = true;
    }

    public void returnBook() {
        SearchingOut = false;
    }
}

class Librarybooks {
  private static String name;
     private static String Id;
    private ArrayList<LibBook> books;

    public Librarybooks() {
        books = new ArrayList<>();
    }

    public void addBook(LibBook book) {
        books.add(book);
    }

    public void listBooks() {
        System.out.println("Library Inventory:");
        for (LibBook book : books) {
            String status = book.isSearchingOut() ? "Checked Out" : "Available";
            System.out.println(book.getHead() + " by " + book.getWritter() + " - " + status);
        }
    }

    public boolean checkOutBook(String title) {
        for (LibBook book : books) {
            if (book.getHead().equalsIgnoreCase(title) && !book.isSearchingOut()) {
                book.SearchingOut();
                System.out.println("You have checked out: " + book.getHead());
                return true;
            }
        }
        System.out.println("Book not found or already checked out.");
        return false;
    }

    public boolean returnBook(String title) {
        for (LibBook book : books) {
            if (book.getHead().equalsIgnoreCase(title) && book.isSearchingOut()) {
                book.returnBook();
                System.out.println("You have returned: " + book.getHead());
                return true;
            }
        }
        System.out.println("Book not found or not checked out.");
        return false;
    }
   
    
}

public class LibraryManagement{
    public static void main(String[] args) {
     System.out.println (" WELCONE TO RVS LIBRARY:");
        System.out.println (" Library Info:");
        Librarybooks l= new Librarybooks();

        Scanner sc = new Scanner(System.in);
        l.addBook(new LibBook("Romeo Julet ", "Sweat martin "));
        l.addBook(new LibBook("Pirates of Carribean ", "jet Lee"));
        l.addBook(new LibBook("Harry poter" , "jk Rolling"));
        l.addBook(new LibBook("Agini Siragugal", "Apj Abdul Kalam"));
      
       
       
      

        while (true) {
        
            System.out.println (" -> 1. List the No of Books here");
            System.out.println (" -> 2. Search Out a Books");
            System.out.println (" -> 3. Return the given Books");
           //  System.out.println("  ->4. Do you want add books");
         
            System.out.println(" Pick Your Intrest");
            int interset = sc.nextInt();
            sc.nextLine(); 
   

            switch (interset) {
                case 1:
                    l.listBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to check out: ");
                    String SearchingOut= sc.nextLine();
                    l.checkOutBook(SearchingOut);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnHead = sc.nextLine();
                    l.returnBook(returnHead);
                    break; 
         /* case 4:
                 System.out.println("Yo hava taken no books");
                 String Searching=sc.nextLine();
                 l.checkOutBook(SearchingOut);
                 */
                case 4:
                    System.out.println("Thanks for Visiting our Library");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Pick \\ Come Agin.");
                   
            }
            System.out.println("4. EXIT");
         

        }
        
     
    }
}