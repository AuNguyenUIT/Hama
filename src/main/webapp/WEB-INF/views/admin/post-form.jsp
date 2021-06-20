<%-- 
    Document   : artical-form
    Created on : Jun 8, 2021, 7:30:06 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true"/>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/assets/js/previewFile.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/ckeditor/ckeditor.js"></script>

<div class="content-wrapper">
    <div class="container-fluid">
        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Thêm bài viết</div>
                        <hr>
                        <c:choose>
                            <c:when test="${post.id ==null}">
                                <form method="post" action="${pageContext.request.contextPath}/quan-tri/bai-viet/them"
                                      accept-charset="UTF-8"
                                      enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="title">Tiêu đề</label>
                                        <input type="text" class="form-control" id="title" placeholder="Chủ đề bài viết"
                                               name="title">
                                    </div>
                                    <div class="form-group">
                                        <label for="thumb">Ảnh đại diện</label>
                                        <input type="file" name="thumb" accept="image/*" id="thumb"/>
                                        <p>
                                            <img width="150px"
                                                 src="${pageContext.request.contextPath}/resources/admin/assets/images/preview.jpg"
                                                 id="thumb_preview" alt="Hình đại diện"/>
                                        </p>
                                    </div>

                                    <div class="form-group">
                                        <label for="body" class="col-form-label">Nội dung</label>
                                        <div>
                                            <textarea class="form-control" rows="30" id="body"
                                                      name="body"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="form-check-label">
                                            <input type="checkbox" value="1" name="status" checked> Công khai
                                        </label>
                                    </div>
                                    <div class="form-footer">
                                        <button class="btn btn-danger"><i class="fa fa-times"></i><a
                                                href="${pageContext.request.contextPath}/quan-tri/bai-viet/danh-sach">Hủy</a>
                                        </button>
                                        <button type="submit" class="btn btn-success"><i
                                                class="fa fa-check-square-o"></i> Thêm
                                        </button>
                                    </div>


                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="${pageContext.request.contextPath}/quan-tri/bai-viet/chinh-sua"
                                      method="post" enctype="multipart/form-data">
                                    <input type="HIDDEN" name="id" value="${post.id}">
                                    <input type="HIDDEN" name="thumb" value="${post.thumb}">
                                    <div class="form-group">
                                        <label for="art-name">Chủ đề bài viết</label>
                                        <input type="text" class="form-control" id="art-name"

                                               required="required"
                                               value="${post.title}"
                                               name="title">
                                    </div>
                                    <div class="form-group">
                                        <label for="thumb">Hình đại diện</label>
                                        <input type="file" name="thumb" accept="image/*" id="thumb"/>
                                        <p>
                                            <c:choose>
                                                <c:when test="${post.thumb !=null && post.thumb!=''}">
                                                    <img width="150px"
                                                         src="${pageContext.request.contextPath}/resources/upload/post/${post.thumb}"
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
                                        <label for="body">Nội dung</label>
                                        <textarea class="form-control" rows="30" id="body"
                                                  name="body">${post.body}</textarea>
                                    </div>

                                    <div class="form-group">
                                        <div>
                                            <label class="form-check-label">
                                                <input type="checkbox" value="1" name="status"
                                                <c:if test="${post.status==true}">
                                                    <c:out value="checked"/>
                                                </c:if>  > Công khai
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-footer">
                                        <a class="btn btn-danger"
                                           href="${pageContext.request.contextPath}/quan-tri/bai-viet/danh-sach"> <i
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
  CKEDITOR.replace("body")
</script>
<jsp:include page="./footer/footer.jsp" flush="true"/>

