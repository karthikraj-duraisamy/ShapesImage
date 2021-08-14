package net.karthikraj.shapesimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * An {@link ImageView} that draws its contents inside a mask.
 */

public class ShapesImage extends ImageView {
    private Paint mBlackPaint;
    private Paint mMaskedPaint;
    private Rect mBounds;
    private RectF mBoundsF;
    private Drawable mMaskDrawable;

    private boolean mCacheValid = false;
    private Bitmap mCacheBitmap;
    private int mCachedWidth;
    private int mCachedHeight;
    private int mImageShape;

    public static final int CUSTOM = 0;
    public static final int CIRCLE = 1;
    public static final int ROUNDED = 2;
    public static final int BOWL = 3;
    public static final int TRIANGLE = 4;
    public static final int CROSS = 5;
    public static final int ELLIPSE = 6;
    public static final int BEAKER = 7;
    public static final int HEART = 8;

    public static final int XBOX = 9;
    public static final int WATER_DROP = 10;
    public static final int VIDEO = 11;
    public static final int TWITTER_BIRD = 12;
    public static final int TROPHY = 13;
    public static final int TREE = 14;
    public static final int TOOLTIP = 15;

    public static final int TIE = 16;
    public static final int THUMB_UP = 17;
    public static final int THUMB_DOWN = 18;
    public static final int TENNIS_BALL = 19;
    public static final int TAG = 20;
    public static final int SNOWMAN = 21;
    public static final int SHEILD = 22;
    public static final int SHOPPING_BAG = 23;
    public static final int PUZZLE = 24;
    public static final int OCTAGON = 25;
    public static final int MESSAGE = 26;
    public static final int MESSAGE_REPLY = 27;
    public static final int LOCK = 28;
    public static final int LIGHT_BULB = 29;
    public static final int LEAF = 30;
    public static final int LABEL = 31;
    public static final int HEART_BROKEN = 32;
    public static final int HEXAGON = 33;
    public static final int GUITAR_PICK = 34;
    public static final int GHOST = 35;
    public static final int APPLE = 36;
    public static final int FOLDER = 37;
    public static final int MESSENGER = 38;
    public static final int DUCK = 39;
    public static final int DELETE = 40;
    public static final int COFFEE_MUG = 41;
    public static final int CLOUD = 42;
    public static final int BOOKMARK = 43;
    public static final int BELL = 44;
    public static final int BATTERY = 45;
    public static final int APPLE_LOGO = 46;
    public static final int ANDROID = 47;

    public ShapesImage(Context context) {
        this(context, null);
    }

    public ShapesImage(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Attribute initialization
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShapesImage);
        mImageShape = a.getInteger(R.styleable.ShapesImage_shape, 0);

        if(mImageShape == CUSTOM) {
            mMaskDrawable = a.getDrawable(R.styleable.ShapesImage_shapeDrawable);
            if (mMaskDrawable != null) {
                mMaskDrawable.setCallback(this);
            }
        }

