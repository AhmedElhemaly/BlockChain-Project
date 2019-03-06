import java.util.ArrayList;
import java.util.Arrays;
public class Blockchain {
	public ArrayList<block>blocks=new ArrayList<>();
	public Blockchain (String genasisBlock)
	{
		block genesisblock=new block( 0,0,genasisBlock);
		blocks.add(genesisblock);
	}
	public void addBlock(block b,String Transaction)
	{
        b=new block(getChainSize(),blocks.get(getChainSize()-1).hashCode(),Transaction);
		blocks.add(b);
	}
	public int getChainSize()
	{
		return blocks.size();
	}
}
