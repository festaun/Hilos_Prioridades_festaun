
//clase CounterThread que extiende de Thread, sera la clase donde describiremos el codigo a utilizar
class CounterThread extends Thread {
    //Usamos esta variable para diferenciar los dos hilos a la hora de ejecutar el programa
    String name;

    public CounterThread(String name) {
        super();
        this.name = name;
    }
    //Metodo que incrementa el valor de un contador hasta un limite de 1000, mostrando cada numero por pantalla
    public void run() {
        int count = 0;
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 100) count = 0;
            System.out.println(name +":"+count++);
        }
    }
}
/*
* Nuestra clase main en la que declaramos ambos hilos y les establecemos una prioridad determinada.
* En este caco asignamos al t1 l a prioridad mas alta (10) y al t2 la mas baja (1).
* En teoría puesto que hemos asignado asi las prioridades, el thread 1 se deberia ejecutar primero, y sera el primero
* en resetea el contador una vez el llegue a su limite
* En la practica observamos que la diferencia de cuando terminan es inapreciable (en tiempo), y se muestran los
* los resultados de ambos hilos intercalados por consola.
* */
public class Prioridad {
    public static void main(String[] args) {
        CounterThread thread1 = new CounterThread("thread1");
        thread1.setPriority(1);
        CounterThread thread2 = new CounterThread("thread2");
        thread2.setPriority(10);
        thread2.start();
        thread1.start();
    }
}
/*
* Si se intercambia la prioridad de ambos hilos no se puede apreciar diferencia, ya que la ejecucion de ambos hilos
* sigue realizandose intercaladamente.
* El hecho de que sea irrelevante se debe principalmente a que esta muy relacionado con el procesador desde el que se
* ejecute.
* SI lo ejecutaramos desde un ordenador muy antiguo y lento, igual podriamos notar alguna diferencia significativa,
* pero con los resultados actuales, la impresion siempre se ejecuta de manera similar (intercalada)
* */