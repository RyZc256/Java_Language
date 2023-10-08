package com.poji;

import java.util.List;

public class Category {
    private int id;
    private String typename;

    private List<Product> products;

    public int getId() {
        return id;
    }

    public String getTypename() {
        return typename;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", products=" + products +
                '}';
    }
}
