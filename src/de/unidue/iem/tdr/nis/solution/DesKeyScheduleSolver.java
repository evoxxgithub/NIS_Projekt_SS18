package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.encryption.DES;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class DesKeyScheduleSolver extends TaskSolver {
    public DesKeyScheduleSolver(Connection connection) {
        super(connection, TaskDefs.TASK_DES_KEYSCHEDULE);
    }

    @Override
    protected String calculateSolution() {
        final String key = this.task.getStringArray(0);
        final int roundNumber = this.task.getIntArray(0);
        System.out.println("key: " + key);
        System.out.println("r_n: " + roundNumber);
        final DES des = new DES(key);
        return des.getKeyOfRound(roundNumber);
    }
}
