package controller;

import java.io.IOException;
import java.util.List;

import model.Car;
import view.Print;

public class Run {

    private Validation validation = new Validation();
    private Service service = new Service();

    private List<Car> carNamesInput() {
        List<Car> cars = null;
        while (true) {
            try {
                Print.printCarNameInputComment();
                List<String> carsNames = Input.carNameInput();
                validation.validationCarName(carsNames);
                cars = carsNames.stream().map(carName -> new Car(carName)).toList();
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return cars;
    }

    private Integer tryCountInput() {
        while (true) {
            try {
                Print.printTryCountInputComment();
                String tryCount = Input.tryCountInput();
                validation.validationTryCount(tryCount);
                return Integer.parseInt(tryCount);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        List<Car> cars = carNamesInput();
        Integer tryCount = tryCountInput();
        System.out.println();

        for (int i = 0; i < tryCount; i++) {
            service.moveCars(cars, service.generatePercent(cars.size()));
            Print.printTotalCarMovement(cars);
            System.out.println();
        }

        Print.printExecutionResult();
        Print.printWinner(service.getWinner(cars));
    }
}
