import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.sql.Time;
import java.util.List;

/**
 * Created by Dragonking3x on 07.04.2016.
 */
public class SearchForNewTxT {
    public String searchForNewTxT(String lolLogFolder){
        //last modified time to search
        long time = 5000;


        File folder = new File(lolLogFolder);
        String returnText = "error";


        if (folder.exists()) {
            File[] listFiles = folder.listFiles();
            if (folder.listFiles().length > 0) {
                for (int i = 0; i < listFiles.length; i++) {

                    //returnText = listFiles[listFiles.length - 1].getName();
                    if (System.currentTimeMillis() - listFiles[i].lastModified() < time) {
                        returnText = listFiles[i].getName();
                        i = listFiles.length;
                    }


                }
            }
        }


        return returnText;
    }
}
