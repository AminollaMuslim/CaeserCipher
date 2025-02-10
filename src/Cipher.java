public class Cipher {
    private static char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е','ё', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public  char[] getAlphabet() {
        return alphabet;
    }

    public String encrypt(String text , int shift){
        StringBuilder encryptWord = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (currentChar == alphabet[j]) {
                    int newIndex = (j + shift) % alphabet.length;
                    if (newIndex < 0) {
                        newIndex += alphabet.length;
                    }
                    encryptWord.append(alphabet[newIndex]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                encryptWord.append(currentChar);
            }
        }
        return encryptWord.toString();
    }
    public String decrypt(String encryptedText , int shift){
        StringBuilder decryptWord = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char currentChar = encryptedText.charAt(i);
            boolean found = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (currentChar == alphabet[j]) {
                    int newIndex = (j - shift) % alphabet.length;
                    if (newIndex < 0) {
                        newIndex += alphabet.length;
                    }
                    decryptWord.append(alphabet[newIndex]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                decryptWord.append(currentChar);
            }
        }
        return decryptWord.toString();
    }
}