package pl.grandma;

import java.util.Scanner;

public class Menu {
    Receipt receipt = new Receipt();

   // String rec = "Śliwki:30:2.5/Masło:20:6.20/Kapusta:2:3/Jabłka:5:4/Margaryna:10:20/Śliwki:10:2.5/Majonez:8:4/Jabłka:10:4/Kapusta:5:3/Śliwki:20:3.20/Masło:2:3.33/Kiełbasa:2:4.44/Ciasto:4:2.22";

    public void showOptions() {
        System.out.println("[1] Enter receipt : name_of_product:quantity_of_roduct:product_value/next_product... Like: Plums:30:2.5/Butter:20:6.20/Juice:2:3 ");
        System.out.println("[2] Get the most valuable product.");
        System.out.println("[3] Get value of all products.");
        System.out.println("[4] Show cheated products.");
        System.out.println("[5] Check which coins and how many You should take.");
        System.out.println("[x] Exit");
    }

    public void showMenu() {
        showOptions();
        Scanner in = new Scanner(System.in);
        String rec;
        String choice;
        do {
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    rec = in.nextLine();
                    receipt. getReceiptAsList(rec);
                    System.out.println("Receipt is converted");
                    break;
                case "2":
                    try {
                        receipt.getTheMostValuableProduct();
                    }catch (Exception e){
                        System.out.println("You have not entered receipt");
                    }
                    break;
                case "3":
                    try {
                        System.out.println(receipt.getValueOfAllProducts());
                    }catch (Exception e){
                        System.out.println("You have not entered receipt");
                    }
                    break;
                case "4":
                    try {
                        receipt.getCheatedProduct();
                    }catch (Exception e){
                        System.out.println("You have not entered receipt");
                    }
                    break;
                case "5":
                    try {
                        receipt.whichAndHowManyCoins();
                    }catch (Exception e){
                        System.out.println("You have not entered receipt");
                    }
                    break;
                case "x":
                    break;
                default:
                    System.out.println("You entered wrong data");
                    break;

            }
        } while (!choice.equals("x"));
    }
}
