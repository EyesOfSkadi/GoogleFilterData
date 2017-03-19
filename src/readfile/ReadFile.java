/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfile;

import Models.Content_Object;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viegrid-04
 */
public class ReadFile {

    private static String FILE = "filedulieu.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        checkHavingSpecialCt();
//        Path path = Paths.get("googlebooks-eng-all-1gram-20120701-0");
        Path path = Paths.get("googlebooks-eng-all-2gram-20120701-a_");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("googlebooks-eng-all-2gram-20120701-a_"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        List<Content_Object> list = new ArrayList<>();
        List<Integer> lstyear = new ArrayList<>();
        List<Integer> lstappearcount = new ArrayList<>();
        List<Integer> lstbookcount = new ArrayList<>();
        Content_Object obj = new Content_Object();

        while ((line = bufferedReader.readLine()) != null) {

            if (!line.equals("")) {
                String[] str = line.split("\t");
                String s = str[0];
                // kiểm tra lượng số có nhiều quá trong chuôi hay k
                boolean isTrue = IsNumberic(s);
                // KIỂM TRA KÝ TỰ ĐẶC BIỆT CÓ NHIỀU QUÁ TRONG CHUỖI HAY KHÔNG
//                boolean isTrueSpecialC = checkHavingSpecialC(s);
                if (s.length() < 5) {
                    System.out.println("nho hon 5");
                } 
                else if (isTrue) {
                    System.out.println("nho hon 5");
                } //                else if (isTrueSpecialC){
                //                    System.out.println("nho hon 5");
                //                }
                else {
                    String ss = str[1];
                    int inss = Integer.parseInt(ss);
                    lstyear.add(inss);

                    String sss = str[2];
                    int insss = Integer.parseInt(sss);
                    lstappearcount.add(insss);

                    String ssss = str[3];
                    int inssss = Integer.parseInt(ssss);
                    lstbookcount.add(inssss);

                    // thêm đối tượng vào List
                    if (obj.getContent().equals(s)) {

                    } else {
                        obj = new Content_Object();
                        lstyear = new ArrayList<>();
                        lstappearcount = new ArrayList<>();
                        lstbookcount = new ArrayList<>();
                        obj.setContent(s);
                        obj.setYear(lstyear);
                        obj.setAppearCount(lstappearcount);
                        obj.setBookCount(lstbookcount);
                        list.add(obj);
                    }
                }
            }

        }

        bufferedReader.close();

        // ghi file
        WriteFile(FILE, list);
    }

    // tính % số trong chuỗi
    private static boolean IsNumberic(String str) {
        boolean isTrue = false;
        double lengofstr = str.length();
        String string = str.replaceAll("[^-?0-9]+", "");
        double lengofstring = string.length();

        double percentage = (lengofstring / lengofstr) * 100;

        if (percentage > 50) {
            isTrue = true;
        } else {
            isTrue = false;
        }

        return isTrue;
    }

    // tính % ký tự đặc biệt trong chuỗi
    private static boolean getSpecialCharacterCount(String s) {
        boolean isTrue = false;
        // độ dài chuôii nhập vào
        double sleng = s.length();
        // xoá ký tự đặc biệt
        String ss = s.replaceAll("[^A-Za-z0-9]", "");

        double countss = ss.length();

        // tính số lượng ký tự đặc biệt trên chuỗi
        double soluongkytu = sleng - countss;
        // tính % ky tu dac biet  trên chuỗi
        double percentage = (soluongkytu / sleng) * 100;
        if (percentage > 10) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }

    // check chuỗi có ký tự đặc biệt hay không
    private static boolean checkHavingSpecialC(String string) {
        boolean isTrue = false;
        List specialCharacters = new ArrayList();
        specialCharacters.add(";");
        specialCharacters.add(",");
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < specialCharacters.size(); j++) {
                if (string.charAt(i) == ((Character) specialCharacters.get(j)).charValue()) {
                    isTrue = true;
                    return isTrue;

                }
            }
        }
        return isTrue;
    }

//   private static boolean checkHavingSpecialCt(){
//        boolean isTrue = false;
//        String string = "!@#$%^&*_+=<>,?/'";
//        List specialCharacters = new ArrayList();
//		specialCharacters.add(";");
//		specialCharacters.add(",");
//                specialCharacters.add("!");
//                specialCharacters.add("@");
//                specialCharacters.add("#");
//                specialCharacters.add("$");
//                specialCharacters.add("%");
//                specialCharacters.add("^");
//                specialCharacters.add("&");
//                specialCharacters.add("*");
//                specialCharacters.add("_");
//                specialCharacters.add("|");
//                specialCharacters.add("/");
//                specialCharacters.add("\'");
//                specialCharacters.add("\"");
//                specialCharacters.add(":");
//                specialCharacters.add("?");
//                specialCharacters.add("\\>");
//                specialCharacters.add("+");
//                specialCharacters.add("=");
//                specialCharacters.add("\\<");
//           
//		for (int i = 0; i < string.length(); i++) {
//		   for (int j=0; j < specialCharacters.size(); j++) {
//		         if ( string.charAt(i) == ((Character) specialCharacters.get(j)).charValue()) {
//		            isTrue = true;
//                            return isTrue;
//                            
//		      }
//		   }
//		}
//                return isTrue;
//    }
    private static void WriteFile(String file, List<Content_Object> list) throws IOException {
        int year = 0;
        int app = 0;
        int book = 0;
        for (Content_Object dis : list) {
            FileWriter fileWriter2 = new FileWriter(file, true);
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            for (int i = 0; i < dis.getYear().size(); i++) {
                year = dis.getYear().get(i);
                app = dis.getAppearCount().get(i);
                book = dis.getBookCount().get(i);

                String str = dis.getContent() + "\t" + year + "\t" + app + "\t" + book;
                bufferedWriter2.write(str);
                bufferedWriter2.append(System.getProperty("line.separator"));

            }
//                    for(int i = 0; i<dis.getAppearCount().size(); i++){
//                         app = dis.getAppearCount().get(i);
//                    }
//                    for(int i = 0; i<dis.getBookCount().size(); i++){
//                         book = dis.getBookCount().get(i);
//                    }

//            String str = dis.getContent() + "/t" + year + "/t" + app + "/t" + book;
//            bufferedWriter2.write(str);
//            bufferedWriter2.append(System.getProperty("line.separator"));
            bufferedWriter2.close();
        }
    }

}
