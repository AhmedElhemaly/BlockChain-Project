import java.util.ArrayList;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner cin=new Scanner (System.in);
    	String Transaction = "mohamed sent 100 coin to ahmed",T;
        Blockchain bc=new Blockchain(Transaction);
        for (int i=0;i<3;i++)
        {
        	T=cin.nextLine();
        	block b=new block(bc.blocks.size()-1,bc.getLastBlock().calculateHash(),T);
            bc.addNewBlockwithMining(b,5);
        }
        for (int i=0;i<bc.blocks.size();i++)
        	System.out.println(bc.blocks.get(i).getBlockhash());   
    	System.out.println("Check Validation of this BlocChain");
    	if (bc.isBlockChainValid())
    	{
    		System.out.println("This Blockchain is valid with its codes : ");
            for (int i=0;i<bc.blocks.size();i++)
            	System.out.println(bc.blocks.get(i).getBlockhash());    
    	}
    	else
    		System.out.println("Check your Blockchain there is wrong block");
}
}