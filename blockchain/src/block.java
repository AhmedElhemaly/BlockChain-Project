import java.util.Arrays;
public class block
{
	private int index;
    private int previoushash;
    private String transaction	;
    private int blockhash;
    public block() {}
    public block(int index,int previoushash, String transaction) {
        this.index=index;
    	this.previoushash = previoushash;
        this.transaction = transaction;
        Object[] contens = {transaction.hashCode(),previoushash};
        this.blockhash=Arrays.hashCode(contens);


    }
    public int getIndex()
    {
    	return index;
    }
    public int getPrevioushash() {
        return previoushash;
    }

    public String getTransaction() {
        return transaction;
    }

    public int getBlockhash() {
        return blockhash;
    }
}
