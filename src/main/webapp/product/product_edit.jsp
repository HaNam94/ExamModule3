<%--
  Created by IntelliJ IDEA.
  User: Ha Duy Nam
  Date: 10-Jun-24
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${edit_element}</title>
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
    <h2>${edit_element}</h2>
    <p><span class="msg-info">${msg_edit}</span></p>
    <form method="post" action="${originalLink}">
        <input type="hidden" name="action" value="edit">
        <%--    *********************************************************************--%>
        <input type="hidden" name="id" value="${el.productId}"> <!-- $$$$$$$$$$$$ -->

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table class="table table-striped table-hover" style="width: 30%">
                <tr>
                    <td scope="col">${title_id}</td>
                    <td scope="col"><input type="text" name="idNew" id="idNew" value="${el.productId}" required> <!-- $$$$$$$$$$$$ -->
                        <span class="msg-invalid">&nbsp;(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_id}</span></td>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_a}</td>
                    <td scope="col"><input type="text" name="a" id="a" value="${el.productName}" required> <!-- $$$$$$$$$$$$ -->
                        <span class="msg-invalid">&nbsp;(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_a}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_b}</td>
                    <td scope="col"><input type="number" min="1.0" step="any" name="b" id="b" value="${el.productPrice}" required> <!-- $$$$$$$$$$$$ -->
                        <span class="msg-invalid">&nbsp;(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_b}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_c}</td>
                    <td scope="col"><input type="number" min="1" name="c" id="c" value="${el.productQuantity}" required> <!-- $$$$$$$$$$$$ -->
                        <span class="msg-invalid">&nbsp;(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_c}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_d}</td>
                    <td scope="col"><input type="text" name="d" id="d" value="${el.productColor}" required> <!-- $$$$$$$$$$$$ -->
                        <span class="msg-invalid">&nbsp;(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_d}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_e}</td>
                    <td scope="col"><input type="text" name="e" id="e" value="${el.productDescription}" required> <!-- $$$$$$$$$$$$ -->
                        <span class="msg-invalid">&nbsp;(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_e}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_f}</td>
                    <td scope="col">
                        <%--                    <input type="text" name="f" id="f" value="${el.productCategory}" required> <!-- $$$$$$$$$$$$ -->--%>
                        <select name="f" id="f" value="${f}">
                            <c:forEach items="${eList2}" var="ca">
                                <option>${ca.categoryName}</option>
                            </c:forEach>
                        </select>
                        <span class="msg-invalid">&nbsp;(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_f}</span>
                    </td>
                </tr>

                <%--    **********************************************************************--%>
                <tr>
                    <td scope="col"><button type="submit"  class="btn btn-outline-danger btn-sm">
                        Update ${element_name}</button>
                    </td>
                    <td scope="col"><button type="button" class="btn btn-outline-info btn-sm">
                        <a href=${originalLink}>Back to ${element_name} list</a></button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
