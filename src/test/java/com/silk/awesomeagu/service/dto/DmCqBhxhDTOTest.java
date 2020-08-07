package com.silk.awesomeagu.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.silk.awesomeagu.web.rest.TestUtil;

public class DmCqBhxhDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmCqBhxhDTO.class);
        DmCqBhxhDTO dmCqBhxhDTO1 = new DmCqBhxhDTO();
        dmCqBhxhDTO1.setId(1L);
        DmCqBhxhDTO dmCqBhxhDTO2 = new DmCqBhxhDTO();
        assertThat(dmCqBhxhDTO1).isNotEqualTo(dmCqBhxhDTO2);
        dmCqBhxhDTO2.setId(dmCqBhxhDTO1.getId());
        assertThat(dmCqBhxhDTO1).isEqualTo(dmCqBhxhDTO2);
        dmCqBhxhDTO2.setId(2L);
        assertThat(dmCqBhxhDTO1).isNotEqualTo(dmCqBhxhDTO2);
        dmCqBhxhDTO1.setId(null);
        assertThat(dmCqBhxhDTO1).isNotEqualTo(dmCqBhxhDTO2);
    }
}
