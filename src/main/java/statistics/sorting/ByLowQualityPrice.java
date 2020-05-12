package statistics.sorting;

import statistics.State;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ByLowQualityPrice implements Sortable {

    public List<State> recordsSorted(List<State> listToSort) {
        return listToSort.stream()
                .sorted(Comparator.comparing(State::getLowQualityPrice))
                .collect(Collectors.toList());
    }

}
