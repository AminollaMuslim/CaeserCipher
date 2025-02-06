public class Cipher {
    private static char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};;

    public  char[] getAlphabet() {
        return alphabet;
    }

    public String encrypt(String text , int shift){
        char[] textForEncrypt = new char[text.length()];
        StringBuilder encryptWord = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            textForEncrypt[i] = text.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(textForEncrypt[i] == alphabet[j]){
                    encryptWord.append(alphabet[(j+shift)%alphabet.length]);
                }
            }
        }
        return encryptWord.toString();

    }
    public String decrypt(String encryptedText , int shift){
        char[] textForDecrypt = new char[encryptedText.length()];
        StringBuilder decryptWord = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            textForDecrypt[i] = encryptedText.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(textForDecrypt[i] == alphabet[j]){
                    decryptWord.append(alphabet[(j-shift+alphabet.length)%alphabet.length]);
                }
            }
        }
        return decryptWord.toString();
    }
}
