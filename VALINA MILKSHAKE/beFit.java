public class beFit {
    // Instance variables
    String category;
    String equipment;
    String price; // Stored as string, will convert to integer when needed

    // Constructor
    public beFit(String category, String equipment, String price) {
        this.category = category;
        this.equipment = equipment;
        this.price = price;
    }

    // Method to display equipment details
    public void displayDetails() {
        System.out.println("Category: " + category + ", Equipment: " + equipment + ", Price: R" + price);
    }

    // Method to sort array using bubble sort by price (ascending)
    public static void bubbleSortByPrice(beFit[] equipmentList) {
        int n = equipmentList.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int price1 = Integer.parseInt(equipmentList[j].price);
                int price2 = Integer.parseInt(equipmentList[j + 1].price);
                if (price1 > price2) {
                    // Swap
                    beFit temp = equipmentList[j];
                    equipmentList[j] = equipmentList[j + 1];
                    equipmentList[j + 1] = temp;
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Declare and initialize array of beFit objects
        beFit[] equipmentList = new beFit[4];
        equipmentList[0] = new beFit("Cardio", "Treadmill", "7000");
        equipmentList[1] = new beFit("Strength Training", "Dumbbells", "300");
        equipmentList[2] = new beFit("Flexibility", "Yoga Mat", "150");
        equipmentList[3] = new beFit("Endurance", "Resistance Bands", "200");

        // Sort equipment by price
        bubbleSortByPrice(equipmentList);

        // Display sorted equipment using for-each loop
        System.out.println("Sorted Equipment List by Price:");
        for (beFit equipment : equipmentList) {
            equipment.displayDetails();
        }
    }
}
