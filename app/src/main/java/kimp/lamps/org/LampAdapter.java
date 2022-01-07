package kimp.lamps.org;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LampAdapter extends ArrayAdapter<Lamp> {

    public LampAdapter(@NonNull Context context, ArrayList<Lamp> lampList) {
        super(context, 0, lampList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        getItem(position).setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,MainActivity.LAMP_SIZE + MainActivity.GRID_SPACING));
        return getItem(position);
    }
}
