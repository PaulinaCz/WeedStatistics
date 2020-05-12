package statistics.bestPriceByDates;

import statistics.State;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public interface BestPriceByDate {
    Map<LocalDate, Optional<State>> bestPricePerDate();
}
