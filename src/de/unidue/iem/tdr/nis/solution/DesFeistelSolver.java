package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.encryption.DESConstants;
import de.unidue.iem.tdr.nis.util.numbers.Functions;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class DesFeistelSolver extends TaskSolver {
    public DesFeistelSolver(Connection connection) {
        super(connection, TaskDefs.TASK_DES_FEISTEL);
    }

    @Override
    protected String calculateSolution() {
        final String input = this.task.getStringArray(0);
        final String l_block = input.substring(0, 32);
        final String r_block = input.substring(32,64);
        final String key = this.task.getStringArray(1);
        final String permuted_result = DESConstants.feistel(DESConstants.expand(r_block), key);
        System.out.println("len: " + permuted_result.length() + " res: " + permuted_result);
        System.out.println("len: " + key.length() + " key: " + key);
        System.out.println("len: " + l_block.length() + " l_block: " + permuted_result);
        return Functions.binaryXor(permuted_result, l_block);
    }
}
