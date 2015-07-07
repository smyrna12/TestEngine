
package smyrna.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cartAddproductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cartAddproductType">
 *   &lt;complexContent>
 *     &lt;extension base="{}cartType">
 *       &lt;sequence>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="visitorId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cartAddproductType", propOrder = {
    "productName",
    "visitorId",
    "productQuantity"
})
public class CartAddproductType
    extends CartType
{

    @XmlElement(required = true)
    protected String productName;
    @XmlElement(required = true)
    protected String visitorId;
    protected int productQuantity;

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

}
