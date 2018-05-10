package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.encryption.Vigenere;
import de.unidue.iem.tdr.nis.util.numbers.Encoding;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class VigenereSolver extends TaskSolver {
    public VigenereSolver(Connection connection) {
        super(connection, TaskDefs.TASK_VIGENERE);
    }

    @Override
    protected String calculateSolution() {
        String cipherText = this.task.getStringArray(0);
        String keyText = Encoding.toUpperCase(this.task.getStringArray(1));
        Vigenere vigenere = new Vigenere(keyText);
        String plainText = vigenere.decrypt(cipherText);

        return plainText;
    }
}
