package statistics.minmaxPricePerRecord;

import lombok.AllArgsConstructor;
import statistics.State;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
public class MinPricePerRecord {
    private List<State> states;

    public Map<State, BigDecimal> minPriceForAllRecords() {
        Map<State, BigDecimal> result = new HashMap<>();
        for(State state : states){
            result.put(state, getMin(List.of(state.getHighQualityPrice(),
                    state.getMediumQualityPrice(), state.getLowQualityPrice())));
        }

        return result;
    }


    public BigDecimal getMin(List<BigDecimal> values) {
        BigDecimal min = BigDecimal.valueOf(Integer.MAX_VALUE);
        for (BigDecimal value : values) {
            if (value.compareTo(min) < 1) {
                min = value;
            }
        }
        return min;
    }


}
