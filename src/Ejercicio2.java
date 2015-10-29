/**
 * Created by CurroEt on 29/10/2015.
 */
class elementos extends Thread {
    private char elemento;

    public elementos(char c) {
        this.elemento = c;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println((char) (elemento + i));
        }
    }

}
public class Ejercicio2 {
    public static void main(String[] args) {
        Thread t1 = new elementos('a');
        Thread t2 = new elementos('0');
        t2.setPriority(10);
        t1.setPriority(1);
        t1.start();
        t2.start();
    }
}
