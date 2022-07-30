import java.util.ArrayList;

public class Chain {
    public void CheckChainIsValid(ArrayList<Block> blockchain, int difficulty) throws Exception {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            // compare registered hash and calculated hash;
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                throw new Exception("Current Hashes not equal");
            }

            // compare previous hash and registered previous hash
            if (!previousBlock.getHash().equals(currentBlock.previousHash)) {
                throw new Exception("Previous Hashes not equal");
            }

            //check if hash is solved
            if(!currentBlock.getHash().substring( 0, difficulty).equals(hashTarget)) {
                throw new Exception("This block hasn't been mined");
            }
        }
    }
}
