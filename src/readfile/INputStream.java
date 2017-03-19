/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author NGOCHUNG
 */
public class INputStream {

    public static void main(String[] args) {
//        String fileName = "googlebooks-eng-all-2gram-20120701-a_";
        File file = new File("googlebooks-eng-all-2gram-20120701-a_");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            System.out.println("Total file size to read (in bytes) : "
                    + fis.available());

            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                System.out.print((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
