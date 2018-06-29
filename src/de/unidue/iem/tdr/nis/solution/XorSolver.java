package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.numbers.Functions;
import de.unidue.iem.tdr.nis.util.string.EncodedString;
import de.unidue.iem.tdr.nis.util.numbers.Encoding;
import de.unidue.iem.tdr.nis.util.numbers.HexToBinConverter;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class XorSolver extends TaskSolver {

    public XorSolver(Connection connection) {
        super(connection, TaskDefs.TASK_XOR);
    }

    @Override
    protected String calculateSolution() {
        HexToBinConverter converter = new HexToBinConverter();
        EncodedString hex1 = new EncodedString(this.task.getStringArray(0), Encoding.HEXA);
        EncodedString hex2 = new EncodedString(this.task.getStringArray(1), Encoding.HEXA);
        String bin1 = converter.convert(hex1.getRepresenation());
        String bin2 = converter.convert(hex2.getRepresenation());
        return this.xorBinaries(bin1, bin2);
    }

    private String xorBinaries(String bin1, String bin2) {
        return Functions.binaryXor(bin1, bin2);
    }
}
