package statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StateMapper {

    Logger logger = Logger.getLogger(StateMapper.class.getName());

    public Optional<State> fromLine(String[] words) {

        try {
            return Optional.of(
                    State.builder()
                            .name(words[0].replaceAll("\"", ""))
                            .highQualityPrice(new BigDecimal(words[1]))
                            .mediumQualityPrice(new BigDecimal(words[3]))
                            .lowQualityPrice(new BigDecimal(words[5]))
                            .averagePrice((new BigDecimal(words[1]).add(new BigDecimal(words[3]))
                                    .add(new BigDecimal(words[5]))).divide(BigDecimal.valueOf(3), RoundingMode.DOWN))
                            .localDate(LocalDate.parse(words[7]))
                            .build()
            );
        } catch (NumberFormatException ex) {
            logger.log(Level.INFO, "State " + words[0] + " has incomplete data.");
        }

        return Optional.empty();

    }

}
