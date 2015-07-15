
package smyrna.config;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generationMethod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="auto"/>
 *               &lt;enumeration value="manual"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dateInterval">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="startDate">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *                         &lt;minExclusive value="1900-01-01"/>
 *                         &lt;maxExclusive value="4712-01-01"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="endDate">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *                         &lt;minExclusive value="1900-01-01"/>
 *                         &lt;maxExclusive value="4712-01-01"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="environment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="checkoutCompleted" type="{}checkoutCompletedType"/>
 *           &lt;element name="identitySignup" type="{}identitySignupType"/>
 *           &lt;element name="visitResource" type="{}visitResourceType"/>
 *           &lt;element name="visitProduct" type="{}visitProductType"/>
 *           &lt;element name="visitCategory" type="{}visitCategoryType"/>
 *           &lt;element name="checkoutStart" type="{}checkoutStartType"/>
 *           &lt;element name="cartAddproduct" type="{}cartAddproductType"/>
 *           &lt;element name="newsletterSubscribe" type="{}newsletterSubscribeType"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "generationMethod",
    "dateInterval",
    "environment",
    "checkoutCompleted",
    "identitySignup",
    "visitResource",
    "visitProduct",
    "visitCategory",
    "checkoutStart",
    "cartAddproduct",
    "newsletterSubscribe"
})
@XmlRootElement(name = "profile")
public class Profile {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String generationMethod;
    @XmlElement(required = true)
    protected Profile.DateInterval dateInterval;
    @XmlElement(required = true)
    protected String environment;
    @XmlElementRef(name = "checkoutCompleted", type = JAXBElement.class, required = false)
    protected JAXBElement<CheckoutCompletedType> checkoutCompleted;
    protected IdentitySignupType identitySignup;
    protected VisitResourceType visitResource;
    protected VisitProductType visitProduct;
    protected VisitCategoryType visitCategory;
    protected CheckoutStartType checkoutStart;
    protected CartAddproductType cartAddproduct;
    protected NewsletterSubscribeType newsletterSubscribe;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the generationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerationMethod() {
        return generationMethod;
    }

    /**
     * Sets the value of the generationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerationMethod(String value) {
        this.generationMethod = value;
    }

    /**
     * Gets the value of the dateInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Profile.DateInterval }
     *     
     */
    public Profile.DateInterval getDateInterval() {
        return dateInterval;
    }

    /**
     * Sets the value of the dateInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Profile.DateInterval }
     *     
     */
    public void setDateInterval(Profile.DateInterval value) {
        this.dateInterval = value;
    }

    /**
     * Gets the value of the environment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnvironment(String value) {
        this.environment = value;
    }

    /**
     * Gets the value of the checkoutCompleted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CheckoutCompletedType }{@code >}
     *     
     */
    public JAXBElement<CheckoutCompletedType> getCheckoutCompleted() {
        return checkoutCompleted;
    }

    /**
     * Sets the value of the checkoutCompleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CheckoutCompletedType }{@code >}
     *     
     */
    public void setCheckoutCompleted(JAXBElement<CheckoutCompletedType> value) {
        this.checkoutCompleted = value;
    }

    /**
     * Gets the value of the identitySignup property.
     * 
     * @return
     *     possible object is
     *     {@link IdentitySignupType }
     *     
     */
    public IdentitySignupType getIdentitySignup() {
        return identitySignup;
    }

    /**
     * Sets the value of the identitySignup property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentitySignupType }
     *     
     */
    public void setIdentitySignup(IdentitySignupType value) {
        this.identitySignup = value;
    }

    /**
     * Gets the value of the visitResource property.
     * 
     * @return
     *     possible object is
     *     {@link VisitResourceType }
     *     
     */
    public VisitResourceType getVisitResource() {
        return visitResource;
    }

    /**
     * Sets the value of the visitResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisitResourceType }
     *     
     */
    public void setVisitResource(VisitResourceType value) {
        this.visitResource = value;
    }

    /**
     * Gets the value of the visitProduct property.
     * 
     * @return
     *     possible object is
     *     {@link VisitProductType }
     *     
     */
    public VisitProductType getVisitProduct() {
        return visitProduct;
    }

    /**
     * Sets the value of the visitProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisitProductType }
     *     
     */
    public void setVisitProduct(VisitProductType value) {
        this.visitProduct = value;
    }

    /**
     * Gets the value of the visitCategory property.
     * 
     * @return
     *     possible object is
     *     {@link VisitCategoryType }
     *     
     */
    public VisitCategoryType getVisitCategory() {
        return visitCategory;
    }

    /**
     * Sets the value of the visitCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisitCategoryType }
     *     
     */
    public void setVisitCategory(VisitCategoryType value) {
        this.visitCategory = value;
    }

    /**
     * Gets the value of the checkoutStart property.
     * 
     * @return
     *     possible object is
     *     {@link CheckoutStartType }
     *     
     */
    public CheckoutStartType getCheckoutStart() {
        return checkoutStart;
    }

    /**
     * Sets the value of the checkoutStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckoutStartType }
     *     
     */
    public void setCheckoutStart(CheckoutStartType value) {
        this.checkoutStart = value;
    }

    /**
     * Gets the value of the cartAddproduct property.
     * 
     * @return
     *     possible object is
     *     {@link CartAddproductType }
     *     
     */
    public CartAddproductType getCartAddproduct() {
        return cartAddproduct;
    }

    /**
     * Sets the value of the cartAddproduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CartAddproductType }
     *     
     */
    public void setCartAddproduct(CartAddproductType value) {
        this.cartAddproduct = value;
    }

    /**
     * Gets the value of the newsletterSubscribe property.
     * 
     * @return
     *     possible object is
     *     {@link NewsletterSubscribeType }
     *     
     */
    public NewsletterSubscribeType getNewsletterSubscribe() {
        return newsletterSubscribe;
    }

    /**
     * Sets the value of the newsletterSubscribe property.
     * 
     * @param value
     *     allowed object is
     *     {@link NewsletterSubscribeType }
     *     
     */
    public void setNewsletterSubscribe(NewsletterSubscribeType value) {
        this.newsletterSubscribe = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="startDate">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
     *               &lt;minExclusive value="1900-01-01"/>
     *               &lt;maxExclusive value="4712-01-01"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="endDate">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
     *               &lt;minExclusive value="1900-01-01"/>
     *               &lt;maxExclusive value="4712-01-01"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "startDate",
        "endDate"
    })
    public static class DateInterval {

        @XmlElement(required = true)
        protected XMLGregorianCalendar startDate;
        @XmlElement(required = true)
        protected XMLGregorianCalendar endDate;

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartDate(XMLGregorianCalendar value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the endDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEndDate() {
            return endDate;
        }

        /**
         * Sets the value of the endDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEndDate(XMLGregorianCalendar value) {
            this.endDate = value;
        }

    }

}
