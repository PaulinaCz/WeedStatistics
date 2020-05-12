package statistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StateImporter {

    private static final StateMapper STATE_MAPPER = new StateMapper();
    private final String pathToFile;

    public StateImporter(String pathToFile){
        this.pathToFile = pathToFile;
    }

    public List<State> readStatesFromFile() {
        return fileAsLines()
                .map(line -> line.split(","))
                .map(STATE_MAPPER::fromLine)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Stream<String> fileAsLines() {
        try{
            return Files.lines(Paths.get(pathToFile));
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}
