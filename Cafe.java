public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /** constructor for building class
    * @param string name
    * @param string address
    * @param int number of floors
    * @param int number of coffee ounces
    * @param int number of sugar packets
    * @param int number of creams
    * @param number of cups
    */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**overloaded constructor for cafe with only name and address
     * calls standard constructor and sets nFloors to 1 and all inventory iteams to 0
     * @param string name
     * @param string address
     */
    public Cafe(String name, String address) {
        this(name, address, 1, 0, 0, 0, 0);
    }

    public void goToFloor(int n) {
        if (n != 1) {
            System.out.println("sorry, customers are not permitted to access other floors");
        } else {
            super.goToFloor(1);
        }  
    }

    /**method to sell a cup of coffee
     * decreases the iteams in the inventory to account for the sale
     * @param int size of coffee in ounces
     * @param int number of sugar packets
     * @param int number of creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("here is your coffee");
    }

    /**overloaded method to sell a cup of coffee with no cream or surgar
     * calls standard sellCoffee method and sets nCream and nSugar to 0
     * @param int size of coffee in ounces
     */
    public void sellCoffee(int size) {
        this.sellCoffee(size, 0, 0);
    }

    
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**method to print options 
   * overrides method from building class and addds cafe-specific methods to printed list
   */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }

    public static void main(String[] args) {
        Cafe cafe1 = new Cafe("cafe1", "1 Main Street", 1, 1000, 100, 150, 300);
        cafe1.sellCoffee(12, 1, 0);
        cafe1.restock(100, 50, 50, 0);
    }
    
}