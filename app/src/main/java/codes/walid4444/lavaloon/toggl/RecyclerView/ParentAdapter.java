package codes.walid4444.lavaloon.toggl.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

import codes.walid4444.lavaloon.toggl.Activities.MainActivity;
import codes.walid4444.lavaloon.toggl.R;
import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {
    Map<String,List<TimeEntryModel>> map;
    Context mContext;

    public ParentAdapter(Map<String,List<TimeEntryModel>> map, Context mContext) {
        this.map = map;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parent_recycler, parent, false);
        return new ParentAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText((String) map.keySet().toArray()[position]);
        holder.child_recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        ChildAdapter adapter= new ChildAdapter(map.get((String) map.keySet().toArray()[position]),mContext);
        holder.child_recyclerView.setAdapter(adapter);
        holder.child_recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public int getItemCount() {
        return map.keySet().toArray().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle;
        RecyclerView child_recyclerView;
        TimeEntryModel timeEntryModel;

        public ViewHolder(View view) {
            super(view);
            mTitle = view.findViewById(R.id.title_txt);
            child_recyclerView = view.findViewById(R.id.rv_child);
        }

        @Override
        public void onClick(View v) {
            //v.getContext().startActivity(new Intent(v.getContext(), StoreDetailsActivity.class).putExtra("store_id", store.getStore_id()));
        }
    }
}
