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
        b=new block(getChainSize(),blocks.get(getChainSize()-1).getBlockhash(),Transaction);
		blocks.add(b);
	}
	public int getChainSize()
	{
		return blocks.size();
	}
	public boolean blockValidate()
    {
    	block genasisBlock = blocks.get(0);
    	if (genasisBlock.getIndex()!=0)
    		return false;
    	if (genasisBlock.getPrevioushash()!=0)
    		return false;
    	if (genasisBlock.getBlockhash()==0 || genasisBlock.getTransaction().hashCode()!=genasisBlock.getBlockhash())
    		return false;
    	return true;
    }
	public boolean isValidNewBlock(block newBlock, block previousBlock) {
		  if (newBlock != null  &&  previousBlock != null) {
		    if (previousBlock.getIndex() + 1 != newBlock.getIndex()) {
		      return false;
		    }

		    if (newBlock.getPrevioushash() == 0  || newBlock.getPrevioushash()!=previousBlock.getBlockhash()) 
		    {
		      return false;
		    }
		    if (newBlock.getBlockhash() == 0  ||  newBlock.getTransaction().hashCode()!=newBlock.getBlockhash())
		    {
		      return false;
		    }

		    return true;
		  }
		  return false;
		}
	public boolean isBlockChainValid() {
		  if (!blockValidate()) {
		    return false;
		  }

		  for (int i = 1; i < blocks.size(); i++) {
		    block currentBlock = blocks.get(i);
		    block previousBlock = blocks.get(i - 1);

		    if (!isValidNewBlock(currentBlock, previousBlock)) {
		      return false;
		    }
		  }

		  return true;
		}
}
