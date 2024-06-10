<%--
  Created by IntelliJ IDEA.
  User: Ha Duy Nam
  Date: 10-Jun-24
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${view_element}</title>
</head>
<body>
<!-- Header -->
<%@ include file="/common/header.jsp"%>
<!-- end -->

<!-- Navigation -->
<%@ include file="/common/navigation.jsp"%>
<!-- end -->

<!-- Body page -->
<center>
    <h2>${view_element}</h2>
    <fieldset>${element_name.toUpperCase()} INFORMATION
        <table class="table table-striped table-hover" style="width: 25%">
            <tr>
                <td scope="col">${title_id}</td>
                <td scope="col">${el.productId}</td><!-- $$$$$$$$$$$$ -->
            </tr>
            <tr>
                <td scope="col">${title_a}</td>
                <td scope="col">${el.productName}</td><!-- $$$$$$$$$$$$ -->
            </tr>
            <tr>
                <td scope="col">${title_b}</td>
                <td scope="col">${el.productPrice}</td><!-- $$$$$$$$$$$$ -->
            </tr>
            <tr>
                <td scope="col">${title_c}</td>
                <td scope="col">${el.productQuantity}</td><!-- $$$$$$$$$$$$ -->
            </tr>
            <tr>
                <td scope="col">${title_d}</td>
                <td scope="col">${el.productColor}</td><!-- $$$$$$$$$$$$ -->
            </tr>
            <tr>
                <td scope="col">${title_e}</td>
                <td scope="col">${el.productDescription}</td><!-- $$$$$$$$$$$$ -->
            </tr>
            <tr>
                <td scope="col">${title_f}</td>
                <td scope="col">${el.productCategory}</td><!-- $$$$$$$$$$$$ -->
            </tr>

            <tr>
                <td scope="col"></td>
                <td scope="col">
                    <button type="button" class="btn btn-outline-info btn-sm">
                        <a href=${originalLink}>Back to ${element_name} list</a></button>
                </td>
            </tr>
        </table>
    </fieldset>
</center>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
