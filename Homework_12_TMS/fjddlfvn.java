package com.tms.Homework_12_TMS;

import java.io.*;
import java.util.*;

public class fjddlfvn {
    public static void main(String[] args) {
        String docNum;
        Set<String> arrayDocNum = new HashSet<>();
        List<String> arrayDocName= new ArrayList<>();
        Map<String,String> arrayFileReport= new HashMap<>();
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("Выберите ");
            System.out.println("Для дальнейшего ввода файлов - 1 ");
            System.out.println("Для завершение программы - 0 ");
            System.out.println("Для проверки всех номеров документов на валидность - 2");
            System.out.println("-----------------------------");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            System.out.println("-----------------------------");
            if (i == 1) {
                System.out.println("Введите путь к файлу и имя файла");
                Scanner scanner2 = new Scanner(System.in);
                String path = scanner2.nextLine();
                String nameDoc = scanner2.nextLine();
                System.out.println("----------------------------");

                arrayDocName.add(nameDoc);
                
                //Объявляем обекты классов BufferedWriter и  BufferedReader.
                try (BufferedReader fr = new BufferedReader(new FileReader(path))) {
                    System.out.println("Имя файла и номера документов этого файла.");
                    System.out.println("-----------------------------");
                    while ((docNum = fr.readLine()) != null) {
                        arrayDocNum.add(docNum);
                        System.out.println(nameDoc + "  " + docNum);

                    }
                    System.out.println(arrayDocNum);

                    System.out.println("-----------------------------");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                } else if(i==0){
                    break;
                }
            try (BufferedWriter fileReport = new BufferedWriter(new FileWriter("C:\\Users\\User\\IdeaProjects\\p1\\src\\com\\tms\\Homework_12_TMS\\file-report.txt", true))) {
                if (i == 2) {
                    for (String item : arrayDocNum) {
                        if (item.length() == 15 && item.startsWith("docNum")) {
                             arrayFileReport.put(item, " -Документ валиден.");
                           // fileReport.write(" Номер документа  - " + item + "       ");
                        } else {
                            //fileReport.write(item + "- Номер документа не валиден так, как не начинается с последовательности символов (docnum) или его длина (>) или (<) 15 символов         ");
                            arrayFileReport.put(item,"Номер документа не валиден так, как не начинается с последовательности символов (docnum) или его длина (>) или (<) 15 символов         " );
                        }

                    }

                }

            }  catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}

