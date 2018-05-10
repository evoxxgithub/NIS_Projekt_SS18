package de.unidue.iem.tdr.nis.util.task;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskObject;

public abstract class TaskSolver {

    protected final Connection connection;
    private final int TASK_ID;
    protected TaskObject task;

    public TaskSolver(Connection connection, int TASK_ID) {
        this.connection = connection;
        this.TASK_ID = TASK_ID;
    }

    public boolean solve() {
        this.task = this.connection.getTask(this.TASK_ID);
        final String solution = this.calculateSolution();
        return this.connection.sendSolution(solution);
    }

    protected abstract String calculateSolution();

}
