package com.zlq.day280.supliers;

import java.util.Comparator;
import java.util.Objects;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/4 11:56
 */
public class Product implements Comparable{


    private String id;

    private String name;

    private Double price;

    private String suppliers;


    public Product(String id, String name, Double price, String suppliers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.suppliers = suppliers;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", suppliers='" + suppliers + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, suppliers);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Product product = (Product) o;
//        return Objects.equals(id, product.id) && Objects.equals(name, product.name)
//                && Objects.equals(price, product.price) && Objects.equals(suppliers, product.suppliers);
//    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Product){
            Product product = (Product) o;
            return product.price.compareTo(this.price);
        }
        return 0;
    }
}
