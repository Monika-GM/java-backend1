package parallel;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public void withStream() {
        IntStream
                .of(2,4,6,8)
                .sequential()
                .filter( el -> el > 10 )

                .forEach( el -> System.out.println(el));

        Stream.of("abc", "pqr", "lmn");
    }

    public void withoutStream() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(4);
        nums.add(6);
        nums.add(8);


        for (int num : nums ) {
            System.out.println(num * num);
        }
    }
    public void futures() {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<String> task1 = service.submit(() -> {
            // uploading images to server
            Thread.sleep(2500);
            return "Hello World From Task 1";
        });

        Future<String> task2 = service.submit(() -> {
            // extracting data from spreadsheet
            Thread.sleep(5500);
            return "Hello World From Task 2";
        });

        try {
            if(!task1.isCancelled()) {
                System.out.println( " Task1 Completed : "+ task1.get() );
            }
            if(!task2.isCancelled()) {
                System.out.println( " Task2 Completed : "+ task2.get() );
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.withoutStream();
        main.futures();
    }


}
