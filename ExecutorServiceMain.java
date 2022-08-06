import java.util.concurrent.*;

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
        ExecutorService executorService = Executors.newFixedThreadPool(1); //creates pool of one thread

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


        /***
         * The submit method can also take in a callable instead of a runnable object.
         * A callable implements the Callable interface which is very similar to the Runnable interface
         * The Callable interface has a call function which returns an object.
         * This allows us to obtain the results of task through future.get()
         */
        CallableClass myCallableTask = new CallableClass();
        Future<?> future_callable = executorService.submit(myCallableTask);

        System.out.println(future_callable.isDone());

        try {
            Object results = future_callable.get();
            System.out.println(results);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(future_callable.isDone());
    }
}
