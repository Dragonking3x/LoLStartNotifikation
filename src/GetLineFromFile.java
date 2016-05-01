import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dragonking3x on 01.05.2016.
 */
public class GetLineFromFile {



    public String getLineFromFile(File file, String line) throws IOException {
        String returnText = "";

        String fileTxt = FileUtils.readFileToString(file);
        TxTDataList txtL = new TxTDataList();

        String[] filetxtArrow = fileTxt.split(System.lineSeparator());

        for (int i = 0 ; i < filetxtArrow.length; i++){
            String[] temp = filetxtArrow[i].trim().split(";");
            if(temp[0].equalsIgnoreCase(line)){
                returnText = temp[1];
                i = filetxtArrow.length;
            }
        }

        return returnText.trim();
    }

    
    
    
    
    
}
