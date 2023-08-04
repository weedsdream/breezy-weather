package org.breezyweather.common.ui.images

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.drawable.Drawable

class RotateDrawable(private val mDrawable: Drawable?) : Drawable() {
    private var mDegree = 0f
    override fun draw(canvas: Canvas) {
        if (mDrawable == null) return
        val innerBounds = mDrawable.bounds
        val cx = (innerBounds.right - innerBounds.left) / 2f
        val cy = (innerBounds.bottom - innerBounds.top) / 2f
        val saveCount = canvas.save()
        canvas.rotate(mDegree, cx + innerBounds.left, cy + innerBounds.top)
        mDrawable.draw(canvas)
        canvas.restoreToCount(saveCount)
    }

    override fun setAlpha(alpha: Int) {
        mDrawable?.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mDrawable?.colorFilter = colorFilter
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }

    override fun setBounds(left: Int, top: Int, right: Int, bottom: Int) {
        mDrawable?.setBounds(left, top, right, bottom)
    }

    override fun setBounds(bounds: Rect) {
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom)
    }

    fun rotate(degree: Float) {
        mDegree = degree
    }
}
