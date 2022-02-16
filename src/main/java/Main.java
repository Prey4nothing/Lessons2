public class Main {
    static final int size = 10000000;
    static final int h = size / 2;



    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
        }
    }



    public static void main(String[] args) {
        arr();
        arr1();
    }


    public static void arr (){
        float[] arr = new float[size];
        for(int i = 0; i< size;i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);

    }

    public static void arr1(){
        float[] arr = new float[size];
        float [] arr1 = new float[h];
        float [] arr2 = new float[h];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0 , arr1, 0, h);
        System.arraycopy(arr, h, arr2,0, h);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        System.arraycopy(arr, 0 ,arr1, 0 ,h);
        System.arraycopy(arr,h,arr2,0,h);
        System.out.println(System.currentTimeMillis() - a);

    }

}

