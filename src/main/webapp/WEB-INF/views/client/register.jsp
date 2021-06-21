<%--
    Document   : index
    Created on : May 5, 2020, 10:57:00 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/resources/client/assets" var="url"/>

<!-- Start header section -->
<jsp:include page="./header/mainHeader.jsp" flush="true"/>
<!-- / header section -->
<!-- content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="${url}/images/archive-banner.png" alt="banner blog">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Đăng ký</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Đăng ký tài khoản</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="aa-myaccount">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-myaccount-area">
                    <div class="row">

                        <div class="col-md-8 col-md-push-2">
                            <div class="aa-myaccount-register">
                                <h4>Đăng ký</h4>
                                <form name="formRegister" class="aa-login-form" method="post"
                                      action="${pageContext.request.contextPath}/dang-ky">
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label for="">Tên đăng nhập<span>*</span></label>
                                            <input type="text" class="form-control" placeholder="Tên đăng nhập"
                                                   name="username" required>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="">Mật khẩu<span>*</span></label>
                                            <input type="password" class="form-control" placeholder="Mật khẩu"
                                                   name="password" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label for="">Họ<span>*</span></label>
                                            <input type="text" class="form-control" placeholder="Họ" name="firstname"
                                                   required>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="">Tên đệm và tên<span>*</span></label>
                                            <input type="text" class="form-control" placeholder="Tên đệm và tên"
                                                   name="lastname" required>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label for="">Email <span>*</span></label>
                                            <input type="email" class="form-control" placeholder="useremail@gmail.com"
                                                   name="email" required>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="">Số điện thoại<span>*</span></label>
                                            <input type="tel" class="form-control" placeholder="Số điện thoại"
                                                   name="phone" required>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group col-md-6 form-check form-check-inline">
                                            <label>Giới tính<span>*</span></label>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <input class="form-check-input" type="radio" id="gender-male"
                                                           value="male" name="gender" checked>
                                                    <label class="form-check-label" for="gender-male">Nam</label>
                                                </div>
                                                <div class="col-md-6">
                                                    <input class="form-check-input" type="radio" name="gender"
                                                           id="gender-female" value="male" name="gender">
                                                    <label class="form-check-label" for="gender-female">Nữ</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label aria-label="birthday">Ngày sinh<span>*</span></label>
                                            <input type="date" class="form-control" placeholder="Ngày sinh"
                                                   name="birthday" required value="1999-02-24">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label aria-label="address">Địa chỉ<span>*</span></label>
                                        <textarea class="form-control" rows="5" name="address" placeholder="Địa chỉ"></textarea>
                                    </div>


                                    <input type="date" style="display: none" placeholder="Password" name="created"
                                           id="the-date">

                                    <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
                                            : request.getAttribute("errMessage")%>
                                    </p>
                                    <p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
                                            : request.getAttribute("Message")%>
                                    </p>
                                    <button type="reset" class="aa-browse-btn" value="Reset">Đặt lại</button>
                                    <button type="submit" class="aa-browse-btn">Đăng ký</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->

<!-- end content-->
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
<!-- footer-->
<jsp:include page="./footer/footer.jsp" flush="true"/>
<!-- end footer-->


