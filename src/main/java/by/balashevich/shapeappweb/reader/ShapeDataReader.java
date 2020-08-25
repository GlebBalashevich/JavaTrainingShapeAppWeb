package by.balashevich.shapeappweb.reader;

import by.balashevich.shapeappweb.exception.ShapeProjectException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShapeDataReader {
    private static final String DEFAULT_PATH = "datares/shapedata.txt"; // FIXME: 25.08.2020 remake on runtime excep, delete thats path

    public List<String> readFileData(String filename) throws ShapeProjectException {
        Path path;
        List<String> dataLines;

        if (filename != null && Files.exists(Paths.get(filename))) {
            path = Paths.get(filename);
        } else{
            path = Paths.get(DEFAULT_PATH);
        }

        try (Stream<String> lineStream = Files.lines(path)) {
            dataLines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ShapeProjectException("Exception while opening file", e);
        }

        return dataLines;
    }
}
