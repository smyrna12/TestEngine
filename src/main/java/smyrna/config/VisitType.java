
package smyrna.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for visitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="visitType">
 *   &lt;complexContent>
 *     &lt;extension base="{}activityType">
 *       &lt;sequence>
 *         &lt;element name="firstTouch" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="newVisitor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "visitType", propOrder = {
    "firstTouch",
    "newVisitor",
    "source",
    "visitorId"
})
@XmlSeeAlso({
    VisitResourceType.class,
    VisitProductType.class,
    VisitCategoryType.class
})
public class VisitType
    extends ActivityType
{

    protected boolean firstTouch;
    protected boolean newVisitor;
    @XmlElement(required = true)
    protected String source;
    @XmlElement(required = true)
    protected String visitorId;

    /**
     * Gets the value of the firstTouch property.
     * 
     */
    public boolean isFirstTouch() {
        return firstTouch;
    }

    /**
     * Sets the value of the firstTouch property.
     * 
     */
    public void setFirstTouch(boolean value) {
        this.firstTouch = value;
    }

    /**
     * Gets the value of the newVisitor property.
     * 
     */
    public boolean isNewVisitor() {
        return newVisitor;
    }

    /**
     * Sets the value of the newVisitor property.
     * 
     */
    public void setNewVisitor(boolean value) {
        this.newVisitor = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
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

}
