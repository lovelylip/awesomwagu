package com.silk.awesomeagu.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DmCqBhxhMapperTest {

    private DmCqBhxhMapper dmCqBhxhMapper;

    @BeforeEach
    public void setUp() {
        dmCqBhxhMapper = new DmCqBhxhMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(dmCqBhxhMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(dmCqBhxhMapper.fromId(null)).isNull();
    }
}
