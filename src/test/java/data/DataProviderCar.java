package data;

import dto.CarDTO;
import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCar {
    @DataProvider
    public Iterator<Object[]> positiveAddCarCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/positiveAddCar.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        CarDTO.builder()
                                .serialNumber(split[0])
                                .manufacture(split[1])
                                .model(split[2])
                                .year(Integer.parseInt(split[3]))
                                .fuel(split[4])
                                .seats(Integer.parseInt(split[5]))
                                .carClass(split[6])
                                .pricePerDay(Double.parseDouble(split[7]))
                                .about(split[8])
                                .city(split[9])
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
    public Iterator<Object[]> negativeAddCarCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/negativeAddCar.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while(line != null && line != "") {
                String[] split = line.split(",");
                list.add(new Object[]{
                        CarDTO.builder()
                                .serialNumber(split[0])
                                .manufacture(split[1])
                                .model(split[2])
                                .year(Integer.parseInt(split[3]))
                                .fuel(split[4])
                                .seats(Integer.parseInt(split[5]))
                                .carClass(split[6])
                                .pricePerDay(Double.parseDouble(split[7]))
                                .about(split[8])
                                .city(split[9])
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

