package asmarttechnology.com.vibelink;

import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkField extends VibeField{

    private String url;
    private EditText input;

    @Override
    public String getType() {
        return "link";
    }

    @Override
    public String getValue() {
        return url;
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
