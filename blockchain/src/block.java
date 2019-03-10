import java.util.Arrays;
public class block
{
	private int index;
    private String previoushash;
    private String transaction	;
    private String blockhash="";
    private  int nonce;
    public block() {}
    public block(int index,String previoushash, String transaction) {
        this.index=index;
    	this.previoushash = previoushash;
        this.transaction = transaction;
        this.blockhash=calculateHash();
        this.nonce=0;
    }
    public String calculateHash()
    {
        return ""+(this.index+this.previoushash+this.nonce+this.transaction).hashCode();
    }
    public void setNonce(int nonce)
    {
    	this.nonce=nonce;
    }
    public int getNonce()
    {
    	return nonce;
    }
    public int getIndex()
    {
    	return index;
    }
    public void setPrevioushash(String previoushash)
    {
    	this.previoushash=previoushash;
    }
    public void setHash(String blockhash)
    {
    	this.blockhash=blockhash;
    }
    public String getPrevioushash() {
        return previoushash;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getBlockhash() {
        return blockhash;
    }

    
}
