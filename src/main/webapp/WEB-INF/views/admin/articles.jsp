<%-- 
    Document   : articles
    Created on : Jun 8, 2021, 6:50:59 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");--%>
<%--    response.setHeader("Pragma", "no-cache");--%>
<%--    response.setHeader("Expires", "0");--%>


<%--    if (session.getAttribute("admin-username") == null) {--%>
<%--        response.sendRedirect(request.getContextPath() + "/admin/login");--%>
<%--    }--%>
<%--%>--%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true"/>
<div class="content-wrapper">
    <div class="container-fluid">
        <!--End Row-->
        <div class="row">
            <div class="col-lg-12">
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/quan-tri/bai-viet/them">Thêm bài viết</a></button>
            </div>
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách bài viết</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Hình đại diện</th>
                                    <th scope="col">Chủ đề</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Ngày đăng</th>
                                    <th scope="col">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${articles}" var="art" varStatus="loop">
                                    <tr>
                                        <td scope="row">${loop.index+1}</td>
                                        <td scope="row">
                                            <c:if test="${art.thumb !=null && art.thumb!=''}">
                                                <img width="150px"
                                                     src="${pageContext.request.contextPath}/resources/upload/article/${art.thumb}">
                                            </c:if>
                                        </td>
                                        <td scope="row">${art.title}</td>
                                        <td scope="row">
                                            <c:if test="${art.status == 1}">Công khai</c:if>
                                            <c:if test="${art.status == 0}">Riêng tư</c:if>
                                        </td>
                                        <td scope="row">${art.created}
                                        </td>
                                            <td scope="row">
                                            <a class="btn btn-danger"
                                               href="${pageContext.request.contextPath}/quan-tri/bai-viet/xoa?id=${art.id}">Xóa</a>
                                            <a class="btn btn-success"
                                               href="${pageContext.request.contextPath}/quan-tri/bai-viet/chinh-sua?id=${art.id}">Sửa</a>
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
