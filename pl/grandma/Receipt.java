package pl.grandma;

import java.util.*;

public class Receipt {

    private String receipt;
    private List<Product> products;

    public List<Product> getReceiptAsList(String receipt) {
        products = new ArrayList<>();
        String[] dividedProducts = getDividedProduct(receipt);

        for (int i = 0; i < dividedProducts.length; i++) {
            String[] finalDivided = dividedProducts[i].split(":");

            products.add(new Product(finalDivided[0],
                    Integer.parseInt(finalDivided[1]),
                    Double.parseDouble(finalDivided[2])));
        }

        return products;
    }

    private String[] getDividedProduct(String receipt) {
        String[] dividedProducts = receipt.split("/");
        return dividedProducts;
    }

    public double getValueOfAllProducts() {
        double value = 0;
        for (Product p : products) {
            value = value + (p.getValue() * p.getQuantity());
        }
        return value;
    }

    public void getCheatedProduct() {
        Set<Product> cheatedProducts = new HashSet<>();
        cheatedProducts.stream().sorted();
                //sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (Product p : products) {
            for (Product p1 : products) {
                if (p.equals(p1)) {
                    continue;
                } else if ((p.getName().equals(p1.getName())) && (p.getValue() != p1.getValue())) {
                    cheatedProducts.add(p);
                }
            }
        }
        System.out.println(cheatedProducts);
    }

    public void getTheMostValuableProduct() {
        double max = 0;
        Product product = null;
        for (Product p : products) {
            if (p.getValue() > max) {
                max = p.getValue();
                product = p;
            }
        }
        System.out.println("The most valuable product is: " + product);

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final double FIVE = 5.0;
    private final double TWO = 2.0;
    private final double TWENTY_GR = 0.2;
    private final double TEN_GR = 0.1;
    private final double FIVE_GR = 0.05;
    private final double ONE_GR = 0.01;

    public void whichAndHowManyCoins() {
        double[] coins = {FIVE, TWO, TWENTY_GR, TEN_GR, FIVE_GR, ONE_GR};
        double finallyValue = getValueOfAllProducts();
        double rest = finallyValue;

        for (int i = 0; i < coins.length; i++) {
            int counter = 0;
            while (rest - coins[i] >= 0) {
                rest = rest - coins[i];
                counter++;
            }
            if (counter > 0) {
                System.out.println("Which coins: " + coins[i] + " zł" + " | Number of coins: " + counter);
            }
        }
    }
}
