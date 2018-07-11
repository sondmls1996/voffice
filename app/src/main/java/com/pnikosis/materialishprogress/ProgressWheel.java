package com.pnikosis.materialishprogress;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import com.viettel.R;

/**
 * A Material style progress wheel, compatible up to 2.2. Todd Davies' Progress
 * Wheel https://github.com/Todd-Davies/ProgressWheel
 * 
 * @author Nico Hormazábal
 *         <p/>
 *         Licensed under the Apache License 2.0 license see:
 *         http://www.apache.org/licenses/LICENSE-2.0
 */
public class ProgressWheel extends View {
	private final int barLength = 16;
	private final int barMaxLength = 270;
	private final long pauseGrowingTime = 200;
	/**
	 * ********* DEFAULTS * **********
	 */
	// Sizes (with defaults in DP)
	private int circleRadius = 28;
	private int barWidth = 4;
	private int rimWidth = 4;
	private boolean fillRadius = false;
	private double timeStartGrowing = 0;
	private double barSpinCycleTime = 460;
	private float barExtraLength = 0;
	private boolean barGrowingFromFront = true;
	private long pausedTimeWithoutGrowing = 0;
	// Colors (with defaults)
	private int barColor = 0xAA000000;
	private int rimColor = 0x00FFFFFF;

	// Paints
	private Paint barPaint = new Paint();
	private Paint rimPaint = new Paint();

	// Rectangles
	private RectF circleBounds = new RectF();

	// Animation
	// The amount of degrees per second
	private float spinSpeed = 230.0f;
	// private float spinSpeed = 120.0f;
	// The last time the spinner was animated
	private long lastTimeAnimated = 0;

	private boolean linearProgress;

	private float mProgress = 0.0f;
	private float mTargetProgress = 0.0f;
	private boolean spinning = false;

	private ProgressCallback callback;

	private boolean shouldAnimate;

	/**
	 * The constructor for the ProgressWheel
	 */
	public ProgressWheel(Context context, AttributeSet attrs) {
		super(context, attrs);

		parseAttributes(context.obtainStyledAttributes(attrs,
				R.styleable.ProgressWheel));

		setAnimationEnabled();
	}

	/**
	 * The constructor for the ProgressWheel
	 */
	public ProgressWheel(Context context) {
		super(context);
		setAnimationEnabled();
	}

	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	private void setAnimationEnabled() {
		int currentApiVersion = android.os.Build.VERSION.SDK_INT;

		float animationValue;
		if (currentApiVersion >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			animationValue = Settings.Global.getFloat(getContext()
					.getContentResolver(),
					Settings.Global.ANIMATOR_DURATION_SCALE, 1);
		} else {
			animationValue = Settings.System.getFloat(getContext()
					.getContentResolver(),
					Settings.System.ANIMATOR_DURATION_SCALE, 1);
		}

		shouldAnimate = animationValue != 0;
	}

	// ----------------------------------
	// Setting up stuff
	// ----------------------------------

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int viewWidth = circleRadius + this.getPaddingLeft()
				+ this.getPaddingRight();
		int viewHeight = circleRadius + this.getPaddingTop()
				+ this.getPaddingBottom();

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		int width;
		int height;

		// Measure Width
		if (widthMode == MeasureSpec.EXACTLY) {
			// Must be this size
			width = widthSize;
		} else if (widthMode == MeasureSpec.AT_MOST) {
			// Can't be bigger than...
			width = Math.min(viewWidth, widthSize);
		} else {
			// Be whatever you want
			width = viewWidth;
		}

		// Measure Height
		if (heightMode == MeasureSpec.EXACTLY
				|| widthMode == MeasureSpec.EXACTLY) {
			// Must be this size
			height = heightSize;
		} else if (heightMode == MeasureSpec.AT_MOST) {
			// Can't be bigger than...
			height = Math.min(viewHeight, heightSize);
		} else {
			// Be whatever you want
			height = viewHeight;
		}

