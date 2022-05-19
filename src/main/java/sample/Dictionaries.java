package sample;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionaries {
    private List<String> material = new ArrayList<>(); //знание и восприятие материала на уроке
    private List<String> homeWork = new ArrayList<>(); //выполнение домашних заданий
    private List<String> generalCharacter = new ArrayList<>(); //основные характеристики студента
    private List<String> selfEducation = new ArrayList<>(); //работа над саморазвитием
    private List<String> goodWork = new ArrayList<>(); //студент немного недорабатывает
    private List<String> badWork = new ArrayList<>(); //студент плохо работает над ДЗ

    String getMaterial() {
        int a = (int) (Math.random() * material.size());
        return material.get(a);
    }

    String getHomework() {
        int a = (int) (Math.random() * homeWork.size());
        return homeWork.get(a);
    }

    String getGeneralCharacter() {
        int a = (int) (Math.random() * generalCharacter.size());
        return generalCharacter.get(a);
    }

    String getSelfEducation() {
        int a = (int) (Math.random() * selfEducation.size());
        return selfEducation.get(a);
    }

    String getGoodWork() {
        int a = (int) (Math.random() * goodWork.size());
        return goodWork.get(a);
    }

    String getBadWork() {
        int a = (int) (Math.random() * badWork.size());
        return badWork.get(a);
    }


    void initializeLists() {
        try {
            FileReader fileReader = new FileReader("comments.txt");
            BufferedReader scanner = new BufferedReader(fileReader);
            String nextString;
            while ((nextString = scanner.readLine()) != null) {

                if (nextString.contains("material")) {
                    nextString = scanner.readLine();
                    while (!nextString.contains("homeWork")) {
                        material.add(nextString);
                        nextString = scanner.readLine();
                    }
                }

                if (nextString.contains("homeWork")) {
                    nextString = scanner.readLine();
                    while (!nextString.contains("generalCharacter")) {
                        homeWork.add(nextString);
                        nextString = scanner.readLine();
                    }
                }

                if (nextString.contains("generalCharacter")) {
                    nextString = scanner.readLine();
                    while (!nextString.contains("selfEducation")) {
                        generalCharacter.add(nextString);
                        nextString = scanner.readLine();
                    }
                }

                if (nextString.contains("selfEducation")) {
                    nextString = scanner.readLine();
                    while (!nextString.contains("goodWork")) {
                        selfEducation.add(nextString);
                        nextString = scanner.readLine();
                    }
                }

                if (nextString.contains("goodWork")) {
                    nextString = scanner.readLine();
                    while (!nextString.contains("badWork")) {
                        goodWork.add(nextString);
                        nextString = scanner.readLine();
                    }
                }

                if (nextString.contains("badWork")) {
                    nextString = scanner.readLine();
                    while (nextString != null) {
                        badWork.add(nextString);
                        nextString = scanner.readLine();
                    }
                }

            }
            scanner.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Not Found!");
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Some problem in FIle...");
            e.printStackTrace();
        }
    }
}