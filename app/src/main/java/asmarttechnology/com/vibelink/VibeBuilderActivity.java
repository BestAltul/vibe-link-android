package asmarttechnology.com.vibelink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class VibeBuilderActivity extends AppCompatActivity {
    private LinearLayout fieldContainer;
    private List<VibeField> vibeFields = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibe_builder);

        fieldContainer = findViewById(R.id.fieldContainer);

        Button addFieldButton = findViewById(R.id.addFieldButton);
        addFieldButton.setOnClickListener(v -> showFieldTypeDialog());

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> openDetailsScreen());

        Intent intent = getIntent();
        ArrayList<String> incomingLabels = intent.getStringArrayListExtra("labels");
        ArrayList<String> incomingValues = intent.getStringArrayListExtra("values");

        if (incomingLabels != null && incomingValues != null) {
            for (int i = 0; i < incomingLabels.size(); i++) {
                PhoneField field = new PhoneField();
                field.setLabel(incomingLabels.get(i));

                View view = field.renderView(this);
                field.getInput().setText(incomingValues.get(i));

                fieldContainer.addView(view);
                vibeFields.add(field);
            }
        }


    }

    private void showFieldTypeDialog() {
        String[] options = {"Phone","Email","Other"};

        new AlertDialog.Builder(this)
                .setTitle("Choose the field")
                .setItems(options, (dialog, which) -> {
                    VibeField field = null;

                    switch(which){

                        case 0:
                            field = new PhoneField();
                            break;
                        case 1:
                            field = new EmailField();
                            break;
                        case 2:
                            field = new LinkField();
                            break;
                        default:
                            Toast.makeText(this,"Unknown field type",Toast.LENGTH_SHORT).show();
                    }

                    if (field != null) {
                        vibeFields.add(field);
                        fieldContainer.addView(field.renderView(this));
                    }
                })
                .show();
    }

    private void openDetailsScreen() {
        ArrayList<String> labels = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        for (VibeField field : vibeFields) {
            labels.add(field.getLabel());
            values.add(field.getValue());
        }

        Intent intent = new Intent(this, VibeDetailsActivity.class);
        intent.putStringArrayListExtra("labels", labels);
        intent.putStringArrayListExtra("values", values);
        startActivity(intent);
    }
}
