package smyrna.base;

/**
 * Created by Erdem.Akdogan on 6/10/15
 */
public enum ProductName {
    SamsungRugbyA837(1, "Cell phones", 43, "t-200"),
    CustomTShirt(2, "Apparel & Shoes", 10, "t-400"),
    Madmax(3, "Movies", 9, "t-600"),
    Avengers(4, "Movies", 38, "t-800");

    public int categoryId;
    public String categoryName;
    public int modelCode;
    public String modelName;

    ProductName(int categoryId, String categoryName, int modelCode, String modelName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.modelCode = modelCode;
        this.modelName = modelName;
    }

    public static ProductName getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
