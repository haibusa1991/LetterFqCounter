import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FileHandler {

    public String readFileFromDisk() throws IOException {
        URL resource = this.getClass().getResource(Config.INPUT_FILE_NAME);
        String filepath;

        if (resource == null) {
            return null;
        }

        filepath = resource.getPath();

        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        br.lines().forEach(sb::append);

        br.close();
        isr.close();

        return sb.toString();
    }

    public void writeResultsToDisk(String s) throws IOException {
        URL resource = this.getClass().getProtectionDomain().getCodeSource().getLocation();

        String filepath;
        if (resource == null) {
            return;
        }

        filepath = resource.getPath() + Config.OUTPUT_FILE_NAME;
        FileOutputStream fos = new FileOutputStream(filepath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(s);
        bw.flush();
        bw.close();
    }
}
