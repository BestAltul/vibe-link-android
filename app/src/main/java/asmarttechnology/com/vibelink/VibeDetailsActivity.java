package asmarttechnology.com.vibelink;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class VibeDetailsActivity extends AppCompatActivity {

    private List<String> labels;
    private List<String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibe_details);


        LinearLayout container = findViewById(R.id.vibeFieldsContainer);
        labels = getIntent().getStringArrayListExtra("labels");
        values = getIntent().getStringArrayListExtra("values");

        if (labels != null && values != null) {
            for (int i = 0; i < labels.size(); i++) {
                TextView fieldView = new TextView(this);
                fieldView.setText(labels.get(i) + ": " + values.get(i));
                fieldView.setTextSize(16);
                fieldView.setPaintFlags(fieldView.getPaintFlags() & ~Paint.UNDERLINE_TEXT_FLAG);
                container.addView(fieldView);
            }
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        Button editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, VibeBuilderActivity.class);

            if (labels != null && values != null) {
                intent.putStringArrayListExtra("labels", new ArrayList<>(labels));
                intent.putStringArrayListExtra("values", new ArrayList<>(values));
            }

            startActivity(intent);
        });


    }
}
