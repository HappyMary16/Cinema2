package com.borodin.server.mapper;

import com.borodin.server.domain.Country;
import org.springframework.jdbc.core.RowMapper;

public class CountryMapper {
    public static RowMapper<Country> getCountryMapper() {
        return (rs, i) -> {
            Country entity = new Country();
            entity.setId(rs.getLong("id"));
            entity.setCountry(rs.getString("country"));
            return entity;
        };
    }
}
