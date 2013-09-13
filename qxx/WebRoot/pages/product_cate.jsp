<%@ page import="com.eric.util.SysConstant" %>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-25
  Time: 下午4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/mytaglib" prefix="my" %>

<html>
<head>
    <title></title>
    <script type="text/javascript">
        function findProduct(cateid) {
            window.location.href = "<%=request.getContextPath()%>/product/list/c" + cateid;
        }
         var cateId='${cateid}';
        $(function(){
          $("#cate_"+cateId).css("color","#00a5eb");
          $("#cate_"+cateId).css("border-bottom","1px solid #00a5eb");
        });
    </script>
</head>
<body>
<!-- === Sidebar[begin] === -->
<div class="sidebar grid_4">
    <!-- ==== WIDGET [begin] ==== -->
    <aside class="widget widget_categories">
        <h3 class="widget-title">Categories</h3>
        <ul>
            <div class="collapsegroup">
                <my:cateNavigate value="${cateList}" cateid="${cateid}"/>
            </div>
        </ul>
    </aside>
    <div class="clear"></div>
    <!-- ==== WIDGET [end] ==== -->

    <!-- ==== WIDGET [begin] ==== -->
    <aside class="widget widget_latest_posts">
        <h3 class="widget-title">Top</h3>
        <c:choose>
            <c:when test="${fn:length(hotList)==0}">
                暂无产品
            </c:when><c:otherwise>
            <ul>
                <c:forEach items="${hotList}" var="item">
                    <li>
                        <a href="<%=request.getContextPath()%>/product/info/${item.id}"><img
                                src="<%=SysConstant.IMAGE_URL%>${item.logo}_100x100" alt="${item.name}"
                                title="${item.name}" width="54" height="54"/></a>
                        <a href="<%=request.getContextPath()%>/product/info/${item.id}"
                           title="${item.name}">${item.name}</a>

                        <div class="clear"></div>
                    </li>
                </c:forEach>
                    <%--<li>
                        <a href="#"><img src="<%=request.getContextPath()%>/images/assets/75/15.jpg" alt=""/></a>
                        <a href="#">Plus quem esse in fuerat eum in lucem genero.</a>

                        <div class="clear"></div>
                    </li>--%>
            </ul>
        </c:otherwise>
        </c:choose>
        <div class="clear"></div>
    </aside>
    <div class="clear"></div>
    <!-- ==== WIDGET [end] ==== -->

    <!-- ==== WIDGET [begin] ==== -->
    <aside class="widget widget_latest_posts">
        <h3 class="widget-title">Recommend</h3>
        <c:choose>
            <c:when test="${fn:length(recList)==0}">
                暂无产品
            </c:when><c:otherwise>
            <ul>
                <c:forEach items="${recList}" var="item">
                    <li>
                        <a href="<%=request.getContextPath()%>/product/info/${item.id}"><img
                                src="<%=SysConstant.IMAGE_URL%>${item.logo}_100x100" alt="${item.name}"
                                title="${item.name}" width="54" height="54"/></a>
                        <a href="<%=request.getContextPath()%>/product/info/${item.id}"
                           title="${item.name}">${item.name}</a>

                        <div class="clear"></div>
                    </li>
                </c:forEach>
            </ul>
        </c:otherwise>
        </c:choose>
        <div class="clear"></div>
    </aside>
    <div class="clear"></div>
    <!-- ==== WIDGET [end] ==== -->
</div>
<div class="clear720"></div>
<!-- === Sidebar[end] === -->
</body>
</html>