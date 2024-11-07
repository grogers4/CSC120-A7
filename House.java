import java.util.ArrayList;

public class House extends Building {
  /** declaring arraylist of residents */
  private ArrayList<String> residents;
  /** declaring boolean for whether house has dining hall */
  private Boolean hasDiningRoom;

  private Boolean hasElevator;


 /* Default constructor */
 public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, false, 0);
}

/** Overloaded constructor without number of residents
 * @param string name
 * @param string address
 * @param int number of floors
 * @param boolean has a dining room
 */
public House(String name, String address, int nFloors, Boolean hasDiningRoom) {
    this(name, address, nFloors, hasDiningRoom, 0);  //name set as address and nResidents set to 0
}

/** Overloaded constructor without building name
 * constructor for unnamed houses with address as name
 * @param string address
 * @param int number of floors
 * @param boolean has a dining room
 * @param int number of residents
 */
public House(String address, int nFloors, Boolean hasDiningRoom, int nResidents) {
    this(address, address, nFloors, hasDiningRoom, nResidents); //name set as address
}


/** constructor for building class
 * @param string name
 * @param string address
 * @param int number of floors
 * @param boolean has a dining room
 * @param int number of residents
 */
  public House(String name, String address, int nFloors, Boolean hasDiningRoom, int nResidents) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;

    this.residents = new ArrayList<String>(nResidents);
    System.out.println("You have built a house: 🏠");
  }

  /**getter for boolean of whether house has dining room
   * @returns hasDiningRoom
   */
  public Boolean getHasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**getter for number of residents
   * @returns size of arraylist of residents
   */
  public int getNResidents() {
    return this.residents.size();
  }

  /**method to add a resident to the residents arraylist
   * @param string of resident's name
   * adds the resident to residents
   */
  public void moveIn(String name) {
    residents.add(name);
  }

  /**method to remove a resident from the residents arraylist
   * @param string of resident's name
   * removed the resident from residents
   */
  public void moveOut(String name) {
    residents.remove(name);
  }

  /**method to print options 
   * overrides method from building class and addds house-specific methods to printed list
  */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + getHasDiningHall()\n + getNResidents()\n + moveIn(name)\n + moveOut(name)");
  }

  /**method to check if someone is a resident of the house
   * @param string of person's name
   * checks if the name is in residents
   * @returns boolean based on whether or not the person is a resident
   */
  public boolean isResident(String person) {
    Boolean contains = residents.contains(name);
    return contains;
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
    House house1 = new House("house1", "1000 Chapin Way", 1, false, 2);
    house1.moveIn("Amelia");
    house1.moveIn("Jeff");
    if (house1.hasDiningRoom) {
      System.out.println("this house has a dining hall");
    } else {
      System.out.println("this house does not have a dining hall");
    }
  }
}