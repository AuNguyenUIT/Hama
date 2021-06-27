

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
    <img src="${pageContext.request.contextPath}/resources/client/assets/images/checkout-banner.png"
         alt="banner thanh toán">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Thanh toán</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Thông tin thanh toán</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="checkout">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="checkout-area">
                    <form action="${pageContext.request.contextPath}/thanh-toan" method="post" id="checkout-form">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="checkout-left">
                                    <div class="panel-group">
                                        <!-- Shipping Address -->
                                        <div class="panel panel-default aa-checkout-billaddress">
                                            <div class="panel-heading">
                                                <h4 class="panel-title" style="color:#754110">
                                                    Địa chỉ giao hàng
                                                </h4>
                                            </div>
                                            <div id="collapseFour">
                                                <div class="panel-body">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="text" placeholder="Họ Tên*"
                                                                       required="required" name="transaction_name"
                                                                       value="${sessionScope.firstname} ${sessionScope.lastname}">
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="email" placeholder="Email"
                                                                       required="required" name="transaction_email"
                                                                       value="${sessionScope.email}" disabled>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="tel" placeholder="Số điện thoại*"
                                                                       required="required" name="transaction_phone"
                                                                       value="${sessionScope.phone}">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                    <textarea cols="8" rows="3" required="required"
                                                                              placeholder="Địa chỉ*"
                                                                              name="transaction_address">${sessionScope.address}</textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                    <textarea cols="8" rows="3" placeholder="Ghi chú"
                                                                              name="transaction_mess"></textarea>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <%--                                                    <div class="row">--%>
                                                    <%--                                                        <div class="col-md-12">--%>
                                                    <%--                                                            <div class="aa-checkout-single-bill">--%>
                                                    <%--                                                                <input type="date" placeholder="Password"--%>
                                                    <%--                                                                       name="transaction_created" id="the-date"--%>
                                                    <%--                                                                       style="display: none">--%>
                                                    <%--                                                            </div>--%>
                                                    <%--                                                        </div>--%>
                                                    <%--                                                    </div>--%>

                                                    <%--                                                    <div class="row" style="display: none">--%>
                                                    <%--                                                        <div class="col-md-12">--%>
                                                    <%--                                                            <div class="aa-checkout-single-bill">--%>
                                                    <%--                                                                <input type="text" placeholder="userid_session"--%>
                                                    <%--                                                                       name="transaction_usersession"--%>
                                                    <%--                                                                       value="${username }">--%>

                                                    <%--                                                                <input type="text" placeholder="totalmoney_session"--%>
                                                    <%--                                                                       name="transaction_amount"--%>
                                                    <%--                                                                       value="${sumprice}">--%>
                                                    <%--                                                            </div>--%>
                                                    <%--                                                        </div>--%>
                                                    <%--                                                    </div>--%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="checkout-right">
                                    <h4>Thông tin đơn hàng</h4>
                                    <div class="aa-order-summary-area">
                                        <table class="table table-responsive">
                                            <thead>
                                            <tr>
                                                <th>Sản phẩm</th>
                                                <th>Số tiền</th>
                                            </tr>
                                            </thead>
                                            <%--                                            <tbody>--%>
                                            <%--                                            <c:forEach items="${order.items}" var="item">--%>
                                            <%--                                                <tr>--%>
                                            <%--                                                    <td>${item.product.name } <strong> x ${item.qty}</strong></td>--%>
                                            <%--                                                    <td>${item.price}00 VNĐ</td>--%>
                                            <%--                                                </tr>--%>
                                            <%--                                            </c:forEach>--%>
                                            <%--                                            </tbody>--%>
                                            <tfoot>
                                            <tr>
                                                <th>Tạm tính</th>
                                                <td>
                                                    <fmt:setLocale value="vi_VN" scope="session"/>
                                                    <fmt:formatNumber value="${sessionScope.total}" type="currency"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>Thuế</th>
                                                <td><fmt:setLocale value="vi_VN" scope="session"/>
                                                    <fmt:formatNumber value="0" type="currency"/></td>
                                            </tr>
                                            <tr>
                                                <th>Tổng cộng</th>
                                                <td>
                                                    <strong>
                                                        <fmt:setLocale value="vi_VN" scope="session"/>
                                                        <fmt:formatNumber value="${sessionScope.total}"
                                                                          type="currency"/>
                                                    </strong>
                                                </td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <h4>Hình thức thanh toán</h4>
                                    <div class="aa-payment-method">
                                        <label for="cod"><input type="radio" id="cod" name="transaction_payment" checked
                                                                value="cod">
                                            Thanh toán khi nhận hàng (COD) </label>
                                        <label for="stripe"><input type="radio" id="stripe" name="transaction_payment"
                                                                   value="stripe"> Thanh toán bàng thẻ tín dụng hoặc thẻ
                                            ghi nợ</label>
                                        <div class="form-row hidden aa-payment-method" id="stripe-card">
                                            <div id="card-element">
                                                <!-- A Stripe Element will be inserted here. -->
                                            </div>

                                            <!-- Used to display Element errors. -->
                                            <div id="card-errors" role="alert"></div>
                                        </div>
                                        <button class="aa-browse-btn">Thanh toán</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->
<!-- end content-->

<!-- footer-->
<jsp:include page="./footer/footer.jsp" flush="true"/>

<script type="application/javascript">

    $(document).ready(function () {
        var payment = $('input:radio[name=transaction_payment]');
        var stripeItem = $('#stripe-card');
        // var form = $('#checkout-form');

        payment.change(function () {
            var value = this.value;

            if (value !== 'stripe') {
                stripeItem.addClass('hidden')
            } else {
                stripeItem.removeClass('hidden')
            }
        })


        // Custom styling can be passed to options when creating an Element.
        var style = {
            base: {
                // Add your base input styles here. For example:
                fontSize: '16px',
                color: '#32325d',
            },
            hidePostalCode: true
        };
        var stripe = Stripe('pk_test_51HyqRrBfp1SrSzFP5aIcZ0YJRSLITf4yOMfMcSH4fkdlsdlygIPICOHVmCF74861Zrwx6w9sVX83FVsK7C8yrEgn00h31sjx9G');
        var elements = stripe.elements();
        var card = elements.create('card', {style: style, hidePostalCode: true});
        var status = false;
        card.mount('#card-element');
        var form =document.getElementById('checkout-form')
        form.addEventListener('submit', function (event) {
            event.preventDefault();
            for (var i = 0; i < payment.length; i++) {
                if (payment[i].type === "radio") {
                    if (payment[i].checked) {
                        method = payment[i].value;
                    }
                }
            }
            stripe.createToken(card).then(function (result) {
                if (result.error) {
                    // Inform the customer that there was an error.
                    var errorElement = document.getElementById('card-errors');
                    errorElement.textContent = result.error.message;
                } else {
                    // Send the token to your server.
                    stripeTokenHandler(result.token);
                }
            });

            if (method === 'stripe') {

            } else {
                form.submit();
            }
        })

        function stripeTokenHandler(token) {
            // Insert the token ID into the form so it gets submitted to the server
            var form = $('#checkout-form');
            var hiddenInput = document.createElement('input');
            hiddenInput.setAttribute('type', 'hidden');
            hiddenInput.setAttribute('name', 'stripeToken');
            hiddenInput.setAttribute('value', token.id);
            form.append(hiddenInput);
            form.submit();
        }
    })
</script>

<!-- end footer-->


  
