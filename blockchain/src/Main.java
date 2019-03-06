import java.util.ArrayList;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    ArrayList<block>blockchain=new ArrayList<>();

    public static void main(String[] args) {

        String [] genasistransaction={"gemy send 100 coin to hemaly"};
        block genesisblock=new block( 0,genasistransaction);
        System.out.println(genesisblock.getBlockhash());
    }
}