package com.kennie.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/**
 * @项目名 KennieViews
 * @类名称 SlantedTextView
 * @类描述 倾斜的TextView，适用于左上左下右上右下角
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/12/26 11:39
 */
public class SlantedTextView extends View {

    public static final int MODE_LEFT = 0;
    public static final int MODE_RIGHT = 1;
    public static final int MODE_LEFT_BOTTOM = 2;
    public static final int MODE_RIGHT_BOTTOM = 3;
    public static final int MODE_LEFT_TRIANGLE = 4;
    public static final int MODE_RIGHT_TRIANGLE = 5;
    public static final int MODE_LEFT_BOTTOM_TRIANGLE = 6;
    public static final int MODE_RIGHT_BOTTOM_TRIANGLE = 7;

    /**
     * 旋转角度
     */
    public static final int ROTATE_ANGLE = 45;
    /**
     * 倾斜背景画笔
     */
    private Paint mBackgroundPaint;
    /**
     * 倾斜背景色(默认Color.TRANSPARENT)
     */
    private int mSlantedBackgroundColor = Color.TRANSPARENT;

    /**
     * 文字画笔
     */
    private TextPaint mTextPaint;
    /**
     * 显示的文本内容
     */
    private String mSlantedText = "";
    /**
     * 显示的文本大小(默认14)
     */
    private float mTextSize = 14;
    /**
     * 显示的文本颜色(默认Color.WHITE)
     */
    private int mTextColor = Color.WHITE;

    /**
     * 倾斜长度（默认40）
     */
    private float mSlantedLength = 40;

    /**
     * 倾斜模式(默认左上角)
     */
    private int mMode = MODE_LEFT;

    public SlantedTextView(Context context) {
        this(context, null);
    }

