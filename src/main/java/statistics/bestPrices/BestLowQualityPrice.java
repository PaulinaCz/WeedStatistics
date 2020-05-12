package statistics.bestPrices;

import lombok.AllArgsConstructor;
import statistics.State;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BestLowQualityPrice implements BestPrice {

    private final List<State> states;

    @Override
    public List<State> bestPriceForNRecords(int number) {
        return states.stream().sorted(Comparator.comparing(State::getLowQualityPrice))
                .limit(number).collect(Collectors.toList());
    }

    public State bestPricePerState(String stateName) {

        return states.stream().filter(state -> state.getName().equals(stateName))
                .min(Comparator.comparing(State::getLowQualityPrice)).orElse(new State());

    }

    public List<State> bestPriceForEachState() {

        List<State> result = new ArrayList<>();

        for (State name : states) {
            result.add(bestPricePerState(name.getName()));
        }
        return result.stream().distinct().collect(Collectors.toList());
    }
}
