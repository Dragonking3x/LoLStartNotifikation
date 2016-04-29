import org.apache.commons.io.FileUtils;
import sun.text.normalizer.Utility;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dragonking3x on 07.04.2016.
 */
public class ReadTxT {
    public String readTxT (String txtFile) throws IOException {
        String returnText = "";

        File lolLogFile = new File(txtFile);
        returnText = FileUtils.readFileToString(lolLogFile);

        return returnText;
    }
}
