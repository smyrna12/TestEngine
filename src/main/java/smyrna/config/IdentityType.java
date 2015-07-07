
package smyrna.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identityType">
 *   &lt;complexContent>
 *     &lt;extension base="{}activityType">
 *       &lt;sequence>
 *         &lt;element name="visitorId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identityType", propOrder = {
    "visitorId"
})
@XmlSeeAlso({
    IdentitySignupType.class
})
public class IdentityType
    extends ActivityType
{

    @XmlElement(required = true)
    protected String visitorId;

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

}
