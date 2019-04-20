package todos.io;

import java.io.*;
import java.util.ArrayList;

import todos.model.list;

public class FileFactory {
    public static boolean saveFile(ArrayList<list> todolist, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (list lt : todolist) {
                String line = lt.getOrdernumber() + ";" + lt.getNote();
                bw.write(line);
                bw.newLine();
            }

            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<list> readFile(String path) {
        ArrayList<list> todolist = new ArrayList<list>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 2)                //length=2 vi co 2 phan tu trong list
                {
                    list lt = new list(arr[0], arr[1]);
                    todolist.add(lt);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return todolist;
    }
}
