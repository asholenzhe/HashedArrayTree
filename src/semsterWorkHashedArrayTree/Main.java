package semsterWorkHashedArrayTree;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000); // заполняем массив случайными числами от 0 до 999
        }
        long startTime = System.nanoTime();
        int operations = 0;
        HashedArrayList hashedArrayList = new HashedArrayList();
        for (int num : array) {
            hashedArrayList.add(num);
            operations++;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // время работы в миллисекундах

        System.out.println("Время работы добавления: " + duration + " мс");
        System.out.println("Количество операций добавления: " + operations);
        int[] randomElements = new int[100];
        for (int i = 0; i < 100; i++) {
            randomElements[i] = array[random.nextInt(array.length)];
        }

        long searchTime = 0;
        int searchOperations = 0;
        for (int num : randomElements) {
            long searchStart = System.nanoTime();
            hashedArrayList.search(num);
            long searchEnd = System.nanoTime();

            searchTime += (searchEnd - searchStart);
            searchOperations++;
        }

        System.out.println("Среднее время поиска: " + (searchTime / searchOperations) + " нс");
        System.out.println("Среднее количество операций поиска: " + searchOperations);
        Random randomIndexes = new Random();
        int[] randomIndexesToRemove = new int[1000];
        for (int i = 0; i < 1000; i++) {
            randomIndexesToRemove[i] = randomIndexes.nextInt(array.length);
        }

        long removeTime = 0;
        int removeOperations = 0;
        for (int index : randomIndexesToRemove) {
            long removeStart = System.nanoTime();
            hashedArrayList.remove(array[index]);
            long removeEnd = System.nanoTime();

            removeTime += (removeEnd - removeStart);
            removeOperations++;
        }

        System.out.println("Среднее время удаления: " + (removeTime / removeOperations) + " нс");
        System.out.println("Среднее количество операций удаления: " + removeOperations);
    }
}
