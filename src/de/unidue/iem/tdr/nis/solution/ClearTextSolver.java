package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class ClearTextSolver extends TaskSolver {

    public ClearTextSolver(Connection connection) {
        super(connection, TaskDefs.TASK_CLEARTEXT);
    }

    @Override
    protected String calculateSolution() {
        return this.task.getStringArray(0).toLowerCase();
    }
}
