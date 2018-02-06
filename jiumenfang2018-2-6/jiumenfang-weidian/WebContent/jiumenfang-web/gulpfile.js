/**
 * Created by Administrator on 2017/6/9.
 */
//获取gulp
var gulp=require('gulp');

//获取gulp-less模块   gulp-livereload模块
var less=require('gulp-less');
var babel=require('gulp-babel');
var livereload=require('gulp-livereload');
//var eslint=require('gulp-eslint');

//编译less
//在命令行输入gulp less启动此任务
gulp.task('less',function(){
    //1.找到less文件
    gulp.src('./WeChat/shopping/build/css/*.less')
    //2.编译为css
        .pipe(less())
    //3.另存为css
        .pipe(gulp.dest('./WeChat/shopping/src/css/'))
    //自动刷新
        .pipe(livereload())
})

//es6转es5
gulp.task('es6',function(){
    return gulp.src('./WeChat/shopping/build/js/*.js')
           .pipe(babel())
           .pipe(gulp.dest('./WeChat/shopping/src/js/'))
});

//检查js代码
//gulp.task('eslint',function(){
//    return gulp.src('./WeChat/shopping/build/js/*.js')
//    .pipe(eslint())
//    .pipe(eslint.format())
//    .pipe(eslint.failAfterError());
//})

//在命令行gulp auto启动此任务
gulp.task('auto',function(){
    //要在这里调用listen()方法
    livereload.listen()
    //监听文件修改，当文件修改则执行less任务
        gulp.watch('./WeChat/shopping/build/css/*.less',['less'])
        gulp.watch('./WeChat/shopping/build/js/*.js',['es6'])
      //  gulp.watch('./WeChat/shopping/build/js/*.js',['eslint'])

});

//使用gulp.task('default')定义默认任务
//在命令行使用gulp启动images任务和auto任务
gulp.task('default',['less','auto'])
//gulp.task('default',['es6','auto'])
//gulp.task('default',['eslint','auto'])