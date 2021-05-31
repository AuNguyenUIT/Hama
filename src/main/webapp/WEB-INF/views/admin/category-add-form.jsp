<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VănÂuNguyễn
  Date: 30/05/2021
  Time: 4:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true"/>
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
                                <form action="${pageContext.request.contextPath}/quan-tri/danh-muc/them" method="post">
                                    <div class="form-group">
                                        <label for="cate-name-add">Tên chuyên mục</label>
                                        <input type="text" class="form-control" id="cate-name-add" required="required"
                                               placeholder="Tên danh mục"
                                               name="cate-name">
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
                                      method="post">
                                    <input type="HIDDEN" name="id" value="${category.id}">
                                    <input type="HIDDEN" name="created" value="${category.created}">
                                    <div class="form-group">
                                        <label for="cate-name">Sửa danh mục</label>
                                        <input type="text" class="form-control" id="cate-name"
                                               placeholder="Tên danh mục"
                                               required="required"
                                               value="${category.title}"
                                               name="cate-name">
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

<jsp:include page="./footer/footer.jsp" flush="true"/>