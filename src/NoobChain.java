import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain {
    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<Block>();
        int difficulty = 5;

        blockchain.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1...");
        System.out.println("Block Mined!!! : " + blockchain.get(0).mineBlock(difficulty));

        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size() - 1).getHash()));
        System.out.println("Trying to Mine block 2...");
        System.out.println("Block Mined!!! : " + blockchain.get(1).mineBlock(difficulty));

        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).getHash()));
        System.out.println("Trying to Mine block 3...");
        System.out.println("Block Mined!!! : " + blockchain.get(2).mineBlock(difficulty));

        try {
           new Chain().CheckChainIsValid(blockchain, difficulty);
           System.out.println("\nBlockchain is Valid.");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}
