<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/resource/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  
  <section id="aa-catg-head-banner">
   <img src="${pageContext.request.contextPath}/resources/client/assets/images/images/banner-hm.jpg" alt="banner sản phẩm">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Giới thiệu</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>      
          <li style="color:#fff">Giới thiệu</li>   
        </ol>
      </div>
     </div>
   </div>
  </section>
  <section id="aa-product-category">
    <div class="container">
      <div class="row">
      	<div>
      		<h1 style ="text-align: center; color: red;">SHOP HANDMADE - HAMA</h1>
      		<p>Ở Việt Nam, sản phẩm handmade luôn dành được sự quan tâm của mọi người. Nhưng lại chưa thật sự có một kênh phân phối
                    nào nổi bật để mọi người quan tâm. Nên chủ yếu các bạn trẻ thường sẽ tự tìm hiểu và tự tạo ra các sản phẩm handmade.
                    Thường những sản phẩm đó mang lại rất nhiều ý nghĩa về mặt tình cảm, nhưng lại cần rất nhiều thời gian và công sức cho
                    những người không chuyên. Mặc khác, sản phẩm tạo ra có thể không đảm bảo về mặt chất lượng. Đối với những người không 
                    khéo tay thì để tạo ra những sản phẩm handmade lại là một điều khó khăn, mà bản thân họ vẫn có nhu cầu sở hữu, gửi tặng
                    những sản phẩm này.</p>
	<p>Hiểu được nhu cầu đó của khách hàng, nhóm chúng tôi quyết định tạo một website bán sản phẩm handmade – 
            một kênh phân phối sản phẩm handmade uy tín, chất lượng tại Việt Nam. Để đáp ứng nhu cầu trên của khách hàng 
            mà ít ai quan tâm, đồng thời tạo ra một thương hiệu mới trên thị trường, cải tạo lại chất lượng trên thị trường màu mỡ này.</p>

                <p>Mang ý nghĩa là một sản phẩm nghệ thuật, tự tay còn người làm ra, nên chứa đựng trong đó đầy tình cảm, công sức, ý nghĩa nhiều hơn những sản phẩm thông thường.</p>

                   <p>Là một sản phẩm được làm bằng tay nên sản phẩm tạo ra có thể không nhiều nên rất giá trị, mặc khác dù các tác phẩm có thể sao chép xong không thể nào giống y hệt sản phẩm ban đầu.
Với công nghệ tiên tiến như hiện nay, ở những nước phát triển như Châu u,.. và ở Việt Nam đang là phong trào, con người lại thích những sản được làm bằng tay và vì thế những người làm đồ handmade giỏi lại kiếm được nhiều tiền trong những món đồ mà họ tạo ra.
Có thể nói đồ handmade còn là một giá trị nghệ thuật và người làm đồ handmade là một nghệ nhân thật thụ.</p>
                   <p style="text-align: center">  <img src="${pageContext.request.contextPath}/resources/client/assets/images/images/product/2s3.jpg" alt="Sản phẩm handmade"></p>
                   <p style="text-align: center"> <img src="${pageContext.request.contextPath}/resources/client/assets/images/images/product/3s1.jpg" alt="Sản phẩm handmade"></p>
                    
      	</div>
      </div>
     </div>
    </section>
    
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
      