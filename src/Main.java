import java.util.*;

public class Main {
    static int number; // выглядит так себе

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доброго времени суток. Чтобы начать игру введите четырёхзначное число.");
        // int goalNumber = (int) ((Math.random() * 8999) + 1001);
        int goalNumber = Random();





        boolean x = true;
        while (x == true) {
            String s = scanner.nextLine();
            if (Checker(s, goalNumber)) {
                if (number == goalNumber) {
                    System.out.println("Вы угадали!");
                    x = false;
                }

            }
            if (number==0001) System.out.println(goalNumber);
        }


    }

    private static int Random() {
        int randNumber = (int) ((Math.random() * 8999) + 1001);


        HashSet<Integer> hashSetNum = new HashSet<Integer>(1);

        while (hashSetNum.size() < 4) {
            hashSetNum.add((int) (Math.random() * 9) + 1);
        }

        int number = 0;
        Iterator<Integer> iterator = hashSetNum.iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < hashSetNum.size(); i++) {
                number = number * 10 + iterator.next();
            }
        }
        return number;
    }

    private static boolean Checker(String unidentifiedNumber, int goalNumber) {
        try {
            number = Integer.parseInt(unidentifiedNumber.trim());
        } catch (NumberFormatException e) {
            System.out.println("Illegal format number : " + e.getMessage());
            return false;
        }
        if (number < 1000 || number > 9999) {  // возможность ввода 0???
            System.out.println("Ваше число находится в недопустимом диапазоне");
            return false;
        }

        int inputNumbersArr[] = new int[4];
        for (int i = 0; i < inputNumbersArr.length; i++) {
            inputNumbersArr[i] = Integer.valueOf(number).toString().charAt(i) - '0'; // хуйня
        }

        ArrayList<Integer> arrayList = new ArrayList(2);
        boolean trigger = false;
        for (int i = 0; i < inputNumbersArr.length; i++) {
            for (int j = i + 1; j < inputNumbersArr.length; j++) {
                if (inputNumbersArr[i] == inputNumbersArr[j]) {
                    arrayList.add(inputNumbersArr[j]);
                    trigger = true;
                }
            }
        }
        arrayList.trimToSize();
        if (trigger) {
            LinkedHashSet<Integer> arrayHash = new LinkedHashSet<>(arrayList);
            System.out.println("Введённые чила не должны повторяться. Повторяющиеся числа: " + arrayHash);
            return false;
        } else NumberWorker(goalNumber, inputNumbersArr);


        return true;

    }

    protected static void NumberWorker(int goalNumber, int[] inputNumArr) {
        int goalNumbersArr[] = new int[4];

        for (int i = 0; i < goalNumbersArr.length; i++) {
            goalNumbersArr[i] = Integer.valueOf(goalNumber).toString().charAt(i) - '0'; // хуйня
        }

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < goalNumbersArr.length; i++) {
            if (goalNumbersArr[i] == inputNumArr[i]) bulls++;
            else {
                for (int j = 0; j < goalNumbersArr.length; j++) {
                    if (inputNumArr[j] == goalNumbersArr[i]) cows++;
                }
            }
        }


        System.out.println("Bulls: " + bulls + " Cows: " + cows);
    }

}
