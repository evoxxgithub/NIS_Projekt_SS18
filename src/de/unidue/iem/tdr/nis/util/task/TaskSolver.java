package de.unidue.iem.tdr.nis.util.task;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskObject;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskSolver {

    protected final Connection connection;
    protected final List<String> moreParams;
    private final int TASK_ID;
    protected TaskObject task;

    public TaskSolver(Connection connection, int TASK_ID) {
        this.connection = connection;
        this.TASK_ID = TASK_ID;
        this.moreParams = new ArrayList<>();
    }

    public boolean solve() {
        this.task = this.connection.getTask(this.TASK_ID);
        final String solution = this.calculateSolution();
        final boolean solved = this.connection.sendSolution(solution);
        return solved;
    }

    protected abstract String calculateSolution();

}
