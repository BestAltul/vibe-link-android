package asmarttechnology.com.vibelink;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.text.InputType;
import android.view.View;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailField extends VibeField{

    private String email;
    private EditText input;
    private View renderView;

    public EmailField(){
        setLabel("email");
    }

    @Override
    public String getType() {
        return "email";
    }

    @Override
    public String getValue() {
        return input != null? input.getText().toString():"";
    }

    @Override
    public View renderView(Context context) {
        if(renderView==null){
        input = new EditText(context);
        input.setHint(getLabel());
        input.setBackground(null);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setLayoutParams(new ViewGroup.LayoutParams(
              android.view.ViewGroup.LayoutParams.MATCH_PARENT,
              android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        CardView card = new CardView(context);
        card.setCardElevation(8);
        card.setRadius(24);
        card.setUseCompatPadding(true);
        card.setContentPadding(16,16,16,16);
        card.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        card.addView(input);

        card.setOnClickListener(v->{
            Toast.makeText(context,"Holding for action", Toast.LENGTH_SHORT).show();
        });
            renderView=card;
        }

    return renderView;
    }
}
