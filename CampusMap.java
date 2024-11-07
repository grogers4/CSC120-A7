import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive Northampton, MA 01063", 5));
        myMap.addBuilding(new Building("Campus Center", "100 Elm Street Northampton, MA 01063"));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Young Library"));
        myMap.addBuilding(new Library("Josten Library"));
        myMap.addBuilding(new House("Lamont House", "17 Prospect Street Noprthampton, MA 01063", 4, true, 85));
        myMap.addBuilding(new House("Gillett House", "47 Elm Street Northampton, MA 01063", 5, true, 80));
        myMap.addBuilding(new House("Chapin House", "3 Chapin Way Northampton, MA 01063", 4, true));
        myMap.addBuilding(new House("44 Green Street Northampton, MA 01063", 3, false, 20));
        myMap.addBuilding(new House("Tyler House", "164 Green Street, Northampton, MA 01063", 4, true));
        System.out.println(myMap);
    }
    
}
