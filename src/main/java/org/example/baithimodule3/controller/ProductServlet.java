package org.example.baithimodule3.controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductBO productBO = new ProductBOImplement();
    // Set invalid message
    private static final String ID_INVALID = "The ID must be as format 'KH-XXXX'";
    private static final String NAME_INVALID = "The name not valid";
    private static final String BIRTHDAY_INVALID = "The birthday must made the age not less than 18";
    private static final String CARD_ID_INVALID = "The ID card number is not valid";
    private static final String EMAIL_INVALID = "The email is not valid";
    private static final String PHONE_INVALID = "The phone number must have 10 or 11 digits";
    private static final String INTEGER_INVALID = "The number is not valid";
    private static final String DOUBLE_INVALID = "The number is not valid";
    private static final String GENDER_INVALID = "Gender must be 'Male/Female/Unknown";
    private static final String TEXT_INVALID = "This field must not be empty.";

    // Attributes
    String element_name = "product";

    // Object's properties
    String title_id = "Product ID";//id
    String title_a = "Product Name";//a
    String title_b = "Product Price";//b
    String title_c = "Product Quantity";//c
    String title_d = "Product Color";//d
    String title_e = "Product Description";//e
    String title_f = "Product Category";//f

    /* ......... Extra ......... */

    // Titles
    String list_element = element_name + " List";
    String create_element = "Create new " + element_name;
    String delete_element = "Delete " + element_name;
    String edit_element = "Edit " + element_name;
    String view_element = "View " + element_name;
    String msg_create = "New " + element_name + " has been successfully created.";
    String msg_edit = "This " + element_name + " has been successfully updated.";
    String msg_delete = "Really want to delete this " + element_name + "?";
    String originalLink = "/" + element_name + "s";

    // Link JSP
    String listJSP = element_name + "/" + element_name + "_" + "list.jsp";
    String createJSP = element_name + "/" + element_name + "_" + "create.jsp";
    String editJSP = element_name + "/" + element_name + "_" + "edit.jsp";
    String deleteJSP = element_name + "/" + element_name + "_" + "delete.jsp";
    String viewJSP = element_name + "/" + element_name + "_" + "view.jsp";

    // Initial set attributes
    protected void initSetAttribute(HttpServletRequest request) {

        request.setAttribute("title_id", title_id);
        request.setAttribute("title_a", title_a);
        request.setAttribute("title_b", title_b);
        request.setAttribute("title_c", title_c);
        request.setAttribute("title_d", title_d);
        request.setAttribute("title_e", title_e);
        request.setAttribute("title_f", title_f);

        //extra....

        request.setAttribute("element_name", element_name);
        request.setAttribute("list_element", list_element);
        request.setAttribute("create_element", create_element);
        request.setAttribute("delete_element", delete_element);
        request.setAttribute("edit_element", edit_element);
        request.setAttribute("view_element", view_element);
        request.setAttribute("originalLink", originalLink);
    }

    // Forward to JSP
    protected void forwardJSP(HttpServletRequest request, HttpServletResponse response, String linkJSP) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(linkJSP);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

    // Redirect to JSP [HOME]
    protected void redirectTo(HttpServletResponse response, String linkToJSP) {
        try {
            response.sendRedirect(linkToJSP);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //_______________________________________________________________________________


    // POST (A) ---------------------------------------------------------------------
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createProduct(request, response); //$$$
                    break;
                case "edit":
                    editProduct(request, response); //$$$
                    break;
                case "delete":
                    deleteProduct(request, response); //$$$
                    break;
                case "search":
                    searchProduct(request, response); //$$$
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    //.................................. POST ends here ........................................

    // 3. create (post)
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");

        // IF NOT VALIDATE
        Product el = new Product(id, a, b, c, d, e, f);
        this.productBO.create(el);
        //request.setAttribute("el", el);
        request.setAttribute("msg_create", msg_create);
        List<Product> eList = this.productBO.findAll();
        request.setAttribute("eList", eList);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. edit (post)
    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");

        String idNew = request.getParameter("idNew");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");

        // IF NOT VALIDATE
        Product el = new Product(idNew,  a,b,c,d,e,f); //<!-- $$$ -->
        this.productBO.update(id, el);
        request.setAttribute("el", el);
        request.setAttribute("msg_edit", msg_edit);
        List<Product> eList = this.productBO.findAll();
        request.setAttribute("eList", eList);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. delete (post)
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        this.productBO.delete(id);
        redirectTo(response, originalLink);
    }
    /* ---------------------- end ------------------------ */


    // GET (B) ----------------------------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showViewForm(request, response);
                break;
            default:
                showProductList(request, response); //$$$
                break;
        }
    }
    // ..................................... GET ends here .................................


    // 1. SHOW LIST ____________________________________________________________________
    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> eList = this.productBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 2. SEARCH NAME __________________________________________________________________
    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("keywords");
        List<Product> eList = this.productBO.findByName(str);
        //eList.sort(new ContactSortByNameBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 3. CREATE NEW (REGISTER) ________________________________________________________
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> eList2= this.productBO.findAllCateGory();
        request.setAttribute("eList2", eList2);
        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. EDIT _______________________________________________________________________
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product el = this.productBO.findById(id);

        List<Product> eList = this.productBO.findAll();
        List<Category> eList2 = this.productBO.findAllCateGory();
        request.setAttribute("eList", eList);
        request.setAttribute("eList2", eList2);
        request.setAttribute("el", el);
        request.setAttribute("id", id);
        request.setAttribute("edit", 1);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. DELETE _______________________________________________________________________
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product el = this.productBO.findById(id);
        request.setAttribute("el", el);
        request.setAttribute("msg_delete", msg_delete);
        forwardJSP(request, response, deleteJSP);
    }
    /* ---------------------- end ------------------------ */

    // 6. VIEW _______________________________________________________________________
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product el = this.productBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, viewJSP);
    }
    /* ---------------------- end ------------------------ */

}



















