package ru.netology.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String query;

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query = read("query.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> getProductName(String name) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return jdbcTemplate.queryForList(query, paramMap);
    }
}

