package controller;

import java.util.Arrays;

public class Validation {
    public void isCarNameLengthUnderFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void isCarNameSame(String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNames.length) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
        }
    }

    public void validationCarName(String[] carNames) {
        Arrays.stream(carNames).forEach(this::isCarNameLengthUnderFive);
        isCarNameSame(carNames);
    }
}