<%@ page import="com.eric.util.SysConstant" %>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-24
  Time: 下午2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>永鑫国际</title>
    <jsp:include page="common_top.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<section id="smk_container_full">
<section class="smk_container">
<section class="wrap">
<jsp:include page="top.jsp"/>
<!-- End of .top_head_separator -->
<div class="clear"></div>
<!--/============================================================= END top blocks -->
<!-- =============== HEADER [end] ================ -->

<!--============================================================== BEGIN content [ .smk_content ] -->
<div class="clear"></div>
<div class="header">

    <div id="onebyone_slider">

        <div class="oneByOne_item">
            <span class="ob1_title">Responsive design</span>
            <span class="ob1_description">Proiciens te princeps ea complacuit leno caelum pariter.Aliorum naufragium fieri scelus patrem alicui virginis instaret, iuvenis ut libertatem non potentiae quem acceperat utique dolorem in!</span>
            <span class="ob1_button"><a href="#" class="default_button">Get it now</a></span>
            <img src="<%=request.getContextPath()%>/images/test/xpic63.png" class="ob1_img_device1" alt=""/>
        </div>

        <div class="oneByOne_item">
            <span class="ob1_title">Multiple layouts</span>
            <span class="ob1_description">Tyrum in modo invenit iuvenem quasi plena violatam videt, visceribusque esocem manibus individuationis omnibus caecus in lucem in. Scelus gentibus innoxius intuere de ascendit in lucem in fuerat construeret in lucem exempli paupers coniunx.</span>
            <span class="ob1_button"><a href="#" class="default_button">Get it now</a></span>
            <img src="<%=request.getContextPath()%>/images/assets/5.png" class="ob1_img_device1" alt=""/>
        </div>

        <div class="oneByOne_item">
            <span class="ob1_title">Unlimited skins</span>
            <span class="ob1_description">Hesterna studiis ascende meae in rei civibus in lucem in deinde plectrum anni ipsa codicellos. Virginis piratae suppetit sibi aperit honestate doctrinam, est amet constanter determinatio vestes.</span>
            <span class="ob1_button"><a href="#" class="default_button">Get it now</a></span>
            <img src="<%=request.getContextPath()%>/images/assets/6.png" class="ob1_img_device1" alt=""/>
        </div>

        <div class="oneByOne_item">
            <span class="ob1_title">Exclusive on themeforest</span>
            <span class="ob1_description">Pentapolitanas Cyrenensi reversus est Apollonius non ait mea, intrarem puella est in deinde vero non potentiae. Nuntiatur hoc puella eius ad nomine Hesterna studiis vadem coepit amatrix tolle quae.</span>
            <span class="ob1_button"><a href="#" class="default_button">Get it now</a></span>
            <img src="<%=request.getContextPath()%>/images/assets/3.png" class="ob1_img_device1" alt=""/>
        </div>

    </div>
    <!-- END OF: #onebyone_slider -->

</div>
<div class="clear"></div>

<section id="smk_content" class="smk_content">
<div class="container_12">

<!-- ===================================================== MAIN CONTENT[begin] -->

<!-- ============= HOME NOTICE[begin] -->
<div class="home_notice">
    <h2>Hey! 欢迎来到永鑫国际！</h2>
</div>
<!-- ============= HOME NOTICE[end] -->

<!-- ============= SERVICES -->
<div class="home_service clearfix">
    <div class="s_title s_color_1">
        <div class="st_in"><h2>优质服务</h2></div>
    </div>
    <div class="service_text s_users">
        <p>Scola somnis angelorum haec sed dominum oculos ut sua in fuerat se vero cum unde non solutionem
            ascendens.</p>
    </div>
    <div class="clear"></div>
    <div class="service_text s_heart">
        <p>Scola somnis angelorum haec sed dominum oculos ut sua in fuerat se vero cum unde non solutionem
            ascendens.</p>
    </div>
</div>
<!-- End service -->

<div class="home_service clearfix">
    <div class="s_title s_color_2">
        <div class="st_in"><h2>物美价廉</h2></div>
    </div>
    <div class="service_text s_magic">
        <p>Scola somnis angelorum haec sed dominum oculos ut sua in fuerat se vero cum unde non solutionem
            ascendens.</p>
    </div>
    <div class="clear"></div>
    <div class="service_text s_brush">
        <p>Scola somnis angelorum haec sed dominum oculos ut sua in fuerat se vero cum unde non solutionem
            ascendens.</p>
    </div>
</div>
<!-- End service -->

<div class="home_service clearfix">
    <div class="s_title s_color_3">
        <div class="st_in"><h2>安全快捷</h2></div>
    </div>
    <div class="service_text s_mobile">
        <p>Scola somnis angelorum haec sed dominum oculos ut sua in fuerat se vero cum unde non solutionem
            ascendens.</p>
    </div>
    <div class="clear"></div>
    <div class="service_text s_monitor">
        <p>Scola somnis angelorum haec sed dominum oculos ut sua in fuerat se vero cum unde non solutionem
            ascendens.</p>
    </div>
</div>
<!-- End service -->
<div class="clear"></div>
<!-- ============= / SERVICES[end] -->


