
package smyrna.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for visitProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="visitProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{}visitType">
 *       &lt;sequence>
 *         &lt;element name="modelCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visitProductType", propOrder = {
    "modelCode",
    "productName",
    "productQuantity",
    "modelName"
})
public class VisitProductType
    extends VisitType
{

    protected int modelCode;
    @XmlElement(required = true)
    protected String productName;
    protected int productQuantity;
    @XmlElement(required = true)
    protected String modelName;

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

}
