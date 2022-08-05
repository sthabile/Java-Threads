public class main
{
    public static void main(String args[]){
        System.out.println("Lets learn about java threads");

        CustomThread customThread = new CustomThread();

        Thread unknownThread = new Thread(){
            public void run(){
                System.out.println("Printing from inside the unknown thread");
            }
        };

        Thread myRunnableClassThread = new Thread(new RunnableClass());

        Runnable unknownRunnableThread = new Runnable() {
            @Override
            public void run() {

                //Thread.sleep() basically tells the thread to pause before
                //executing the next lines of code.
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Printing from inside the unknown Runnable class");
            }
        };

        unknownThread.start();
        customThread.start();

        myRunnableClassThread.start();
        unknownRunnableThread.run();
    }
}
