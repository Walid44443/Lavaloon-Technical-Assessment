package codes.walid4444.lavaloon.toggl.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

import codes.walid4444.lavaloon.toggl.Activities.TimeDetailsActivity;
import codes.walid4444.lavaloon.toggl.R;
import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;
import codes.walid4444.lavaloon.toggl.Utility;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    List<TimeEntryModel> timeEntryModelList;
    Context mContext;

    public ChildAdapter(List<TimeEntryModel> timeEntryModelList, Context mContext) {
        this.timeEntryModelList = timeEntryModelList;
        this.mContext = mContext.getApplicationContext() ;
    }

    @NonNull
    @Override
    public ChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_sec_content, parent, false);
        return new ChildAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ViewHolder holder, int position) {
        holder.timeEntryModel = timeEntryModelList.get(position);
        holder.duration.setText(Utility.getDurationString(holder.timeEntryModel.getDuration())+"");
        if (holder.timeEntryModel.getDescription() != null)
            holder.description.setText(holder.timeEntryModel.getDescription());
        else
            holder.description.setText("No available description");
    }

    @Override
    public int getItemCount() {
        return timeEntryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TimeEntryModel timeEntryModel;
        TextView duration;
        TextView description;

        public ViewHolder(View view) {
            super(view);
            duration = view.findViewById(R.id.forText);
            description = view.findViewById(R.id.description);
            view.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            Log.i("ID",timeEntryModel.getId()+"");
            v.getContext().startActivity(new Intent(v.getContext(), TimeDetailsActivity.class).putExtra("ID", timeEntryModel.getId()));
        }
    }
}
