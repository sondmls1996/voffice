package com.serhatsurguvec.swipablelayout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Serhat Surguvec on 17/09/15.
 */
public class SwipeableLayout extends FrameLayout {

	public interface OnLayoutCloseListener {
		void OnLayoutClosed(boolean close);
	}

	enum Direction {
		UP_DOWN, LEFT_RIGHT, NONE
	}

	private Direction direction = Direction.NONE;
	private int previousFingerPositionY;
	private int previousFingerPositionX;
	private int baseLayoutPosition;
	private boolean isScrollingUp;
	private boolean isLocked = false;
	private OnLayoutCloseListener listener;

	public SwipeableLayout(Context context) {
		super(context);
	}

	public SwipeableLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SwipeableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {

		if (isLocked) {
			return false;
		} else {
			final int y = (int) ev.getRawY();
			final int x = (int) ev.getRawX();

			if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {

				previousFingerPositionX = x;
				previousFingerPositionY = y;

			} else if (ev.getActionMasked() == MotionEvent.ACTION_MOVE) {

				int diffY = y - previousFingerPositionY;
				int diffX = x - previousFingerPositionX;

				if (Math.abs(diffX) + 50 < Math.abs(diffY)) {
					return true;
				}

			}

			return false;
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {

		if (!isLocked) {

			final int y = (int) ev.getRawY();
			final int x = (int) ev.getRawX();

			if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {

				previousFingerPositionX = x;
				previousFingerPositionY = y;
				baseLayoutPosition = (int) this.getY();

			} else if (ev.getActionMasked() == MotionEvent.ACTION_MOVE) {

				int diffY = y - previousFingerPositionY;
				int diffX = x - previousFingerPositionX;

				if (direction == Direction.NONE) {
					if (Math.abs(diffX) > Math.abs(diffY)) {
						direction = Direction.LEFT_RIGHT;
					} else if (Math.abs(diffX) < Math.abs(diffY)) {
						direction = Direction.UP_DOWN;
					} else {
						direction = Direction.NONE;
					}
				}

				if (direction == Direction.UP_DOWN) {
					isScrollingUp = diffY <= 0;

					this.setY(baseLayoutPosition + (float) diffY);
					requestLayout();
					return true;
				}

			} else if (ev.getActionMasked() == MotionEvent.ACTION_UP) {

				if (direction == Direction.UP_DOWN) {

					if (isScrollingUp) {
						int height = this.getHeight();
						if (Math.abs(this.getY()) > (height / 4)) {
							if (listener != null) {
								listener.OnLayoutClosed(true);
							}
						} else {
							if (listener != null) {
								listener.OnLayoutClosed(false);
							}
						}

					} else {

						int height = this.getHeight();

						if (Math.abs(this.getY()) > (height / 4)) {
							if (listener != null) {
								listener.OnLayoutClosed(true);
							}
						} else {
							if (listener != null) {
								listener.OnLayoutClosed(false);
							}
						}

					}

					ObjectAnimator positionAnimator = ObjectAnimator.ofFloat(
							this, "y", this.getY(), 0);
					positionAnimator.setDuration(300);
					positionAnimator.start();

					direction = Direction.NONE;
					return true;
				}

				direction = Direction.NONE;
			}

			return true;

		}

		return false;
	}

	public void setOnLayoutCloseListener(OnLayoutCloseListener closeListener) {
		this.listener = closeListener;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void lock() {
		isLocked = true;
	}

	public void unLock() {
		isLocked = false;
	}

}
