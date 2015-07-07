
package smyrna.config;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the smyrna.config package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProfileCheckoutCompleted_QNAME = new QName("", "checkoutCompleted");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: smyrna.config
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Profile }
     * 
     */
    public Profile createProfile() {
        return new Profile();
    }

    /**
     * Create an instance of {@link SmyrnaConfig }
     * 
     */
    public SmyrnaConfig createSmyrnaConfig() {
        return new SmyrnaConfig();
    }

    /**
     * Create an instance of {@link Profile.DateInterval }
     * 
     */
    public Profile.DateInterval createProfileDateInterval() {
        return new Profile.DateInterval();
    }

    /**
     * Create an instance of {@link CheckoutCompletedType }
     * 
     */
    public CheckoutCompletedType createCheckoutCompletedType() {
        return new CheckoutCompletedType();
    }

    /**
     * Create an instance of {@link IdentitySignupType }
     * 
     */
    public IdentitySignupType createIdentitySignupType() {
        return new IdentitySignupType();
    }

    /**
     * Create an instance of {@link VisitResourceType }
     * 
     */
    public VisitResourceType createVisitResourceType() {
        return new VisitResourceType();
    }

    /**
     * Create an instance of {@link VisitProductType }
     * 
     */
    public VisitProductType createVisitProductType() {
        return new VisitProductType();
    }

    /**
     * Create an instance of {@link VisitCategoryType }
     * 
     */
    public VisitCategoryType createVisitCategoryType() {
        return new VisitCategoryType();
    }

    /**
     * Create an instance of {@link CheckoutStartType }
     * 
     */
    public CheckoutStartType createCheckoutStartType() {
        return new CheckoutStartType();
    }

    /**
     * Create an instance of {@link CartAddproductType }
     * 
     */
    public CartAddproductType createCartAddproductType() {
        return new CartAddproductType();
    }

    /**
     * Create an instance of {@link NewsletterSubscribeType }
     * 
     */
    public NewsletterSubscribeType createNewsletterSubscribeType() {
        return new NewsletterSubscribeType();
    }

    /**
     * Create an instance of {@link IdentityType }
     * 
     */
    public IdentityType createIdentityType() {
        return new IdentityType();
    }

    /**
     * Create an instance of {@link CartType }
     * 
     */
    public CartType createCartType() {
        return new CartType();
    }

    /**
     * Create an instance of {@link CheckoutType }
     * 
     */
    public CheckoutType createCheckoutType() {
        return new CheckoutType();
    }

    /**
     * Create an instance of {@link ActivityType }
     * 
     */
    public ActivityType createActivityType() {
        return new ActivityType();
    }

    /**
     * Create an instance of {@link NewsletterType }
     * 
     */
    public NewsletterType createNewsletterType() {
        return new NewsletterType();
    }

    /**
     * Create an instance of {@link VisitType }
     * 
     */
    public VisitType createVisitType() {
        return new VisitType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckoutCompletedType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "checkoutCompleted", scope = Profile.class)
    public JAXBElement<CheckoutCompletedType> createProfileCheckoutCompleted(CheckoutCompletedType value) {
        return new JAXBElement<CheckoutCompletedType>(_ProfileCheckoutCompleted_QNAME, CheckoutCompletedType.class, Profile.class, value);
    }

}
