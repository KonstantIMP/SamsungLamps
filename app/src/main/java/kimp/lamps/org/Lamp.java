package kimp.lamps.org;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class Lamp extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private boolean isToggled = false;

    public Lamp(@NonNull Context context) {
        super(context);
    }

    public void setToggled(boolean toggled) {
        isToggled = toggled;
    }

    public boolean isToggled() {
        return isToggled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            isToggled = !isToggled;
            invalidate();
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = Math.min(getHeight(), getWidth()) / 2;

        if (isToggled) paint.setColor(Color.YELLOW);
        else paint.setColor(Color.GRAY);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
    }
}
