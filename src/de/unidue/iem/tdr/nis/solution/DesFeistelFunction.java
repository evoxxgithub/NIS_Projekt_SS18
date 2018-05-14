package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.encryption.DESConstants;
import de.unidue.iem.tdr.nis.util.numbers.Functions;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class DesFeistelFunction extends TaskSolver {

    public DesFeistelFunction(Connection connection) {
        super(connection, TaskDefs.TASK_DES_FEISTEL);
    }

    @Override
    protected String calculateSolution() {
        final String input = this.task.getStringArray(0);
        final String l_block = input.substring(0, 32);
        final String r_block = input.substring(32,64);
        final String key = this.task.getStringArray(1);
        final String permuted_result = DESConstants.feistel(r_block, key);
        return Functions.xor(permuted_result, l_block);
    }
}
