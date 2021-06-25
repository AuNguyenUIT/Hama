<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true"/>
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
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
<script src="https://www.mindmeister.com/api/v2/js/api.js?client_id=[Client_ID]"></script>

<script>

</script>
<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Thêm người dùng</div>
                        <hr>
                        <form action="${pageContext.request.contextPath}/quan-tri/nguoi-dung/them" method="post"
                              accept-charset="UTF-8"
                              enctype="multipart/form-data">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Tên đăng nhập</label>
                                    <input type="text" class="form-control" placeholder="Tên đăng nhập"
                                           name="username" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Mật khẩu</label>
                                    <input type="password" class="form-control" placeholder="Mật khẩu"
                                           name="password" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Họ</label>
                                    <input type="text" class="form-control" placeholder="Họ"
                                           name="user-firstname" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Tên</label>
                                    <input type="text" class="form-control" placeholder="Tên"
                                           name="user-lastname" required>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Email</label>
                                    <input type="email" class="form-control" placeholder="useremail@gmail.com"
                                           name="user-mail" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Số điện thoại</label>
                                    <input type="tel" class="form-control" placeholder="Số điện thoại"
                                           name="user-phone" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-3">
                                    <label>Giới tính</label><br>
                                    <input type="radio" id="male" name="user-gender" value="male" checked><label
                                        for="male">Nam</label><br>
                                    <input type="radio" id="female" name="user-gender" value="female"> <label
                                        for="female">Nữ</label><br>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Vai trò</label><br>
                                    <input type="radio" id="admin" name="user-role" value="admin">
                                    <label for="admin">Quản trị viên</label><br/>
                                    <input type="radio" id="user" name="user-role" value="user" checked>
                                    <label for="user">Người dùng</label>

                                </div>

                                <div class="form-group col-md-6">
                                    <label aria-label="birthday">Ngày sinh</label>
                                    <input type="date" class="form-control" placeholder="Ngày sinh"
                                           name="user-date" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-check-label">
                                    <input type="checkbox" value="1" name="user-status" checked> Kích hoạt
                                </label>
                            </div>
                            <div class="form-group">

                                <button class="btn btn-danger"><a
                                        href="${pageContext.request.contextPath}/quan-tri/user/danh-sach">Hủy</a>
                                </button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Đăng
                                    ký
                                </button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>
<script>
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;


    document.getElementById('the-date').value = today;

</script>


<jsp:include page="./footer/footer.jsp" flush="true"/>