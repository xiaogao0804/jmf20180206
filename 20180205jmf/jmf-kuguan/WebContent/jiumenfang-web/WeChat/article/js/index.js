
/**
 * Created by Administrator on 2017/6/7.
 */
//公共获取当前的时间
function getNowTime(select){
    var date=new Date();
    var seperator1="-";
    var seperator2=":";
    var month=date.getMonth()+1;
    var strDate=date.getDate();
    if(month>=1&&month<=9){
        month="0"+month;
    }
    if(strDate>=1&&strDate<=9){
        strDate="0"+strDate;
    }
    var currentDate=date.getFullYear()+seperator1+month+seperator1+strDate/*+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()*/;
    $(select).html(currentDate);
    return currentDate;
}
//头部
getNowTime(".header-time");

