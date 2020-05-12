package statistics.bestPriceByDates;

import lombok.AllArgsConstructor;
import statistics.State;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BestAveragePriceByDate implements BestPriceByDate {

    private final List<State> states;

    @Override
    public Map<LocalDate, Optional<State>> bestPricePerDate() {
        return states.stream()
                .collect(Collectors.groupingBy(State::getLocalDate,
                        Collectors.minBy(Comparator.comparing(State::getAveragePrice))));
    }
}
