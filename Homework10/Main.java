package Homework10;

import java.util.Map;
import java.util.Random;

public class Main {

    private static final Map<Integer, Throwable> EXCEPTION = Map.of(
            0, new Exception1("u catch exception1"),
            1, new Exception2("u catch exception2"),
            2, new Exception3("u catch exception3")
    );

    public static void main(String[] args) {
        Random random = new Random();
        try{
            someException(random.nextInt(3));
        } catch (Exception1 e) {
            System.out.println("u catch exception1");
            e.printStackTrace();
        } catch (Exception2 e) {
            System.out.println("u catch exception2 ");
            e.printStackTrace();
        } catch (Exception3 e) {
            System.out.println("u catch exception3");
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("я не смогла придумать случаи в которых исключения должны срабатывать");
        }
    }


    public static void someException(int randomValue) throws Throwable{
        Throwable throwable = EXCEPTION.getOrDefault(randomValue, new Exception("this is my exception"));
        throw throwable;
    }
}
