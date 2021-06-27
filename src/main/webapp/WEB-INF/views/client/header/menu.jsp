<%-- 
    Document   : menu
    Created on : May 5, 2020, 11:15:00 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value ="/resources/client/assets" var="url"/>
        <section id="menu">
    <div class="container">
      <div class="menu-area">
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>          
          </div>
          <div class="navbar-collapse collapse">
            <!-- Left nav -->
            <ul class="nav navbar-nav">
              <li><a href="${pageContext.request.contextPath}/">TRANG CHỦ</a></li>
              <li><a href="${pageContext.request.contextPath}/gioi-thieu">GIỚI THIỆU</a></li>
            <li><a href="${pageContext.request.contextPath}/san-pham">SẢN PHẨM</span></a>
                <ul class="dropdown-menu">                
                  <li><a href="product.jsp">MÓC KHÓA</a></li>
                  <li><a href="product.jsp">VÒNG TAY</a></li>
                  <li><a href="product.jsp">GẤU BÔNG</a></li>
                  <li><a href="product.jsp">HOA GIẤY</a></li>
                  <li><a href="product.jsp">MÔ HÌNH LƯU NIỆM</a></li>
                </ul>
              </li>
              <li><a href="${pageContext.request.contextPath}/bai-viet">BÀI VIẾT</a></li>
              <li><a href="${pageContext.request.contextPath}/chinh-sach">CHÍNH SÁCH</a></li>
              <li><a href="${pageContext.request.contextPath}/lien-he">LIÊN HỆ</a></li>
              <li class="aa-search"><!-- search box -->
              <a class="aa-search-box">
                <form action="${pageContext.request.contextPath}/san-pham/search" method="GET">
                  <input type="text" name="s" id="" placeholder="Tìm kiếm sản phẩm..">
                 <button class="serach-box"><span class="fa fa-search"></span></button>
                </form>
              </a>
              <!-- / search box -->
             </li>
            </ul>
          </div><!--/.nav-collapse -->
          
        </div>
      </div>       
    </div>
  </section>
