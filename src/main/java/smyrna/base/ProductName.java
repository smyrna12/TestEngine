package smyrna.base;

/**
 * Created by Erdem.Akdogan on 6/10/15
 */
public enum ProductName {
    SamsungRugbyA837("Cell phones", 43),
    CustomTShirt("Apparel & Shoes", 10),
    Madmax("Movies", 9),
    Avengers("Movies", 38);

    public String category;
    public int modelCode;

    ProductName(String category, int modelCode) {
        this.category = category;
        this.modelCode = modelCode;
    }

    public static ProductName getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
