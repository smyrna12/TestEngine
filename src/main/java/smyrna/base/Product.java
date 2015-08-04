package smyrna.base;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Erdem.Akdogan on 6/4/15
 */
public class Product {
    private final Integer modelCode;
    private final String modelName;
    private final String name;
    private final BigDecimal unitPrice;
    private final Integer quantity;
    private final String itemCode;
    private final String currency;
    private final BigDecimal totalPrice;
    private final List<Category> categories;

    //private constructor to enforce object creation through builder
    private Product(Builder builder) {
        this.modelCode = builder.modelCode;
        this.name = builder.name;
        this.unitPrice = builder.unitPrice;
        this.quantity = builder.quantity;
        this.itemCode = builder.itemCode;
        this.currency = builder.currency;
        this.totalPrice = builder.totalPrice;
        this.modelName = builder.modelName;
        this.categories = builder.categories;
    }

    public Integer getModelCode() {
        return modelCode;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public final List<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        String categoriesStr = "";
        if (categories != null) {
            for (Category category : categories) {
                categoriesStr += "," + category.toString();
            }
            categoriesStr = categoriesStr.substring(1, categoriesStr.length());
        }

        return "modelCode=" + modelCode +
                "; modelName='" + modelName + '\'' +
                "; name='" + name + '\'' +
                "; unitPrice=" + unitPrice +
                "; quantity=" + quantity +
                "; itemCode='" + itemCode + '\'' +
                "; currency='" + currency + '\'' +
                "; totalPrice=" + totalPrice +
                "; categories=" + categoriesStr;
    }

    public static class Builder {
        private Integer modelCode;
        private String modelName;
        private String name;
        private BigDecimal unitPrice;
        private Integer quantity;
        private String itemCode;
        private String currency;
        private BigDecimal totalPrice;
        private List<Category> categories;

        //builder methods for setting property
        public Builder modelCode(Integer modelCode) {
            this.modelCode = modelCode;
            return this;
        }

        public Builder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder unitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder itemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder totalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder categories(List<Category> categories) {
            this.categories = categories;
            return this;
        }

        //return fully build object
        public Product build() {
            return new Product(this);
        }
    }
}
