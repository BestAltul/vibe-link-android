package asmarttechnology.com.vibelink;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.text.InputType;
import android.view.View;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailField extends VibeField{

    private String email;
    private EditText input;

    @Override
    public String getType() {
        return "email";
    }

    @Override
    public String getValue() {
        return email;
    }

    @Override
    public View renderView(Context context) {
        input = new EditText(context);
        input.setHint(getLabel());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setLayoutParams(new ViewGroup.LayoutParams(
              android.view.ViewGroup.LayoutParams.MATCH_PARENT,
              android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        ));
    return input;
    }
}
