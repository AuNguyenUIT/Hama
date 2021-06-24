
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
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
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
<script src="https://www.mindmeister.com/api/v2/js/api.js?client_id=[Client_ID]"></script>

<script>

</script>
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm người dùng</div>
                <hr>
                <form action="${pageContext.request.contextPath}/quan-tri/nguoi-dung/them" method="post"
                      accept-charset="UTF-8"
                              enctype="multipart/form-data">
                 <div class="form-group">
                    <label for="input-1">Họ</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Nhập họ" name="user-lastname" required autofocus>
                  </div>
                  <div class="form-group">
                    <label for="input-2">Tên</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Nhập tên" name="user-firstname" required>
                  </div>
                    <div class="form-group">
                        <label for="input-3">Giới tính</label><br>
                    <input type="radio" id="male" name="user-gender" value="male"><label for="male">Nam</label><br>
                     <input type="radio" id="female" name="user-gender" value="female"> <label for="female">Nữ</label><br>
  
 
                  </div>
                    <div class="form-group">
                    <label for="input-4">Ngày sinh</label>
                    <input type="date" class="form-control" id="input-4" placeholder="Nhập ngày sinh" name="user-date">
                  </div>
                    <div class="form-group">
                    <label for="input-5">Địa chỉ</label>
                    <textarea type="text" class="form-control" id="input-5" placeholder="Nhập địa chỉ" name="user-address" required"></textarea>
                  </div>
                   
                  <div class="form-group">
                    <label for="input-6">Email</label>
                    <input type="text" class="form-control" id="input-6" placeholder="Nhập địa chỉ Email" name="user-mail" required>
                  </div>
                  <div class="form-group">
                    <label for="input-7">Số Điện Thoại</label>
                    <input type="text" class="form-control" id="input-7" placeholder="Nhập số điện thoại" name="user-phone" required>
                  </div>
                  <div class="form-group">
                    <label for="input-8">Tên đăng nhập</label>
                    <input type="text" class="form-control" id="input-8" placeholder="Nhập tên đăng nhập" name="user-userName" required>
                  </div>
                   <div class="form-group">
                       <label for="input-8">Vai trò</label><br>
                    <input type="radio" id="admin" name="user-role" value="admin"><label for="admin">Admin</label><br>
                     <input type="radio" id="user" name="user-role" value="user"> <label for="user">User</label><br>
                  </div>
                  <div class="form-group">
                    <label for="myinput">Mật khẩu</label>
                    <input type="password" class="form-control" id="myinput" placeholder="Nhập mật khẩu" name="user-password" required>
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
                                    <img width="150px"
                                         src="${pageContext.request.contextPath}/resources/admin/assets/images/preview.jpg"
                                         id="thumb_preview" alt="Hình đại diện"/>
                                </p>
                      </div>
                  <div class="form-group">
                    <label for="the-date">Ngày tạo</label>
                    <input type="date" class="form-control" id="the-date" placeholder="Ngày tạo" name="user-created">
                  </div>
                  <div class="form-group">
                      
                      <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/quan-tri/user/danh-sach">Hủy</a></button>
                      <button  type="submit" class="btn btn-light px-5"  ><i class="icon-lock" ></i> Đăng ký</button>
                      
                    
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
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
                
</script>
<script>
    $(document).ready(function () {
        $("form").submit(function (e) {
            e.preventDefault();
             var href = "${pageContext.request.contextPath}/quan-tri/nguoi-dung/danh-sach";
            $.confirm({
                title: 'Thông báo',
                content: 'Đăng ký thành công',
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

    <jsp:include page = "./footer/footer.jsp" flush = "true" />