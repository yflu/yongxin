<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 13-7-25
  Time: 下午3:20
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
                <div class="page_title">
                    <div class="container_12">
                        <div class="grid_8">
                            <h1>FAQ</h1>
                        </div>
                    </div>
                </div>
            </div>
            <section id="smk_content" class="smk_content">
                <div class="container_12">

                    <div class="grid_12 aboutpage clearfix">
                        <div class="grid_6 alpha">
                            <div class="aboutus_img">
							<span class="image_wrap">
								<span class="img_wrap_in">
									<img src="<%=request.getContextPath()%>/images/my/weijin.jpg" alt=""/>
								</span>
							</span><!-- End of  .image_wrap-->
                            </div>
                        </div>
                        <h1>FAQ</h1>

                        <p>The aim of FAQ is to address the most common questions.
                            However, if you need further assistance, please feel free to contact us by email or fax or
                            telephone.
                        </p>

                        <h3>1. Do you have a catalogue or price list?</h3>

                        <p>We only have the limited products on our catalogue and website, which is only show part of
                            our products.
                            We always renew our products range constantly as per the demand from the market and the
                            clients.
                            The price is based on different quantity, dimensions, quality, material, packing, etc. So we
                            have no a standard price list.
                        </p>

                        <p>If you need the newest products and price information, please feel free to contact us.</p>

                        <h2>2. Can I buy the products at your website?</h2>

                        <p>The products at our website don’t belong to us totally. We have produced them for some of our
                            clients.
                            We only show something which products we can make. And give some ideas about our production
                            ability to the visitors.
                        </p>

                        <h3>3. How to place the order?</h3>

                        <p>
                            You can send us your detailed inquiry including the product name, quantity, material,
                            dimensions, weight, design, packing, etc.
                            We will check the price for you as per your request.
                            If you think the price is available, before the mass production, we make the customized
                            samples for your approval.
                            After you confirmed the customized sample, we start with the mass production.
                        </p>

                        <h3>4. What is the payment term?</h3>

                        <p>Usually, we accept the payment by T/T, L/C at sight, Western Union, etc.</p>

                        <h3>5. Could you send me the samples to check the quality?</h3>

                        <p>We don’t produce the standard line products. We can produce all kinds of quality products
                            from promotional gifts to luxurious products.
                            So, we always produce the products as per the request and standard of our different clients.
                            Of course, if we have samples which match your criterion, we can send you the samples. The
                            sample is free, freight collect. We can send them to you by freight collect by DHL or UPS or
                            FEDEX or TNT, etc.
                        </p>

                        <h3>6. How I can be sure of your products and service quality?</h3>

                        <ul class="d_list l_tick">
                            <li>
                                We have got plenty of customers around the world, especially in Europe. We can send you
                                these company names which we have produced for them in your country.
                            </li>
                            <li>
                                We have our own QC team, who control and inspect each step in the mass production.
                            </li>
                            <li>
                                We can accept the inspection or audit as per the international AQL standard by any third
                                party, such as SGS, INTERTEK, Asia-inspection or BV, etc.
                            </li>
                        </ul>

                        <h3>7. What is the MOQ?</h3>

                        <p>MOQ is Minimum Order Quantity, MOQ is no problem for us.
                            But a product also has its own lowest production cost for each step, such as printing,
                            dyeing, weaving, etc.
                            So, sometimes, it is clear that you pay same production cost for the minimum quantity and
                            maximum orders.
                            So, it means the maximum order = minimum price.
                        </p>

                        <h3>8. What is sample set up time and production time?</h3>

                        <p>Based on different products, the new sample set up time is about 7 – 15 days.
                            It takes about 3-5 days on the way to your office by DHL or UPS or FEDEX, etc.
                            Based on different products and quantity, the production time is about 25-60 days after
                            confirm the customized samples.
                        </p>

                        <h3>9. Chinese new year holiday</h3>

                        <p>The Chinese New Year is the traditional public holiday in China.
                            Our office will close 7 days in this holiday.
                            Most of the factories have about 30 days holiday in these days.
                            Usually, the date is from January 25th to February 25th, each year is different.
                            So, if you have urgent delivery time in these days, please check with us in advance.
                        </p>

                        <h3>10. Where is your company?</h3>

                        <p>Our company is located in Suzhou city, which is the well-known city in China.
                            It is near from Shanghai city.
                            From Shanghai to Suzhou, it takes about 30 minutes by train; it takes about one and half
                            hours by car or bus.
                            You can search “Suzhou” or “Soochow” or “Suzhou Industrial Park” by Internet.
                        </p>
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
</body>
</html>