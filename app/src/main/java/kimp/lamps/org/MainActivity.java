package kimp.lamps.org;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int LAMP_SIZE = 100;
    public static final int GRID_SPACING = 5;

    int rows, columns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        rows = dm.heightPixels / (LAMP_SIZE + GRID_SPACING) - 1;
        columns = dm.widthPixels / (LAMP_SIZE + GRID_SPACING) - 1;

        GridView gridView = (GridView) findViewById(R.id.main_grid);
        ArrayList<Lamp> lamps = new ArrayList<>();

        for (int i = 0; i < columns * rows; i++) lamps.add(new Lamp(this));
        gridView.setAdapter(new LampAdapter(MainActivity.this, lamps));

        gridView.setNumColumns(columns);
        gridView.setHorizontalSpacing(GRID_SPACING);
        gridView.setVerticalSpacing(GRID_SPACING);
    }
}