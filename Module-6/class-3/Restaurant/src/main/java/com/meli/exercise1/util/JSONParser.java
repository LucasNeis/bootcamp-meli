package com.meli.exercise1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class JSONParser {
    private ObjectMapper mapper;
    private String base;

    public JSONParser(ObjectMapper mapper, String basePath) {
        this.mapper = mapper;
        this.base = basePath;
    }

    public void toJSON(String fileName, Object obj) throws ImpossibleToAccessException {
        String path = base.concat(fileName);
        try {
            mapper.writeValue(new File(path), obj);
        } catch (Exception ex) {
            throw new ImpossibleToAccessException(ex.getMessage());
        }
    }

    public<T> T fromJSON(String path, Class<T> cls) throws ImpossibleToAccessException {
        T result;
        try {
            String json = readFile(path);
            System.out.println(json);
            result = mapper.readValue(json, cls);
        } catch (Exception ex) {
            throw new ImpossibleToAccessException(ex.getMessage());
        }
        return result;
    }

    private String readFile(String path) throws IOException {
        Path pth = Paths.get(path);

        return Files.readAllLines(pth).stream().collect(Collectors.joining());
    }


}
