package smyrna.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erdem.Akdogan on 6/4/15
 */
public class Data {
    private boolean newVisitor;
    private boolean firstTouch;
    private BigDecimal totalAmount;
    private int orderId;
    private List<Product> products;

    public boolean isNewVisitor() {
        return newVisitor;
    }

    public void setNewVisitor(boolean newVisitor) {
        this.newVisitor = newVisitor;
    }

    public boolean isFirstTouch() {
        return firstTouch;
    }

    public void setFirstTouch(boolean firstTouch) {
        this.firstTouch = firstTouch;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<Product>();
        }

        return products;
    }
}
