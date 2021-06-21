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
    <img src="${url}/images/images/banner-sp.jpg" alt="banner sản phẩm">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Sản phẩm</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Danh sách sản phẩm</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- product category -->
<section class="container bootdey">
    <div class="row">
        <div class="col-md-3">
            <section class="panel">
                <div class="panel-body">
                    <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/san-pham/tim-kiem"
                          method="post">
                        <input type="hidden" value="${category_id}" name="category_id">
                        <input value="${title}" type="text" placeholder="Tên Sản Phẩm" class="form-control"
                               name="title"/>
                        <br>
                        <button class="form-control btn btn-info" type="submit">Tìm kiếm</button>
                    </form>
                </div>
            </section>
            <section class="panel">
                <header class="panel-heading">
                    <h3>Danh mục</h3>
                </header>
                <div class="panel-body">
                    <ul class="nav prod-cat">
                        <li>
                            <a href="${pageContext.request.contextPath}/san-pham"
                               class="<c:if test="${category_id==0}">
                               <c:out value="active"/>
                                </c:if>"><i class="fa fa-angle-right">
                            </i> Tất cả
                            </a>
                        </li>
                        <c:forEach items="${categories}" var="cate">
                            <li>
                                <a href="${pageContext.request.contextPath}/san-pham?danh-muc=${cate.id}"
                                   class="<c:if test="${cate.id==category_id}">
                               <c:out value="active"/>
                                </c:if>"><i class="fa fa-angle-right"></i> ${cate.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
        </div>
        <div class="col-md-9">
            <div class="row product-list">
                <c:if test="${empty products}">
                    <p style="margin-left: 30px">Chưa có sản phẩm!</p>
                </c:if>
                <c:forEach items="${products}" var="product">
                    <div class="col-md-4">
                        <section class="panel offer offer-radius offer-danger ">
                            <div class="pro-img-box">
                                <c:if test="${product.sale != 0}">
                                    <div class="shape">
                                        <div class="shape-text">
                                            - ${product.sale} %
                                        </div>
                                    </div>
                                </c:if>

                                <a class=""
                                   href="${pageContext.request.contextPath}/san-pham/chi-tiet/${product.id}"><img
                                        src="${pageContext.request.contextPath}/resources/upload/product/${product.id}/${product.thumb}"
                                        alt="${product.title}"></a>

                                <form class=""
                                      action="${pageContext.request.contextPath}/them-gio-hang"
                                      method="post">
                                    <input hidden value="${product.id}" name="product_id"/>
                                    <input hidden value="/san-pham"
                                           name="current_path"/>
                                    <button type="submit" class="adtocart"><i
                                            class="fa fa-shopping-cart"></i>
                                    </button>
                                </form>
                            </div>

                            <div class="panel-body text-center">
                                <h4>
                                    <a href="${pageContext.request.contextPath}/san-pham/chi-tiet/${product.id}"
                                       class="pro-title"> ${product.title}</a>
                                </h4>
                                <c:choose>
                                    <c:when test="${product.sale == 0}">
                                        <p class="price">
                                            <fmt:setLocale value="vi_VN" scope="session"/>
                                            <fmt:formatNumber value="${product.price}"
                                                              type="currency"/></p>
                                        <p class="price"></p>
                                    </c:when>
                                    <c:otherwise>
                                                    <span class="price">
                                                           <fmt:setLocale value="vi_VN" scope="session"/>
                                                            <fmt:formatNumber
                                                                    value="${product.price - product.price*(product.sale/100)}"
                                                                    type="currency"/>
                                                    </span>
                                        <span class=""><del>
                                                        <fmt:setLocale value="vi_VN" scope="session"/>
                                                        <fmt:formatNumber value="${product.price}" type="currency"/>
                                                        </del>
                                                    </span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </section>
                    </div>
                </c:forEach>
            </div>
        </div>


    </div>
</section>
<!-- / product category -->
<!-- end content-->

<!-- footer-->
<jsp:include page="./footer/footer.jsp" flush="true"/>
<!-- end footer-->
 

  
