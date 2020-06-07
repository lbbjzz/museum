  $(function () {
    $('.nav-sidebar li:not(.has-treeview) > a').on('click', function () {
      $(this).addClass('active');
      let $parent = $(this).parent();
      $parent.siblings('.has-treeview .active').find('> a').trigger('click');
      $parent.siblings().removeClass('active').find('li').removeClass('active');
    });
    $('.nav-sidebar a').each(function () {
      if (this.href === window.location.href.split("?")[0].split("#")[0]) {
        $(this).addClass('active')
          .closest('.has-treeview').addClass('menu-open').find('> a').addClass("active");
      }
    });
  });