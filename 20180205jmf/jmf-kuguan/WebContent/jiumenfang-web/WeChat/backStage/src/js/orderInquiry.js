/**
 * Created by Administrator on 2017/7/19.
 */
//高度设置
let conHeight=$(window).height();
//console.log(conHeight);
$('.contain-inquiry').height(conHeight);

//时间控件
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: '2017-06-01 23:59:59', //设定最小日期为当前日期
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday:false,
    choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas; //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: laydate.now(),
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(start);
laydate(end);

//订单号排序
/*
var arr=[];
$('.order-tr').each(function(){
    var num=parseInt($(this).attr("id"));
    arr.push(num);
    console.log(num);
});
console.log(arr);
//升序
function ascendingOrder(a,b){
    return a-b;
}
//降序
function descendOrder(a,b){
    return b-a;
};
$('.order-num').toggle(
    function(){
        var arr1=arr.sort(ascendingOrder);
        arr1.forEach(function(i){
            var aaa=$('.order-tr').eq(arr1[i-1]-1);   //tr
            console.log(aaa);

        })
    },
    function(){
        var arr2=arr.sort(descendOrder);
        arr2.forEach(function(j){
            var bbb=$('.order-tr').eq(arr2[4]-1);   //tr
            console.log(bbb);
            console.log(arr2);
            console.log(j);
        });
    }
);*/


var tag=1;
//升序
function sortNumberAS(a, b)
{
    return a - b
}
//降序
function sortNumberDesc(a, b)
{
    return b-a
}

function SortTable(obj){
    var td0s=document.getElementsByName("td0");
    var td1s=document.getElementsByName("td1");
    var td2s=document.getElementsByName("td2");
    var td3s=document.getElementsByName("td3");
    var td4s=document.getElementsByName("td4");
    var td5s=document.getElementsByName("td5");
    var td6s=document.getElementsByName("td6");
    var td7s=document.getElementsByName("td7");
    var td8s=document.getElementsByName("td8");
    var tdArray0=[];
    var tdArray1=[];
    var tdArray2=[];
    var tdArray3=[];
    var tdArray4=[];
    var tdArray5=[];
    var tdArray6=[];
    var tdArray7=[];
    var tdArray8=[];
    //将每一列的内容分别放在单独数组中
    for(var i=0;i<td0s.length;i++){
        tdArray0.push(td0s[i].innerHTML);
        //console.log(tdArray0);
    }
    for(var i=0;i<td1s.length;i++){
        tdArray1.push(td1s[i].innerHTML);
        //console.log(tdArray1)
    }
    for(var i=0;i<td2s.length;i++){
        tdArray2.push(td2s[i].innerHTML);
    }
    for(var i=0;i<td3s.length;i++){
        tdArray3.push(td3s[i].innerHTML);
    }
    for(var i=0;i<td4s.length;i++){
        tdArray4.push(td4s[i].innerHTML);
    }
    for(var i=0;i<td5s.length;i++){
        tdArray5.push(td5s[i].innerHTML);
        //console.log(tdArray5)
    }
    for(var i=0;i<td6s.length;i++){
        tdArray6.push(td6s[i].innerHTML);
    }
    for(var i=0;i<td7s.length;i++){
        tdArray7.push(td7s[i].innerHTML);
    }
    for(var i=0;i<td8s.length;i++){
        var timeStr=td8s[i].innerHTML;
        //timeStr=timeStr.substring(0,4)+timeStr.substring(5,7)+timeStr.substring(8,10);
        var timeArr1=timeStr.split('-');    //将字符串转化为数组
        var itemStr1=timeArr1.join('');     //将数组转化为字符串
        var timeArr2=itemStr1.split(':');
        var itemStr2=timeArr2.join('');
        var timeArr3=itemStr2.split(' ');
        var itemStr3=timeArr3.join('');
        var itemNum=parseInt(itemStr3);
        tdArray8.push(itemNum);
       //console.log(tdArray8);
    }
    var tds=document.getElementsByName("td"+obj.id.substr(2,1));
    var columnArray=[];
    //console.log(tds);
    for(var i=0;i<tds.length;i++){
        columnArray.push(tds[i].innerHTML);
       // console.log(columnArray);
    }
    var orginArray=[];
    for(var i=0;i<columnArray.length;i++){
        orginArray.push(columnArray[i]);
       // console.log(orginArray);
    }
    if(obj.className=="as"){
        columnArray.sort(sortNumberAS);               //排序后的新值
        obj.className="desc";
    }else{
        columnArray.sort(sortNumberDesc);               //排序后的新值
        obj.className="as";
    }

//分别将内容插进表格中

    for(var i=0;i<columnArray.length;i++){
        for(var j=0;j<orginArray.length;j++){
            if(orginArray[j]==columnArray[i]){
                var timeArr8=[];
                tdArray8.forEach(function(item){
                    var items=String(item);
                    var tdTime=items.substr(0,4)+'-'+items.substr(4,2)+'-'+items.substr(6,2)+' '+items.substr(8,2)+':'+items.substr(10,2)+':'+items.substr(12,2);
                    //console.log(tdTime);
                    timeArr8.push(tdTime);
                });
                //console.log(timeArr8);
                document.getElementsByName("td0")[i].innerHTML=tdArray0[j];
                document.getElementsByName("td1")[i].innerHTML=tdArray1[j];
                document.getElementsByName("td2")[i].innerHTML=tdArray2[j];
                document.getElementsByName("td3")[i].innerHTML=tdArray3[j];
                document.getElementsByName("td4")[i].innerHTML=tdArray4[j];
                document.getElementsByName("td5")[i].innerHTML=tdArray5[j];
                document.getElementsByName("td6")[i].innerHTML=tdArray6[j];
                document.getElementsByName("td7")[i].innerHTML=tdArray7[j];
                document.getElementsByName("td8")[i].innerHTML=timeArr8[j];
                orginArray[j]=null;
                break;
            }
        }
    }
};

//状态排序


//计算总收入
var priceArr=[];
var total=0;
$('.td-price').each(function(){
    let price=parseFloat($(this).html());
      priceArr.push(price);
});
console.log(priceArr);
priceArr.forEach(function(item){
    total=total+item;
});
//console.log(total);
$('.con-ipt-rmb').val(total.toFixed(2));