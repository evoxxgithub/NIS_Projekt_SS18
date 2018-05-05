package de.unidue.iem.tdr.nis.util.task;

import de.unidue.iem.tdr.nis.client.Connection;

public class ProjectSolver {

    private static final int NUM_OF_TASKS = 22;
    private final TaskSolver[] solvers;
    private final Connection con;



    public ProjectSolver(TaskSolver[] solvers, Connection con) {
        this.solvers = solvers;
        this.con = con;
    }

    public boolean solveProject() {
        boolean correct = true;
        for (int taskNumber = 1; taskNumber <= NUM_OF_TASKS; taskNumber++) {
            if (!this.getSolverOf(taskNumber).solve()) correct = false;
        }
    return correct;
    }

    TaskSolver getSolverOf(int taskType) {
        if (this.con == null) {
            return new DummySolver();
        } else {
            return this.solvers[taskType];
        }
    }

    public void closeConnection() {
        this.con.close();
    }
}
