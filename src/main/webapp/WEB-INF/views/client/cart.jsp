<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/resources/client/assets" var="url"/>
<!-- Start header section -->
<jsp:include page="./header/mainHeader.jsp" flush="true"/>
<!-- / header section -->

<!-- content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="${pageContext.request.contextPath}/resources/client/assets/images/banner-cart.png" alt="banner giỏ hàng">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Giỏ hàng</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}">Trang chủ </a></li>
                    <li style="color:#fff">Thông tin giỏ hàng</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="cart-view">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="cart-view-area">
                    <div class="cart-view-table">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Bỏ chọn</th>
                                    <th>Mô tả</th>
                                    <th>Sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Giảm giá</th>
                                    <th>Thành Tiền</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${items}" var="item">
                                    <tr>
                                        <td><a class="remove"
                                               href="${pageContext.request.contextPath}/gio-hang/xoa?id=${item.id}">
                                            <fa class="fa fa-close"></fa>
                                        </a></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/san-pham/${item.product.id}"><img
                                                    src="${pageContext.request.contextPath}/resources/upload/product/${item.product.id}/${item.product.thumb}"
                                                    alt="img${item.product.title }"></a></td>
                                        <td><a class="aa-cart-title"
                                               href="${pageContext.request.contextPath}/san-pham/${item.product.id}">${item.product.title }</a>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="vi_VN" scope="session"/>
                                            <fmt:formatNumber value="${item.product.price} " type="currency"/></td>
                                        <td>${item.quantity}</td>
                                        <td>${item.product.sale} %</td>
                                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                                            <fmt:formatNumber value="${item.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="6" class=""><strong>TỔNG TIỀN</strong></td>
                                    <td><strong><fmt:setLocale value="vi_VN" scope="session"/>
                                        <fmt:formatNumber value="${order.total}" type="currency"/></strong></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- Cart Total view -->
                        <div class="cart-view-total">
                            <h4>Thông tin giỏ hàng</h4>
                            <table class="aa-totals-table">
                                <tbody>
                                <tr>
                                    <th>Tạm tính</th>
                                    <td><fmt:setLocale value="vi_VN" scope="session"/>
                                        <fmt:formatNumber value="${order.total}" type="currency"/></td>
                                </tr>
                                <tr>
                                    <th>VAT</th>
                                    <td><fmt:setLocale value="vi_VN" scope="session"/>
                                        <fmt:formatNumber value="0" type="currency"/></td>
                                </tr>
                                <tr>
                                    <th>Tổng cộng</th>
                                    <td><strong><fmt:setLocale value="vi_VN" scope="session"/>
                                        <fmt:formatNumber value="${order.total}" type="currency"/></strong></td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="${pageContext.request.contextPath}/thanh-toan" class="aa-cart-view-btn">Thanh
                                toán</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->

<!-- end content-->

<!-- footer-->
<jsp:include page="./footer/footer.jsp" flush="true"/>
<!-- end footer-->
