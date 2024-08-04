package dypham.callProcedureOracle.CallProcedureOracle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEntity {
    private LocalDateTime created_at;

    private String created_by;

    private LocalDateTime updated_at;

    private String updated_by;
}
