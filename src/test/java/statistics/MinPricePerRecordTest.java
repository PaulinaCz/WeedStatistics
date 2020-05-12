package statistics;

import org.junit.jupiter.api.Test;
import statistics.minmaxPricePerRecord.MinPricePerRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MinPricePerRecordTest {

    @Test
    void shouldReturnBestPriceForOneRecordList() {
        //given
        List<State> states = List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)));
        MinPricePerRecord minPricePerRecord = new MinPricePerRecord(states);
        //when
        Map<State, BigDecimal> result = minPricePerRecord.minPriceForAllRecords();
        Map<State, BigDecimal> expected = new HashMap<>();
        expected.put(new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)),
                new BigDecimal(60));
        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnRecordsWithLowestPrice() {
        //given
        List<State> states = List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)),
                new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                        new BigDecimal(30), new BigDecimal(70), LocalDate.of(2014, 8, 1)),
                new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                        new BigDecimal(90), new BigDecimal(90), LocalDate.of(2014, 8, 1))
                );
        MinPricePerRecord minPricePerRecord = new MinPricePerRecord(states);
        //when
        Map<State, BigDecimal> result = minPricePerRecord.minPriceForAllRecords();
        Map<State, BigDecimal> expected = new HashMap<>();
        expected.put(new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                        new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)),
                new BigDecimal(60));
        expected.put(new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                        new BigDecimal(30), new BigDecimal(70), LocalDate.of(2014, 8, 1)),
                new BigDecimal(30));
        expected.put(new State("Alabama", new BigDecimal("100"), new BigDecimal(80),
                        new BigDecimal(90), new BigDecimal(90), LocalDate.of(2014, 8, 1)),
                new BigDecimal(80));

        //then
        assertEquals(expected, result);
    }

}