package statistics.bestPrices;

import lombok.AllArgsConstructor;
import statistics.State;


import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BestAveragePrice implements BestPrice {

    private final List<State> states;

    @Override
    public List<State> bestPriceForNRecords(int number) {
        return states.stream().sorted(Comparator.comparing(State::getAveragePrice))
                .limit(number).collect(Collectors.toList());
    }

    public State bestPricePerState(String stateName) {

        return states.stream().filter(state -> state.getName().equals(stateName))
                .min(Comparator.comparing(State::getAveragePrice)).orElse(new State());

    }

    public List<State> bestPriceForEachState() {

        List<State> result = new ArrayList<>();

        for (State name : states) {
            result.add(bestPricePerState(name.getName()));
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

}
