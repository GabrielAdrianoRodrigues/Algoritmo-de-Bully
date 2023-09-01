import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Bully {
    Process coordinator;
    List<Process> processList = new ArrayList<Process>();
    
    public static void main(String[] args) {
        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
        executor.schedule(ThreadUtil.twentyFiveSeconds, 25, TimeUnit.SECONDS);
        executor.schedule(ThreadUtil.thirdSeconds, 30, TimeUnit.SECONDS);
        executor.schedule(ThreadUtil.eightySeconds, 80, TimeUnit.SECONDS);
        executor.schedule(ThreadUtil.oneHundredSeconds, 100, TimeUnit.SECONDS);
    }
}
