
//获取myCanvas
var can = document.getElementById("myCanvas");

//返回canvas 的上下文，如果上下文没有定义则返回null
//2d",建立一个 CanvasRenderingContext2D 二维渲染上下文
var ctx = can.getContext("2d");


//画布宽度,高度
var wid = window.innerWidth;
var hei = window.innerHeight;
can.width = wid;
can.height = hei;
//雪花数目

var snow = 50;

//雪花坐标、半径
var arr = []; //保存各圆坐标及半径
for (var i = 0; i < snow; i++) {

    //push() 方法可向数组的末尾添加一个或多个元素，并返回新的长度。
    arr.push({

        x: Math.random() * wid,//横坐标

        y: Math.random() * hei,//纵坐标

        r: Math.random() * 10 + 1

    })

}

//画雪花

function DrawSnow() {

    //clearRect：在给定矩形内清空一个矩形：
    /**
     * x-要清除的矩形左上角的x坐标
     * y-要清除的矩形左上角的y坐标
     * width：要清除的矩形的宽度，以像素计
     * height：要清除的矩形的高度，以像素计
     */
    ctx.clearRect(0, 0, wid, hei);

    //填充
    ctx.fillStyle = "white";

    //beginPath()方法开始一条路径，或重置当前的路径
    ctx.beginPath();

    for (var i = 0; i < snow; i++) {

        var p = arr[i];

        //moveTo：
        /**
         * x:目标位置x坐标
         * y：目标位置y坐标
         */
        ctx.moveTo(p.x, p.y);

        //画圆：
        /**
         * x        ---     圆心x坐标
         * y        ---     圆心y坐标
         * r        ---     圆的半径
         * sAngle   ---     起始角，以弧度计。（弧的圆心的三点钟位置是0度）。
         * eAngle   --- 	结束角，以弧度计。
         * counterclockwise ---- false:顺时针，逆时针
         */
        ctx.arc(p.x, p.y, p.r, 0, 2 * Math.PI, false);

    }

    //fill() 方法填充当前的图像（路径）。默认颜色是黑色。
    ctx.fill();

    SnowFall();

    ctx.closePath();

}

//雪花飘落

function SnowFall() {

    for (var i = 0; i < snow; i++) {

        var p = arr[i];

        p.y += Math.random() * 2 + 1;

        if (p.y > hei) {

            p.y = 0;

        }

        p.x += Math.random() * 2 + 1;

        if (p.x > wid) {

            p.x = 0;

        }

    }

}

setInterval(DrawSnow, 50);
