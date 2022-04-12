import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
Есть 3 производителя и 2 потребителя, все разные потоки и работают все
одновременно. Есть очередь с  200 элементами. Производители добавляют
случайное число от 1..100, а потребители берут эти числа. Если в очереди
элементов >= 100 производители спят, если нет элементов в очереди – потребители
спят. Если элементов стало <= 80, производители просыпаются. Все это работает до
тех пор, пока  обработанных элементов не станет 10000, только потом программа
завершается.
 */

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start, then will be finish, then your threads ");
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        Thread producer1 = new Thread(producer);
        Thread producer2 = new Thread(producer);
        Thread producer3 = new Thread(producer);
        Thread consumer1 = new Thread(consumer);
        Thread consumer2 = new Thread(consumer);

        producer1.setName("Производитель 1");
        producer2.setName("Производитель 2");
        producer3.setName("Производитель 3");
        consumer1.setName("Потребитель 1");
        consumer2.setName("Потребитель 2");

        producer1.start();
        producer2.start();
        producer3.start();
//        consumer1.start();
//        consumer2.start();

//        Thread.sleep(5000);

//        producer1.join();
//        producer2.join();
//        producer3.join();
//
//        consumer1.join();
//        consumer2.join();

        System.out.println("Finish!");

    }
}


class Store {

    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 200;

    public synchronized void produce() throws InterruptedException { // производство
        Random random = new Random();
        while (queue.size() <= LIMIT) {
            while (queue.size() >= 100) {
//                wait();
            }

            queue.offer(random.nextInt(100));
            System.out.println(Thread.currentThread().getName() + " добавил " + random.nextInt(100) + "  --> Размер очереди = " + queue.size());
//            notify();
        }

    }


    public synchronized void consume() throws InterruptedException { // потребление
        while (true) {
            while (queue.size() < 1) {
                wait();
            }
            while (queue.size() > 80) {
                int value = queue.poll();
                System.out.println(Thread.currentThread().getName() + " взял : " + value + "  --> Размер очереди " + queue.size());
            }
            notify();
        }
    }
}


class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            try {
                store.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            try {
                store.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
