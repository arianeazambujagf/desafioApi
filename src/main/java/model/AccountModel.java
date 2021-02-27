package model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter

public class AccountModel {
    private int id;
    private String nome;
    private Boolean visivel;
    private int usuario_id;
}
