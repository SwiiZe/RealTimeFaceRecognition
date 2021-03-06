package com.example.irteza.facerecognition.Helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.google.firebase.ml.vision.common.FirebaseVisionPoint;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceContour;

import java.util.List;

public class DotOverlay extends GraphicOverlay.Graphic
{

    private Paint dotPaint;

    private GraphicOverlay graphicOverlay;
    private List<FirebaseVisionPoint> dotsArray;

    public DotOverlay(GraphicOverlay graphicOverlay, List<FirebaseVisionPoint> dots)
    {

        super(graphicOverlay);
        dotsArray = dots;
        dotPaint = new Paint();
        dotPaint.setStyle(Paint.Style.FILL);
        dotPaint.setColor(Color.YELLOW);
        postInvalidate();
        this.graphicOverlay = graphicOverlay;
    }

    @Override
    public void draw(Canvas canvas)
    {
        for(int i=0; i<dotsArray.size(); i++)
        {
            float x = translateX(dotsArray.get(i).getX());
            float y = translateY(dotsArray.get(i).getY());
          //  canvas.drawCircle(dotsArray.get(i).getX() + 19 , dotsArray.get(i).getY() - 10, 3, dotPaint);
            canvas.drawCircle(x , y, 3, dotPaint);
        }
    }
}
