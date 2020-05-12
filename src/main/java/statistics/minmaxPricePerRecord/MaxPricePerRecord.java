package statistics.minmaxPricePerRecord;

import lombok.AllArgsConstructor;
import statistics.State;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class MaxPricePerRecord {

    List<State> states;

    public Map<State, BigDecimal> maxPriceForAllRecords(List<State> states) {
        Map<State, BigDecimal> result = new HashMap<>();
        for(State state : states){
            result.put(state, getMax(List.of(state.getHighQualityPrice(),
                    state.getMediumQualityPrice(), state.getLowQualityPrice())));
        }

        return result;
    }

    private BigDecimal getMax(List<BigDecimal> values) {
        BigDecimal max = BigDecimal.valueOf(Integer.MIN_VALUE);
        for (BigDecimal value : values) {
            if (value.compareTo(max) >= 1) {
                max = value;
            }
        }
        return max;
    }

}