        prepareDrawables(mImageShape);
        a.recycle();
        setUpPaints();
    }

    private void prepareDrawables(int checkShape) {
        switch (checkShape)
        {
            case CIRCLE:
                if(Build.VERSION.SDK_INT >= 21)
                mMaskDrawable = getResources().getDrawable(R.drawable.circle, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.circle);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case ROUNDED:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.round_corner, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.round_corner);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case BOWL:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.bowl, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.bowl);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TRIANGLE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.triangle, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.triangle);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case HEART:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.heart_vector, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.heart_vector);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case CROSS:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.cross, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.cross);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case BEAKER:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.beaker, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.beaker);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case ELLIPSE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.ellipse, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.ellipse);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case XBOX:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.xbox, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.xbox);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case WATER_DROP:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.water_drop, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.water_drop);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case VIDEO:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.video, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.video);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TWITTER_BIRD:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.twitter_bird, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.twitter_bird);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TROPHY:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.trophy, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.trophy);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TREE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.tree, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.tree);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TOOLTIP:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.tooltip, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.tooltip);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TIE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.tie, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.tie);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case THUMB_UP:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.thumb_up, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.thumb_up);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case THUMB_DOWN:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.thumb_down, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.thumb_down);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TENNIS_BALL:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.tennis_ball, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.tennis_ball);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case TAG:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.tag, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.tag);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case SNOWMAN:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.snow_man, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.snow_man);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case SHEILD:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.sheild, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.sheild);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case SHOPPING_BAG:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.shopping_bag, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.shopping_bag);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case PUZZLE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.puzzle, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.puzzle);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case OCTAGON:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.octagon, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.octagon);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case MESSAGE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.message, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.message);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case MESSAGE_REPLY:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.message_reply, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.message_reply);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case LOCK:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.lock, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.lock);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case LIGHT_BULB:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.light_bulb, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.light_bulb);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case LEAF:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.leaf, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.leaf);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case LABEL:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.label, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.label);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case HEART_BROKEN:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.heart_broken, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.heart_broken);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case HEXAGON:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.hexagon, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.hexagon);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case GUITAR_PICK:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.guitar_pick, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.guitar_pick);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case GHOST:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.ghost, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.ghost);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case APPLE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.apple, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.apple);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case FOLDER:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.folder, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.folder);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case MESSENGER:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.messenger, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.messenger);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case DUCK:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.duck, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.duck);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case DELETE:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.delete, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.delete);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case COFFEE_MUG:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.coffee_mug, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.coffee_mug);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case CLOUD:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.cloud, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.cloud);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case BOOKMARK:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.bookmark, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.bookmark);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case BELL:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.bell, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.bell);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case BATTERY:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.battery, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.battery);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case APPLE_LOGO:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.apple_logo, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.apple_logo);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
            case ANDROID:
                if(Build.VERSION.SDK_INT >= 21)
                    mMaskDrawable = getResources().getDrawable(R.drawable.android, null);
                else
                    mMaskDrawable = getResources().getDrawable(R.drawable.android);
                if (mMaskDrawable != null) {
                    mMaskDrawable.setCallback(this);
                }
                break;
        }
    }

    private void setUpPaints() {
        mBlackPaint = new Paint();
        mBlackPaint.setColor(0xff000000);
        mMaskedPaint = new Paint();
        mMaskedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        mCacheBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }

    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        final boolean changed = super.setFrame(l, t, r, b);
        mBounds = new Rect(0, 0, r - l, b - t);
        mBoundsF = new RectF(mBounds);
        if (mMaskDrawable != null) {
            mMaskDrawable.setBounds(mBounds);
        }
        if (changed) {
            mCacheValid = false;
        }
        return changed;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mBounds == null) {
            return;
        }
        int width = mBounds.width();
        int height = mBounds.height();
        if (width == 0 || height == 0) {
            return;
        }

        if (!mCacheValid || width != mCachedWidth || height != mCachedHeight) {
            // Need to redraw the cache
            if (width == mCachedWidth && height == mCachedHeight) {
                // Have a correct-sized bitmap cache already allocated. Just erase it.
                mCacheBitmap.eraseColor(0);
            } else {
                // Allocate a new bitmap with the correct dimensions.
                mCacheBitmap.recycle();
                //noinspection AndroidLintDrawAllocation
                mCacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                mCachedWidth = width;
                mCachedHeight = height;
            }

            Canvas cacheCanvas = new Canvas(mCacheBitmap);
            if (mMaskDrawable != null) {
                int sc = cacheCanvas.save();
                mMaskDrawable.draw(cacheCanvas);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    cacheCanvas.saveLayer(mBoundsF, mMaskedPaint);
                }else{
                    cacheCanvas.saveLayer(mBoundsF, mMaskedPaint,Canvas.ALL_SAVE_FLAG);
                }
                super.onDraw(cacheCanvas);
                cacheCanvas.restoreToCount(sc);
            }else {
                super.onDraw(cacheCanvas);
            }
        }
        // Draw from cache
        canvas.drawBitmap(mCacheBitmap, mBounds.left, mBounds.top, null);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mMaskDrawable != null && mMaskDrawable.isStateful()) {
            mMaskDrawable.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override
    public void invalidateDrawable(Drawable who) {
        if (who == mMaskDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(who);
        }
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mMaskDrawable || super.verifyDrawable(who);
    }

    /**
     * Sets the Drawable
     *
     * @param drawable Drawable object
     */
    public void setShapeDrawable(Drawable drawable) {
        this.mMaskDrawable = drawable;
        if (mMaskDrawable != null) {
            mMaskDrawable.setCallback(this);
        }
        setUpPaints();
    }
    /**
     * Sets the Drawable resource
     *
     * @param drawable Drawable resource
     */
    public void setShapeDrawable(int drawable) {
        if(drawable != CUSTOM) {
            mImageShape = drawable;
            prepareDrawables(mImageShape);
            setUpPaints();
        }
   }

}