<!-- ============= / hot[begin] -->
<div class="home_blog">
    <div class="grid_3 hp_item_grid">
        <h1 class="home_module_title">Hot products</h1>

        <p>Individuationis quae dicens hoc ambulare manu impetum ideo dilectio incompletum Apollonius. Pedes rex in
            lucem exempli paupers coniunx.</p>
        <span class="home_more_link"><a href="<%=request.getContextPath()%>/product/list">View all our products &rarr;</a></span>
    </div>
    <c:forEach var="hot" items="${hots}" varStatus="status">
        <c:if test="${status.index>0&&status.index%3==0}">
            <div class="grid_3 hp_item_grid">
                <h1 class="home_module_title"></h1>

                <p></p>
                <span class="home_more_link"><a href="#"></a></span>
            </div>
        </c:if>
        <div class="grid_3 hp_item_grid clearfix">
            <a class="lightbox" href="<%=SysConstant.IMAGE_URL%>${hot.logo}_600">
            <span class="image_wrap">
                   <span class="img_wrap_in">
                        <div class="">
                            <img alt="${hot.name}" src="<%=SysConstant.IMAGE_URL%>${hot.logo}_300"
                                 style="display: block; visibility: visible; opacity: 1;">
                        </div>
                    <span class="img_caption_zoom"></span>
                   </span>
            </span>
            </a>

            <div class="hp_item_meta" style="height:80px">
                <h2><a href="<%=request.getContextPath()%>/product/info/${hot.id}" title="${hot.name}">
                    <c:choose>
                        <c:when test="${fn:length(hot.name)>14}">
                            <c:out value="${fn:substring(hot.name,0,13)}"/>...
                        </c:when>
                        <c:otherwise>
                            <c:out value="${hot.name}"/>
                        </c:otherwise>
                    </c:choose>
                </a></h2>

                <p style="height: 35px;">
                    <c:choose>
                        <c:when test="${fn:length(hot.intro)>36}">
                            <c:out value="${fn:substring(hot.intro,0,35)}"/>...
                        </c:when>
                        <c:otherwise>
                            <c:out value="${hot.intro}"/>
                        </c:otherwise>
                    </c:choose>
                </p>
                <span class="hb_meta">Posted by <a href="javascript:void(0);">JOY</a></span>
            </div>
            <div class="clear"></div>
        </div>
    </c:forEach>
</div>
<!-- ============= / hot[end] -->

<div class="clear"></div>

<!-- ============= / Recommend[begin] -->
<div class="home_portfolio">
    <div class="grid_3 hp_item_grid">
        <h1 class="home_module_title">Recommend products</h1>

        <p>Individuationis quae dicens hoc ambulare manu impetum ideo dilectio incompletum Apollonius. Pedes rex in
            lucem exempli paupers coniunx.</p>
        <span class="home_more_link"><a href="<%=request.getContextPath()%>/product/list">View all our products &rarr;</a></span>
    </div>
    <c:forEach var="rec" items="${recs}" varStatus="status">
        <c:if test="${status.index>0&&status.index%3==0}">
            <div class="grid_3 hp_item_grid">
                <h1 class="home_module_title"></h1>

                <p></p>
                <span class="home_more_link"><a href="#"></a></span>
            </div>
        </c:if>
        <div class="grid_3 hp_item_grid clearfix">
            <a class="lightbox" href="<%=SysConstant.IMAGE_URL%>${rec.logo}_600">
            <span class="image_wrap">
                   <span class="img_wrap_in">
                        <div class="">
                            <img alt="${rec.name}" src="<%=SysConstant.IMAGE_URL%>${rec.logo}_300"
                                 style="display: block; visibility: visible; opacity: 1;">
                        </div>
                    <span class="img_caption_zoom"></span>
                   </span>
            </span>
            </a>

            <div class="hp_item_meta" style="height:80px;word-break:break-all;">
                <h2><a href="<%=request.getContextPath()%>/product/info/${rec.id}" title="${rec.name}">
                    <c:choose>
                        <c:when test="${fn:length(rec.name)>14}">
                            <c:out value="${fn:substring(rec.name,0,13)}"/>...
                        </c:when>
                        <c:otherwise>
                            <c:out value="${rec.name}"/>
                        </c:otherwise>
                    </c:choose></a></h2>

                <p style="height: 40px;">
                    <c:choose>
                        <c:when test="${fn:length(rec.intro)>36}">
                            <c:out value="${fn:substring(rec.intro,0,35)}"/>...
                        </c:when>
                        <c:otherwise>
                            <c:out value="${rec.intro}"/>
                        </c:otherwise>
                    </c:choose> </p>
                <span class="hb_meta">Posted by <a href="javascript:void(0);">JOY</a></span>
            </div>
            <div class="clear"></div>
        </div>
    </c:forEach>
</div>
<!-- ============= / Recommend[end] -->

<div class="clear"></div>
<!-- ===================================================== MAIN CONTENT[end] -->
</div>
<!-- END .container_12 -->
<div class="clear"></div>
</section>
<!-- END of .smk_content -->
<div class="clear"></div>
<!--/============================================================= END content [ .smk_content ] -->
<!-- =============== FOOTER [begin] ================ -->
</section>
<jsp:include page="buttom.jsp"/>
</section>
</section>
<jsp:include page="common_buttom.jsp"/>
</body>
</html>