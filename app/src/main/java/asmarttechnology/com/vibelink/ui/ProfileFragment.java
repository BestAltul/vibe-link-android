package asmarttechnology.com.vibelink.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import asmarttechnology.com.vibelink.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private EditText nameInput, emailInput, phoneInput;
    private Button saveButton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View root = inflater.inflate(R.layout.fragment_profile,container,false);

        nameInput = root.findViewById(R.id.nameInput);
        nameInput = root.findViewById(R.id.nameInput);
        emailInput = root.findViewById(R.id.emailInput);
        phoneInput = root.findViewById(R.id.phoneInput);
        saveButton = root.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v->{
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String phone = phoneInput.getText().toString();

            Toast.makeText(getContext(), "Saved: " + name + ", " + email + ", " + phone, Toast.LENGTH_SHORT).show();

        });

        return root;
    }
}