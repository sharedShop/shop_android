package com.shily.shared_shop.util;

import android.graphics.*;

/**
 * Created by shanlihou on 2017/10/25.
 */
public class MakeImage {
    public Bitmap createCircleImage(Bitmap source, int min) {
        int height = source.getHeight();
        int width = source.getWidth();
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
// 注意一定要用ARGB_8888，否则因为背景不透明导致遮罩失败
        Bitmap target = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
// 产生一个同样大小的画布
        Canvas canvas = new Canvas(target);
// 首先绘制圆形
        canvas.drawCircle(width / 2, 0, height, paint);
// 使用SRC_IN
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
// 绘制图片
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }
}
