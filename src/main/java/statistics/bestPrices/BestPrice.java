package statistics.bestPrices;

import statistics.State;

import java.util.List;

public interface BestPrice {
    List<State> bestPriceForNRecords(int number);
    State bestPricePerState(String stateName);
    List<State> bestPriceForEachState();

}
