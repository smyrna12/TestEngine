package smyrna.tester;

/**
 * Created by Erdem.Akdogan on 6/4/15
 */
public class Consts {

    public static final int VISIT_RESOURCE_COUNT_START_INCLUSIVE = 10;
    public static final int VISIT_RESOURCE_COUNT_END_EXCLUSIVE = 30;

    public static final int PRODUCT_QUANTITY_START_INCLUSIVE = 1;
    public static final int PRODUCT_QUANTITY_END_EXCLUSIVE = 5;

    public static final int UNIT_PRICE_START_INCLUSIVE = 10;
    public static final int UNIT_PRICE_END_EXCLUSIVE = 50;

    public static final int SESSION_ID_LENGTH = 2;
    public static final int VISITOR_ID_LENGTH = 2;

    public static final double SIGNUP_COUNT_PERCENTAGE = 0.2;
    public static final double NEWSLETTER_SUBSCRIBE_COUNT_PERCENTAGE = 0.3;

    public static final double CHECKOUT_START_COUNT_PERCENTAGE = 0.2;
    public static final double CHECKOUT_COMPLETED_COUNT_PERCENTAGE = 0.5;
    public static final double CART_ADDPRODUCT_COUNT_PERCENTAGE = 0.3;

    public static final double VISIT_CATEGORY_COUNT_PERCENTAGE = 0.1;

    public static final double VISIT_PRODUCT_COUNT_PERCENTAGE = 0.1;

    public static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss";
    public static final String DATE_PATTERN2 = "yyyy-MM-dd'T'HH:mm:ssZ";


    /**
     * The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, and so on. Thus, the caller should be prevented from
     * constructing objects of this class, by declaring this private constructor.
     */
    private Consts() {
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
}
