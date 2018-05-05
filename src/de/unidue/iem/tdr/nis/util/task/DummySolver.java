package de.unidue.iem.tdr.nis.util.task;

import de.unidue.iem.tdr.nis.client.Connection;

public class DummySolver extends TaskSolver {

    public DummySolver() {
        super(null, -1);
    }

    @Override
    public boolean solve() {
        return false;
    }

    @Override
    protected String calculateSolution() {
        return "NO_SOLUTION";
    }
}
