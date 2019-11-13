package com.pcz.ch3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author picongzhi
 */
public class ExecuteAround {
    public static void main(String[] args) throws IOException {
        System.out.println(processFileLimited());
        System.out.println(processFile((BufferedReader bufferedReader) -> bufferedReader.readLine()));
        System.out.println(processFile((BufferedReader bufferedReader) -> bufferedReader.readLine() + bufferedReader.readLine()));
    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/picongzhi/workspace/java/idea/java8-in-action/src/main/resources/com.pcz.ch3/data.txt"))) {
            return bufferedReader.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/picongzhi/workspace/java/idea/java8-in-action/src/main/resources/com.pcz.ch3/data.txt"))) {
            return bufferedReaderProcessor.process(bufferedReader);
        }
    }

    public interface BufferedReaderProcessor {
        public String process(BufferedReader bufferedReader) throws IOException;
    }
}
