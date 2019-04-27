package com.upes.major2.service;

import com.upes.major2.dto.LoginDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    public List<LoginDTO> getFailedLogins() throws IOException {
        List<LoginDTO> loginDTOListFailure = new ArrayList<>();
        File file = new File("/var/log/auth.log");
        Files.lines(file.toPath())
                .filter(s -> s.contains("authentication failure"))
                .forEach(e -> {
                            LoginDTO loginDTO = new LoginDTO();
                            String date = e.substring(0, 6);
                            String time = e.substring(7, 16);
                            loginDTO.setDate(date);
                            loginDTO.setTime(time);
                            loginDTOListFailure.add(loginDTO);
                        }
                );
        return loginDTOListFailure;
    }

    public List<LoginDTO> getSuccessLogins() throws IOException {
        List<LoginDTO> loginDTOListSuccess = new ArrayList<>();
        File file = new File("/var/log/auth.log");
        Files.lines(file.toPath())
                .filter(s -> s.contains("login keyring"))
                .forEach(e -> {
                            LoginDTO loginDTO = new LoginDTO();
                            String date = e.substring(0, 6);
                            String time = e.substring(7, 16);
                            loginDTO.setDate(date);
                            loginDTO.setTime(time);
                            loginDTOListSuccess.add(loginDTO);
                        }
                );
        return loginDTOListSuccess;
    }


}
