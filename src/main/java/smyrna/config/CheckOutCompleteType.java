package smyrna.config;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for checkOutCompleteType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="checkOutCompleteType">
 *   &lt;complexContent>
 *     &lt;extension base="{}checkoutType">
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
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkOutCompleteType", propOrder = {
        "totalAmount",
        "productQuantity",
        "visitorId"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
public class CheckOutCompleteType
        extends CheckoutType {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    protected BigDecimal totalAmount;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    protected int productQuantity;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    protected String visitorId;

    /**
     * Gets the value of the totalAmount property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the productQuantity property.
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Sets the value of the productQuantity property.
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    public void setProductQuantity(int value) {
        this.productQuantity = value;
    }

    /**
     * Gets the value of the visitorId property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    public String getVisitorId() {
        return visitorId;
    }

    /**
     * Sets the value of the visitorId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T03:55:33+03:00", comments = "JAXB RI v2.2.4-2")
    public void setVisitorId(String value) {
        this.visitorId = value;
    }

}
