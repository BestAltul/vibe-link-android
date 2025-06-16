package asmarttechnology.com.vibelink.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import asmarttechnology.com.vibelink.R;

public class VibesFragment extends Fragment {

    private RecyclerView recyclerView;
    private VibeAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vibes, container, false);

        recyclerView = root.findViewById(R.id.vibeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Пример данных
        List<VibeItem> vibes = new ArrayList<>();
        vibes.add(new VibeItem("Personal Vibe", "This is my private vibe.",R.drawable.ic_person));
//        vibes.add(new VibeItem("Vibe #2", "Another example of a vibe."));
//        vibes.add(new VibeItem("Work", "Only show work email, no phone."));
//        vibes.add(new VibeItem("Casual", "Show Instagram + first name only."));

        adapter = new VibeAdapter(vibes);
        recyclerView.setAdapter(adapter);

        return root;
    }
}
