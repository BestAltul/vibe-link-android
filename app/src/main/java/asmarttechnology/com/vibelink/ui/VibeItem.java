package asmarttechnology.com.vibelink.ui;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VibeItem {
    private String title;
    private String description;
    private int iconResId;

    public VibeItem(String title, String description, int iconResId){
        this.title = title;
        this.description = description;
        this.iconResId = iconResId;
    }
}
