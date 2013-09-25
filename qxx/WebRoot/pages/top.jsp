<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-24
  Time: 下午3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<section class="top_head_separator">
    <!--============================================================= BEGIN top blocks -->
    <section class="container_12">
        <div class="grid_4 logo">
            <a href="<%=request.getContextPath()%>/pages/index.jsp"><img
                    src="<%=request.getContextPath()%>/images/logo.png" alt="Forever Star Textile Co.,Ltd"/></a>
        </div>
        <div class="grid_8 top_mod_right">

            <!--================== BEGIN main menu  -->
            <nav id="horizontal">
                <ul id="nav" class="nav_simple">
                    <li><a href="<%=request.getContextPath()%>/index">Home</a></li>
                    <li><a href="<%=request.getContextPath()%>/product/list">Product</a></li>
                    <li><a href="<%=request.getContextPath()%>/pages/contact.jsp">Contact</a></li>
                    <li><a href="<%=request.getContextPath()%>/pages/faq.jsp">FAQ</a></li>
                    <li><a href="<%=request.getContextPath()%>/pages/about.jsp">About Us</a></li>
                </ul>
                <!-- End of #nav-->
            </nav>
            <!-- End of menu nav#horizontal -->
            <div class="clear"></div>
            <!--/================= END main menu -->
        </div>
        <div class="clear"></div>
    </section>
    <div class="clear"></div>
</section>
</body>
</html>