		setMeasuredDimension(width, height);
	}

	/**
	 * Use onSizeChanged instead of onAttachedToWindow to get the dimensions of
	 * the view, because this method is called after measuring the dimensions of
	 * MATCH_PARENT & WRAP_CONTENT. Use this dimensions to setup the bounds and
	 * paints.
	 */
	@Override
	protected void onSizeChanged(int width, int height, int oldw, int oldh) {
		super.onSizeChanged(width, height, oldw, oldh);

		setupBounds(width, height);
		setupPaints();
		invalidate();
	}

	/**
	 * Set the properties of the paints we're using to draw the progress wheel
	 */
	private void setupPaints() {
		barPaint.setColor(barColor);
		barPaint.setAntiAlias(true);
		barPaint.setStyle(Style.STROKE);
		barPaint.setStrokeWidth(barWidth);

		rimPaint.setColor(rimColor);
		rimPaint.setAntiAlias(true);
		rimPaint.setStyle(Style.STROKE);
		rimPaint.setStrokeWidth(rimWidth);
	}

	/**
	 * Set the bounds of the component
	 */
	private void setupBounds(int layoutWidth, int layoutHeight) {
		int paddingTop = getPaddingTop();
		int paddingBottom = getPaddingBottom();
		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();

		if (!fillRadius) {
			// Width should equal to Height, find the min value to setup the
			// circle
			int minValue = Math.min(layoutWidth - paddingLeft - paddingRight,
					layoutHeight - paddingBottom - paddingTop);

			int circleDiameter = Math.min(minValue, circleRadius * 2 - barWidth
					* 2);

			// Calc the Offset if needed for centering the wheel in the
			// available space
			int xOffset = (layoutWidth - paddingLeft - paddingRight - circleDiameter)
					/ 2 + paddingLeft;
			int yOffset = (layoutHeight - paddingTop - paddingBottom - circleDiameter)
					/ 2 + paddingTop;

			circleBounds = new RectF(xOffset + barWidth, yOffset + barWidth,
					xOffset + circleDiameter - barWidth, yOffset
							+ circleDiameter - barWidth);
		} else {
			circleBounds = new RectF(paddingLeft + barWidth, paddingTop
					+ barWidth, layoutWidth - paddingRight - barWidth,
					layoutHeight - paddingBottom - barWidth);
		}
	}

	/**
	 * Parse the attributes passed to the view from the XML
	 * 
	 * @param array
	 *            the attributes to parse
	 */
	private void parseAttributes(TypedArray array) {
		// We transform the default values from DIP to pixels
		DisplayMetrics metrics = getContext().getResources()
				.getDisplayMetrics();
		barWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				barWidth, metrics);
		rimWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				rimWidth, metrics);
		circleRadius = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, circleRadius, metrics);

		circleRadius = (int) array.getDimension(
				R.styleable.ProgressWheel_matProg_circleRadius, circleRadius);

		fillRadius = array.getBoolean(
				R.styleable.ProgressWheel_matProg_fillRadius, false);

		barWidth = (int) array.getDimension(
				R.styleable.ProgressWheel_matProg_barWidth, barWidth);

		rimWidth = (int) array.getDimension(
				R.styleable.ProgressWheel_matProg_rimWidth, rimWidth);

		float baseSpinSpeed = array
				.getFloat(R.styleable.ProgressWheel_matProg_spinSpeed,
						spinSpeed / 360.0f);
		spinSpeed = baseSpinSpeed * 360;

		barSpinCycleTime = array.getInt(
				R.styleable.ProgressWheel_matProg_barSpinCycleTime,
				(int) barSpinCycleTime);

		barColor = array.getColor(R.styleable.ProgressWheel_matProg_barColor,
				barColor);

		rimColor = array.getColor(R.styleable.ProgressWheel_matProg_rimColor,
				rimColor);

		linearProgress = array.getBoolean(
				R.styleable.ProgressWheel_matProg_linearProgress, false);

		if (array.getBoolean(
				R.styleable.ProgressWheel_matProg_progressIndeterminate, false)) {
			spin();
		}

		// Recycle
		array.recycle();
	}

	public void setCallback(ProgressCallback progressCallback) {
		callback = progressCallback;

		if (!spinning) {
			runCallback();
		}
	}

	// ----------------------------------
	// Animation stuff
	// ----------------------------------

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawArc(circleBounds, 360, 360, false, rimPaint);

		boolean mustInvalidate = false;

		if (!shouldAnimate) {
			return;
		}

		if (spinning) {
			// Draw the spinning bar
			mustInvalidate = true;

			long deltaTime = (SystemClock.uptimeMillis() - lastTimeAnimated);
			float deltaNormalized = deltaTime * spinSpeed / 1000.0f;

			updateBarLength(deltaTime);

			mProgress += deltaNormalized;
			if (mProgress > 360) {
				mProgress -= 360f;

				// A full turn has been completed
				// we run the callback with -1 in case we want to
				// do something, like changing the color
				runCallback(-1.0f);
			}
			lastTimeAnimated = SystemClock.uptimeMillis();

			float from = mProgress - 90;
			float length = barLength + barExtraLength;

			if (isInEditMode()) {
				from = 0;
				length = 135;
			}

			canvas.drawArc(circleBounds, from, length, false, barPaint);
		} else {
			float oldProgress = mProgress;

			if (mProgress != mTargetProgress) {
				// We smoothly increase the progress bar
				mustInvalidate = true;

				float deltaTime = (float) (SystemClock.uptimeMillis() - lastTimeAnimated) / 1000;
				float deltaNormalized = deltaTime * spinSpeed;

				mProgress = Math.min(mProgress + deltaNormalized,
						mTargetProgress);
				lastTimeAnimated = SystemClock.uptimeMillis();
			}

			if (oldProgress != mProgress) {
				runCallback();
			}

			float offset = 0.0f;
			float progress = mProgress;
			if (!linearProgress) {
				float factor = 2.0f;
				offset = (float) (1.0f - Math.pow(1.0f - mProgress / 360.0f,
						2.0f * factor)) * 360.0f;
				progress = (float) (1.0f - Math.pow(1.0f - mProgress / 360.0f,
						factor)) * 360.0f;
			}

			if (isInEditMode()) {
				progress = 360;
			}

			canvas.drawArc(circleBounds, offset - 90, progress, false, barPaint);
		}

		if (mustInvalidate) {
			invalidate();
		}
	}

	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);

		if (visibility == VISIBLE) {
			lastTimeAnimated = SystemClock.uptimeMillis();
		}
	}

	private void updateBarLength(long deltaTimeInMilliSeconds) {
		if (pausedTimeWithoutGrowing >= pauseGrowingTime) {
			timeStartGrowing += deltaTimeInMilliSeconds;

			if (timeStartGrowing > barSpinCycleTime) {
				// We completed a size change cycle
				// (growing or shrinking)
				timeStartGrowing -= barSpinCycleTime;
				// if(barGrowingFromFront) {
				pausedTimeWithoutGrowing = 0;
				// }
				barGrowingFromFront = !barGrowingFromFront;
			}

			float distance = (float) Math.cos((timeStartGrowing
					/ barSpinCycleTime + 1)
					* Math.PI) / 2 + 0.5f;
			float destLength = (barMaxLength - barLength);

			if (barGrowingFromFront) {
				barExtraLength = distance * destLength;
			} else {
				float newLength = destLength * (1 - distance);
				mProgress += (barExtraLength - newLength);
				barExtraLength = newLength;
			}
		} else {
			pausedTimeWithoutGrowing += deltaTimeInMilliSeconds;
		}
	}

	/**
	 * Check if the wheel is currently spinning
	 */

	public boolean isSpinning() {
		return spinning;
	}

	/**
	 * Reset the count (in increment mode)
	 */
	public void resetCount() {
		mProgress = 0.0f;
		mTargetProgress = 0.0f;
		invalidate();
	}

	/**
	 * Turn off spin mode
	 */
	public void stopSpinning() {
		spinning = false;
		mProgress = 0.0f;
		mTargetProgress = 0.0f;
		invalidate();
	}

	/**
	 * Puts the view on spin mode
	 */
	public void spin() {
		lastTimeAnimated = SystemClock.uptimeMillis();
		spinning = true;
		invalidate();
	}

	private void runCallback(float value) {
		if (callback != null) {
			callback.onProgressUpdate(value);
		}
	}

	private void runCallback() {
		if (callback != null) {
			float normalizedProgress = (float) Math
					.round(mProgress * 100 / 360.0f) / 100;
			callback.onProgressUpdate(normalizedProgress);
		}
	}

	/**
	 * Set the progress to a specific value, the bar will be set instantly to
	 * that value
	 * 
	 * @param progress
	 *            the progress between 0 and 1
	 */
	public void setInstantProgress(float progress) {
		if (spinning) {
			mProgress = 0.0f;
			spinning = false;
		}

		if (progress > 1.0f) {
			progress -= 1.0f;
		} else if (progress < 0) {
			progress = 0;
		}

		if (progress == mTargetProgress) {
			return;
		}

		mTargetProgress = Math.min(progress * 360.0f, 360.0f);
		mProgress = mTargetProgress;
		lastTimeAnimated = SystemClock.uptimeMillis();
		invalidate();
	}

	// Great way to save a view's state
	// http://stackoverflow.com/a/7089687/1991053
	@Override
	public Parcelable onSaveInstanceState() {
		Parcelable superState = super.onSaveInstanceState();

		WheelSavedState saveState = new WheelSavedState(superState);

		// We save everything that can be changed at runtime
		saveState.mProgress = this.mProgress;
		saveState.mTargetProgress = this.mTargetProgress;
		saveState.isSpinning = this.spinning;
		saveState.spinSpeed = this.spinSpeed;
		saveState.barWidth = this.barWidth;
		saveState.barColor = this.barColor;
		saveState.rimWidth = this.rimWidth;
		saveState.rimColor = this.rimColor;
		saveState.circleRadius = this.circleRadius;
		saveState.linearProgress = this.linearProgress;
		saveState.fillRadius = this.fillRadius;

		return saveState;
	}

	@Override
	public void onRestoreInstanceState(Parcelable state) {
		if (!(state instanceof WheelSavedState)) {
			super.onRestoreInstanceState(state);
			return;
		}

		WheelSavedState saveState = (WheelSavedState) state;
		super.onRestoreInstanceState(saveState.getSuperState());

		this.mProgress = saveState.mProgress;
		this.mTargetProgress = saveState.mTargetProgress;
		this.spinning = saveState.isSpinning;
		this.spinSpeed = saveState.spinSpeed;
		this.barWidth = saveState.barWidth;
		this.barColor = saveState.barColor;
		this.rimWidth = saveState.rimWidth;
		this.rimColor = saveState.rimColor;
		this.circleRadius = saveState.circleRadius;
		this.linearProgress = saveState.linearProgress;
		this.fillRadius = saveState.fillRadius;

		this.lastTimeAnimated = SystemClock.uptimeMillis();
	}

	/**
	 * @return the current progress between 0.0 and 1.0, if the wheel is
	 *         indeterminate, then the result is -1
	 */
	public float getProgress() {
		return spinning ? -1 : mProgress / 360.0f;
	}

	// ----------------------------------
	// Getters + setters
	// ----------------------------------

	/**
	 * Set the progress to a specific value, the bar will smoothly animate until
	 * that value
	 * 
	 * @param progress
	 *            the progress between 0 and 1
	 */
	public void setProgress(float progress) {
		if (spinning) {
			mProgress = 0.0f;
			spinning = false;

			runCallback();
		}

		if (progress > 1.0f) {
			progress -= 1.0f;
		} else if (progress < 0) {
			progress = 0;
		}

		if (progress == mTargetProgress) {
			return;
		}

		// If we are currently in the right position
		// we set again the last time animated so the
		// animation starts smooth from here
		if (mProgress == mTargetProgress) {
			lastTimeAnimated = SystemClock.uptimeMillis();
		}

		mTargetProgress = Math.min(progress * 360.0f, 360.0f);

		invalidate();
	}

	/**
	 * Sets the determinate progress mode
	 * 
	 * @param isLinear
	 *            if the progress should increase linearly
	 */
	public void setLinearProgress(boolean isLinear) {
		linearProgress = isLinear;
		if (!spinning) {
			invalidate();
		}
	}

	/**
	 * @return the radius of the wheel in pixels
	 */
	public int getCircleRadius() {
		return circleRadius;
	}

	/**
	 * Sets the radius of the wheel
	 * 
	 * @param circleRadius
	 *            the expected radius, in pixels
	 */
	public void setCircleRadius(int circleRadius) {
		this.circleRadius = circleRadius;
		if (!spinning) {
			invalidate();
		}
	}

	/**
	 * @return the width of the spinning bar
	 */
	public int getBarWidth() {
		return barWidth;
	}

	/**
	 * Sets the width of the spinning bar
	 * 
	 * @param barWidth
	 *            the spinning bar width in pixels
	 */
	public void setBarWidth(int barWidth) {
		this.barWidth = barWidth;
		if (!spinning) {
			invalidate();
		}
	}

	/**
	 * @return the color of the spinning bar
	 */
	public int getBarColor() {
		return barColor;
	}

	/**
	 * Sets the color of the spinning bar
	 * 
	 * @param barColor
	 *            The spinning bar color
	 */
	public void setBarColor(int barColor) {
		this.barColor = barColor;
		setupPaints();
		if (!spinning) {
			invalidate();
		}
	}

	/**
	 * @return the color of the wheel's contour
	 */
	public int getRimColor() {
		return rimColor;
	}

	/**
	 * Sets the color of the wheel's contour
	 * 
	 * @param rimColor
	 *            the color for the wheel
	 */
	public void setRimColor(int rimColor) {
		this.rimColor = rimColor;
		setupPaints();
		if (!spinning) {
			invalidate();
		}
	}

	/**
	 * @return the base spinning speed, in full circle turns per second (1.0
	 *         equals on full turn in one second), this value also is applied
	 *         for the smoothness when setting a progress
	 */
	public float getSpinSpeed() {
		return spinSpeed / 360.0f;
	}

	/**
	 * Sets the base spinning speed, in full circle turns per second (1.0 equals
	 * on full turn in one second), this value also is applied for the
	 * smoothness when setting a progress
	 * 
	 * @param spinSpeed
	 *            the desired base speed in full turns per second
	 */
	public void setSpinSpeed(float spinSpeed) {
		this.spinSpeed = spinSpeed * 360.0f;
	}

	/**
	 * @return the width of the wheel's contour in pixels
	 */
	public int getRimWidth() {
		return rimWidth;
	}

	/**
	 * Sets the width of the wheel's contour
	 * 
	 * @param rimWidth
	 *            the width in pixels
	 */
	public void setRimWidth(int rimWidth) {
		this.rimWidth = rimWidth;
		if (!spinning) {
			invalidate();
		}
	}

	public interface ProgressCallback {
		/**
		 * Method to call when the progress reaches a value in order to avoid
		 * float precision issues, the progress is rounded to a float with two
		 * decimals.
		 * 
		 * In indeterminate mode, the callback is called each time the wheel
		 * completes an animation cycle, with, the progress value is -1.0f
		 * 
		 * @param progress
		 *            a double value between 0.00 and 1.00 both included
		 */
		public void onProgressUpdate(float progress);
	}

	static class WheelSavedState extends BaseSavedState {
		// required field that makes Parcelables from a Parcel
		public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() {
			public WheelSavedState createFromParcel(Parcel mParcel) {
				return new WheelSavedState(mParcel);
			}

			public WheelSavedState[] newArray(int size) {
				return new WheelSavedState[size];
			}
		};
		float mProgress;
		float mTargetProgress;
		boolean isSpinning;
		float spinSpeed;
		int barWidth;
		int barColor;
		int rimWidth;
		int rimColor;
		int circleRadius;
		boolean linearProgress;
		boolean fillRadius;

		WheelSavedState(Parcelable superState) {
			super(superState);
		}

		private WheelSavedState(Parcel input) {
			super(input);
			this.mProgress = input.readFloat();
			this.mTargetProgress = input.readFloat();
			this.isSpinning = input.readByte() != 0;
			this.spinSpeed = input.readFloat();
			this.barWidth = input.readInt();
			this.barColor = input.readInt();
			this.rimWidth = input.readInt();
			this.rimColor = input.readInt();
			this.circleRadius = input.readInt();
			this.linearProgress = input.readByte() != 0;
			this.fillRadius = input.readByte() != 0;
		}

		@Override
		public void writeToParcel(Parcel out, int flags) {
			super.writeToParcel(out, flags);
			out.writeFloat(this.mProgress);
			out.writeFloat(this.mTargetProgress);
			out.writeByte((byte) (isSpinning ? 1 : 0));
			out.writeFloat(this.spinSpeed);
			out.writeInt(this.barWidth);
			out.writeInt(this.barColor);
			out.writeInt(this.rimWidth);
			out.writeInt(this.rimColor);
			out.writeInt(this.circleRadius);
			out.writeByte((byte) (linearProgress ? 1 : 0));
			out.writeByte((byte) (fillRadius ? 1 : 0));
		}
	}
}