package statistics.averagePrices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import statistics.State;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.List;


@AllArgsConstructor
@Getter
@ToString
public class LowQualityAveragePrice implements AveragePrices {

    private final List<State> states;

    public BigDecimal averagePricePerState(String stateName) {

        BigDecimal sumPerState = states.stream()
                .filter(state -> state.getName().equals(stateName))
                .map(State::getLowQualityPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        long count = states.stream()
                .filter(state -> state.getName().equals(stateName))
                .map(State::getLowQualityPrice)
                .count();


        return sumPerState.divide(BigDecimal.valueOf(count), RoundingMode.DOWN);

    }

}



