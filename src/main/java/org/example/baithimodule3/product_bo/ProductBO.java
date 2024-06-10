package org.example.baithimodule3.product_bo;

import jdk.jfr.Category;

import java.sql.SQLException;
import java.util.List;

public class ProductBO {
    public void create(Product el) throws SQLException;

    public Product findById(String id);

    public List<Product> findAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(String id, Product el) throws SQLException;

    List<Product> findByName(String str);

    List<Category> findAllCateGory();
}
