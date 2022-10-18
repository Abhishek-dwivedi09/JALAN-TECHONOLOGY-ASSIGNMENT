package problemTwo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Coffee {
    private String coffeeName;
    private List<String> addOnes;
}
