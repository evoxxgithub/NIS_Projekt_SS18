package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class DesFeistelSolver extends TaskSolver {
    public DesFeistelSolver(Connection connection) {
        super(connection, TaskDefs.TASK_DES_FEISTEL);
    }

    @Override
    protected String calculateSolution() {
        return null;
    }
}
