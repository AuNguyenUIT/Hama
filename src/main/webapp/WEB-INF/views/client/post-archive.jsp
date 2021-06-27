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
    <img src="${pageContext.request.contextPath}/resources/client/assets/images/images/banner-post.jpg"
         alt="banner blog">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Tin tức</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Tin tức</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- Blog Archive -->
<section id="aa-blog-archive">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-blog-archive-area">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="aa-blog-content">
                                <div class="row">
                                    <c:forEach items="${posts}" var="post">
                                        <div class="col-md-4 col-sm-4">
                                            <article class="aa-blog-content-single">
                                                    <%--                        <h4><a href="${pageContext.request.contextPath}/bai-viet/${post.id}">${post.title}</a></h4>--%>
                                                    <%--                        <figure class="aa-blog-img">--%>
                                                    <%--                          <a href="${pageContext.request.contextPath}/bai-viet/${post.id}"><img src="${pageContext.request.contextPath}/resources/client/assetsimages/news/${post.thumb}" alt="farm products" height="180px" width="300px"></a>--%>
                                                    <%--                        </figure>--%>
                                                    <%--                        <p class="desc-posts">${post.body}</p>--%>
                                                    <%--                        <div class="aa-article-bottom">--%>
                                                    <%--                          <div class="aa-post-author">--%>
                                                    <%--&lt;%&ndash;                            Đăng bởi <a href="#">${post.author}</a>&ndash;%&gt;--%>
                                                    <%--                          </div>--%>
                                                    <%--                          <div class="aa-post-date">${post.created}</div>--%>
                                                    <%--                        </div>--%>


                                                <figure class="aa-blog-img">
                                                    <a href="${pageContext.request.contextPath}/bai-viet/${post.id}"><img
                                                            src="${pageContext.request.contextPath}/resources/upload/post/${post.thumb}"
                                                            height="180px" width="300px"
                                                            alt="Tin tức ${post.title}"></a>
                                                    <figcaption class="aa-blog-img-caption">
                                                        <h3 class="aa-blog-title"><a
                                                                href="${pageContext.request.contextPath}/bai-viet/${post.id}">${post.title}</a>
                                                        </h3>

                                                    </figcaption>
                                                </figure>
<%--                                                <div class="aa-blog-info">--%>
<%--                                                    <span href="#"><i class="fa fa-clock-o"></i><fmt:formatDate--%>
<%--                                                            value="${post.created}"--%>
<%--                                                            pattern="yyyy-MM-dd HH:mm"/></span>--%>
<%--                                                </div>--%>
                                            </article>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!-- Blog Pagination -->

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Blog Archive -->

<!-- end content-->

<!-- footer-->
<jsp:include page="./footer/footer.jsp" flush="true"/>
<!-- end footer-->
  
  
