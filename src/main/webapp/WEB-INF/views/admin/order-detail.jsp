<%--
  Created by IntelliJ IDEA.
  User: VănÂuNguyễn
  Date: 27/06/2021
  Time: 8:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Chi tiết đơn hàng</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">Tên Sản Phẩm</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Tổng tiền</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${items}" var="item">
                                    <tr>
                                        <td>${item.product.title}</td>
                                        <td>${item.unitPrice}</td>
                                        <td>${item.quantity}</td>
                                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                                            <fmt:formatNumber value="${item.total}"
                                                              type="currency"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <h6>Tổng tiền đơn hàng: <fmt:setLocale value="vi_VN" scope="session"/>
                            <fmt:formatNumber value="${order.total}"
                                              type="currency"/></h6>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Thông tin đơn hàng</h5>
                        <h6>Phương thức thanh toán: <c:choose>
                            <c:when test="${order.transaction.payment =='cod'}">
                                <c:out value="COD"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="Thẻ tín dụng"/>
                            </c:otherwise>
                        </c:choose></h6>
                        <div class="row">
                            <div class="col-6">
                                <h6>Tên khách hàng:</h6>
                                <p>${order.transaction.name}</p>
                            </div>
                            <div class="col-6">
                                <h6>Số điện thoại:</h6>
                                <p>${order.transaction.phone}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <h6>Địa chỉ:</h6>
                                <p>${order.transaction.address}</p>
                            </div>
                            <div class="col-6">
                                <h6>Lời nhắn:</h6>
                                <p>${order.transaction.message}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true"/>
