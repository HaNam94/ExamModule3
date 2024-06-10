package org.example.baithimodule3.product_dao;

public class ProductDAO {
    public void create(Product el) throws SQLException;

    public Product findById(String id);

    public List<Product> findAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(String id, Product el) throws SQLException;

    List<Product> findByName(String str);
}
