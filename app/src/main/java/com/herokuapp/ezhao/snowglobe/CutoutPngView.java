package com.herokuapp.ezhao.snowglobe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class CutoutPngView extends View {
    private Bitmap mask;
    Paint maskPaint;

    public CutoutPngView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Drawable maskDrawable = getResources().getDrawable(R.drawable.mask);
        if (maskDrawable != null) {
            mask = ((BitmapDrawable) maskDrawable).getBitmap();
        }

        maskPaint = new Paint();
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mask != null) {
            canvas.save();
            canvas.drawBitmap(mask, getWidth()/2 - mask.getWidth()/2, 0, maskPaint);
            canvas.restore();
        }
    }
}
