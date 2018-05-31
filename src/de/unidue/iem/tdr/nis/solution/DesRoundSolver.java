package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.encryption.DES;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class DesRoundSolver extends TaskSolver {

    public DesRoundSolver(Connection connection) {
        super(connection, TaskDefs.TASK_DES_ROUND);
    }

    @Override
    protected String calculateSolution() {
        final String l_block = this.task.getStringArray(0);
        final String r_block = this.task.getStringArray(1);
        final String masterkey = this.task.getStringArray(2);
        final int round_num = this.task.getIntArray(0);
        final DES des = new DES(masterkey);
        final String roundKey = des.getKeyOfRound(round_num);
        des.roundwith(r_block, l_block, roundKey);
        final StringBuilder solutionBuilder = new StringBuilder();
        solutionBuilder.append(des.getL_block());
        solutionBuilder.append(des.getR_block());
        return solutionBuilder.toString();
    }
}
