
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <jsp:include page = "./header/header.jsp" flush = "true" />
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/assets/js/previewFile.js"></script>
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Cập nhật người dùng</div>
                <hr>
                <form action="${pageContext.request.contextPath}/quan-tri/nguoi-dung/chinh-sua" method="post"
                      accept-charset="UTF-8"
                              enctype="multipart/form-data">
                    <div class="form-group" hidden="true">
                    <label for="input-1">ID</label>
                    <input type="text" class="form-control" id="input-1"   readonly="readonly" placeholder="ID" value="${user.id}" name="user-id" >
                  </div>
                  <div class="form-group">
                    <label for="input-2">Họ</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Họ" value="${user.lastName}" name="user-lastname">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Tên</label>
                    <input type="text" class="form-control" id="input-3" placeholder="Tên" value="${user.firstName}" name="user-firstname">
                  </div>
                  <div class="form-group">
                    <label>Giới tính</label><br>
                    <c:choose>
                    <c:when test="${user.gender=='male'}">
                        <input type="radio" id="male" name="user-gender" value="male"  checked="checked" ><label for="male">Nam</label><br>
                          <input type="radio" id="female" name="user-gender" value="female" > <label for="female" >Nữ</label><br>
                 </c:when>
                          <c:otherwise>
                          <input type="radio" id="male" name="user-gender" value="male"   ><label for="male">Nam</label><br>
                          <input type="radio" id="female" name="user-gender" value="female" checked="checked" > <label for="female" >Nữ</label><br>
                          </c:otherwise>
                    </c:choose>
                          
                          
                  </div>
                    <div class="form-group">
                    <label for="input-5">Ngày sinh</label>
                    <input type="date" class="form-control" id="input-5" placeholder="Nhập ngày sinh" value="${date}" name="user-date">
                  </div>
                    <div class="form-group">
                    <label for="input-6">Địa chỉ</label>
                    <textarea type="text" class="form-control" id="input-6" placeholder="Nhập địa chỉ"  name="user-address">${user.address}</textarea>
                  </div>
                  <div class="form-group">
                    <label for="input-7">Email</label>
                    <input type="text" class="form-control" id="input-7" placeholder="Địa chỉ Email" value="${user.mail}" name="user-mail"  readonly="readonly">
                  </div>
                  <div class="form-group">
                    <label for="input-8">Số điện thoại</label>
                    <input type="text" class="form-control" id="input-8" placeholder="Số điện thoại" value="${user.phoneNumber}" name="user-phone"  readonly="readonly">
                  </div>
                  <div class="form-group">
                    <label for="input-9">Tên đăng nhập</label>
                    <input type="text" class="form-control" id="input-9" placeholder="Tên đăng nhập"  value="${user.userName}" name="user-userName" readonly="readonly">
                  </div>
                  <div class="form-group">
                      <label for="input-10">Vai trò</label><br>
                    <c:choose>
                    <c:when test="${user.role=='admin'}">
                        <input type="radio" id="admin" name="user-role" value="admin"  checked="checked" ><label for="admin">Admin</label><br>
                          <input type="radio" id="user" name="user-role" value="user" > <label for="user" >User</label><br>
                 </c:when>
                          <c:otherwise>
                          <input type="radio" id="admin" name="user-role" value="admin"   ><label for="admin">Admin</label><br>
                          <input type="radio" id="user" name="user-role" value="user"checked="checked"> <label for="user" >User</label><br>
                          </c:otherwise>
                    </c:choose>
                    
                  </div>
                  <div class="form-group">
                    <label for="myinput">Mật khẩu</label>
                    <input type="password" class="form-control" id="myinput" placeholder="Mật khẩu"  value="${user.password}" name="user-password" readonly="readonly">
					
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
                    <label for="the-date">Ngày tạo</label>
                    <input type="date" class="form-control" id="the-date" placeholder="Ngày tạo" value="${user.created}" name="user-created">
                  </div>
                  <div class="form-group">
                    <label for="cbox">Trạng thái</label>
                    <c:choose>
                    <c:when test="${user.status==true}">
                         <input type="checkbox" class="form-control" id="cbox" value="" name="user-status" checked="checked">
                    </c:when>
                    <c:otherwise>
                        <input type="checkbox" class="form-control" id="cbox" name="user-status"  value="true">
                    </c:otherwise>
                    </c:choose>

                  </div>
                  <div class="form-group">
                    <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/quan-tri/nguoi-dung/danh-sach">Hủy</a></button>
                         
                     <button type="submit" class="btn btn-success btn-edit">Cập nhật</button>
                     <script>

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
                content: 'Cập nhật thành công',
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