//        // CREATE --> VALIDATE input  ______________________________________________________________________________
//        boolean isValidALL = false;

//        boolean isValid_id = Validation.checkInteger(id); //<!-- $$$ -->
//
//        boolean isValid_a = Validation.checkName(a); //<!-- $$$ -->
//
//        boolean isValid_b = Validation.checkPhoneNumber(b); //<!-- $$$ -->
//
//        boolean isValid_c = Validation.checkGender(c); //<!-- $$$ -->
//
//        boolean isValid_d = Validation.checkBirthday(d); //<!-- $$$ -->
//
//        boolean isValid_e = Validation.checkEmail(e); //<!-- $$$ -->
//
//        boolean isValid_f = Validation.checkNotEmpty(f); //<!-- $$$ -->
//
//        boolean isValid_g = Validation.checkNotEmpty(g); //<!-- $$$ -->
//
//        // *******************************************************
//        if (!isValid_id) {
//            request.setAttribute("msg_invalid_id", INTEGER_INVALID);
//        }

//        if (!isValid_a) {
//            request.setAttribute("msg_invalid_a", NAME_INVALID);
//        }

//        if (!isValid_b) {
//            request.setAttribute("msg_invalid_b", PHONE_INVALID);
//        }

//        if (!isValid_c) {
//            request.setAttribute("msg_invalid_c", GENDER_INVALID);
//        }

//        if (!isValid_d) {
//            request.setAttribute("msg_invalid_d", BIRTHDAY_INVALID);
//        }

//        if (!isValid_e) {
//            request.setAttribute("msg_invalid_e", EMAIL_INVALID);
//        }

//        if (!isValid_f) {
//            request.setAttribute("msg_invalid_f", TEXT_INVALID);
//        }

//        if (!isValid_g) {
//            request.setAttribute("msg_invalid_g", TEXT_INVALID);
//        }

//        // *********************************************************
//
//        isValidALL = isValid_id
//                && isValid_a
//                && isValid_b
//                && isValid_c
//                && isValid_d
//                && isValid_e
//                && isValid_f
//                && isValid_g;
//        if (isValidALL) {
//            Contact el = new Contact(id, a, b, c, d, e, f, g);
//            this.contactBO.create(el);
//            //request.setAttribute("el", el);
//            request.setAttribute("msg_create", msg_create);
//        } else {
//            request.setAttribute("msg_create", "Input not valid!");
//            request.setAttribute("id", id);
//            request.setAttribute("a", a);
//            request.setAttribute("b", b);
//            request.setAttribute("c", c);
//            request.setAttribute("d", d);
//            request.setAttribute("e", e);
//            request.setAttribute("f", f);
//            request.setAttribute("g", g);//
//        }

//        forwardJSP(request, response, createJSP);
//        // CREATE --> validate ends here....... _________________________________________________________________

//.................................................................................................................

//        // EDIT --> VALIDATE input ______________________________________________________________________________

//        boolean isValidALL = false;

//        boolean isValid_id = Validation.checkInteger(id); //<!-- $$$ -->
//
//        boolean isValid_a = Validation.checkName(a); //<!-- $$$ -->
//
//        boolean isValid_b = Validation.checkPhoneNumber(b); //<!-- $$$ -->
//
//        boolean isValid_c = Validation.checkGender(c); //<!-- $$$ -->
//
//        boolean isValid_d = Validation.checkBirthday(d); //<!-- $$$ -->
//
//        boolean isValid_e = Validation.checkEmail(e); //<!-- $$$ -->
//
//        boolean isValid_f = Validation.checkNotEmpty(f); //<!-- $$$ -->
//
//        boolean isValid_g = Validation.checkNotEmpty(g); //<!-- $$$ -->
//
//        //*******************************************************
//        if (!isValid_id) {
//            request.setAttribute("msg_invalid_id", INTEGER_INVALID);
//        }
//        if (!isValid_a) {
//            request.setAttribute("msg_invalid_a", NAME_INVALID);
//        }
//        if (!isValid_b) {
//            request.setAttribute("msg_invalid_b", PHONE_INVALID);
//        }
//        if (!isValid_c) {
//            request.setAttribute("msg_invalid_c", GENDER_INVALID);
//        }
//        if (!isValid_d) {
//            request.setAttribute("msg_invalid_d", BIRTHDAY_INVALID);
//        }
//        if (!isValid_e) {
//            request.setAttribute("msg_invalid_e", EMAIL_INVALID);
//        }
//        if (!isValid_f) {
//            request.setAttribute("msg_invalid_f", TEXT_INVALID);
//        }
//        if (!isValid_g) {
//            request.setAttribute("msg_invalid_g", TEXT_INVALID);
//        }
//        //*********************************************************
//
//        isValidALL = isValid_id
//                && isValid_a
//                && isValid_b
//                && isValid_c
//                && isValid_d
//                && isValid_e
//                && isValid_f
//                && isValid_g;
//        if (isValidALL) {
//            Contact el = new Contact(idNew,  a,b,c,d,e,f,g); //<!-- $$$ -->
//            this.contactBO.update(id, el);
//            request.setAttribute("el", el);
//            request.setAttribute("msg_edit", msg_edit);
//        } else {
//            Contact el = contactBO.findById(id);
//            request.setAttribute("el", el);
//            request.setAttribute("msg_edit", "Input not valid!");
//            request.setAttribute("idNew", idNew);
//        }
//
//        forwardJSP(request, response, editJSP);
//        // EDIT --> VALIDATE ends here.....________________________________________________________________________
