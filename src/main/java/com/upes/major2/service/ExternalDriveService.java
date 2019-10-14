package com.upes.major2.service;

import com.upes.major2.dto.ExternalDriveDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExternalDriveService{
    public List<ExternalDriveDTO> getRecords() throws IOException {
        List<ExternalDriveDTO> externalDriveDTOList = new ArrayList<>();
        File file = new File("/var/log/syslog");
        Iterator<String> stringIterator = Files.readAllLines(file.toPath()).iterator();
        while (stringIterator.hasNext()) {
            if (stringIterator.next().contains("New USB device found")) {
                ExternalDriveDTO externalDriveDTO=new ExternalDriveDTO();
                String s = stringIterator.next();
                String date=s.substring(0, 6);
                String time=s.substring(7, 16);
                String product=stringIterator.next().substring(70);
                String manufacturer=stringIterator.next().substring(75);
                String serialNumber=stringIterator.next().substring(75);
                externalDriveDTO.setDate(date);
                externalDriveDTO.setTime(time);
                externalDriveDTO.setProduct(product);
                externalDriveDTO.setManufacturer(manufacturer);
                externalDriveDTO.setSerialNumber(serialNumber);
                externalDriveDTOList.add(externalDriveDTO);
            }
        }
        return externalDriveDTOList;
    }
}
