package asmarttechnology.com.vibelink;

import android.content.Context;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneField extends VibeField{

    private String phone;
    private EditText input;

    public PhoneField(){
        setLabel("phone");
    }

    @Override
    public String getType() {
        return "phone";
    }

    @Override
    public String getValue() {
        return input != null? input.getText().toString():"";
    }

    @Override
    public View renderView(Context context) {
        input = new EditText(context);

        input.setHint(getLabel());
        input.setInputType(InputType.TYPE_CLASS_PHONE);
        input.setBackground(null);
        input.setLayoutParams(new ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        return input;
    }
}
