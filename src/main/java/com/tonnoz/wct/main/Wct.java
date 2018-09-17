package com.tonnoz.wct.main;

import com.google.gson.GsonBuilder;
import com.tonnoz.wct.main.domain.LogLine;
import com.tonnoz.wct.main.domain.Output;
import com.tonnoz.wct.main.utils.StringUtils;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.write;

@AllArgsConstructor
public class Wct {

    private final String fileInput;
    private final String fileOutput;

    public void run() throws IOException {
        final Output output = parseOutput();
        writeOutputToFile(output);
    }

    private void writeOutputToFile(Output output) throws IOException {
        final Path file = Paths.get(fileOutput);
        final String s = new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(output);
        write(file, s.getBytes());
    }

    private Output parseOutput() throws IOException {
        try (final Stream<String> stream = Files.lines(Paths.get(fileInput))) {
            return new Output(
                    stream.filter(line -> line.matches(StringUtils.URL_REGEX))
                            .map(LogLine::new)
                            .collect(Collectors.toList())
            );
        }
    }

}
