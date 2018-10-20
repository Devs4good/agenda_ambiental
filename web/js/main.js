$(function() { var logo = $(".log");
$(window).scroll(function() {
    var scroll = $(window).scrollTop();

    if (scroll > 140) {
        if(!logo.hasClass("line-logo")) {
          logo.hide();
          logo.removeClass('log').addClass("line-logo").fadeIn( "slow");
        }
      } else {
        if(!logo.hasClass("log")) {
          logo.hide();
          logo.removeClass("line-logo").addClass('log').fadeIn( "slow");
        }
      }

  });
  });
