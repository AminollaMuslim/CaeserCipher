import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {
    String content = "";
    public String readFile(String filePath){
        Path path = Path.of(filePath);
        Validator validator = new Validator();
        try(FileChannel source = FileChannel.open(path , StandardOpenOption.READ)) {
            content = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            validator.isFileExists(filePath);
        }
        return content;
    }
    public void writeFile(String content , String filePath){
        Path path = Path.of(filePath);
        Validator validator = new Validator();
        try (FileChannel dest = FileChannel.open(path , StandardOpenOption.WRITE , StandardOpenOption.CREATE)){
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            while (buffer.hasRemaining()){
                dest.write(buffer);
            }
        } catch (IOException e) {
            validator.isFileExists(filePath);
        }
    }
}
