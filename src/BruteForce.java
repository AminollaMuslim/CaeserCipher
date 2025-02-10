public class BruteForce {
    public void decryptByBruteForce(String encryptedText, char[] alphabet) {
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        for (int i = 0; i < alphabet.length; i++) {
            String s = cipher.decrypt(fileManager.readFile(encryptedText),alphabet[i]);
            fileManager.writeFile(s , "encrypt"+i+".txt");
        }
    }
}