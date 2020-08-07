package com.silk.awesomeagu.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.silk.awesomeagu.web.rest.TestUtil;

public class DmCqBhxhTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmCqBhxh.class);
        DmCqBhxh dmCqBhxh1 = new DmCqBhxh();
        dmCqBhxh1.setId(1L);
        DmCqBhxh dmCqBhxh2 = new DmCqBhxh();
        dmCqBhxh2.setId(dmCqBhxh1.getId());
        assertThat(dmCqBhxh1).isEqualTo(dmCqBhxh2);
        dmCqBhxh2.setId(2L);
        assertThat(dmCqBhxh1).isNotEqualTo(dmCqBhxh2);
        dmCqBhxh1.setId(null);
        assertThat(dmCqBhxh1).isNotEqualTo(dmCqBhxh2);
    }
}
