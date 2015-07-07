package smyrna.config;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element ref="{}profile"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "profile"
})
@XmlRootElement(name = "smyrna")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T11:23:20+03:00", comments = "JAXB RI v2.2.4-2")
public class Smyrna {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T11:23:20+03:00", comments = "JAXB RI v2.2.4-2")
    protected List<Profile> profile;

    /**
     * Gets the value of the profile property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profile property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfile().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Profile }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-06-09T11:23:20+03:00", comments = "JAXB RI v2.2.4-2")
    public List<Profile> getProfile() {
        if (profile == null) {
            profile = new ArrayList<Profile>();
        }
        return this.profile;
    }

}
