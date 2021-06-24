<%--
  Created by IntelliJ IDEA.
  User: VănÂuNguyễn
  Date: 30/05/2021
  Time: 10:35 SA
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");

    if (session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/dang-nhap");
    } else {
        if (!session.getAttribute("role").equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/dang-nhap");
        }
    }
%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true"/>
<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/quan-tri/san-pham/them">Thêm sản
                    phẩm</a></button>
            </div>
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách sản phẩm</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Hình ảnh</th>
                                    <th scope="col">Danh mục</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Tình trạng</th>
                                    <th scope="col">Giảm giá</th>
                                    <th scope="col">Cập nhật lần cuối</th>
                                    <th scope="col">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${products}" var="product" varStatus="loop">
                                    <tr>
                                        <th scope="row">${loop.index+1 }</th>
                                        <td>${product.title }</td>
                                        <td><c:if test="${product.thumb !=null && product.thumb!=''}">
                                            <img width="100px" height="70px"
                                                 src="${pageContext.request.contextPath}/resources/upload/product/${product.id}/${product.thumb}">
                                        </c:if></td>
                                        <td>${product.category.title }</td>
                                        <td>${product.price }</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${product.status == true}">
                                                    <c:out value="Còn hàng"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="Hết hàng"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>${product.sale }%</td>
                                        <td><fmt:formatDate value="${product.modified}"
                                                            pattern="yyyy-MM-dd HH:mm"/></td>
                                        <td>
                                            <a class="btn btn-danger btn-edit" onclick="myfunction4()"
                                                    href="${pageContext.request.contextPath}/quan-tri/san-pham/xoa?id=${product.id}">Xóa</a>
                                            

                                            <a class="btn btn-success"
                                                    href="${pageContext.request.contextPath}/quan-tri/san-pham/chinh-sua?id=${product.id}">Sửa</a>

                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $(".btn-edit").click(function (e) {
            e.preventDefault();
            var href = $(this).attr('href');
            $.confirm({
                title: 'Xác nhận',
                content: 'Bạn có chắc chắn muốn xóa sản phẩm này',
                type: 'danger',
                buttons: {
                    ok: {
                        text: "Xóa",
                        btnClass: 'btn-danger',
                        keys: ['enter'],
                        action: function () {
                            window.location.href = href;
                        }
                    },
                    cancel: {
                        text: "Hủy",
                        action: function () {
                            console.log('the user clicked confirm');
                        }
                    }
                }
            })
        })
        if ("${message}") {
            showMessage("${message}", "${type}")
        }
    })
</script>

<jsp:include page="./footer/footer.jsp" flush="true"/>
