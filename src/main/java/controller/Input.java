package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] CarNameInput() throws IOException {
        String carNames = br.readLine();
        return carNames.split(",");
    }
}