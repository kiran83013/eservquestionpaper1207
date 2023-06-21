package com.travel.travtronics.repository;


import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.travel.travtronics.dto.MasterRowMapper;
import com.travel.travtronics.model.MasterModel;

import java.util.List;

@Component
public class MasterDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MasterDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(String sql, List<MapSqlParameterSource> sqlParameterSources) {
        sqlParameterSources.forEach(source -> jdbcTemplate.update(sql, source));
    }

    public List<MasterModel> getAll(String sql) {
        return jdbcTemplate.query(sql, new MasterRowMapper());
    }

    public MasterModel getById(String sql, Integer id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ID", id);
        return jdbcTemplate.queryForObject(sql, source, new MasterRowMapper());
    }

    public void updateById(String sql,MapSqlParameterSource source){
        jdbcTemplate.update(sql,source);
    }

    public List<MasterModel> getByName(String sql) {
        return jdbcTemplate.query(sql, new MasterRowMapper());
    }
    
//    public List<MasterModel> getByOrgId(String sql,String orgId) {
//        MapSqlParameterSource source = new MapSqlParameterSource();
//        source.addValue("orgId", orgId);
//        return jdbcTemplate.query(sql, source, new MasterRowMapper());
//    }
}
