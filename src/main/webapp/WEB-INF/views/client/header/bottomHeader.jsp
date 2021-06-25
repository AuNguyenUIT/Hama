<%-- 
    Document   : bottomHeader
    Created on : May 5, 2020, 11:14:19 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url value="/resources/client/assets" var="url"/>
<div class="aa-header-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-header-bottom-area">
                    <!-- logo  -->
                    <div class="aa-logo">
                        <!-- Text based logo -->
                        <!--                <a href="index.jsp">
                                          <span class="fa fa-shopping-cart"></span>
                                          <p>daily<strong>Shop</strong> <span>Your Shopping Partner</span></p>
                                        </a>-->
                        <!-- img based logo -->
                        <a href="${pageContext.request.contextPath}/"><img src="${url}/images/images/logo.png"
                                                                           alt="logo img" width="100%"></a>
                    </div>
                    <!-- / logo  -->
                    <!-- Shipping service -->
                    <div class="aa-shipping-box">
                        <a class="aa-shipping-boxsmall">
                            <span class="aa-shipping-boxsmall-icon fas fa-shipping-fast"></span>
                            <span class="aa-shipping-box-text">
                          <div class="aa-shipping-title">Miễn phí vận chuyển</div>
                      <div class="">Khu vực TP HCM</div>
                      </span>

                        </a>
                        <a class="aa-shipping-boxsmall">
                            <span class="aa-shipping-boxsmall-icon fas fa-phone"></span>
                            <span class="aa-shipping-box-text">
                          <div class="aa-shipping-title">Hỗ trợ: 037.7026.186</div>
                          <div class="">Tư vấn 24/7 miễn phí</div>
                      </span>

                        </a>
                        <a class="aa-shipping-boxsmall">
                            <span class="aa-shipping-boxsmall-icon fas fa-shipping-fast"></span>
                            <span class="aa-shipping-box-text">
                          <div class="aa-shipping-title">Giao hàng toàn quốc</div>
                      <div class="">Đảm bảo uy tín, chất lượng</div>
                      </span>

                        </a>
                    </div>


                    <!-- cart box -->
                    <div class="aa-cartbox">
                        <a class="aa-cart-link" href="${pageContext.request.contextPath}/gio-hang">
                            <span class="fas fa-cart-arrow-down"></span>
                            <span class="aa-cart-title">GIỎ HÀNG</span>
                            <c:if test="${sessionScope.length != null}">
                                <span class="aa-cart-notify">${sessionScope.length}</span>
                            </c:if>
                        </a>
                        <div class="aa-cartbox-summary">
                            <ul class="scroll-product">
                                <c:if test="${sessionScope.order_items!=null}">
                                    <c:forEach items="${sessionScope.order_items}" var="item">
                                        <li>
                                            <a class="aa-cartbox-img"
                                               href="${pageContext.request.contextPath}/gio-hang"><img
                                                    src="${pageContext.request.contextPath}/resources/upload/product/${item.product.id}/${item.product.thumb}"
                                                    alt="img"></a>
                                            <div class="aa-cartbox-info">
                                                <h4>
                                                    <a href="${pageContext.request.contextPath}/gio-hang">${item.product.title}
                                                        ( ${item.size} )</a>
                                                </h4>
                                                <p>${item.quantity} x
                                                    <fmt:setLocale value="vi_VN" scope="session"/>
                                                    <fmt:formatNumber
                                                            value="  ${item.product.price * (1-((item.product.sale)/100))}"
                                                            type="currency"/>
                                                </p>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </c:if>
                            </ul>
                            <div class="total-detailproduct">
                  		<span class="aa-cartbox-total-title">
                        <b>Tổng:</b>
                      </span>
                                <span class="aa-cartbox-total-price">
                                    <c:choose>
                                        <c:when test="${total !=null}">
                                            <fmt:setLocale value="vi_VN" scope="session"/>
                                            <fmt:formatNumber value="  ${total}" type="currency"/>
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:setLocale value="vi_VN" scope="session"/>
                                            <fmt:formatNumber value="0" type="currency"/>
                                        </c:otherwise>
                                    </c:choose>

                                </span>
                            </div>
                            <a class="aa-cartbox-checkout aa-primary-btn"
                               href="${pageContext.request.contextPath}/gio-hang">Chi tiết</a>
                            <a class="aa-cartbox-checkout aa-primary-btn"
                               href="${pageContext.request.contextPath}/thanh-toan">Thanh toán</a>
                        </div>
                    </div>
                    <!-- / cart box -->

                </div>
            </div>
        </div>
    </div>
</div>

