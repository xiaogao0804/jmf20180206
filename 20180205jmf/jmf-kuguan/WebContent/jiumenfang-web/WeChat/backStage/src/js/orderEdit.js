    /**
 * Created by Administrator on 2017/7/18.
 */
//高度设置
let conHeight=$(window).height();
console.log(conHeight);
$('.contain-edit').height(conHeight);

//编辑
   var stateTxt="";
   var addressTxt="";
$(document).on('click','.edit-btn',function(){
     $('.edit-td').css({'text-decoration':'underline','color':'red'}).attr('contenteditable','true');
     var txt=$('.edit-td-state').html();
     $('.edit-td-address').html('').append(`<input type="text" value="北京市"> -- <input type="text" value="石景山区"> -- <input type="text" value="古城"> -- <input type="text" value="古城南街">`)
     $('.edit-td-state').html('').append('<select name="" class="state-btn" style="border: none;color:red;text-decoration: underline"><option value="已发货"  id="3">已发货</option><option value="已退货" id="dd">已退货</option><option value="已支付">已支付</option><option value="未支付">未支付</option><option value="退货中">退货中</option></select>');
     $('.edit-btn').remove();
     $('.edit-wrap').append('<p class="save-btn"><img src="image/edit.png" alt=""><span>编辑中，点击按钮保存</span></p>');
     $('.state-btn').change(function(){
        stateTxt=$(this).val();
        //获取id
       /* $('option:checked').each(function(){
            var id=$(this).attr('id');
            console.log(id);
        })*/

      // console.log(stateTxt);

    })
});

//保存
 $(document).on('click','.save-btn',function(){
     $('.save-pop').css('display','block');
 });
//弹窗保存/取消按钮
$('.pop-save-btn').on('click',function(){
    $('.save-pop').css('display','none');
    $('.edit-td').css({'text-decoration':'none','color':'#000'}).attr('contenteditable','false');
    $('.edit-td-state').html(stateTxt);
    $('.save-btn').remove();
    $('.edit-wrap').append('<p class="edit-btn"><img src="image/not-edit.png" alt=""><span>点击按钮进行编辑</span></p>')
    console.log(stateTxt);
/*    var city = $(".edit-td-address input").eq(0).val();
    var district = $(".edit-td-address input").eq(1).val();
    var area = $(".edit-td-address input").eq(2).val();
    var address = $(".edit-td-address input").eq(3).val();
    alert(city)
    alert(district)
    alert(area)
    alert(address)*/
    $('.edit-td-address input').each(function(i){
        addressTxt+=$('.edit-td-address input').eq(i).val();
        console.log(addressTxt);
    });
    $('.edit-td-address').html(`${addressTxt}`);
});

$('.pop-cancel-btn').on('click',function(){
    $('.save-pop').css('display','none');
});

