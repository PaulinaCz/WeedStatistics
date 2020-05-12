package statistics.bestPricesByYears;

import statistics.State;

import java.util.Map;
import java.util.Optional;

public interface BestPriceByYear {
    Map<Integer, Optional<State>> bestPricePerYear();
}
