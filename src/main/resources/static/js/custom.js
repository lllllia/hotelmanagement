(function($) {
	"use strict";

/* ----------------------------
    preloader
    ------------------------------ */

$(window).on('load', function(){        
	$('#preloader').delay(300).fadeOut('slow',function(){
	$(this).remove();
	});
});

/* ----------------------------
    Top Scroll
    ------------------------------ */

var offset = 220;
var duration = 500;
jQuery(window).on('scroll', function() {
	if (jQuery(this).scrollTop() > offset) {
		jQuery('.scroll-top').fadeIn(duration);
	} 
	else {
		jQuery('.scroll-top').fadeOut(duration);
	}
});
jQuery('.scroll-top').on('click', function() {
	event.preventDefault();
	jQuery('html, body').animate({scrollTop: 0}, duration);
	return false;
})

/* ----------------------------
	@module       Copyright
	@description  Evaluates the copyright year
    ------------------------------ */
	
var currentYear = (new Date).getFullYear();
	$(document).ready(function () {
		$(".current-year").text((new Date).getFullYear());
});

/* ----------------------------
    Datepicker
    ------------------------------ */

/* check in */
$('#check-in').datepicker({
	uiLibrary: 'bootstrap4'
});

/* check out */
$('#check-out').datepicker({
	uiLibrary: 'bootstrap4'
});

/* Date of Birth */
$('#datepickerdob').datepicker({
	uiLibrary: 'bootstrap4'
});

/* ----------------------------
    venobox
    ------------------------------ */

$('.venobox').venobox();

/* ----------------------------
    popular hotel carousel
    ------------------------------ */

$('.popular-hotel-carousel').owlCarousel({
	loop: true,
	margin: 15,
	dots:false,
	items: 4,
	nav: true,
	autoplay:true,
	navText : ['<i class="fas fa-long-arrow-alt-left"></i>','<i class="fas fa-long-arrow-alt-right"></i>'],
	responsiveClass: true,
	responsive: {
	  0: {
		items: 1
	  },
	  576: {
		items: 2
	  },
	  767: {
		items: 2
	  },
	  768: {
		items: 3
	  },
	  1000: {
		items: 4
	  }
	}
})

/* ----------------------------
    testimonial carousel
    ------------------------------ */

$('.testimonial-carousel').owlCarousel({
	loop: true,
	margin: 15,
	dots:false,
	items: 2,
	nav: true,
	autoplay:true,
	navText : ['<i class="fas fa-long-arrow-alt-left"></i>','<i class="fas fa-long-arrow-alt-right"></i>'],
	responsiveClass: true,
	responsive: {
	  0: {
		items: 1
	  },
	  576: {
		items: 1
	  },
	  767: {
		items: 1
	  },
	  768: {
		items: 2
	  },
	  1000: {
		items: 2
	  }
	}
})

/* ----------------------------
    partner
    ------------------------------ */
	
$('.partner-carousel').owlCarousel({
	loop: true,
	margin: 10,
	dots:false,
	nav: false,
	autoplay:true,
	responsiveClass: true,
	responsive: {
	  0: {
		items: 2
	  },
	  767: {
		items: 3
	  },
	  768: {
		items: 3
	  },
	  1000: {
		items: 6,
		loop: true
	  }
	}
})

/* ----------------------------
    list box carousel
    ------------------------------ */
	
$('.list-box-carousel').owlCarousel({
	loop: true,
	margin: 10,
	dots:false,
	nav: true,
	autoplay:true,
	items: 1,
	responsiveClass: true,
	responsive: {
	  0: {
		items: 1
	  },
	  767: {
		items: 2
	  },
	  768: {
		items: 1
	  },
	  1000: {
		items: 1,
		loop: true
	  }
	}
})

/* ----------------------------
    list box carousel
    ------------------------------ */
	
$('.detail-page-gallery-carousel').owlCarousel({
	loop: true,
	margin: 10,
	dots:false,
	nav: true,
	autoplay:true,
	items: 1,
	responsiveClass: true
})

})(jQuery);