    public SlantedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SlantedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SlantedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SlantedTextView);

        mTextSize = array.getDimension(R.styleable.SlantedTextView_slantedTextSize, mTextSize);
        mTextColor = array.getColor(R.styleable.SlantedTextView_slantedTextColor, mTextColor);
        mSlantedLength = array.getDimension(R.styleable.SlantedTextView_slantedLength, mSlantedLength);
        mSlantedBackgroundColor = array.getColor(R.styleable.SlantedTextView_slantedBackgroundColor, mSlantedBackgroundColor);

        if (array.hasValue(R.styleable.SlantedTextView_slantedText)) {
            mSlantedText = array.getString(R.styleable.SlantedTextView_slantedText);
        }

        if (array.hasValue(R.styleable.SlantedTextView_slantedMode)) {
            mMode = array.getInt(R.styleable.SlantedTextView_slantedMode, 0);
        }
        array.recycle();

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        mBackgroundPaint.setAntiAlias(true);
        mBackgroundPaint.setColor(mSlantedBackgroundColor);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(mTextColor);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // 绘制背景
        drawBackground(canvas);
        // 绘制文本
        drawText(canvas);
    }


    private void drawBackground(Canvas canvas) {
        Path path = new Path();
        int w = getWidth();
        int h = getHeight();

        if (w != h) throw new IllegalStateException("SlantedTextView's width must equal to height");

        switch (mMode) {
            case MODE_LEFT:
                path = getModeLeftPath(path, w, h);
                break;
            case MODE_RIGHT:
                path = getModeRightPath(path, w, h);
                break;
            case MODE_LEFT_BOTTOM:
                path = getModeLeftBottomPath(path, w, h);
                break;
            case MODE_RIGHT_BOTTOM:
                path = getModeRightBottomPath(path, w, h);
                break;
            case MODE_LEFT_TRIANGLE:
                path = getModeLeftTrianglePath(path, w, h);
                break;
            case MODE_RIGHT_TRIANGLE:
                path = getModeRightTrianglePath(path, w, h);
                break;
            case MODE_LEFT_BOTTOM_TRIANGLE:
                path = getModeLeftBottomTrianglePath(path, w, h);
                break;
            case MODE_RIGHT_BOTTOM_TRIANGLE:
                path = getModeRightBottomTrianglePath(path, w, h);
                break;
            default:
                throw new IllegalArgumentException("are you ok?");
        }
        path.close();
        canvas.drawPath(path, mBackgroundPaint);
        canvas.save();
    }

    private Path getModeLeftPath(Path path, int w, int h) {
        path.moveTo(w, 0);
        path.lineTo(0, h);
        path.lineTo(0, h - mSlantedLength);
        path.lineTo(w - mSlantedLength, 0);
        return path;
    }

    private Path getModeRightPath(Path path, int w, int h) {
        path.lineTo(w, h);
        path.lineTo(w, h - mSlantedLength);
        path.lineTo(mSlantedLength, 0);
        return path;
    }

    private Path getModeLeftBottomPath(Path path, int w, int h) {
        path.lineTo(w, h);
        path.lineTo(w - mSlantedLength, h);
        path.lineTo(0, mSlantedLength);
        return path;
    }

    private Path getModeRightBottomPath(Path path, int w, int h) {
        path.moveTo(0, h);
        path.lineTo(mSlantedLength, h);
        path.lineTo(w, mSlantedLength);
        path.lineTo(w, 0);
        return path;
    }

    private Path getModeLeftTrianglePath(Path path, int w, int h) {
        path.lineTo(0, h);
        path.lineTo(w, 0);
        return path;
    }

    private Path getModeRightTrianglePath(Path path, int w, int h) {
        path.lineTo(w, 0);
        path.lineTo(w, h);
        return path;
    }

    private Path getModeLeftBottomTrianglePath(Path path, int w, int h) {
        path.lineTo(w, h);
        path.lineTo(0, h);
        return path;
    }

    private Path getModeRightBottomTrianglePath(Path path, int w, int h) {
        path.moveTo(0, h);
        path.lineTo(w, h);
        path.lineTo(w, 0);
        return path;
    }

    private void drawText(Canvas canvas) {
        int w = (int) (canvas.getWidth() - mSlantedLength / 2);
        int h = (int) (canvas.getHeight() - mSlantedLength / 2);
        float[] xy = calculateXY(canvas, w, h);
        float toX = xy[0];
        float toY = xy[1];
        float centerX = xy[2];
        float centerY = xy[3];
        float angle = xy[4];

        canvas.rotate(angle, centerX, centerY);

        canvas.drawText(mSlantedText, toX, toY, mTextPaint);
    }

    private float[] calculateXY(Canvas canvas, int w, int h) {
        float[] xy = new float[5];
        Rect rect = null;
        RectF rectF = null;
        int offset = (int) (mSlantedLength / 2);
        switch (mMode) {
            case MODE_LEFT_TRIANGLE:
            case MODE_LEFT:
                rect = new Rect(0, 0, w, h);
                rectF = new RectF(rect);
                rectF.right = mTextPaint.measureText(mSlantedText, 0, mSlantedText.length());
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent();
                rectF.left += (rect.width() - rectF.right) / 2.0f;
                rectF.top += (rect.height() - rectF.bottom) / 2.0f;
                xy[0] = rectF.left;
                xy[1] = rectF.top - mTextPaint.ascent();
                xy[2] = w / 2f;
                xy[3] = h / 2f;
                xy[4] = -ROTATE_ANGLE;
                break;
            case MODE_RIGHT_TRIANGLE:
            case MODE_RIGHT:
                rect = new Rect(offset, 0, w + offset, h);
                rectF = new RectF(rect);
                rectF.right = mTextPaint.measureText(mSlantedText, 0, mSlantedText.length());
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent();
                rectF.left += (rect.width() - rectF.right) / 2.0f;
                rectF.top += (rect.height() - rectF.bottom) / 2.0f;
                xy[0] = rectF.left;
                xy[1] = rectF.top - mTextPaint.ascent();
                xy[2] = w / 2f + offset;
                xy[3] = h / 2f;
                xy[4] = ROTATE_ANGLE;
                break;
            case MODE_LEFT_BOTTOM_TRIANGLE:
            case MODE_LEFT_BOTTOM:
                rect = new Rect(0, offset, w, h + offset);
                rectF = new RectF(rect);
                rectF.right = mTextPaint.measureText(mSlantedText, 0, mSlantedText.length());
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent();
                rectF.left += (rect.width() - rectF.right) / 2.0f;
                rectF.top += (rect.height() - rectF.bottom) / 2.0f;

                xy[0] = rectF.left;
                xy[1] = rectF.top - mTextPaint.ascent();
                xy[2] = w / 2f;
                xy[3] = h / 2f + offset;
                xy[4] = ROTATE_ANGLE;
                break;
            case MODE_RIGHT_BOTTOM_TRIANGLE:
            case MODE_RIGHT_BOTTOM:
                rect = new Rect(offset, offset, w + offset, h + offset);
                rectF = new RectF(rect);
                rectF.right = mTextPaint.measureText(mSlantedText, 0, mSlantedText.length());
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent();
                rectF.left += (rect.width() - rectF.right) / 2.0f;
                rectF.top += (rect.height() - rectF.bottom) / 2.0f;
                xy[0] = rectF.left;
                xy[1] = rectF.top - mTextPaint.ascent();
                xy[2] = w / 2f + offset;
                xy[3] = h / 2f + offset;
                xy[4] = -ROTATE_ANGLE;
                break;
        }
        return xy;
    }

    public SlantedTextView setText(String str) {
        mSlantedText = str;
        postInvalidate();
        return this;
    }

    public SlantedTextView setText(int res) {
        String str = getResources().getString(res);
        if (!TextUtils.isEmpty(str)) {
            setText(str);
        }
        return this;
    }

    public String getText() {
        return mSlantedText;
    }

    public SlantedTextView setSlantedBackgroundColor(int color) {
        mSlantedBackgroundColor = color;
        mBackgroundPaint.setColor(mSlantedBackgroundColor);
        postInvalidate();
        return this;
    }

    public SlantedTextView setTextColor(int color) {
        mTextColor = color;
        mTextPaint.setColor(mTextColor);
        postInvalidate();
        return this;
    }

    /**
     * @param mode :
     *             SlantedTextView.MODE_LEFT : top left
     *             SlantedTextView.MODE_RIGHT :top right
     * @return this
     */
    public SlantedTextView setMode(int mode) {
        if (mMode > MODE_RIGHT_BOTTOM_TRIANGLE || mMode < 0)
            throw new IllegalArgumentException(mode + "is illegal argument ,please use right value");
        this.mMode = mode;
        postInvalidate();
        return this;
    }

    public int getMode() {
        return mMode;
    }

    public SlantedTextView setTextSize(int size) {
        this.mTextSize = size;
        mTextPaint.setTextSize(mTextSize);
        postInvalidate();
        return this;
    }

    /**
     * set slanted space length
     *
     * @param length
     * @return this
     */
    public SlantedTextView setSlantedLength(int length) {
        mSlantedLength = length;
        postInvalidate();
        return this;
    }

}
