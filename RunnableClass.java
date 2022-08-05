public class RunnableClass implements Runnable
{
    private void myMethod(){
        System.out.println("Printing from inside run of RunnableClass");
    }

    @Override
    public void run() {
        myMethod();
    }
}
