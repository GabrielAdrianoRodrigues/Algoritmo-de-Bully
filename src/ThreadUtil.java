import java.util.Random;
import java.util.stream.Collectors;

public abstract class ThreadUtil {
    private final static Bully bully = new Bully();
    private static volatile Boolean inElection;

    public static Runnable twentyFiveSeconds = () -> {
        while (true) {
            if (!inElection) {
                Process randomProcess = randomProcess();
                if (randomProcess != null) {
                    if (randomProcess.getIsCoordinator()) {

                    } else if (randomProcess.getCurrentCoordinator() != null
                            && randomProcess.getCurrentCoordinator().getIsActive()) {

                    } else {
                        election(randomProcess);
                    }
                }
            }
        }
    };

    public static Runnable thirdSeconds = () -> {
        while (true) {
            Process newProcess = new Process(1);
            if(bully.coordinator != null) {
                newProcess.setCurrentCoordinator(bully.coordinator);
            }
            bully.processList.add(newProcess);
            bully.processList.stream().map(x -> x.getId().toString()).collect(Collectors.joining(","));
        }
    };

    public static Runnable eightySeconds = () -> {
        while (true) {
            Process randomProcess = randomProcess();
            if (randomProcess != null) {
                randomProcess.setIsActive(false);
            }
        }
    };

    public static Runnable oneHundredSeconds = () -> {
        bully.coordinator.setIsActive(false);
    };

    private static void election(Process currentProcess) {
        inElection = true;
        Process possibleCoordinator = bully.processList.stream().filter(x -> x.getIsActive() && x.getId() > currentProcess.getId()).findFirst().orElse(currentProcess);
        if (possibleCoordinator.getId() != currentProcess.getId()) {
            election(possibleCoordinator);
        } else {
            bully.processList.forEach(x -> x.setCurrentCoordinator(possibleCoordinator));
            if (bully.coordinator != null) {
                bully.coordinator.setIsCoordinator(false);
            }
            bully.coordinator = possibleCoordinator;
            bully.coordinator.setIsCoordinator(true);
            inElection = false;
        }
    }

    public static Process randomProcess() {
        while (true) {
            if (bully.processList.size() > 0) {
                Process p = bully.processList.get(new Random().nextInt(bully.processList.size()));
                return p.getIsActive() ? p : null;
            }
        }
    }
}
