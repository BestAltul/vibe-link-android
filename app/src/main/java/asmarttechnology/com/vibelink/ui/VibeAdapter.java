package asmarttechnology.com.vibelink.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import asmarttechnology.com.vibelink.R;
import asmarttechnology.com.vibelink.VibeDetailsActivity;

public class VibeAdapter extends RecyclerView.Adapter<VibeAdapter.VibeViewHolder> {

    private List<VibeItem> vibeList;

    public VibeAdapter(List<VibeItem> vibeList) {
        this.vibeList = vibeList;
    }

    @NonNull
    @Override
    public VibeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vibe, parent, false);
        return new VibeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VibeViewHolder holder, int position) {
        VibeItem item = vibeList.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        
        holder.itemView.setOnClickListener(v->{
            Context context = v.getContext();
            Intent intent = new Intent(context, VibeDetailsActivity.class);
            intent.putExtra("title",item.getTitle());
            intent.putExtra("description", item.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return vibeList.size();
    }

    public static class VibeViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView icon;

        public VibeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.vibeTitle);
            description = itemView.findViewById(R.id.vibeDescription);
            icon = itemView.findViewById(R.id.vibeIcon);
        }
    }
}
