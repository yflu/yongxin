/* This file is minimized */

/* Hide Show config panel (frontend) */
jQuery(".color_whell").toggle(function () {
    jQuery('#style-switcher').animate({ left:"0px"}, {duration:300});
}, function () {
    jQuery('#style-switcher').animate({left:"-358px"}, {duration:300});
});

$._messengerDefaults = {
    extraClasses:'messenger-fixed messenger-theme-air messenger-on-bottom'
}

function changeVerifyCode(id) {
    $("#" + id).attr("src", basePath + "/Kaptcha.jpg?time=" + new Date().getTime());
}

var emailReg = /(\S)+[@]{1}(\S)+[.]{1}(\w)+/;
function validateField(id) {
    var dom = $("#" + id);
    var val = dom.val();

    if (dom.attr("notNull") == "true") {
        if (null == val || "" == val) {
            if (dom.attr("errorText") == "undefined" || dom.attr("errorText") == null || dom.attr("errorText") == "") {
                dom.attr("errorText", "Please enter " + id + "!");
            }
            alertErrorMessage(dom.attr("errorText"));
            return false;
        }
    }
    if (dom.attr("isEmail") == "true") {
        if (null != val && "" != val && !emailReg.test(val)) {
            if (dom.attr("errorText") == "undefined" || dom.attr("errorText") == null || dom.attr("errorText") == "") {
                dom.attr("Please enter a useful email!");
            }
            alertErrorMessage(dom.attr("errorText"));
            return false;
        }
    }

    if (dom.attr("minLength") != "undefined") {
        if (null != val && "" != val && val.length < parseInt(dom.attr("minLength"))) {
            if (dom.attr("lengthError") == "undefined" || dom.attr("lengthError") == null || dom.attr("lengthError") == "") {
                dom.attr("lengthError", id + " minLength is " + dom.attr("minLength") + "!");
            }
            alertErrorMessage(dom.attr("lengthError"));
            return false;
        }
    }

    if (dom.attr("maxLength") != "undefined") {
        if (null != val && "" != val && val.length > parseInt(dom.attr("maxLength"))) {
            if (dom.attr("lengthError") == "undefined" || dom.attr("lengthError") == null || dom.attr("lengthError") == "") {
                dom.attr("errorText", id + " maxLength is " + dom.attr("maxLength") + "!");
            }
            alertErrorMessage(dom.attr("lengthError"));
            return false;
        }
    }
    return true;
}


function alertErrorMessage(mgs) {
    $.globalMessenger().post({
        message:mgs,
        type:'error',
        hideAfter:3,
        showCloseButton:true
    });
}

function validateForm() {
    var name = $('#name').val();
    var email = $('#email').val();
    var subject = $('#subject').val();
    var content = $('#content').val();
    var verify = $('#verify').val();
    if (null == name || "" == name) {
        alertErrorMessage($('#name').attr("errorText"));
        document.all.name.focus();
        return false;
    }
    if (null == email || "" == email || !emailReg.test(email)) {
        alertErrorMessage($('#email').attr("errorText"));
        document.all.email.focus();
        return false;
    }
    if (null == subject || "" == subject) {
        alertErrorMessage($('#name').attr("errorText"));
        document.all.subject.focus();
        return false;
    }
    if (null == content || "" == content) {
        alertErrorMessage($('#content').attr("errorText"));
        document.all.content.focus();
        return false;
    }
    if (verify == null || verify == "") {
        alertErrorMessage($('#verify').attr("errorText"));
        document.all.verify.focus();
        changeVerifyCode("code_img");
        return false;
    }
    return true;
}

function submitForm() {
    if (validateForm()) {
        $.ajax({
            type:"post",
            url:basePath + "/checkcode/" + $('#verify').val(),
            dataType:"json",
            async:false,
            success:function (data) {
                if (data.success) {
                    $('#contactform').submit();
                } else {
                    alertErrorMessage("verify code error!");
                    $('#verify').val("");
                    document.all.verify.focus();
                    changeVerifyCode("code_img");
                    return false;
                }
            },
            error:function () {//请求失败
                alert("服务器请求失败！");
            }
        });

    }
}

