package smyrna.base.stats;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by Erdem.Akdogan on 6/19/15
 */
public class CheckoutStats extends Stats {
    private int oldVisCCCount = 0;
    private int prodSaleCount = 0;
    private int daysToFirstCheckoutCompletedDate = 0;
    private DateTime firstCheckoutCompletedDate;
    private BigDecimal totEndorsement = new BigDecimal(BigInteger.ZERO);
    private HashMap<String, String> visitorMap2 = new HashMap<>();

    public CheckoutStats(int count) {
        super(count);
    }

    public int getOldVisCCCount() {
        return oldVisCCCount;
    }

    public void setOldVisCCCount(int oldVisCCCount) {
        this.oldVisCCCount = oldVisCCCount;
    }

    public int getProdSaleCount() {
        return prodSaleCount;
    }

    public void setProdSaleCount(int prodSaleCount) {
        this.prodSaleCount = prodSaleCount;
    }

    public int getDaysToFirstCheckoutCompletedDate() {
        return daysToFirstCheckoutCompletedDate;
    }

    public void setDaysToFirstCheckoutCompletedDate(int daysToFirstCheckoutCompletedDate) {
        this.daysToFirstCheckoutCompletedDate = daysToFirstCheckoutCompletedDate;
    }

    public DateTime getFirstCheckoutCompletedDate() {
        return firstCheckoutCompletedDate;
    }

    public void setFirstCheckoutCompletedDate(DateTime firstCheckoutCompletedDate) {
        this.firstCheckoutCompletedDate = firstCheckoutCompletedDate;
    }

    public BigDecimal getTotEndorsement() {
        return totEndorsement;
    }

    public void setTotEndorsement(BigDecimal totEndorsement) {
        this.totEndorsement = totEndorsement;
    }

    public HashMap<String, String> getVisitorMap2() {
        return visitorMap2;
    }

    public void setVisitorMap2(HashMap<String, String> visitorMap2) {
        this.visitorMap2 = visitorMap2;
    }
}
