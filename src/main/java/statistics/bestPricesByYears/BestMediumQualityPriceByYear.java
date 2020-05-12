package statistics.bestPricesByYears;

import lombok.AllArgsConstructor;
import statistics.State;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BestMediumQualityPriceByYear implements BestPriceByYear {

    private final List<State> states;

    @Override
    public Map<Integer, Optional<State>> bestPricePerYear() {
        return states.stream()
                .collect(Collectors.groupingBy((state -> state.getLocalDate().getYear()),
                        Collectors.minBy(Comparator.comparing(State::getMediumQualityPrice))));
    }
}
