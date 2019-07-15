
		var canvas = document.createElement("CANVAS");
		canvas.setAttribute('width', '500px');
		canvas.setAttribute('height', '500px');
        var context = canvas.getContext("2d");
        
        function drawClock() {
            context.clearRect(0, 0, canvas.width, canvas.height);

            var circleX = 200;    // 圆心X坐标
            var circleY = 200;    // 圆心Y坐标
            var radius = 190;    // 半径长度

            // 获取时间信息
            var date = new Date();
            var hour = date.getHours();
            var min = date.getMinutes();
            var sec = date.getSeconds();

            // 分针走一圈60度，时针走30度
            // 度数转化为弧度  度数*Math.PI/180
            var hourValue = (-90+30*hour+min/2)*Math.PI/180;
            var minValue = (-90+6*min)*Math.PI/180;
            var secValue = (-90+6*sec)*Math.PI/180;

            // 绘制表盘
            context.beginPath();
            context.font = "bold 16px Arial";
            context.lineWidth = '3';
            for(var i=0;i<12;i++) {
                context.moveTo(circleX,circleY);
                context.arc(circleX,circleY,radius,30*i*Math.PI/180,30*(i+1)*Math.PI/180,false); 
            }
            context.stroke();

            context.fillStyle='#0ff';
            context.beginPath();
            context.moveTo(circleX,circleY);
            context.arc(circleX,circleY,radius*19/20,0,360*Math.PI/180,false);
            context.closePath();
            context.fill();

            // 绘制钟表中心
            context.beginPath();
            context.arc(200,200,6,0,360,false);
            context.fillStyle = "#000";
            context.fill();//画实心圆
            context.closePath();

            // 绘制时针刻度
            context.lineWidth = '5';
            context.beginPath();
            context.moveTo(circleX, circleY);
            context.arc(circleX, circleY, radius*9/20, hourValue, hourValue, false);
            context.stroke();

            // 绘制分针
            context.lineWidth = '3';
            context.beginPath();
            context.moveTo(circleX, circleY);
            context.arc(circleX, circleY, radius*13/20, minValue, minValue, false);
            context.stroke();
            
            // 绘制秒针
            context.lineWidth = '1';
            context.beginPath();
            context.moveTo(circleX, circleY);
            context.arc(circleX, circleY, radius*18/20, secValue, secValue, false);
            context.stroke();


            // 绘制钟表的数字
            context.fillStyle = "#0ad";
            context.fillText("12", 190, 34);
            context.fillText("3", 370, 206);
            context.fillText("6", 196, 378);
            context.fillText("9", 22, 206);

        }
       function clock() {
        setInterval(drawClock, 1000);
        drawClock();
}