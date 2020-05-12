package statistics;

import statistics.bestPriceByDates.BestPriceByDate;
import statistics.bestPriceByDates.BestPriceInStateByDate;
import statistics.bestPricesByYears.BestPriceByYear;
import statistics.bestPricesByYears.BestPriceInStateByYear;
import statistics.bestPrices.BestAveragePrice;
import statistics.bestPrices.BestHighQualityPrice;
import statistics.bestPrices.BestMediumQualityPrice;
import statistics.bestPrices.BestPrice;
import statistics.minmaxPricePerRecord.MinPricePerRecord;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        StateImporter stateImporter = new StateImporter("src/main/resources/marijuana-street-price.csv");
        List<State> states = stateImporter.readStatesFromFile();


        System.out.println("1. State with best average price");
        BestPrice bestAveragePrice = new BestAveragePrice(states);
        List<State> result = bestAveragePrice.bestPriceForNRecords(1);
        System.out.println("State " + result.get(0).getName() + " of price " + result.get(0).getAveragePrice() + "$");


        System.out.println("============================================");

        System.out.println("5 lowest prices of high quality weed");
        BestPrice bestHighQualityPrice = new BestHighQualityPrice(states);
        List<State> statesWithBestHQP = bestHighQualityPrice.bestPriceForNRecords(5);
        for (State s : statesWithBestHQP) {
            System.out.println(s.getHighQualityPrice() + "$ in state " + s.getName());
        }

        System.out.println("============================================");

        System.out.println("Best price of medium quality weed for each state ");
        BestPrice pricePerState = new BestMediumQualityPrice(states);
        System.out.println(pricePerState.bestPriceForEachState());

        System.out.println("============================================");

        System.out.println("Best price of weed by year ");
        BestPriceByYear stateByYear = new BestPriceInStateByYear(states, new MinPricePerRecord(states));
        System.out.println(stateByYear.bestPricePerYear());

        System.out.println("============================================");

        System.out.println("Best price of weed by days");
        BestPriceByDate priceByDate = new BestPriceInStateByDate(states, new MinPricePerRecord(states));
        System.out.println(priceByDate.bestPricePerDate());


    }
}
