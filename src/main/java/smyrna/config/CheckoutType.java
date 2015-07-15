
package smyrna.config;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkoutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkoutType">
 *   &lt;complexContent>
 *     &lt;extension base="{}activityType">
 *       &lt;sequence>
 *         &lt;element name="totalAmount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minExclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="productQuantity">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minExclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="visitorId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkoutType", propOrder = {
    "totalAmount",
    "productQuantity",
    "visitorId",
    "modelCode",
    "modelName",
    "productName"
})
@XmlSeeAlso({
    CheckoutCompletedType.class,
    CheckoutStartType.class
})
public class CheckoutType
    extends ActivityType
{

    @XmlElement(required = true)
    protected BigDecimal totalAmount;
    protected int productQuantity;
    @XmlElement(required = true)
    protected String visitorId;
    protected int modelCode;
    @XmlElement(required = true)
    protected String modelName;
    @XmlElement(required = true)
    protected String productName;

    /**
     * Gets the value of the totalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the productQuantity property.
     * 
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Sets the value of the productQuantity property.
     * 
     */
    public void setProductQuantity(int value) {
        this.productQuantity = value;
    }

    /**
     * Gets the value of the visitorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitorId() {
        return visitorId;
    }

    /**
     * Sets the value of the visitorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitorId(String value) {
        this.visitorId = value;
    }

    /**
     * Gets the value of the modelCode property.
     * 
     */
    public int getModelCode() {
        return modelCode;
    }

    /**
     * Sets the value of the modelCode property.
     * 
     */
    public void setModelCode(int value) {
        this.modelCode = value;
    }

    /**
     * Gets the value of the modelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the value of the modelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

}
