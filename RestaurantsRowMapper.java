package edu.lawrence.picker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RestaurantsRowMapper implements RowMapper<Restaurants> {
    @Override
    public Restaurants mapRow(ResultSet row, int rowNum) throws SQLException {
    	Restaurants u = new Restaurants();
        u.setId(row.getString("Id"));
        u.setName(row.getString("name"));
        u.setCategory(row.getString("category"));
        u.setPrice(row.getInt("price"));
        u.setKnownFor(row.getString("knownFor"));
        u.setSpecificFood(row.getString("specificFood"));
        u.setCode(row.getString("code"));
        return u;
    }
}