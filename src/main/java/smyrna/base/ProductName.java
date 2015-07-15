package smyrna.base;

/**
 * Created by Erdem.Akdogan on 6/10/15
 */
public enum ProductName {
    SamsungRugbyA837("Cell phones", 43, "t-200"),
    CustomTShirt("Apparel & Shoes", 10, "t-400"),
    Madmax("Movies", 9, "t-600"),
    Avengers("Movies", 38, "t-800");

    public String category;
    public int modelCode;
    public String modelName;

    ProductName(String category, int modelCode, String modelName) {
        this.category = category;
        this.modelCode = modelCode;
        this.modelName = modelName;
    }

    public static ProductName getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
