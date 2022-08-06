import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMain
{
    public static void main(String args[])
    {
        System.out.println("============== Lets learn about the ExecutorService ===============");

        /**
         * The executor service here is created using the newSingleThreadExecutor.
         * This creates a ThreadPool of just one thread.
         * An alternative would be to create a ThreadPoolExecutor (implements the ExecutorService Interface)
         * The advantage of using that alternative is that you can specify the number of threads in the thread pool
         * as well as the maximum extra threads in case there are too many tasks for the thread pool to handle without
         * obvious delay
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //creates pool of one thread

        /**
         * Using the submit function allows us to submit tasks to be completed in the future
         * We can use the Future interface to hold the results of that task once it is complete.
         * Java uses its internal Pool management pattern to allocate threads for executing the task
         * We can use future.isDone() to check the status of the task
         * We can use future.get() to get the results of the task
         * future.get() is very useful because it blocks execution of the main thread until the task is complete
         * so in the code below, the first future.isDone() will be false but the second one will be true.
         */
        Future<?> future = executorService.submit(new RunnableClass());
        System.out.println(future.isDone());

        try{
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
    }
}