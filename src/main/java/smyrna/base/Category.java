package smyrna.base;

/**
 * Created by Erdem.Akdogan on 7/21/15
 */
public class Category {
    private String categoryName;
    private Integer categoryId;

    //private constructor to enforce object creation through builder
    private Category(Builder builder) {
        this.categoryName = builder.categoryName;
        this.categoryId = builder.categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "categoryName='" + categoryName + '\'' + "; categoryId=" + categoryId;
    }

    public static class Builder {
        private Integer categoryId;
        private String categoryName;

        //builder methods for setting property
        public Builder categoryId(Integer categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        //return fully build object
        public Category build() {
            return new Category(this);
        }
    }
}
