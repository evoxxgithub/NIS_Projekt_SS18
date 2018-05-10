package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.numbers.Encoding;
import de.unidue.iem.tdr.nis.util.numbers.Functions;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;


public class ModuloSolver extends TaskSolver {

    public ModuloSolver(Connection connection) {
        super(connection, TaskDefs.TASK_MODULO);
    }

    @Override
    protected String calculateSolution() {
        int int1 = this.task.getIntArray(0);
        int int2 = this.task.getIntArray(1);
        String rep = Encoding.DEC.getRepresentationOf(Functions.mod(int1, int2));
        return rep;
    }

}
