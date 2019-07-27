package HelperClasses;

import java.nio.file.*;
import java.lang.System.*;
import java.io.*;
import java.util.ArrayList;

public class ReadFile {

    public String readTestFile(String fname) {

        String file = "";

        Path cwd = Paths.get(".").toAbsolutePath();//get the test file stored in the parent directory
        cwd = cwd.getParent().getParent();
        String path = cwd.toString().toString() + "/" + fname;

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String chunk = "";
            while ((chunk = br.readLine()) != null) {
                file += chunk;
            }
            br.close();
        } catch (IOException E) {
            System.out.println(fname + " was not found");
        }

        return file;
    }

    public ArrayList<Integer> tokenizeList(String values) {
        String[] chunks = values.split(" ");

        ArrayList<Integer> num = new ArrayList<>(chunks.length);

        for (String s : chunks) num.add(Integer.valueOf(s));

        return num;
    }

}