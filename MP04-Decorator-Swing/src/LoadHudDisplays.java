import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface{
    String fileName;

    public LoadHudDisplays(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<String> load() {
        ArrayList<String> fileNameList = new ArrayList<String>();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String line = "";
            // .readLine()은 끝에 개행문자를 읽지 않음
            while ((line = buf.readLine()) != null)
                fileNameList.add(line);
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNameList;
    }
}
