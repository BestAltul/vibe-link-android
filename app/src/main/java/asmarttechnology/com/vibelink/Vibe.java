package asmarttechnology.com.vibelink;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vibe {
    private UUID id;

    private UUID vibeAccountId;

    private String title;

    private List<VibeField> fields = new ArrayList<>();
}
