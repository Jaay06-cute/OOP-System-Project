
package Model;

import java.util.ArrayList;
import java.util.List;


public class ActionLogData {
    
    
    private static final List<ActionLog> logs = new ArrayList<>();

    public static List<ActionLog> getActionLogs() {
        return logs;
    }

    public static void addLog(ActionLog log) {
        logs.add(log);
    }
}
