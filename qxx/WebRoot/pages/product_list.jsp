<%@ page import="com.eric.util.SysConstant" %>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-25
  Time: 下午12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/mytaglib" prefix="my" %>
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

        function searchProduct(pageindex) {
            window.location.href = "<%=request.getContextPath()%>/product/list/c${cateid}/k${keyword}/p" + pageindex;
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
                <div class="page_title container_12">
                    <div class="grid_6">
                        <h1>Product</h1>
                    </div>
                    <div class="grid_6">
                        <form method="post" id="searchform" onsubmit="setParam();"/>
                        <input type="text" class="field" name="keyword" id="keyword" placeholder="Search"
                               value="${keyword}"/>
                        <input type="submit" class="submit" name="submit" id="searchsubmit" value=""/>
                        </form>
                    </div>
                </div>
            </div>
            <section id="smk_content" class="smk_content">
                <div class="container_12 clearfix">
                    <!-- ===================================================== MAIN CONTENT[begin] -->
                    <jsp:include page="product_cate.jsp"/>

                    <div id="portfolio_masonry" class="grid_posts_wh_sidebar">
                        <!-- Portfolio item [begin] -->
                        <c:choose>
                            <c:when test="${fn:length(productList)==0}">
                                <div class="portf_item grid_4">
                                    <img src="<%=request.getContextPath()%>/images/no_result.png" width="400"/>
                                </div>
                            </c:when><c:otherwise>
                            <c:forEach var="product" items="${productList}">
                                <div class="portf_item grid_4">
                                    <a href="<%=SysConstant.IMAGE_URL%>${product.logo}_600" class="lightbox">
							<span class="image_wrap">
								<span class="img_wrap_in">
									<img src="<%=SysConstant.IMAGE_URL%>${product.logo}_300" alt="${product.name}"
                                         title="${product.name}"/>
									<span class="img_caption_zoom"></span>
								</span>
							</span>
                                    </a>

                                    <div class="clear"></div>
                                    <div class="pf_item_description_masonry clearfix" style="height:95px;word-break:break-all;" >
                                        <h2><a href="<%=request.getContextPath()%>/product/info/${product.id}" title="${product.name}">
                                            <c:choose>
                                                <c:when test="${fn:length(product.name)>18}">
                                                    <c:out value="${fn:substring(product.name,0,17)}"/>...
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="${product.name}"/>
                                                </c:otherwise>
                                            </c:choose></a>
                                        </h2>
                                        <p style="height: 35px;">
                                            <c:choose>
                                            <c:when test="${fn:length(product.intro)>46}">
                                                <c:out value="${fn:substring(product.intro,0,45)}"/>...
                                                </c:when>
                                                <c:otherwise>
                                                <c:out value="${product.intro}"/>
                                            </c:otherwise>
                                            </c:choose>
                                        <div class="pf_masonry_meta">Posted by <a href="javascript:void(0);">JOY</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                        </c:choose>
                        <!-- Portfolio item [end] -->
                    </div>
                    <!-- End of #portfolio_masonry -->
                    <div class="clear"></div>

                    <!-- ==== Pagination [begin] ==== -->
                    <div id="smk_pagination" class="all_transition_05">
                        <%--<c:if test="${pages>1}">
                            <span class="disabled_smk_pagination">Prev</span>

                            <span class="active_smk_link">1</span>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">5</a>
                            <a href="#">6</a>
                            <a href="#">7</a>
                            <a href="#">8</a>
                            <a href="#">9</a>
                            <a href="#">10</a>
                            <a href="#">Next</a>
                        </c:if>--%>
                        <my:pageHelper total="${pages}" pageindex="${pageindex}" keyword="${keyword}"
                                       cateid="${cateid}"/>
                    </div>
                    <div class="clear"></div>
                    <!-- ==== Pagination [end] ==== -->

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