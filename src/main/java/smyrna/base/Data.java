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
    private Integer orderId;
    private List<Product> products;
    private Category category;
    private String userName;
    private String fullName;
    private String gender;
    private String birthDate;
    private String age;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<Product>();
        }

        return products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        String totalAmountStr = "";
        if (totalAmount != null) {
            totalAmountStr = totalAmount.toString();
        }

        String orderIdStr = "";
        if (orderId != null) {
            orderIdStr = orderId.toString();
        }

        String productsStr = "";
        if (products != null) {
            for (Product product : products) {
                productsStr += "," + product.toString();
            }
            productsStr = productsStr.substring(1, productsStr.length());
        }

        String categoryStr = "";
        if (category != null) {
            categoryStr = category.toString();
        }

        return "newVisitor=" + newVisitor +
                "; firstTouch=" + firstTouch +
                "; totalAmount=" + totalAmountStr +
                "; orderId=" + orderIdStr +
                "; products=" + productsStr +
                "; category=" + categoryStr +
                "; userName='" + userName + '\'' +
                "; fullName='" + fullName + '\'' +
                "; gender='" + gender + '\'' +
                "; birthDate='" + birthDate + '\'' +
                "; age='" + age + '\'';
    }
}
