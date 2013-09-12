<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-24
  Time: 下午4:42
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
    <script type="text/javascript">
        var basePath = '<%=request.getContextPath()%>';
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
            <div class="page_top_details page_top_gmap clearfix">

                <div id="google_map"></div>
                <div class="clear"></div>

            </div>
            <div class="clear"></div>

            <section id="smk_content" class="smk_content">
                <div class="container_12">

                    <!--Contact form [begin]-->
                    <div id="contact">
                        <div id="message"></div>
                        <!-- For error display -->
                        <form method="post" commandName="message" action="<%=request.getContextPath()%>/message/add.do"
                              name="contactform" id="contactform" onsubmit="return validateForm()">
                            <div class="grid_5">
                                <div><label>Name<span style="color: red;">*</span></label></div>
                                <input name="name" type="text" id="name" class="name" size="30" value="" notNull="true"
                                       onblur="validateField(this.id);" errorText="Please enter your name!"/>

                                <div class="clear"></div>

                                <div><label>Email<span style="color: red;">*</span></label></div>
                                <input name="email" type="text" id="email" class="email" size="30" value=""
                                       notNull="true" isEmail="true" errorText="Please enter a useful email!"
                                       onblur="validateField(this.id);"/>

                                <div class="clear"></div>

                                <div><label>Subject<span style="color: red;">*</span></label></div>
                                <input name="subject" type="text" id="subject" class="subject" notNull="true" size="30"
                                       value="" errorText="Please enter a subject!" onblur="validateField(this.id);"/>

                                <div class="clear"></div>

                                <div><label>Verify code<span style="color: red;">*</span></label></div>
                                <div class="div_verify">
                                    <div class="user_verify"><label for="verify" accesskey="V">
                                        <img src="<%=request.getContextPath()%>/Kaptcha.jpg"
                                             onclick="changeVerifyCode(this.id)"
                                             id="code_img"
                                             title="看不清，点击换一张"/></label></div>
                                    <input name="verify" type="text" id="verify" size="4" value="" class="captcha"
                                           placeholder="" errorText="Please enter a verify code!"/>
                                </div>
                            </div>
                            <div class="grid_7">
                                <div><label>Message<span style="color: red;">*</span></label></div>
                                <textarea name="content" cols="40" rows="3" id="content" notNull="true"
                                          errorText="Please enter a message!"
                                          onblur="validateField(this.id);"></textarea>

                                <div class="clear"></div>

                                <input type="button" class="default_button alignright contact_submit" id="submit"
                                       value="Send your message" onclick="submitForm();"/>
                            </div>
                            <div class="clear"></div>
                        </form>
                    </div>
                    <!--Contact form [end]-->
                    <div class="clear"></div>

                    <!--Some details [begin]-->
                    <h5 class="grid_12">Details</h5>
                    <hr/>
                    <div class="grid_4">
                        <p>Lorem ipsum dolor sit amet, suam vidit ad suis alteri si puella ut diem obiecti vestes manda
                            autem est
                            in. Musis nihilominus proposuisti enim formam speciosam at actus eorum non potentiae!</p>
                    </div>
                    <div class="grid_4">
                        <p>
                            <strong>Address:</strong> 3010 Browning Lane, Madison, WI 53705<br/>
                            <strong>Phone:</strong> 608-218-6534<br/>
                            <strong>Fax:</strong> 608-218-5987<br/>
                            <strong>Email:</strong> firstagent@loveliness.us<br/>
                        </p>
                    </div>
                    <div class="grid_4">
                        <p>
                            <strong>Address:</strong> 1626 Maple Lane, Morgan City, AL 35016<br/>
                            <strong>Phone:</strong> 256-498-4884<br/>
                            <strong>Fax:</strong> 608-498-5127<br/>
                            <strong>Email:</strong> secondagent@loveliness.us<br/>
                        </p>
                    </div>
                    <!--Some details [end]-->
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
</body>
</html>