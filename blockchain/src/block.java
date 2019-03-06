import jdk.nashorn.internal.ir.LiteralNode;
import java.util.Arrays;
public class block
{
    private int previoushash;
    private String []transactions;//list of trans
    private int blockhash;

    public block(int previoushash, String[] transactions) {
        this.previoushash = previoushash;
        this.transactions = transactions;
        Object[] contens = {Arrays.hashCode(transactions),previoushash};
        this.blockhash=Arrays.hashCode(contens);


    }

    public int getPrevioushash() {
        return previoushash;
    }

    public String[] getTransaction() {
        return transactions;
    }

    public int getBlockhash() {
        return blockhash;
    }
}
