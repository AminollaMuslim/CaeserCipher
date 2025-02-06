import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        Cipher caesarCipher = new Cipher();
        FileManager fileManager = new FileManager();

        while (true){
            System.out.println("/nВыберите пункт меню:");
            System.out.println("1.Зашифровать текст");
            System.out.println("2.Расшифровать текст");
            System.out.println("3.Расшифровать текст Brute force");
            System.out.println("4.Выход");
            System.out.print("Ваш выбор: ");

            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice){
                case 1:
                    System.out.print("Введите путь к файлу: ");
                    String source = scanner.nextLine();
                    System.out.print("Ключ:");
                    int key = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите путь к файлу , где должен быть зашифрованный текст: ");
                    String destination = scanner.nextLine();
                    validator.isValidKey(key, caesarCipher.getAlphabet());
                    String encrypt = caesarCipher.encrypt(fileManager.readFile(source), key);
                    fileManager.writeFile(encrypt , destination);
                case 2:
                    System.out.print("Введите путь к файлу: ");
                    source = scanner.nextLine();
                    System.out.print("Ключ:");
                    key = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите путь к файлу , где должен быть зашифрованный текст: ");
                    destination = scanner.nextLine();
                    validator.isValidKey(key, caesarCipher.getAlphabet());
                    String decrypt = caesarCipher.decrypt(fileManager.readFile(source), key);
                    fileManager.writeFile(decrypt , destination);
                case 3:

                case 4:
                    return;

                default:
                    System.out.println("Вы сделали не верный выбор. Еще раз.");
            }

        }
    }
}