package Homework10;

import java.util.Map;
import java.util.Random;

public class Main {

    // смысл был в том что бы вычислялась площадь прямоугольника,
    // но оно выбивает рандомную ошибку, почему это происходит я понимаю,
    // а как это исправить нет

    private static final Map<Integer, Throwable> EXCEPTION = Map.of(
            0, new Exception1("u catch exception1"),
            1, new Exception2("u catch exception2"),
            2, new Exception3("u catch exception3")
    );

    public static void main(String[] args) {
        Random random = new Random();
        int x = 10;
        int y = -10;
        int square;
        try{
            if(x >= 0 && y >= 0 && x != y){
                square = x*y;
            }
            someException(random.nextInt(3));
        } catch (Exception1 e) {
            if(x < 0 || y < 0){
                System.out.println("u catch exception1, x < 0 or y < 0");
            }
            e.printStackTrace();
        } catch (Exception2 e) {
            if ( x == y){
                System.out.println("u catch exception2, it`s not rectangle, it`s square ");
            }
            e.printStackTrace();
        } catch (Exception3 e) {
            if ( x == 0 || y == 0){
                System.out.println("u catch exception3, x = 0 or y = 0");
            }
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("some string");
        }
    }

    public static void someException(int randomValue) throws Throwable{
        Throwable throwable = EXCEPTION.getOrDefault(randomValue, new Exception("this is my exception"));
        throw throwable;
    }
}
