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
                <div class="card-title">Cập nhật User</div>
                <hr>
                <form action="${pageContext.request.contextPath}/quan-tri/user/update" method="post"
                      accept-charset="UTF-8"
                              enctype="multipart/form-data">
                  <div class="form-group">
                    <label for="input-1">ID</label>
                    <input type="text" class="form-control" id="input-1" type="HIDDEN" readonly="readonly" placeholder="ID" value="${user.id}" name="user-id">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Họ</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Họ" value="${user.lastName}" name="user-lastname">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Tên</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Tên" value="${user.firstName}" name="user-firstname">
                  </div>
                  <div class="form-group">
                    <label for="input-4">Giới tính</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Nhập giới tính" value="${user.gender}" name="user-gender">
                  </div>
                    <div class="form-group">
                    <label for="input-5">Ngày sinh</label>
                    <input  class="form-control" id="input-1" placeholder="Nhập ngày sinh" value="${user.date}" name="user-date">
                  </div>
                    <div class="form-group">
                    <label for="input-5">Địa chỉ</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Nhập địa chỉ" value="${user.address}" name="user-address">
                  </div>
                  <div class="form-group">
                    <label for="input-6">Email</label>
                    <input type="text" class="form-control" id="input-3" placeholder="Địa chỉ Email" value="${user.mail}" name="user-mail">
                  </div>
                  <div class="form-group">
                    <label for="input-7">Số điện thoại</label>
                    <input type="text" class="form-control" id="input-4" placeholder="Số điện thoại" value="${user.phoneNumber}" name="user-phone">
                  </div>
                  <div class="form-group">
                    <label for="input-8">UserName</label>
                    <input type="text" class="form-control" id="input-5" placeholder="Username" value="${user.userName}" name="user-userName">
                  </div>
                  <div class="form-group">
                    <label for="myinput">Mật khẩu</label>
                    <input type="password" class="form-control" id="myinput" placeholder="Mật khẩu" value="${user.password}" name="user-password">
					<input type="checkbox" onclick="myFunction1()">Hiển thị mật khẩu
					<script>function myFunction1() {
                    	  var x = document.getElementById("myinput");
                    	  if (x.type === "password") {
                    	    x.type = "text";
                    	  } else {
                    	    x.type = "password";
                    	  }
                    	}
					</script>                   
                  </div>
                    <div class="form-group">
                                <label for="thumb">Hình đại diện</label>
                                <input type="file" name="thumb" accept="image/*" id="thumb"/>
                                <p>
                                    <c:choose>
                                        <c:when test="${user.picture!=null && !user.picture.equals('')}">
                                            <img width="150px"
                                                 src="${pageContext.request.contextPath}/resources/upload/user/${user.id}/${user.picture}"
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
                    <label for="input-9">Date</label>
                    <input type="date" class="form-control" id="input-9" placeholder="Ngày tạo" value="${user.created}" name="user-created">
                  </div>
                  
                  <div class="form-group">
                    <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/quan-tri/user/danh-sach">Hủy</a></button>
                         
                     <button type="submit" class="btn btn-success">Cập nhật</button>
                     <script>
$(document).ready(function(){
  $("form").submit(function(){
    alert("Cập nhật thành công");
  });
});
</script>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>

    <jsp:include page = "./footer/footer.jsp" flush = "true" />