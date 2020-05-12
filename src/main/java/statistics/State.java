package statistics;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class State implements Comparable<State> {

    private String name;
    private BigDecimal highQualityPrice;
    private BigDecimal mediumQualityPrice;
    private BigDecimal lowQualityPrice;
    private BigDecimal averagePrice;
    private LocalDate localDate;


    @Override
    public int compareTo(State state) {
        return this.name.compareTo(state.getName());
    }



}
