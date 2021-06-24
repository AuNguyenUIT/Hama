<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VănÂuNguyễn
  Date: 30/05/2021
  Time: 4:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Thêm danh mục</div>
                        <hr>
                        <c:choose>
                            <c:when test="${category.id ==null}">
                                <form action="${pageContext.request.contextPath}/quan-tri/danh-muc/them" method="post"
                                      accept-charset="UTF-8"
                                      enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="cate-name-add">Tên chuyên mục</label>
                                        <input type="text" class="form-control" id="cate-name-add" required="required"
                                               placeholder="Tên danh mục"
                                               name="cate-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="parent-cate">Danh mục cha</label>
                                        <select name="parent-cate" class="form-control" id="parent-cate">
                                            <option value="0" selected>Không có danh mục cha</option>

                                            <c:forEach var="category" items="${categories}">
                                                <option value="${category.id}" }>${category.title}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="thumb">Hình đại diện</label>
                                        <input type="file" name="thumb" accept="image/*" id="thumb"/>
                                        <p>
                                            <img width="150px"
                                                 src="${pageContext.request.contextPath}/resources/admin/assets/images/preview.jpg"
                                                 id="thumb_preview" alt="Hình đại diện"/>
                                        </p>
                                    </div>
                                    <div class="form-footer">
                                        <a class="btn btn-danger"
                                           href="${pageContext.request.contextPath}/quan-tri/danh-muc/danh-sach"> <i
                                                class="fa fa-times"></i>&nbsp;Hủy</a>
                                        <button type="submit" class="btn btn-success"><i
                                                class="fa fa-check-square-o"></i>
                                            Thêm
                                        </button>
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="${pageContext.request.contextPath}/quan-tri/danh-muc/chinh-sua"
                                      method="post" enctype="multipart/form-data" >
                                    <input type="HIDDEN" name="id" value="${category.id}">
                                    <input type="HIDDEN" name="thumb" value="${category.thumb}">
                                    <div class="form-group">
                                        <label for="cate-name">Tên danh mục</label>
                                        <input type="text" class="form-control" id="cate-name"
                                               placeholder="Tên danh mục"
                                               required="required"
                                               value="${category.title}"
                                               name="cate-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="parent-cate">Danh mục cha</label>
                                        <select name="parent-cate" class="form-control" id="parent-cate">
                                            <option value="0" selected>Không có danh mục cha</option>
                                            <c:forEach var="parentCate" items="${categories}">
                                                <c:if test="${parentCate.id!=category.id and parentCate.category.id != category.id}">
                                                    <option value="${parentCate.id}" ${parentCate.id == category.category.id ? 'selected="selected"' : ''}>${parentCate.title}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="thumb">Hình đại diện</label>
                                        <input type="file" name="thumb" accept="image/*" id="thumb"/>
                                        <p>
                                            <c:choose>
                                                <c:when test="${category.thumb !=null && category.thumb!=''}">
                                                    <img width="150px"
                                                         src="${pageContext.request.contextPath}/resources/upload/category/${category.thumb}"
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
                                    <div class="form-footer">
                                        <a class="btn btn-danger"
                                           href="${pageContext.request.contextPath}/quan-tri/danh-muc/danh-sach"> <i
                                                class="fa fa-times"></i>&nbsp;Hủy</a>
                                        <button type="submit" class="btn btn-success"><i
                                                class="fa fa-pencil-square-o"></i>
                                            Cập Nhật
                                        </button>
                                    </div>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("form").submit(function (e) {
            e.preventDefault();
             var href = "${pageContext.request.contextPath}/quan-tri/danh-muc/danh-sach";
            $.confirm({
                title: 'Thông báo',
                content: 'Thành công',
                type: 'danger',
                buttons: {
                    ok: {
                        text: "OK",
                        btnClass: 'btn-danger',
                        keys: ['enter'],
                        action: function () {
                            window.location.href = href;
                        }
                    }
                }
            });
        });
        if ("${message}") {
       
     showMessage("${message}", "${type}");
        }
    });
</script>
<jsp:include page="./footer/footer.jsp" flush="true"/>