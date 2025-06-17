package asmarttechnology.com.vibelink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VibeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibe_details);


        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v->finish());

        TextView titleView = findViewById(R.id.vibeDetailTitle);
        TextView descView = findViewById(R.id.vibeDetailDescription);
        ImageView iconView = findViewById(R.id.vibeDetailIcon);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        int iconRes = intent.getIntExtra("icon", R.drawable.ic_person);

        titleView.setText(title);
        descView.setText(description);
        iconView.setImageResource(iconRes);
    }

}
