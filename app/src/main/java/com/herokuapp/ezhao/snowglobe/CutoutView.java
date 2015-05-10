package com.herokuapp.ezhao.snowglobe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CutoutView extends View {
    Paint backgroundPaint;
    Path path;
    RectF rectF;

    public CutoutView(Context context, AttributeSet attrs) {
        super(context, attrs);

        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.BLACK);
        backgroundPaint.setAlpha(128);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (path == null) {
            path = new Path();
        }
        if (rectF == null) {
            rectF = new RectF(0, 0, getWidth(), getHeight());
        }

        path.setFillType(Path.FillType.EVEN_ODD);
        path.addRect(rectF, Path.Direction.CW);
        path.addCircle(getWidth()/2, getHeight()/2, getWidth()/2-100, Path.Direction.CCW);

        canvas.drawPath(path, backgroundPaint);
    }
}
