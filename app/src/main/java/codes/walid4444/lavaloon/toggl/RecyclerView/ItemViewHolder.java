package codes.walid4444.lavaloon.toggl.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import codes.walid4444.lavaloon.toggl.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout rootView;
    public TextView contentText;
    public TextView duration;
    public TextView description;
    private int defalut_text_size;

    ItemViewHolder(View view) {
        super(view);

        rootView = view.findViewById(R.id.rootView);
        duration = view.findViewById(R.id.forText);
        description = view.findViewById(R.id.description);

        defalut_text_size = 19;
    }
}
