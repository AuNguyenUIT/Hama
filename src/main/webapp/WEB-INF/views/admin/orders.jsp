<%--
  Created by IntelliJ IDEA.
  User: VănÂuNguyễn
  Date: 27/06/2021
  Time: 2:12 CH
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
        <!--End Row-->


        <div class="row">

            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách đơn hàng</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Tài khoản</th>
                                    <th scope="col">Họ Tên</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">SĐT</th>
                                    <th scope="col">Địa chỉ</th>
                                    <th scope="col">Ghi chú</th>
                                    <th scope="col">Tổng tiền</th>
                                    <th scope="col">Phương thức thanh toán</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Ngày tạo</th>
                                    <th scope="col">Hành động</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orders}" var="order" varStatus="loop">
                                    <tr>
                                        <td scope="row">${loop.index+1}</td>
                                        <td>${order.user.userName}</td>
                                        <td>${order.transaction.name}</td>
                                        <td>${order.user.mail}</td>
                                        <td>${order.transaction.phone}</td>
                                        <td>${order.transaction.address}</td>
                                        <td>${order.transaction.message}</td>
                                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                                            <fmt:formatNumber value="${order.total}"
                                                              type="currency"/></td>
                                        <td>
                                            <c:if test="${order.status=='completed'}">
                                                <c:choose>
                                                    <c:when test="${order.transaction.payment =='cod'}">
                                                        <c:out value="COD"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:out value="Thẻ tín dụng"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>

                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${order.status == 'cart' }">
                                                    <c:out value="Giỏ hàng"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="Đã đặt hàng"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><fmt:formatDate value="${order.created}"
                                                            pattern="yyyy-MM-dd HH:mm"/></td>
                                        <td>
                                            <c:if test="${order.status=='completed'}">
                                                <button class="btn btn-success"><a
                                                        href="${pageContext.request.contextPath}/quan-tri/don-hang/${order.id}">Chi
                                                    tiết</a>
                                                </button>
                                            </c:if>

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

<jsp:include page="./footer/footer.jsp" flush="true"/>
