package saucedemo.utils;

import com.google.common.collect.Iterators;
import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class UserReader {
    @DataProvider(name = "LoginUser")
    public Object[][] readCsv() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("loginusers.csv"), ',');
        List<String[]> csvData = csvReader.readAll();
        Object[][] csvDataObject = new Object[csvData.size()][2];
        for (int i = 0; i < csvData.size(); i++) {
            csvDataObject[i] = csvData.get(i);
        }

        return csvDataObject;
    }



}
