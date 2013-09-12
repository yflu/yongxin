<%@ page import="com.eric.util.SysConstant" %>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-25
  Time: 下午3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>永鑫国际</title>
    <jsp:include page="common_top.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript">
        function setParam() {
            $("#searchform").attr("action", "<%=request.getContextPath()%>/product/list/k" + $("#keyword").val());
            return false;
        }
    </script>
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
<div class="page_top_details clearfix">
    <div class="page_title container_12 clearfix">
        <div class="grid_8 clearfix">
            <h1>Product Info</h1>
        </div>
        <div class="grid_4 clearfix">
            <form method="post" id="searchform" onsubmit="setParam();"/>
            <input type="text" class="field" name="keyword" id="keyword" placeholder="Search"/>
            <input type="submit" class="submit" name="submit" id="searchsubmit" value=""/>
            </form>
        </div>
    </div>
</div>
<section id="smk_content" class="smk_content">
<div class="container_12">
<!-- ===================================================== MAIN CONTENT[begin] -->
<jsp:include page="product_cate.jsp"/>
<div class="grid_8">

<!-- ==== Blog article [begin] ==== -->
<div class="post_article_single clearfix">
    <div class="clearfix">
        <h1><a href="<%=request.getContextPath()%>/product/info/${product.id}">${product.name}</a></h1>

        <div class="blog_post_meta">
            <span>Posted by: <a href="#">joy</a></span>
            <fmt:parseDate value="${product.updatetime}" var="proDate" pattern="yyyy-MM-dd HH:mm:ss"/>
        <span>Date: <span class="blogpost_date"><fmt:formatDate value="${proDate}" type="both"
                                                                pattern="yyyy-MM-dd"/></span></span>
            <span>Comments: <a href="#">${fn:length(commentList)} comments</a></span>
        </div>
    </div>

    <div>
        <blockquote><c:out value="${product.intro}"/></blockquote>
    </div>

    <!-- Post slider -->
    <c:choose>
        <c:when test="${fn:length(product.medias)==0}">
            <img src="<%=request.getContextPath()%>/images/nopic_0.png"/>
        </c:when><c:otherwise>
        <div id="blogSlider1" class="post_slider flexslider">
            <ul class="slides">
                <c:forEach items="${product.medias}" var="media" end="10">
                    <li>
                        <img src="<%=SysConstant.IMAGE_URL%>${media.imgid}_610" alt="${media.name}"
                             title="${media.name}"/>
                    </li>
                </c:forEach>
                    <%--<li>
                        <img src="<%=request.getContextPath()%>/images/assets/610x250.jpg"/>
                    </li>--%>
            </ul>
        </div>
    </c:otherwise>
    </c:choose>
    <div class="clear"></div>
    <br/>
    <div class="grid_4 alpha">
        <ul class="d_list l_star">
            <li>material:<c:out value="${product.material}"/></li>
            <li>useage:<c:out value="${product.useage}"/></li>
            <li>usesex:<c:out value="${product.sex}"/></li>
            <li>size:<c:out value="${product.size}"/></li>
            <li>color:<c:out value="${product.color}"/></li>
            <li>application:<c:out value="${product.application}"/></li>
        </ul>
    </div>
    <div class="grid_4 omega">
        <ul class="d_list l_tick">
            <li>brand:<c:out value="${product.brand}"/></li>
            <li>model:<c:out value="${product.model_num}"/></li>
            <li>style:<c:out value="${product.pro_style}"/></li>
            <li>pattern:<c:out value="${product.pattern}"/></li>
            <li>moq:<c:out value="${product.moq}"/></li>
            <li>unit:<c:out value="${product.unit}"/></li>
        </ul>
    </div>

    <!-- Post content-->
    <div class="blog_post_content">
        <p>Etiam fermentum semper ligula ac bibendum. Nulla molestie metus est. Proin id neque ut ligula aliquet
            condimentum. Curabitur sed bibendum mauris. Nullam hendrerit arcu vel libero volutpat mattis eget a
            nisi.</p>

        <p>Nullam a orci nisi. Nunc augue urna, fringilla vitae condimentum eu, viverra at neque. Nullam eu lorem quis
            lectus luctus accumsan in nec tellus. Pellentesque a lectus odio. In eu sapien nulla, in aliquam leo. Duis
            quis quam velit. Nullam enim diam, dapibus vitae convallis quis, malesuada ullamcorper elit. Nullam
            fringilla lorem nibh. Sed mattis, erat ut pulvinar condimentum, mi purus convallis tortor, ut egestas massa
            purus vel mauris. Nulla posuere sem vitae metus accumsan mattis tincidunt velit posuere. Vivamus ac elit sit
            amet magna sollicitudin vehicula id facilisis lacus. Donec metus diam, luctus eu volutpat in, ornare sit
            amet massa. Aenean aliquam congue dapibus. Mauris ac mi ipsum.</p>

        <div class="grid_3 alignright">
            <a href="<%=request.getContextPath()%>/images/assets/800.jpg" class="lightbox">
									<span class="image_wrap">
										<span class="img_wrap_in">
											<img src="<%=request.getContextPath()%>/images/assets/300/5.jpg" alt=""/>
											<span class="img_caption_zoom"></span>
										</span>
									</span>
            </a>
        </div>

        <p>In hac habitasse platea dictumst. Curabitur sit amet aliquet turpis. Fusce odio lorem, porta eu ornare et,
            placerat eu augue. Sed consectetur, metus eget malesuada condimentum, elit lorem commodo lorem, quis
            vulputate elit metus a purus. Maecenas dolor mi, interdum sit amet consequat ut, aliquet nec nisl. Nunc et
            tristique nibh. Fusce magna sapien, tincidunt sit amet pulvinar nec, mattis quis nisl. Praesent blandit
            ornare volutpat. Nullam justo purus, porta vitae interdum sit amet, porttitor vel arcu. Duis et sagittis
            ipsum. Maecenas dictum posuere nulla, sed elementum diam eleifend eu.</p>

        <p>Pellentesque sed risus augue. Aenean mollis mauris ut augue interdum vitae semper lorem tempor. Ut vitae
            velit metus, non mattis nisi. Nulla congue dolor consectetur dolor ornare vitae pellentesque ante convallis.
            Fusce dapibus iaculis erat, sit amet volutpat quam elementum nec. Cum sociis natoque penatibus et magnis dis
            parturient montes, nascetur ridiculus mus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
            posuere cubilia Curae; Fusce pulvinar feugiat posuere.</p>

        <p>Morbi massa lorem, consequat laoreet ultricies at, imperdiet et velit. Ut vulputate mattis enim non auctor.
            Maecenas condimentum est lacus, sed pellentesque velit. Aenean metus nisi, lobortis sit amet facilisis id,
            laoreet in elit. Vivamus purus eros, aliquet vulputate vulputate in, adipiscing in enim. Etiam ut sodales
            augue. Praesent sed nisl nisl. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac
            turpis egestas. Aliquam nulla urna, placerat id tincidunt vitae, euismod vitae nunc. Fusce porttitor dolor
            ut velit venenatis lobortis. Etiam felis odio, vulputate nec condimentum ut, accumsan quis felis. Sed felis
            felis, mattis vel rutrum a, accumsan ut purus. Nam ut ultricies libero. Cras a tortor erat, sed iaculis
            libero. Mauris quam purus, hendrerit non lobortis non, suscipit vel diam. Maecenas euismod est in lacus
            mattis facilisis. Nulla dictum, lorem ullamcorper venenatis adipiscing, purus sem mattis risus, at lobortis
            enim ante eget orci.</p>

        <p>Integer accumsan malesuada dolor non ultrices. Curabitur rutrum turpis enim, nec consequat lacus. Proin
            fringilla turpis eu urna feugiat eu aliquet ligula mattis. In hac habitasse platea dictumst. Morbi ut risus
            a odio suscipit vestibulum. Aliquam consequat iaculis viverra. Aliquam in volutpat ligula.</p>

        <p>In nec est quis dui placerat auctor ac eget lorem. Suspendisse potenti. Suspendisse in mauris neque. Donec
            congue tempor condimentum. Praesent bibendum laoreet nisi vitae tincidunt. Fusce commodo augue eu tortor
            tristique venenatis. Suspendisse molestie imperdiet est, vel pellentesque lorem mattis non. Mauris non ipsum
            leo. Suspendisse potenti.</p>

    </div>
    <div class="clear"></div>
    <!-- End of .blog_post_content -->

    <!-- ==== COMMENTS [begin] ==== -->
    <h5>Comments</h5>
    <hr/>

    <div id="comments">
        <ul id="comments_list">
            <!-- Comment [begin] -->
            <c:choose>
                <c:when test="${fn:length(commentList)==0}">
                    暂无评论
                </c:when><c:otherwise>
                <c:forEach var="comment" items="${commentList}" varStatus="status">
                    <li class="comment all_transition_05 clearfix">

                        <div class="comment_avatar">
                            <img src="<%=request.getContextPath()%>/images/assets/75-3.jpg" alt="${comment.name}" title="${comment.name}"/>
                        </div>

                        <div class="comment_content">
                            <div class="comment_head">
                                <span class="name"><a href="#"><c:out value="${comment.name}"/></a></span> -
                                <span><c:out value="${comment.createtime}"/></span>
                                    <%--<%--<span class="comment_top_right"><a href="#">Reply</a></span>--%>
                            </div>
                            <p><c:out value="${comment.content}"/></p>
                        </div>
                    </li>
                </c:forEach>
            </c:otherwise>
            </c:choose>
            <!-- Comment [end] -->
        </ul>
        <!-- End all comments -->
    </div>
    <!-- ==== COMMENTS [end] ==== -->

    <!-- ==== COMMENTS FORM[begin] ==== -->
    <h5>Your comment</h5>
    <hr/>

    <div id="respond" class="clearfix">

        <form action="<%=request.getContextPath()%>/comment/add.do" method="post" id="comment_form"/>
        <div class="grid_4 alpha comm_row">
            <label>Name: </label>
            <input name="author" type="text" id="author" class="all_transition_05 author" tabindex="2" required/>
        </div>

        <div class="grid_4 omega comm_row">
            <label>Email: </label>
            <input name="email" type="text" id="email" class="all_transition_05 email" tabindex="3" required/>
        </div>
        <div class="clear"></div>

        <div class="grid_8 alpha omega comm_row">
            <label>Comment: </label>
            <textarea name="comment" id="comment" class="all_transition_05 message" tabindex="1" required></textarea>
        </div>
        <div class="clear"></div>
        <input type="hidden" value="${product.id}" name="productid" id="productid"/>
        <input type="hidden" value="0" name="parentid" id="parentid"/>
        <input type="submit" name="submit" class="smk_button blue" id="submit" value=" - Add Comment - "/>

        </form>
        <div id="message"></div>
        <div class="clear"></div>

    </div>
    <!-- ==== COMMENTS FORM[end] ==== -->


</div>
<!-- End .grid_8 in MAIN CONTENT -->

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