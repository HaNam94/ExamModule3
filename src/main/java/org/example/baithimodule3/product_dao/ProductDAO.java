package org.example.baithimodule3.product_dao;



import org.example.baithimodule3.model.Category;
import org.example.baithimodule3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    public void create(Product el) throws SQLException;

    public Product findById(String id);

    public List<Product> findAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(String id, Product el) throws SQLException;

    List<Product> findByName(String str);

    // list 2
    List<Category> findAllCateGory();
}
