<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-25
  Time: 下午12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="page_title">
                    <div class="container_12">
                        <div class="grid_8">
                            <h1>Page not found</h1>
                        </div>
                        <div class="grid_4">
                            <form method="get" id="searchform" action="#"/>
                            <input type="text" class="field" name="s" id="s" placeholder="Search"/>
                            <input type="submit" class="submit" name="submit" id="searchsubmit" value=""/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <section id="smk_content" class="smk_content">
                <div class="container_12">

                    <div class="grid_8 page404_block clearfix"></div>
                    <div class="grid_4 clearfix">
                        <h1>404. That's an error.</h1>

                        <p>It seem the page you were looking for has moved or is no longer there. Or maybe you just
                            mistyped something. It happens.</p>

                        <p>Why not start over with the main navigation at the top of the page or on sidebar? Or maybe
                            you want to use again the search box at the top of page?</p>

                        <div class="list404 grid_2 alpha">
                            <ul class="d_list l_plus">
                                <li><a href="#">Homepage</a></li>
                                <li><a href="#">Sitemap</a></li>
                            </ul>
                        </div>
                        <div class="list404 grid_2 omega">
                            <ul class="d_list l_plus">
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="clear"></div>
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
</body> </html>