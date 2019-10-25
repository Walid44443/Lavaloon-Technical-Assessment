package codes.walid4444.lavaloon.toggl.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import codes.walid4444.lavaloon.toggl.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    protected View rootView;
    protected TextView titleText;

    HeaderViewHolder(View view) {
        super(view);
        rootView = view;
        titleText = view.findViewById(R.id.titleText);
    }
}
