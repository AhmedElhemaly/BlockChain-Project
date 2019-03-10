import java.util.ArrayList;
import java.util.Arrays;
public class Blockchain {
	public ArrayList<block>blocks=new ArrayList<>();
	public Blockchain (String genasisBlock)
	{
		block genesisblock=new block(0,null,"Genasis");
		blocks.add(genesisblock);
	}
	public void addBlock(block b)
	{
        b=new block(getChainSize(),blocks.get(getChainSize()-1).getBlockhash(),b.getTransaction());
		blocks.add(b);
	}
	public int getChainSize()
	{
		return blocks.size();
	}
	public block getLastBlock()
	{
		return blocks.get(blocks.size()-1);
	}
	//----------------------------------------------
	
	public void addNewBlockwithMining(block b,int diff)
	{
		if (diff==0)
		{
			this.addBlock(b);
			return ;
		}
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<diff;i++)
		{
			sb.append("0");
		}
		String leadingZeros=sb.toString();
		System.out.println("leadingZeros : " + leadingZeros);
		b.setPrevioushash(getLastBlock().getBlockhash());
		b.setHash(b.calculateHash());
		while (b.getBlockhash().substring(0,diff)!=leadingZeros)
		{
			b.setNonce(b.getNonce()+1);
			b.setHash(b.calculateHash());
			System.out.println("Current Block's hash : "+b.getBlockhash());
		}
		System.out.println("Current Block's hash : "+b.getBlockhash());
		blocks.add(b);
	}
	
	//----------------------------------------------
	
	public boolean blockValidate()
    {
    	block genasisBlock = blocks.get(0);
    	if (genasisBlock.getIndex()!=0)
    		return false;
    	if (genasisBlock.getPrevioushash()!=null)
    		return false;
    	if (genasisBlock.getBlockhash()==null || Integer.toString(genasisBlock.getTransaction().hashCode())!=genasisBlock.getBlockhash())
    		return false;
    	return true;
    }
	public boolean isValidNewBlock(block newBlock, block previousBlock) {
		  if (newBlock != null  &&  previousBlock != null) {
		    if (previousBlock.getIndex() + 1 != newBlock.getIndex()) {
		      return false;
		    }

		    if (newBlock.getPrevioushash() == null  || newBlock.getPrevioushash()!=previousBlock.getBlockhash()) 
		    {
		      return false;
		    }
		    if (newBlock.getBlockhash() == null  ||  Integer.toString(newBlock.getTransaction().hashCode())!=newBlock.getBlockhash())
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
