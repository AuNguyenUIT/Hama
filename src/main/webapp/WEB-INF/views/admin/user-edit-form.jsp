<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/assets/js/previewFile.js"></script>
<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Cập nhật người dùng</div>
                        <hr>
                        <form action="${pageContext.request.contextPath}/quan-tri/nguoi-dung/chinh-sua" method="post"
                              accept-charset="UTF-8"
                              enctype="multipart/form-data">
                            <div class="form-group" hidden="true">
                                <label for="input-1">ID</label>
                                <input type="text" class="form-control" id="input-1" readonly="readonly"
                                       placeholder="ID" value="${user.id}" name="user-id">
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Tên đăng nhập</label>
                                    <input type="text" class="form-control" placeholder="Tên đăng nhập"
                                           name="username" value="${user.userName}" disabled>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Mật khẩu</label>
                                    <input type="password" class="form-control" placeholder="Mật khẩu"
                                           name="password" value="1234590" disabled>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Họ</label>
                                    <input type="text" class="form-control" placeholder="Họ"
                                           value="${user.lastName}" name="user-lastname" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Tên</label>
                                    <input type="text" class="form-control" placeholder="Tên"
                                           value="${user.firstName}" name="user-firstname">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Email</label>
                                    <input type="email" class="form-control" placeholder="useremail@gmail.com"
                                           value="${user.mail}" name="user-mail" readonly="readonly">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Số điện thoại</label>
                                    <input type="tel" class="form-control" placeholder="Số điện thoại"
                                           value="${user.phoneNumber}" name="user-phone" readonly="readonly">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-3">
                                    <label>Giới tính</label><br>
                                    <c:choose>
                                        <c:when test="${user.gender=='male'}">
                                            <input type="radio" id="male" name="user-gender" value="male"
                                                   checked="checked"><label
                                                for="male">Nam</label><br>
                                            <input type="radio" id="female" name="user-gender" value="female"> <label
                                                for="female">Nữ</label><br>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="radio" id="male" name="user-gender" value="male"><label
                                                for="male">Nam</label><br>
                                            <input type="radio" id="female" name="user-gender" value="female"
                                                   checked="checked"> <label for="female">Nữ</label><br>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Vai trò</label><br>
                                    <input type="radio" id="admin" name="user-role" value="admin"
                                    <c:if test="${user.role =='admin'}">
                                        <c:out value="checked"/>
                                    </c:if>>
                                    <label for="admin">Quản trị viên</label><br/>
                                    <input type="radio" id="user" name="user-role" value="user"
                                    <c:if test="${user.role =='user'}">
                                        <c:out value="checked"/>
                                    </c:if> >
                                    <label for="user">Người dùng</label>

                                </div>

                                <div class="form-group col-md-6">
                                    <label aria-label="birthday">Ngày sinh</label>
                                    <input type="date" class="form-control" placeholder="Ngày sinh"
                                           value="${date}" name="user-date">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-check-label">
                                    <input type="checkbox" value="1" name="user-status"
                                    <c:if test="${user.status==true}">
                                        <c:out value="checked"/>
                                    </c:if>  > Kích hoạt
                                </label>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-danger"><a
                                        href="${pageContext.request.contextPath}/quan-tri/nguoi-dung/danh-sach">Hủy</a>
                                </button>
                                <button type="submit" class="btn btn-success btn-edit">Cập nhật</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>
<jsp:include page="./footer/footer.jsp" flush="true"/>