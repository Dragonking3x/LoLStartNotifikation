import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dragonking3x on 01.05.2016.
 */
public class SetLineFromFile {

    public SetLineFromFile(File file , String line, String lineTxt) throws IOException {

        String fileTxt = FileUtils.readFileToString(file);

        String[] fileTxtArrow = fileTxt.split(System.lineSeparator());

        boolean found = false;

        for (int i = 0 ; i < fileTxtArrow.length; i++){
            String[] temp = fileTxtArrow[i].trim().split(";");

            if(temp[0].equalsIgnoreCase(line)){
                found = true;
                fileTxtArrow[i] = line + ";" + lineTxt;
                i = fileTxtArrow.length;
            }

        }

        String backToFile = "";
        for(int i = 0; i < fileTxtArrow.length ;i++ ){

            if(!found){
                backToFile = line + ";" + lineTxt + System.lineSeparator();
            }

            if(i == 0){
                if (found){
                    backToFile = fileTxtArrow[i];
                }else{
                    backToFile = backToFile + fileTxtArrow[i];
                    found = true;
                }
            }else {
                backToFile = backToFile + System.lineSeparator() + fileTxtArrow[i];
            }

        }


        FileUtils.writeStringToFile(file,backToFile);





    }
}
