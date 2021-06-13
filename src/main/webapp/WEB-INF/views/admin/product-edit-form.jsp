<%--
  Created by IntelliJ IDEA.
  User: VănÂuNguyễn
  Date: 30/05/2021
  Time: 10:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/assets/js/previewFile.js"></script>
<div class="content-wrapper">
    <div class="container-fluid">
        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Thêm sản phẩm</div>
                        <hr>
                        <form method="post" action="${pageContext.request.contextPath}/quan-tri/san-pham/chinh-sua"
                              accept-charset="UTF-8"
                              enctype="multipart/form-data">

                            <input type="HIDDEN" class="form-control"
                                   name="id" value="${product.id}">
                            <input type="HIDDEN" class="form-control"
                                   name="old_thumb" value="${product.thumb}">
                            <input type="HIDDEN" class="form-control"
                                   name="old_images" value="${product.images}">
                            <div class="form-group">
                                <label for="title">Tên sản phẩm</label>
                                <input type="text" class="form-control" id="title" placeholder="Tên sản phẩm"
                                       name="title" required value="${product.title}">
                            </div>
                            <div class="form-group">
                                <label for="cate_id">Chuyên mục</label>
                                <div>
                                    <select class="form-control valid" id="cate_id" name="cate_id"
                                            aria-invalid="false">
                                        <c:forEach items="${categoryList}" var="cate">
                                            <option value="${cate.id }" <c:if test="${cate.id==product.category.id}">
                                                <c:out value="selected"/>
                                            </c:if>>
                                                    ${cate.title }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="thumb">Hình đại diện</label>
                                <input type="file" name="thumb" accept="image/*" id="thumb"/>
                                <p>
                                    <c:choose>
                                        <c:when test="${product.thumb!=null && !product.thumb.equals('')}">
                                            <img width="150px"
                                                 src="${pageContext.request.contextPath}/resources/upload/product/${product.id}/${product.thumb}"
                                                 id="thumb_preview" alt="Hình đại diện"/>
                                        </c:when>
                                        <c:otherwise>
                                            <img width="150px"
                                                 src="${pageContext.request.contextPath}/resources/admin/assets/images/preview.jpg"
                                                 id="thumb_preview" alt="Hình đại diện"/>
                                        </c:otherwise>
                                    </c:choose>

                                </p>
                            </div>
                            <div class="form-group">
                                <label for="multiple_image">Một số hình ảnh khác</label>
                                <input type="file" name="multiple_image" accept="image/*" id="multiple_image" multiple/>
                                <div id="preview" class="d-flex">
                                    <c:choose>
                                        <c:when test="${product.images!=null && !product.images.equals('')}">
                                            <c:set var="images" value="${fn:split(product.images,';')}"/>
                                            <c:forEach items="${images}" var="image">
                                                <img class="m-2" width="150px"
                                                     src="${pageContext.request.contextPath}/resources/upload/product/${product.id}/${image}"
                                                     id="thumb_preview" alt="Hình đại diện"/>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <img width="150px"
                                                 src="${pageContext.request.contextPath}/resources/admin/assets/images/preview.jpg"
                                                 id="thumb_preview" alt="Hình đại diện"/>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="price" class="col-form-label">Giá</label>
                                <div>
                                    <input min="0.00" step="0.01" required type="number" class="form-control"
                                           id="price"
                                           name="price" value="${product.price}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="sale">Giảm giá</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Giảm ... %" name="sale"
                                           id="sale" value="${product.sale}">
                                    <div class="input-group-append">
                                        <button class="btn btn-light" type="button">%</button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="desc" class="col-form-label">Mô tả</label>
                                <div>
                                    <textarea required class="form-control" rows="4" id="desc"
                                              name="desc">${product.description}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-check-label">
                                    <input type="checkbox" value="1" name="status"
                                    <c:if test="${product.status==true}">
                                        <c:out value="checked"/>
                                    </c:if>  > Còn hàng
                                </label>
                            </div>
                            <div class="form-footer">
                                <button class="btn btn-danger"><i class="fa fa-times"></i><a
                                        href="${pageContext.request.contextPath}/quan-tri/san-pham/danh-sach">Hủy</a>
                                </button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Cập
                                    nhật
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
    CKEDITOR.replace('desc')
</script>
<jsp:include page="./footer/footer.jsp" flush="true"/>
