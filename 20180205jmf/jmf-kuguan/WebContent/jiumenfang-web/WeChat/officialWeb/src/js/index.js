/**
 * Created by Administrator on 2017/8/7.
 */
//轮播
var mySwiper = new Swiper ('.swiper-container', {
    direction: 'horizontal',
    loop: true,
    autoplay:1000,

    // 如果需要分页器
    pagination: '.swiper-pagination'
})