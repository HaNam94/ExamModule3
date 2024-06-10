package org.example.baithimodule3.product_dao;


import org.example.baithimodule3.common.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAOImplement implements ProductDAO{
    /* ....................... Table and Column ......................*/
    private static final String TABLE_NAME = " `product` ";

    private static final String COL_NAME_1 = "product_id";
    private static final String COL_NAME_2 = "product_name";
    private static final String COL_NAME_3 = "product_price";
    private static final String COL_NAME_4 = "product_quantity";
    private static final String COL_NAME_5 = "product_color";
    private static final String COL_NAME_6 = "product_description";
    private static final String COL_NAME_7 = "product_category";


    private static final String cm = ",";
    private static final String eq = " = ?";
    /* .......................... Table end .........................*/

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private static final String INSERT_INTO = "INSERT INTO " + TABLE_NAME
            + "(" +
            COL_NAME_1 + cm +
            COL_NAME_2 + cm +
            COL_NAME_3 + cm +
            COL_NAME_4 + cm +
            COL_NAME_5 + cm +
            COL_NAME_6 + cm +
            COL_NAME_7
            + ")"
            +  " VALUES (?,?,?,?,?,?,?);"; // 7 cols--ok

    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String UPDATE_SET = "UPDATE " + TABLE_NAME + " SET " +
            COL_NAME_1 + eq + cm +
            COL_NAME_2 + eq + cm +
            COL_NAME_3 + eq + cm +
            COL_NAME_4 + eq + cm +
            COL_NAME_5 + eq + cm +
            COL_NAME_6 + eq + cm +
            COL_NAME_7 + eq
            + " WHERE " + COL_NAME_1 + eq;

    private static final String DELETE_FROM = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME_1 + eq;

    private static final String SELECT_BY_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE `product_name` like ?"; // $$$$$$$$$$$

    @Override
    public void create(Product el) throws SQLException {
        // 1.Open new connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                // 2.Create a statement with connection object, and setting
                statement = connection.prepareStatement(INSERT_INTO);
                statement.setInt(1, Integer.parseInt(el.getProductId()));
                statement.setString(2, el.getProductName());
                statement.setString(3, el.getProductPrice());
                statement.setString(4, el.getProductQuantity());
                statement.setString(5, el.getProductColor());

                @Override
                public List<Product> findAll() {
                    Connection connection = DBConnection.getConnection();
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    List<Product> eList = new ArrayList<>();
                    Product el = null;

                    if(connection != null) {
                        try {
                            statement = connection.prepareStatement(SELECT_ALL);
                            resultSet = statement.executeQuery();

                            while (resultSet.next()) {
                                el = new Product();
                                el.setProductId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                                el.setProductName(resultSet.getString(COL_NAME_2));
                                el.setProductPrice(resultSet.getString(COL_NAME_3));
                                el.setProductQuantity(resultSet.getString(COL_NAME_4));
                                el.setProductColor(resultSet.getString(COL_NAME_5));
                                el.setProductDescription(resultSet.getString(COL_NAME_6));
                                el.setProductCategory(resultSet.getString(COL_NAME_7));

                                eList.add(el);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            DBConnection.close();
                        }
                    }
                    return eList;
                }


                @Override
                public Product findById(String id) {
                    Connection connection = DBConnection.getConnection();
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    Product el = null;

                    if(connection != null) {
                        try {
                            statement = connection.prepareStatement(SELECT_BY_ID);
                            statement.setInt(1, Integer.parseInt(id));
                            resultSet = statement.executeQuery();

                            if (resultSet.next()) {
                                el = new Product();
                                el.setProductId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                                el.setProductName(resultSet.getString(COL_NAME_2));
                                el.setProductPrice(resultSet.getString(COL_NAME_3));
                                el.setProductQuantity(resultSet.getString(COL_NAME_4));
                                el.setProductColor(resultSet.getString(COL_NAME_5));
                                el.setProductDescription(resultSet.getString(COL_NAME_6));
                                el.setProductCategory(resultSet.getString(COL_NAME_7));

                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            DBConnection.close();
                        }
                    }
                    return el;
                }


                @Override
                public List<Product> findByName(String str) {
                    Connection connection = DBConnection.getConnection();
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    List<Product> eList = new ArrayList<>();
                    Product el = null;

                    if (connection != null) {
                        try {
                            statement = connection.prepareStatement(SELECT_BY_NAME);
                            statement.setString(1, "%" + str + "%");
                            resultSet = statement.executeQuery();

                            while (resultSet.next()) {
                                el = new Product();
                                el.setProductId(String.valueOf(resultSet.getInt(COL_NAME_1)));
                                el.setProductName(resultSet.getString(COL_NAME_2));
                                el.setProductPrice(resultSet.getString(COL_NAME_3));
                                el.setProductQuantity(resultSet.getString(COL_NAME_4));
                                el.setProductColor(resultSet.getString(COL_NAME_5));
                                el.setProductDescription(resultSet.getString(COL_NAME_6));
                                el.setProductCategory(resultSet.getString(COL_NAME_7));

                                eList.add(el);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            DBConnection.close();
                        }
                    }
                    return eList;
                }

                @Override
                public List<Category> findAllCateGory() {
                    Connection connection = DBConnection.getConnection();
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    List<Category> eList2 = new ArrayList<>();
                    Category el = null;
                    String findAllCategory = "select * from `category`";

                    if(connection != null) {
                        try {
                            statement = connection.prepareStatement(findAllCategory);
                            resultSet = statement.executeQuery();

                            while (resultSet.next()) {
                                el = new Category();
                                el.setCategoryId((resultSet.getString("category_id")));
                                el.setCategoryName(resultSet.getString("category_name"));
                                eList2.add(el);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            DBConnection.close();
                        }
                    }
                    return eList2;
                }

                List<Category> findAllCateGory();
}
