<%--
  Created by IntelliJ IDEA.
  User: VănÂuNguyễn
  Date: 30/05/2021
  Time: 4:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder"%>

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
        <!--End Row-->
        <div class="row">
            <div class="col-lg-12">
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/quan-tri/danh-muc/them">Thêm
                    chuyên
                    mục</a></button>
            </div>
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách danh mục</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Hình đại diện</th>
                                    <th scope="col">Tên danh mục</th>
                                    <th scope="col">Danh mục cha</th>
                                    <th scope="col">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${categories}" var="cate" varStatus="loop">
                                    <tr>
                                        <td scope="row">${loop.index+1}</td>
                                        <td scope="row">
                                            <c:if test="${cate.thumb !=null && cate.thumb!=''}">
                                                <img width="150px"
                                                     src="${pageContext.request.contextPath}/resources/upload/category/${cate.thumb}">
                                            </c:if>
                                        </td>
                                        <td>${cate.title}</td>
                                        <td>${cate.category.title}</td>
                                        <td>
                                            <a class="btn btn-danger btn-edit"
                                               href="${pageContext.request.contextPath}/quan-tri/danh-muc/xoa?id=${cate.id}">Xóa</a>
                                            <a class="btn btn-success"
                                               href="${pageContext.request.contextPath}/quan-tri/danh-muc/chinh-sua?id=${cate.id}">Sửa</a>
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
    </div>
</div>
<script>
    $(document).ready(function () {
        $(".btn-edit").click(function (e) {
            e.preventDefault();
            var href = $(this).attr('href');
            $.confirm({
                title: 'Xác nhận',
                content: 'Bạn có chắc chắn muốn xóa danh mục này',
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
        <%--if ("${message}") {--%>
        <%--    showMessage("${message}", "${type}")--%>
        <%--}--%>
    })
</script>

<jsp:include page="./footer/footer.jsp" flush="true"/>