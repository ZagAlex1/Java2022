package Course2.Homeworks.HomeWork5;

import java.util.Arrays;

public class ArrayThread {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];
    float[] a1 = new float[h];
    float[] a2 = new float[h];

    public float[] put1InArray() {
        Arrays.fill(arr, 1);
        return arr;
    }

    public void calc(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public void calcArr1() {
        float[] arr = put1InArray();
        long a = System.currentTimeMillis();
        calc(arr);
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }

    public void calcArr2() {
        float[] arr = put1InArray();
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calc(a1);
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calc(a2);
            }
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.currentTimeMillis();
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

}

