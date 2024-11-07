import java.util.Hashtable;
import java.util.Set;

public class Library extends Building {

  /**declaring hashtable for library's collection */
  private Hashtable<String, Boolean> collection;

  private Boolean hasElevator;


  /** overloaded constructor with address and number of floors only 
   * calls Library constructor with unknown name
   * @param string address of library
   * @param int number of floors
   */
  public Library(String address, int nFloors) {
    this("<name unknown>", address, nFloors); 
  }

  /** overloaded constructor with name only
   * calls Library constructor and sets address to unknown and nFloors to 1
   * @param string name of library
   */
  public Library(String name) {
    this(name, "<address unknown>", 1);
  }

  /**constructor for library
   * @param string building name
   * @param string address
   * @param int number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }

  /**method for adding book to library's collectiom
   * @param title of book to be added
   * adds this title to the collection hashtable with value true
   */
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /**method to remove a book from the library
   * @param title of book to be removed
   * removes this title from the collection hashtable
   * @returns title of the book
   */
  public String removeTitle(String title) {
    collection.remove(title);
    return title;
  }

  /**method to check out book
   * checks if the title is in the collection and sets value to false if it is true
   * @param title of book
   */
  public void checkOut(String title){
    if (collection.containsKey(title)) {
      if (collection.get(title)) {
        collection.replace(title, false);
      } else {
        System.out.println("This book is not currently available");
    }
    } else {
      throw new RuntimeException("This book is not in our collection.");
    }
  }

  /**method to return book
   * checks if the title is in the collection and sets value to true if it is false
   * @param title of book
   */
  public void returnBook(String title) {
    if (collection.containsKey(title)) {
      if (collection.get(title) == false) {
        collection.replace(title, true);
      } else {
        System.out.println("This book is currently in the library, would you like to check it out?");
      }
      } else {
        throw new RuntimeException("This book is not in our collection.");
      }
  }

  /**method to check if a title is in the library's collection
   * @param title of book
   * @returns true if the title appears in the collection, false otherwise
   */
  public boolean containsTitle(String title){
    return collection.contains(title);
  }

  /**method to check availability of a book
   * @param title of book
   * @returns true if the title is available, false otherwise
   */
  public boolean isAvailable(String title) {
    return collection.get(title);
  } 

  /**method to print library collection with books availability
   * prints each title in the collection and whether it is curently available
   */
  public void printCollection() {
    Set<String> titles = collection.keySet();
    for(String title: titles){
      if (collection.get(title)) {
        System.out.println(title + ", currently available");
      } else {
        System.out.println(title + ", currently checked out");
      }
      }
    }

    /**method to print options 
   * overrides method from building class and addds library-specific methods to printed list
   */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection()");
    }

    /**method to go to a specific floor
     * calls building class method if the building has an elevator
     * @param int of floor number
     */
    public void goToFloor(int floorNum) {
        if (this.hasElevator) {
            super.goToFloor(floorNum);
        } else {
            throw new RuntimeException("This building doesn't have an elevator. You need to go up or down floor by floor to get to this floor.");
        }
    }
  
    public static void main(String[] args) {
      Library library1 = new Library("library1", "1 Main Street", 2);
      library1.addTitle("The Lorax by Dr. Seuss");
      library1.addTitle("To Kill a Mockingbird by Harper Lee");
      library1.addTitle("Slaughterhouse Five by Kurt Vonnegut");
      library1.checkOut("The Lorax by Dr. Seuss");
      library1.printCollection();
    }
  
  }