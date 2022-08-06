import java.util.concurrent.Callable;

public class CallableClass implements Callable<Object>
{

    @Override
    public Object call() throws Exception {
        return "Printing from inside CallableClass";
    }
}
