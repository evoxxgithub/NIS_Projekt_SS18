package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;
import de.unidue.iem.tdr.nis.util.encryption.DES;

public class DesRBlockSolver extends TaskSolver {
    public DesRBlockSolver(Connection connection) {
        super(connection, TaskDefs.TASK_DES_RBLOCK);
    }

    @Override
    protected String calculateSolution() {
        final String input = this.task.getStringArray(0);
        final int round = this.task.getIntArray(0);
        final String KEY = "0000000000000000000000000000000000000000000000000000000000000000";
        DES des = new DES(KEY);
        System.out.println(input);
        des.setNewInput(input);
        for (int i = 0;  i < round; i++) {
            des.iterateRound();
        }
        return des.getR_block();
    }
}
