package statistics.bestPricesByYears;

import lombok.AllArgsConstructor;
import statistics.minmaxPricePerRecord.MinPricePerRecord;
import statistics.State;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BestPriceInStateByYear implements BestPriceByYear {

    private final List<State> states;
    private MinPricePerRecord minPricePerRecord;

    public Map<Integer, Optional<State>> bestPricePerYear() {
        return states.stream()
                .collect(Collectors.groupingBy((state -> state.getLocalDate().getYear()),
                        Collectors.minBy(Comparator.comparing(state -> minPricePerRecord.getMin(
                                List.of(state.getHighQualityPrice(),
                                        state.getMediumQualityPrice(),
                                        state.getLowQualityPrice()
                        ))
                        ))));
    }
}
