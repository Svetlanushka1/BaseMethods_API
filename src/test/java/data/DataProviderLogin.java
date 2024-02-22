package data;


import dto.AuthRequestDTO;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderLogin {
    @DataProvider
    public Iterator<Object[]> loginCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/datalogin.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        AuthRequestDTO.builder()
                                .username(split[0])
                                .password(split[1])
                                .build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginCSV_negative() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/dataloginnegative.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        AuthRequestDTO.builder()
                                .username(split[0])
                                .password(split[1])
                                .build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }

}
