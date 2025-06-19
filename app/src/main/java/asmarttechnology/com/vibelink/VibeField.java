package asmarttechnology.com.vibelink;

import android.content.Context;
import android.view.View;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class VibeField {
    private UUID id;
    private String label;

    private Vibe vibe;

    private  Long accountVibeId;

    public final String getLabel(){
        return this.label;
    }

    public abstract String getType();
    public abstract String getValue();

    public abstract View renderView(Context context);
}
