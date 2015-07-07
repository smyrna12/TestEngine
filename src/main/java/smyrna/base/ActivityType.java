package smyrna.base;

/**
 * Created by Erdem.Akdogan on 6/1/15
 */
public enum ActivityType {
    CC("CHECKOUT.COMPLETED", "43"),
    VR("VISIT.RESOURCE", "1"),
    IS("IDENTITY.SIGNUP", "21"),
    VC("VISIT.CATEGORY", "5"),
    VP("VISIT.PRODUCT", "9"),
    CS("CHECKOUT.START", "38"),
    CA("CART.ADDPRODUCT", "32"),
    NS("NEWSLETTER.SUBSCRIBE", "14");

    public String value;
    public String num;

    ActivityType(String value, String num) {
        this.value = value;
        this.num = num;
    }
}