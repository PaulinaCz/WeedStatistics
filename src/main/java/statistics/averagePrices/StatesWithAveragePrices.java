package statistics.averagePrices;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import statistics.State;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class StatesWithAveragePrices implements Comparator<State> {

    private List<State> states;

       public Map<String, BigDecimal> averagePriceForEachState() {
        Map<String, BigDecimal> sumOfAveragePricePerState = new HashMap<>();

        states
                .forEach(state -> sumOfAveragePricePerState.put(state.getName(), averagePriceForState(state.getName())));
        

        return sumOfAveragePricePerState;
    }


    public BigDecimal averagePriceForState(String stateName){

        BigDecimal sumPerState = states.stream()
                .filter(state -> state.getName().equals(stateName))
                .map(State::getAveragePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        long count = states.stream()
                .filter(state -> state.getName().equals(stateName))
                .count();


        return sumPerState.divide(BigDecimal.valueOf(count), RoundingMode.DOWN);
    }

    @Override
    public int compare(State state, State otherState) {
        return averagePriceForEachState().get(state.getName())
                .compareTo(averagePriceForEachState().get(otherState.getName()));
    }

}
