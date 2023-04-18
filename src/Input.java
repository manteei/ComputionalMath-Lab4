import Storage.Storage;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int chooseFunction() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Аппроксимация методом наименьших квадратов");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Выберите набор точек:");
        Storage.printSet();
        System.out.println("------------------------------------------------------------------------------");
        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                int num = Integer.parseInt(s);
                if (num < 4 && num > 0) {
                    return num;
                }
                System.out.println("Ошибка! Номер должен задаваться числом от 1 и до 3");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Номер должен задаваться числом");
            }
        }
    }
    public int getApproximate() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Выберите аппроксимирующую функцию: \n 1)Линейная y = kx + b \n 2)Экспоненциальная функция y = be^(ax) \n 3)Квадратичная y = ax^2 + bx + c");
        System.out.println("------------------------------------------------------------------------------");
        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                int num = Integer.parseInt(s);
                if (num < 4 && num > 0) {
                    System.out.println("------------------------------------------------------------------------------");
                    return num;
                }
                System.out.println("Ошибка! Номер должен задаваться числом от 1 и до 3");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Номер должен задаваться числом");
            }
        }
    }


}
