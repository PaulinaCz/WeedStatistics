package statistics.sorting;

import statistics.State;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ByYearSorting implements Sortable {

    @Override
    public List<State> recordsSorted(List<State> listToSort) {
        return listToSort.stream()
                .sorted(Comparator.comparing(State::getLocalDate)
                        .reversed())
                .collect(Collectors.toList());
    }
}
