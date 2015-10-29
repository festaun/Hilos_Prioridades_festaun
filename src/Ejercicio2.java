/**
 * Created by CurroEt on 29/10/2015.
 */
class elementos extends Thread {
    private char elemento;

    public elementos(char c) {
        this.elemento = c;
    }
    /*
    * Metodo run() de la clase derivada de Thread, donde se indica el funcionamiento del metodo de conteo de elementos.
    * Se añaden numeros secuencialmente incrementados  al valor del elemento inicial, y se imprime por pantalla.
    * */
    public void run() {
        char extra;
        for (int i = 0; i < 10; i++) {
            extra = (char) (elemento + i);
            System.out.println(extra);
        }
    }
}
/*Clase princpipal en la que se inician los hilos y se establecen prioridades
* Utilizo "MIN_PRIORITY" y "MAX_PRIORITY porque pense que te referias a eso con constantes
* Estos valores de prioridad varian entre 1 y 10 asi que podria utilizar 1 y 10 para este ejercicio*/
public class Ejercicio2 {
    public static void main(String[] args) {
        Thread t1 = new elementos('a');
        Thread t2 = new elementos('0');
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
