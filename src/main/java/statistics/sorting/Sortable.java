package statistics.sorting;

import statistics.State;

import java.util.List;

public interface Sortable {
    public List<State> recordsSorted(List<State> listToSort);
}
