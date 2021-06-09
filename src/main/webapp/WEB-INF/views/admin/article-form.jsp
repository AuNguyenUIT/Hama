<%-- 
    Document   : artical-form
    Created on : Jun 8, 2021, 7:30:06 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start header section -->
<jsp:include page = "./header/header.jsp" flush = "true" />
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/assets/js/previewFile.js"></script>
<div class="content-wrapper">
    <div class="container-fluid">
        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Thêm bài viết</div>
                        <hr>
                        <c:choose>
                            <c:when test="${articles.id ==null}">
                        <form method="post" action="${pageContext.request.contextPath}/quan-tri/bai-viet/them" accept-charset="UTF-8"
                                      enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="input-1">Chủ đề bài viết</label>
                                <input type="text" class="form-control" id="input-1" placeholder="Chủ đề bài viết" name="article-title">
                            </div>
                            
                            <div class="form-group">
                                <label for="input-1">Ngày</label>
                                <input type="date" class="form-control" id="the-date" placeholder="Ngày đăng" name="article-day">
                            </div>
                          
                        

                            <div class="form-group">
                                <label for="input-2" class="col-form-label">Nội dung</label>
                                <div>
                                    <textarea class="form-control" rows="30" id="input-17" name="article-body"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input-1">Ảnh đại diện</label>
                                <input type="file" class="form-control" id="input-1" placeholder="Tên hình" name="thumb">
                            </div>
                            
                            <div class="form-group">
                                <label for="input-2">Trạng thái</label>
                                <div>
                                    <select class="form-control valid" id="input-6" name="article-status" required aria-invalid="false">
                                        <option value="1">Công khai</option>
                                        <option value="0">Riêng tư</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-footer">
                                <button class="btn btn-danger"><i class="fa fa-times"></i><a href="${pageContext.request.contextPath}/quan-tri/bai-viet/danh-sach">Hủy</a></button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm</button>
                            </div>
                                
                        
                        </form>
                        </c:when>
                        <c:otherwise>
                                <form action="${pageContext.request.contextPath}/quan-tri/bai-viet/chinh-sua"
                                      method="post" enctype="multipart/form-data">
                                    <input  type ="HIDDEN" name="id" value="${articles.id}">
                                    <input  type ="HIDDEN" name="thumb" value="${articles.thumb}">
                                    <div class="form-group">
                                        <label for="art-name">Chủ đề bài viết</label>
                                        <input type="text" class="form-control" id="art-name"
                                               
                                               required="required"
                                               value="${articles.title}"
                                               name="art-title">
                                    </div>
                                    <div class="form-group">
                                        <label for="art-body">Nội dung</label>
                                        <input type="text" class="form-control" id="art-body"
                                               placeholder="Nội dung"
                                               required="required"
                                               value="${articles.body}"
                                               name="art-body"
                                              >
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="thumb">Hình đại diện</label>
                                        <input type="file" name="thumb" accept="image/*" id="thumb"/>
                                        <p>
                                            <c:choose>
                                                <c:when test="${articles.thumb !=null && articles.thumb!=''}">
                                                    <img width="150px"
                                                         src="${pageContext.request.contextPath}/resources/upload/article/${articles.thumb}"
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
                                <label for="input-2">Trạng thái</label>
                                <div>
                                    <c:if test="${articles.status==1}">
                                    <select class="form-control valid" id="input-6" name="article-status" required aria-invalid="false" >
                                        <option value="1">Công khai</option>
                                        <option value="0">Riêng tư</option>
                                    </select>
                                    </c:if>
                                    <c:if test="${articles.status==0}">
                                    <select class="form-control valid" id="input-6" name="article-status" required aria-invalid="false" >
                                        <option value="0">Riêng tư</option>
                                        <option value="1">Công khai</option>
                                        
                                    </select>
                                    </c:if>
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
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;


    document.getElementById('the-date').value = today;
</script>
<jsp:include page = "./footer/footer.jsp" flush = "true" />