jQuery(document).ready(function () {
    $('#contactform').submit(function () {
        var action = $(this).attr('action');
        $('#submit').attr('disabled', 'disabled').after('<img src="../images/icons/ajax-loader.gif" class="loader" />');
        $("#message").slideUp(750, function () {
            $('#message').hide();
            $.post(action, {name:$('#name').val(), email:$('#email').val(), subject:$('#subject').val(), content:$('#content').val(), verify:$('#verify').val()}, function (data) {
                //document.getElementById('message').innerHTML = data.msg;
                $('#message').slideDown('slow');
                $('#contactform img.loader').fadeOut('fast', function () {
                    $(this).remove()
                });
                $('#submit').removeAttr('disabled');
                $('#contactform')[0].reset();
                changeVerifyCode("code_img");
                alertErrorMessage(data.msg);
                // $('#contactform').slideUp('slow');
            }, 'json')
        });
        return false
    })
});
$(window).load(function () {
    $('div[id^=portfolioSlider]').flexslider()
});
$('#mainSlider').flexslider();
$('div[id^=blogSlider]').flexslider();
$(document).ready(function () {
    $('#iview').iView({fx:'random', pauseTime:7000, pauseOnHover:true, directionNavHoverOpacity:0, timer:"Bar", timerDiameter:"50%", timerPadding:0, timerStroke:7, timerBarStroke:0, timerColor:"#FFF", timerPosition:"bottom-right"})
});
$(document).ready(function () {
    $('#onebyone_slider').oneByOne({className:'oneByOne1', easeType:'random', slideShow:true, delay:200, slideShowDelay:4000})
});
$(".container_video").fitVids();
$(function () {
    var $container = $('#portfolio_masonry');
    $container.imagesLoaded(function () {
        $container.masonry({itemSelector:'.portf_item'})
    })
});
$(function () {
    var $container = $('#blog_masonry');
    $container.imagesLoaded(function () {
        $container.masonry({itemSelector:'.blog_article'})
    })
});
$(function () {
    var $container = $('#testimonials_section');
    $container.imagesLoaded(function () {
        $container.masonry({itemSelector:'.testimonial'})
    })
});
$(function () {
    $('a .image_wrap').hover(function () {
        $('img', this).animate({"opacity":"0.6"}, {queue:true, duration:500})
    }, function () {
        $('img', this).animate({"opacity":"1"}, {queue:true, duration:400})
    })
});
$(function () {
    $('.home_clients .hp_item_grid_client').hover(function () {
        $('img', this).animate({"opacity":"0.75"}, {queue:true, duration:300})
    }, function () {
        $('img', this).animate({"opacity":"1"}, {queue:true, duration:300})
    })
});
$(function () {
    var $IsoContainer = $('#portfolio');
    $IsoContainer.imagesLoaded(function () {
        $IsoContainer.isotope({itemSelector:'.portf_item'})
    });
    $('#portfolio_menu a').click(function () {
        var selector = $(this).attr('data-filter');
        $IsoContainer.isotope({filter:selector});
        $('#portfolio_menu a').removeClass('active_cat');
        $(this).addClass('active_cat');
        return false
    })
});
$(document).ready(function () {
    $('#faq_questions ul li a').click(function () {
        var el = $(this).attr('href');
        var elWrapped = $(el);
        scrollToDiv(elWrapped, 40);
        return false
    });
    function scrollToDiv(element, navheight) {
        var offset = element.offset();
        var offsetTop = offset.top;
        var totalScroll = offsetTop - navheight;
        $('body,html').animate({scrollTop:totalScroll}, 500)
    }
});
$(document).ready(function () {
    $("#voucher_counttime").countdown({date:"september 1, 2012", direction:'down', leadingZero:true})
});
$(document).ready(function () {
    $('.faq_question').live('click', function () {
        var $q = $(this).attr('id');
        var $q_id = $q.substr($q.indexOf('_') + 1);
        $.scrollTo('#answer_' + $q_id, {duration:500, onAfter:function () {
            $('#answer_' + $q_id + '_text').highlightFade({color:'rgb(206,255,205)', speed:500})
        }})
    });
    $('.go_to_top').click(function () {
        $.scrollTo('#smk_container_full', {duration:500})
    })
});


jQuery(document).ready(function () {
    $('#comment_form').submit(function () {
        var action = $(this).attr('action');
        $('#submit').attr('disabled', 'disabled').after('<img src="../../images/icons/ajax-loader.gif" class="loader" />');
        $("#message").slideUp(750, function () {
            $('#message').hide();
            $.post(action, {author:$('#author').val(), email:$('#email').val(), comment:$('#comment').val(), productid:$('#productid').val(), parentid:$('#parentid').val()}, function (data) {
                $('#message').slideDown('slow');
                $('#comment_form img.loader').fadeOut('fast', function () {
                    $(this).remove()
                });
                $('#submit').removeAttr('disabled');
                setTimeout('reloadJsp()',3000);
                $('#comment_form')[0].reset();
                alertErrorMessage(data.msg);
            }, 'json')
        });
        return false
    })
});

function reloadJsp(){
    window.location.reload();
}