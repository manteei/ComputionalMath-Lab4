import Storage.Storage;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int chooseFunction() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("������������� ������� ���������� ���������");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("�������� ����� �����:");
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
                System.out.println("������! ����� ������ ���������� ������ �� 1 � �� 3");
            } catch (NumberFormatException e) {
                System.out.println("������! ����� ������ ���������� ������");
            }
        }
    }
    public int getApproximate() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("�������� ���������������� �������: \n 1)�������� y = kx + b \n 2)���������������� ������� y = be^(ax) \n 3)������������ y = ax^2 + bx + c");
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
                System.out.println("������! ����� ������ ���������� ������ �� 1 � �� 3");
            } catch (NumberFormatException e) {
                System.out.println("������! ����� ������ ���������� ������");
            }
        }
    }


}
