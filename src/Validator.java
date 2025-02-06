import java.io.File;

public class Validator {
    public boolean isValidKey(int key , char[] alphabet){
        if (key >= 0 && key < alphabet.length) {
            return true;
        } else {
            System.out.println("Неверный ключ. Ключ должен быть в пределах от 0 до " + (alphabet.length - 1));
            return false;
        }
    }
    public boolean isFileExists(String filePath){
            File file = new File(filePath);
            if(file.exists() || file.isFile()){

                return true;
            }
            System.out.println("Файл не существует");
            return false;
    }
}
