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
                        <form method="post" action="${pageContext.request.contextPath}/quan-tri/san-pham/them"
                              accept-charset="UTF-8"
                              enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="title">Tên sản phẩm</label>
                                <input type="text" class="form-control" id="title" placeholder="Tên sản phẩm"
                                       name="title" required>
                            </div>
                            <div class="form-group">
                                <label for="cate_id">Chuyên mục</label>
                                <div>
                                    <select class="form-control valid" id="cate_id" name="cate_id"
                                            aria-invalid="false">
                                        <c:forEach items="${categoryList}" var="cate">
                                            <option value="${cate.id }">${cate.title }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="thumb">Hình đại diện</label>
                                <input type="file" name="thumb" accept="image/*" id="thumb" required/>
                                <p>
                                    <img width="150px"
                                         src="${pageContext.request.contextPath}/resources/admin/assets/images/preview.jpg"
                                         id="thumb_preview" alt="Hình đại diện"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label for="multiple_image">Một số hình ảnh khác</label>
                                <input type="file" name="multiple_image" accept="image/*" id="multiple_image" multiple
                                       required/>
                                <div id="preview" class="d-flex">
                                    <img width="150px"
                                         src="${pageContext.request.contextPath}/resources/admin/assets/images/preview.jpg"
                                         id="thumb_preview" alt="Xem trước"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="price" class="col-form-label">Giá</label>
                                <div>
                                    <input min="0.00" step="0.01" required type="number" class="form-control" value="0"
                                           id="price"
                                           name="price"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="sale">Giảm giá</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Giảm ... %" name="sale"
                                           value="0"
                                           id="sale">
                                    <div class="input-group-append">
                                        <button class="btn btn-light" type="button">%</button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="summary" class="col-form-label">Mô tả ngắn</label>
                                <div>
                                    <textarea required class="form-control" rows="4" id="summary"
                                              name="summary"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="desc" class="col-form-label">Mô tả</label>
                                <div>
                                    <textarea required class="form-control" rows="4" id="desc"
                                              name="desc"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-check-label">
                                    <input type="checkbox" value="1" name="status" checked> Còn hàng
                                </label>
                            </div>
                            <div class="form-footer">
                                <button class="btn btn-danger"><i class="fa fa-times"></i><a
                                        href="${pageContext.request.contextPath}/quan-tri/danh-muc/danh-sach">Hủy</a>
                                </button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm
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
