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
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/quan-tri/nguoi-dung/them">Thêm
                    người dùng</a></button>
            </div>
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách người dùng</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Họ</th>
                                    <th scope="col">Tên</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Số điện thoại</th>
                                    <th scope="col">Tên đăng nhập</th>
                                    <th scope="col">Vai trò</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Ngày tạo</th>
                                    <th scope="col">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user" varStatus="loop">
                                    <tr>
                                        <th scope="row">${loop.index+1 }</th>
                                        <td>${user.firstName} </td>
                                        <td> ${user.lastName }</td>
                                        <td>${user.mail }</td>
                                        <td>${user.phoneNumber }</td>
                                        <td>${user.userName }</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${user.role=='admin' }">
                                                    Quản trị viên
                                                </c:when>
                                                <c:otherwise>
                                                    Người dùng
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${user.status==true }">
                                                    Kích hoạt
                                                </c:when>
                                                <c:otherwise>
                                                    Bị chặn
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><fmt:formatDate value="${user.created }"
                                                            pattern="yyyy-MM-dd HH:mm"/></td>
                                        <td>
                                            <a class="btn btn-danger btn-edit"
                                               href="${pageContext.request.contextPath}/quan-tri/nguoi-dung/xoa?id=${user.id}">Xóa</a>

                                            <a class="btn btn-success"
                                               href="${pageContext.request.contextPath}/quan-tri/nguoi-dung/chinh-sua?id=${user.id}">Sửa</a>
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
                content: 'Bạn có chắc chắn muốn xóa người dùng này',
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