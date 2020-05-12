package statistics.averagePrices;

import java.math.BigDecimal;

public interface AveragePrices {
    BigDecimal averagePricePerState(String stateName);
}
