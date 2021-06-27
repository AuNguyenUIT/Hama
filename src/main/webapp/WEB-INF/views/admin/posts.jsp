<%-- 
    Document   : articles
    Created on : Jun 8, 2021, 6:50:59 PM
    Author     : nguye
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
        <!--End Row-->
        <div class="row">
            <div class="col-lg-12">
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/quan-tri/bai-viet/them">Thêm bài
                    viết</a></button>
            </div>
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách bài viết</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Hình đại diện</th>
                                    <th scope="col">Chủ đề</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Ngày đăng</th>
                                    <th scope="col">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${posts}" var="post" varStatus="loop">
                                    <tr>
                                        <td scope="row">${loop.index+1}</td>
                                        <td scope="row">
                                            <c:if test="${post.thumb !=null && post.thumb!=''}">
                                                <img width="150px"
                                                     src="${pageContext.request.contextPath}/resources/upload/post/${post.thumb}">
                                            </c:if>
                                        </td>
                                        <td scope="row">${post.title}</td>
                                        <td scope="row">
                                            <c:choose>
                                                <c:when test="${post.status == true}">
                                                    <c:out value="Công khai"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="Riêng tư"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td scope="row"><fmt:formatDate value="${post.created}"
                                                                        pattern="yyyy-MM-dd HH:mm"/>
                                        </td>
                                        <td scope="row">
                                            <a class="btn btn-danger btn-edit"
                                               href="${pageContext.request.contextPath}/quan-tri/bai-viet/xoa?id=${post.id}">Xóa</a>
                                            <a class="btn btn-success"
                                               href="${pageContext.request.contextPath}/quan-tri/bai-viet/chinh-sua?id=${post.id}">Sửa</a>
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
                content: 'Bạn có chắc chắn muốn xóa bài viết này',
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
