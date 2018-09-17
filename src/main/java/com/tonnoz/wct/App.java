package com.tonnoz.wct;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.tonnoz.wct.main.Wct;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class App {

    @Parameter(names={"--input", "-i"}, description = "Input file name")
    private static String fileInput;

    @Parameter(names={"--output", "-o"}, description = "Output file name")
    private static String fileOutput;


    public static void main(String[] args) {
        final App app = new App();
        JCommander.newBuilder()
                .addObject(app)
                .build()
                .parse(args);
        try {
            new Wct(fileInput, fileOutput).run();
        } catch (IOException e) {
            log.error("an error occurred while processing: ", e);
        }
    }

}
