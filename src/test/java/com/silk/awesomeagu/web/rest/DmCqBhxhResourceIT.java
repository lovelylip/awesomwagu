package com.silk.awesomeagu.web.rest;

import com.silk.awesomeagu.AwesomeaguApp;
import com.silk.awesomeagu.domain.DmCqBhxh;
import com.silk.awesomeagu.repository.DmCqBhxhRepository;
import com.silk.awesomeagu.repository.search.DmCqBhxhSearchRepository;
import com.silk.awesomeagu.service.DmCqBhxhService;
import com.silk.awesomeagu.service.dto.DmCqBhxhDTO;
import com.silk.awesomeagu.service.mapper.DmCqBhxhMapper;
import com.silk.awesomeagu.service.dto.DmCqBhxhCriteria;
import com.silk.awesomeagu.service.DmCqBhxhQueryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DmCqBhxhResource} REST controller.
 */
@SpringBootTest(classes = AwesomeaguApp.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class DmCqBhxhResourceIT {

    private static final String DEFAULT_MA_CQBH = "AAAAAAAAAA";
    private static final String UPDATED_MA_CQBH = "BBBBBBBBBB";

    private static final String DEFAULT_TEN = "AAAAAAAAAA";
    private static final String UPDATED_TEN = "BBBBBBBBBB";

    private static final String DEFAULT_DIA_CHI = "AAAAAAAAAA";
    private static final String UPDATED_DIA_CHI = "BBBBBBBBBB";

    private static final String DEFAULT_MA_XA = "AAAAAAAAAA";
    private static final String UPDATED_MA_XA = "BBBBBBBBBB";

    private static final String DEFAULT_MA_HUYEN = "AAAAAAAAAA";
    private static final String UPDATED_MA_HUYEN = "BBBBBBBBBB";

    private static final String DEFAULT_MA_TINH = "AAAAAAAAAA";
    private static final String UPDATED_MA_TINH = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_ACC = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_ACC = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMERIC = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMERIC = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final Long DEFAULT_ACTIVE_DATE = 1L;
    private static final Long UPDATED_ACTIVE_DATE = 2L;
    private static final Long SMALLER_ACTIVE_DATE = 1L - 1L;

    private static final Long DEFAULT_INACTIVE_DATE = 1L;
    private static final Long UPDATED_INACTIVE_DATE = 2L;
    private static final Long SMALLER_INACTIVE_DATE = 1L - 1L;

    private static final String DEFAULT_MA_CQBH_CHA = "AAAAAAAAAA";
    private static final String UPDATED_MA_CQBH_CHA = "BBBBBBBBBB";

    private static final String DEFAULT_NGUOI_KY = "AAAAAAAAAA";
    private static final String UPDATED_NGUOI_KY = "BBBBBBBBBB";

    private static final String DEFAULT_CHUC_DANH = "AAAAAAAAAA";
    private static final String UPDATED_CHUC_DANH = "BBBBBBBBBB";

    private static final String DEFAULT_TEN_NOI_KY = "AAAAAAAAAA";
    private static final String UPDATED_TEN_NOI_KY = "BBBBBBBBBB";

    private static final Long DEFAULT_IS_ACTIVE = 1L;
    private static final Long UPDATED_IS_ACTIVE = 2L;
    private static final Long SMALLER_IS_ACTIVE = 1L - 1L;

    private static final String DEFAULT_PATH = "AAAAAAAAAA";
    private static final String UPDATED_PATH = "BBBBBBBBBB";

    private static final Long DEFAULT_NGAY_KHOA = 1L;
    private static final Long UPDATED_NGAY_KHOA = 2L;
    private static final Long SMALLER_NGAY_KHOA = 1L - 1L;

    private static final String DEFAULT_SO_QD_TL = "AAAAAAAAAA";
    private static final String UPDATED_SO_QD_TL = "BBBBBBBBBB";

    private static final Long DEFAULT_NGAY_QD_TL = 1L;
    private static final Long UPDATED_NGAY_QD_TL = 2L;
    private static final Long SMALLER_NGAY_QD_TL = 1L - 1L;

    private static final String DEFAULT_CQ_KY_QD = "AAAAAAAAAA";
    private static final String UPDATED_CQ_KY_QD = "BBBBBBBBBB";

    @Autowired
    private DmCqBhxhRepository dmCqBhxhRepository;

    @Autowired
    private DmCqBhxhMapper dmCqBhxhMapper;

    @Autowired
    private DmCqBhxhService dmCqBhxhService;

    /**
     * This repository is mocked in the com.silk.awesomeagu.repository.search test package.
     *
     * @see com.silk.awesomeagu.repository.search.DmCqBhxhSearchRepositoryMockConfiguration
     */
    @Autowired
    private DmCqBhxhSearchRepository mockDmCqBhxhSearchRepository;

    @Autowired
    private DmCqBhxhQueryService dmCqBhxhQueryService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDmCqBhxhMockMvc;

    private DmCqBhxh dmCqBhxh;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmCqBhxh createEntity(EntityManager em) {
        DmCqBhxh dmCqBhxh = new DmCqBhxh()
            .maCqbh(DEFAULT_MA_CQBH)
            .ten(DEFAULT_TEN)
            .diaChi(DEFAULT_DIA_CHI)
            .maXa(DEFAULT_MA_XA)
            .maHuyen(DEFAULT_MA_HUYEN)
            .maTinh(DEFAULT_MA_TINH)
            .emailAcc(DEFAULT_EMAIL_ACC)
            .phoneNumeric(DEFAULT_PHONE_NUMERIC)
            .status(DEFAULT_STATUS)
            .activeDate(DEFAULT_ACTIVE_DATE)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .maCqbhCha(DEFAULT_MA_CQBH_CHA)
            .nguoiKy(DEFAULT_NGUOI_KY)
            .chucDanh(DEFAULT_CHUC_DANH)
            .tenNoiKy(DEFAULT_TEN_NOI_KY)
            .isActive(DEFAULT_IS_ACTIVE)
            .path(DEFAULT_PATH)
            .ngayKhoa(DEFAULT_NGAY_KHOA)
            .soQdTl(DEFAULT_SO_QD_TL)
            .ngayQdTl(DEFAULT_NGAY_QD_TL)
            .cqKyQd(DEFAULT_CQ_KY_QD);
        return dmCqBhxh;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmCqBhxh createUpdatedEntity(EntityManager em) {
        DmCqBhxh dmCqBhxh = new DmCqBhxh()
            .maCqbh(UPDATED_MA_CQBH)
            .ten(UPDATED_TEN)
            .diaChi(UPDATED_DIA_CHI)
            .maXa(UPDATED_MA_XA)
            .maHuyen(UPDATED_MA_HUYEN)
            .maTinh(UPDATED_MA_TINH)
            .emailAcc(UPDATED_EMAIL_ACC)
            .phoneNumeric(UPDATED_PHONE_NUMERIC)
            .status(UPDATED_STATUS)
            .activeDate(UPDATED_ACTIVE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .maCqbhCha(UPDATED_MA_CQBH_CHA)
            .nguoiKy(UPDATED_NGUOI_KY)
            .chucDanh(UPDATED_CHUC_DANH)
            .tenNoiKy(UPDATED_TEN_NOI_KY)
            .isActive(UPDATED_IS_ACTIVE)
            .path(UPDATED_PATH)
            .ngayKhoa(UPDATED_NGAY_KHOA)
            .soQdTl(UPDATED_SO_QD_TL)
            .ngayQdTl(UPDATED_NGAY_QD_TL)
            .cqKyQd(UPDATED_CQ_KY_QD);
        return dmCqBhxh;
    }

    @BeforeEach
    public void initTest() {
        dmCqBhxh = createEntity(em);
    }

    @Test
    @Transactional
    public void createDmCqBhxh() throws Exception {
        int databaseSizeBeforeCreate = dmCqBhxhRepository.findAll().size();
        // Create the DmCqBhxh
        DmCqBhxhDTO dmCqBhxhDTO = dmCqBhxhMapper.toDto(dmCqBhxh);
        restDmCqBhxhMockMvc.perform(post("/api/dm-cq-bhxhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqBhxhDTO)))
            .andExpect(status().isCreated());

        // Validate the DmCqBhxh in the database
        List<DmCqBhxh> dmCqBhxhList = dmCqBhxhRepository.findAll();
        assertThat(dmCqBhxhList).hasSize(databaseSizeBeforeCreate + 1);
        DmCqBhxh testDmCqBhxh = dmCqBhxhList.get(dmCqBhxhList.size() - 1);
        assertThat(testDmCqBhxh.getMaCqbh()).isEqualTo(DEFAULT_MA_CQBH);
        assertThat(testDmCqBhxh.getTen()).isEqualTo(DEFAULT_TEN);
        assertThat(testDmCqBhxh.getDiaChi()).isEqualTo(DEFAULT_DIA_CHI);
        assertThat(testDmCqBhxh.getMaXa()).isEqualTo(DEFAULT_MA_XA);
        assertThat(testDmCqBhxh.getMaHuyen()).isEqualTo(DEFAULT_MA_HUYEN);
        assertThat(testDmCqBhxh.getMaTinh()).isEqualTo(DEFAULT_MA_TINH);
        assertThat(testDmCqBhxh.getEmailAcc()).isEqualTo(DEFAULT_EMAIL_ACC);
        assertThat(testDmCqBhxh.getPhoneNumeric()).isEqualTo(DEFAULT_PHONE_NUMERIC);
        assertThat(testDmCqBhxh.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testDmCqBhxh.getActiveDate()).isEqualTo(DEFAULT_ACTIVE_DATE);
        assertThat(testDmCqBhxh.getInactiveDate()).isEqualTo(DEFAULT_INACTIVE_DATE);
        assertThat(testDmCqBhxh.getMaCqbhCha()).isEqualTo(DEFAULT_MA_CQBH_CHA);
        assertThat(testDmCqBhxh.getNguoiKy()).isEqualTo(DEFAULT_NGUOI_KY);
        assertThat(testDmCqBhxh.getChucDanh()).isEqualTo(DEFAULT_CHUC_DANH);
        assertThat(testDmCqBhxh.getTenNoiKy()).isEqualTo(DEFAULT_TEN_NOI_KY);
        assertThat(testDmCqBhxh.getIsActive()).isEqualTo(DEFAULT_IS_ACTIVE);
        assertThat(testDmCqBhxh.getPath()).isEqualTo(DEFAULT_PATH);
        assertThat(testDmCqBhxh.getNgayKhoa()).isEqualTo(DEFAULT_NGAY_KHOA);
        assertThat(testDmCqBhxh.getSoQdTl()).isEqualTo(DEFAULT_SO_QD_TL);
        assertThat(testDmCqBhxh.getNgayQdTl()).isEqualTo(DEFAULT_NGAY_QD_TL);
        assertThat(testDmCqBhxh.getCqKyQd()).isEqualTo(DEFAULT_CQ_KY_QD);

        // Validate the DmCqBhxh in Elasticsearch
        verify(mockDmCqBhxhSearchRepository, times(1)).save(testDmCqBhxh);
    }

    @Test
    @Transactional
    public void createDmCqBhxhWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dmCqBhxhRepository.findAll().size();

        // Create the DmCqBhxh with an existing ID
        dmCqBhxh.setId(1L);
        DmCqBhxhDTO dmCqBhxhDTO = dmCqBhxhMapper.toDto(dmCqBhxh);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDmCqBhxhMockMvc.perform(post("/api/dm-cq-bhxhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqBhxhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DmCqBhxh in the database
        List<DmCqBhxh> dmCqBhxhList = dmCqBhxhRepository.findAll();
        assertThat(dmCqBhxhList).hasSize(databaseSizeBeforeCreate);

        // Validate the DmCqBhxh in Elasticsearch
        verify(mockDmCqBhxhSearchRepository, times(0)).save(dmCqBhxh);
    }


    @Test
    @Transactional
    public void checkMaCqbhIsRequired() throws Exception {
        int databaseSizeBeforeTest = dmCqBhxhRepository.findAll().size();
        // set the field null
        dmCqBhxh.setMaCqbh(null);

        // Create the DmCqBhxh, which fails.
        DmCqBhxhDTO dmCqBhxhDTO = dmCqBhxhMapper.toDto(dmCqBhxh);


        restDmCqBhxhMockMvc.perform(post("/api/dm-cq-bhxhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqBhxhDTO)))
            .andExpect(status().isBadRequest());

        List<DmCqBhxh> dmCqBhxhList = dmCqBhxhRepository.findAll();
        assertThat(dmCqBhxhList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhs() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList
        restDmCqBhxhMockMvc.perform(get("/api/dm-cq-bhxhs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dmCqBhxh.getId().intValue())))
            .andExpect(jsonPath("$.[*].maCqbh").value(hasItem(DEFAULT_MA_CQBH)))
            .andExpect(jsonPath("$.[*].ten").value(hasItem(DEFAULT_TEN)))
            .andExpect(jsonPath("$.[*].diaChi").value(hasItem(DEFAULT_DIA_CHI)))
            .andExpect(jsonPath("$.[*].maXa").value(hasItem(DEFAULT_MA_XA)))
            .andExpect(jsonPath("$.[*].maHuyen").value(hasItem(DEFAULT_MA_HUYEN)))
            .andExpect(jsonPath("$.[*].maTinh").value(hasItem(DEFAULT_MA_TINH)))
            .andExpect(jsonPath("$.[*].emailAcc").value(hasItem(DEFAULT_EMAIL_ACC)))
            .andExpect(jsonPath("$.[*].phoneNumeric").value(hasItem(DEFAULT_PHONE_NUMERIC)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].activeDate").value(hasItem(DEFAULT_ACTIVE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].maCqbhCha").value(hasItem(DEFAULT_MA_CQBH_CHA)))
            .andExpect(jsonPath("$.[*].nguoiKy").value(hasItem(DEFAULT_NGUOI_KY)))
            .andExpect(jsonPath("$.[*].chucDanh").value(hasItem(DEFAULT_CHUC_DANH)))
            .andExpect(jsonPath("$.[*].tenNoiKy").value(hasItem(DEFAULT_TEN_NOI_KY)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE.intValue())))
            .andExpect(jsonPath("$.[*].path").value(hasItem(DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].ngayKhoa").value(hasItem(DEFAULT_NGAY_KHOA.intValue())))
            .andExpect(jsonPath("$.[*].soQdTl").value(hasItem(DEFAULT_SO_QD_TL)))
            .andExpect(jsonPath("$.[*].ngayQdTl").value(hasItem(DEFAULT_NGAY_QD_TL.intValue())))
            .andExpect(jsonPath("$.[*].cqKyQd").value(hasItem(DEFAULT_CQ_KY_QD)));
    }
    
    @Test
    @Transactional
    public void getDmCqBhxh() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get the dmCqBhxh
        restDmCqBhxhMockMvc.perform(get("/api/dm-cq-bhxhs/{id}", dmCqBhxh.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dmCqBhxh.getId().intValue()))
            .andExpect(jsonPath("$.maCqbh").value(DEFAULT_MA_CQBH))
            .andExpect(jsonPath("$.ten").value(DEFAULT_TEN))
            .andExpect(jsonPath("$.diaChi").value(DEFAULT_DIA_CHI))
            .andExpect(jsonPath("$.maXa").value(DEFAULT_MA_XA))
            .andExpect(jsonPath("$.maHuyen").value(DEFAULT_MA_HUYEN))
            .andExpect(jsonPath("$.maTinh").value(DEFAULT_MA_TINH))
            .andExpect(jsonPath("$.emailAcc").value(DEFAULT_EMAIL_ACC))
            .andExpect(jsonPath("$.phoneNumeric").value(DEFAULT_PHONE_NUMERIC))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.activeDate").value(DEFAULT_ACTIVE_DATE.intValue()))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.intValue()))
            .andExpect(jsonPath("$.maCqbhCha").value(DEFAULT_MA_CQBH_CHA))
            .andExpect(jsonPath("$.nguoiKy").value(DEFAULT_NGUOI_KY))
            .andExpect(jsonPath("$.chucDanh").value(DEFAULT_CHUC_DANH))
            .andExpect(jsonPath("$.tenNoiKy").value(DEFAULT_TEN_NOI_KY))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE.intValue()))
            .andExpect(jsonPath("$.path").value(DEFAULT_PATH))
            .andExpect(jsonPath("$.ngayKhoa").value(DEFAULT_NGAY_KHOA.intValue()))
            .andExpect(jsonPath("$.soQdTl").value(DEFAULT_SO_QD_TL))
            .andExpect(jsonPath("$.ngayQdTl").value(DEFAULT_NGAY_QD_TL.intValue()))
            .andExpect(jsonPath("$.cqKyQd").value(DEFAULT_CQ_KY_QD));
    }


    @Test
    @Transactional
    public void getDmCqBhxhsByIdFiltering() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        Long id = dmCqBhxh.getId();

        defaultDmCqBhxhShouldBeFound("id.equals=" + id);
        defaultDmCqBhxhShouldNotBeFound("id.notEquals=" + id);

        defaultDmCqBhxhShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultDmCqBhxhShouldNotBeFound("id.greaterThan=" + id);

        defaultDmCqBhxhShouldBeFound("id.lessThanOrEqual=" + id);
        defaultDmCqBhxhShouldNotBeFound("id.lessThan=" + id);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbh equals to DEFAULT_MA_CQBH
        defaultDmCqBhxhShouldBeFound("maCqbh.equals=" + DEFAULT_MA_CQBH);

        // Get all the dmCqBhxhList where maCqbh equals to UPDATED_MA_CQBH
        defaultDmCqBhxhShouldNotBeFound("maCqbh.equals=" + UPDATED_MA_CQBH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbh not equals to DEFAULT_MA_CQBH
        defaultDmCqBhxhShouldNotBeFound("maCqbh.notEquals=" + DEFAULT_MA_CQBH);

        // Get all the dmCqBhxhList where maCqbh not equals to UPDATED_MA_CQBH
        defaultDmCqBhxhShouldBeFound("maCqbh.notEquals=" + UPDATED_MA_CQBH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbh in DEFAULT_MA_CQBH or UPDATED_MA_CQBH
        defaultDmCqBhxhShouldBeFound("maCqbh.in=" + DEFAULT_MA_CQBH + "," + UPDATED_MA_CQBH);

        // Get all the dmCqBhxhList where maCqbh equals to UPDATED_MA_CQBH
        defaultDmCqBhxhShouldNotBeFound("maCqbh.in=" + UPDATED_MA_CQBH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbh is not null
        defaultDmCqBhxhShouldBeFound("maCqbh.specified=true");

        // Get all the dmCqBhxhList where maCqbh is null
        defaultDmCqBhxhShouldNotBeFound("maCqbh.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbh contains DEFAULT_MA_CQBH
        defaultDmCqBhxhShouldBeFound("maCqbh.contains=" + DEFAULT_MA_CQBH);

        // Get all the dmCqBhxhList where maCqbh contains UPDATED_MA_CQBH
        defaultDmCqBhxhShouldNotBeFound("maCqbh.contains=" + UPDATED_MA_CQBH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbh does not contain DEFAULT_MA_CQBH
        defaultDmCqBhxhShouldNotBeFound("maCqbh.doesNotContain=" + DEFAULT_MA_CQBH);

        // Get all the dmCqBhxhList where maCqbh does not contain UPDATED_MA_CQBH
        defaultDmCqBhxhShouldBeFound("maCqbh.doesNotContain=" + UPDATED_MA_CQBH);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ten equals to DEFAULT_TEN
        defaultDmCqBhxhShouldBeFound("ten.equals=" + DEFAULT_TEN);

        // Get all the dmCqBhxhList where ten equals to UPDATED_TEN
        defaultDmCqBhxhShouldNotBeFound("ten.equals=" + UPDATED_TEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ten not equals to DEFAULT_TEN
        defaultDmCqBhxhShouldNotBeFound("ten.notEquals=" + DEFAULT_TEN);

        // Get all the dmCqBhxhList where ten not equals to UPDATED_TEN
        defaultDmCqBhxhShouldBeFound("ten.notEquals=" + UPDATED_TEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ten in DEFAULT_TEN or UPDATED_TEN
        defaultDmCqBhxhShouldBeFound("ten.in=" + DEFAULT_TEN + "," + UPDATED_TEN);

        // Get all the dmCqBhxhList where ten equals to UPDATED_TEN
        defaultDmCqBhxhShouldNotBeFound("ten.in=" + UPDATED_TEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ten is not null
        defaultDmCqBhxhShouldBeFound("ten.specified=true");

        // Get all the dmCqBhxhList where ten is null
        defaultDmCqBhxhShouldNotBeFound("ten.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByTenContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ten contains DEFAULT_TEN
        defaultDmCqBhxhShouldBeFound("ten.contains=" + DEFAULT_TEN);

        // Get all the dmCqBhxhList where ten contains UPDATED_TEN
        defaultDmCqBhxhShouldNotBeFound("ten.contains=" + UPDATED_TEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ten does not contain DEFAULT_TEN
        defaultDmCqBhxhShouldNotBeFound("ten.doesNotContain=" + DEFAULT_TEN);

        // Get all the dmCqBhxhList where ten does not contain UPDATED_TEN
        defaultDmCqBhxhShouldBeFound("ten.doesNotContain=" + UPDATED_TEN);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByDiaChiIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where diaChi equals to DEFAULT_DIA_CHI
        defaultDmCqBhxhShouldBeFound("diaChi.equals=" + DEFAULT_DIA_CHI);

        // Get all the dmCqBhxhList where diaChi equals to UPDATED_DIA_CHI
        defaultDmCqBhxhShouldNotBeFound("diaChi.equals=" + UPDATED_DIA_CHI);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByDiaChiIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where diaChi not equals to DEFAULT_DIA_CHI
        defaultDmCqBhxhShouldNotBeFound("diaChi.notEquals=" + DEFAULT_DIA_CHI);

        // Get all the dmCqBhxhList where diaChi not equals to UPDATED_DIA_CHI
        defaultDmCqBhxhShouldBeFound("diaChi.notEquals=" + UPDATED_DIA_CHI);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByDiaChiIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where diaChi in DEFAULT_DIA_CHI or UPDATED_DIA_CHI
        defaultDmCqBhxhShouldBeFound("diaChi.in=" + DEFAULT_DIA_CHI + "," + UPDATED_DIA_CHI);

        // Get all the dmCqBhxhList where diaChi equals to UPDATED_DIA_CHI
        defaultDmCqBhxhShouldNotBeFound("diaChi.in=" + UPDATED_DIA_CHI);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByDiaChiIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where diaChi is not null
        defaultDmCqBhxhShouldBeFound("diaChi.specified=true");

        // Get all the dmCqBhxhList where diaChi is null
        defaultDmCqBhxhShouldNotBeFound("diaChi.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByDiaChiContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where diaChi contains DEFAULT_DIA_CHI
        defaultDmCqBhxhShouldBeFound("diaChi.contains=" + DEFAULT_DIA_CHI);

        // Get all the dmCqBhxhList where diaChi contains UPDATED_DIA_CHI
        defaultDmCqBhxhShouldNotBeFound("diaChi.contains=" + UPDATED_DIA_CHI);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByDiaChiNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where diaChi does not contain DEFAULT_DIA_CHI
        defaultDmCqBhxhShouldNotBeFound("diaChi.doesNotContain=" + DEFAULT_DIA_CHI);

        // Get all the dmCqBhxhList where diaChi does not contain UPDATED_DIA_CHI
        defaultDmCqBhxhShouldBeFound("diaChi.doesNotContain=" + UPDATED_DIA_CHI);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaXaIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maXa equals to DEFAULT_MA_XA
        defaultDmCqBhxhShouldBeFound("maXa.equals=" + DEFAULT_MA_XA);

        // Get all the dmCqBhxhList where maXa equals to UPDATED_MA_XA
        defaultDmCqBhxhShouldNotBeFound("maXa.equals=" + UPDATED_MA_XA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaXaIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maXa not equals to DEFAULT_MA_XA
        defaultDmCqBhxhShouldNotBeFound("maXa.notEquals=" + DEFAULT_MA_XA);

        // Get all the dmCqBhxhList where maXa not equals to UPDATED_MA_XA
        defaultDmCqBhxhShouldBeFound("maXa.notEquals=" + UPDATED_MA_XA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaXaIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maXa in DEFAULT_MA_XA or UPDATED_MA_XA
        defaultDmCqBhxhShouldBeFound("maXa.in=" + DEFAULT_MA_XA + "," + UPDATED_MA_XA);

        // Get all the dmCqBhxhList where maXa equals to UPDATED_MA_XA
        defaultDmCqBhxhShouldNotBeFound("maXa.in=" + UPDATED_MA_XA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaXaIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maXa is not null
        defaultDmCqBhxhShouldBeFound("maXa.specified=true");

        // Get all the dmCqBhxhList where maXa is null
        defaultDmCqBhxhShouldNotBeFound("maXa.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByMaXaContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maXa contains DEFAULT_MA_XA
        defaultDmCqBhxhShouldBeFound("maXa.contains=" + DEFAULT_MA_XA);

        // Get all the dmCqBhxhList where maXa contains UPDATED_MA_XA
        defaultDmCqBhxhShouldNotBeFound("maXa.contains=" + UPDATED_MA_XA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaXaNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maXa does not contain DEFAULT_MA_XA
        defaultDmCqBhxhShouldNotBeFound("maXa.doesNotContain=" + DEFAULT_MA_XA);

        // Get all the dmCqBhxhList where maXa does not contain UPDATED_MA_XA
        defaultDmCqBhxhShouldBeFound("maXa.doesNotContain=" + UPDATED_MA_XA);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaHuyenIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maHuyen equals to DEFAULT_MA_HUYEN
        defaultDmCqBhxhShouldBeFound("maHuyen.equals=" + DEFAULT_MA_HUYEN);

        // Get all the dmCqBhxhList where maHuyen equals to UPDATED_MA_HUYEN
        defaultDmCqBhxhShouldNotBeFound("maHuyen.equals=" + UPDATED_MA_HUYEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaHuyenIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maHuyen not equals to DEFAULT_MA_HUYEN
        defaultDmCqBhxhShouldNotBeFound("maHuyen.notEquals=" + DEFAULT_MA_HUYEN);

        // Get all the dmCqBhxhList where maHuyen not equals to UPDATED_MA_HUYEN
        defaultDmCqBhxhShouldBeFound("maHuyen.notEquals=" + UPDATED_MA_HUYEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaHuyenIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maHuyen in DEFAULT_MA_HUYEN or UPDATED_MA_HUYEN
        defaultDmCqBhxhShouldBeFound("maHuyen.in=" + DEFAULT_MA_HUYEN + "," + UPDATED_MA_HUYEN);

        // Get all the dmCqBhxhList where maHuyen equals to UPDATED_MA_HUYEN
        defaultDmCqBhxhShouldNotBeFound("maHuyen.in=" + UPDATED_MA_HUYEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaHuyenIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maHuyen is not null
        defaultDmCqBhxhShouldBeFound("maHuyen.specified=true");

        // Get all the dmCqBhxhList where maHuyen is null
        defaultDmCqBhxhShouldNotBeFound("maHuyen.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByMaHuyenContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maHuyen contains DEFAULT_MA_HUYEN
        defaultDmCqBhxhShouldBeFound("maHuyen.contains=" + DEFAULT_MA_HUYEN);

        // Get all the dmCqBhxhList where maHuyen contains UPDATED_MA_HUYEN
        defaultDmCqBhxhShouldNotBeFound("maHuyen.contains=" + UPDATED_MA_HUYEN);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaHuyenNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maHuyen does not contain DEFAULT_MA_HUYEN
        defaultDmCqBhxhShouldNotBeFound("maHuyen.doesNotContain=" + DEFAULT_MA_HUYEN);

        // Get all the dmCqBhxhList where maHuyen does not contain UPDATED_MA_HUYEN
        defaultDmCqBhxhShouldBeFound("maHuyen.doesNotContain=" + UPDATED_MA_HUYEN);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaTinhIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maTinh equals to DEFAULT_MA_TINH
        defaultDmCqBhxhShouldBeFound("maTinh.equals=" + DEFAULT_MA_TINH);

        // Get all the dmCqBhxhList where maTinh equals to UPDATED_MA_TINH
        defaultDmCqBhxhShouldNotBeFound("maTinh.equals=" + UPDATED_MA_TINH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaTinhIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maTinh not equals to DEFAULT_MA_TINH
        defaultDmCqBhxhShouldNotBeFound("maTinh.notEquals=" + DEFAULT_MA_TINH);

        // Get all the dmCqBhxhList where maTinh not equals to UPDATED_MA_TINH
        defaultDmCqBhxhShouldBeFound("maTinh.notEquals=" + UPDATED_MA_TINH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaTinhIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maTinh in DEFAULT_MA_TINH or UPDATED_MA_TINH
        defaultDmCqBhxhShouldBeFound("maTinh.in=" + DEFAULT_MA_TINH + "," + UPDATED_MA_TINH);

        // Get all the dmCqBhxhList where maTinh equals to UPDATED_MA_TINH
        defaultDmCqBhxhShouldNotBeFound("maTinh.in=" + UPDATED_MA_TINH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaTinhIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maTinh is not null
        defaultDmCqBhxhShouldBeFound("maTinh.specified=true");

        // Get all the dmCqBhxhList where maTinh is null
        defaultDmCqBhxhShouldNotBeFound("maTinh.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByMaTinhContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maTinh contains DEFAULT_MA_TINH
        defaultDmCqBhxhShouldBeFound("maTinh.contains=" + DEFAULT_MA_TINH);

        // Get all the dmCqBhxhList where maTinh contains UPDATED_MA_TINH
        defaultDmCqBhxhShouldNotBeFound("maTinh.contains=" + UPDATED_MA_TINH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaTinhNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maTinh does not contain DEFAULT_MA_TINH
        defaultDmCqBhxhShouldNotBeFound("maTinh.doesNotContain=" + DEFAULT_MA_TINH);

        // Get all the dmCqBhxhList where maTinh does not contain UPDATED_MA_TINH
        defaultDmCqBhxhShouldBeFound("maTinh.doesNotContain=" + UPDATED_MA_TINH);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByEmailAccIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where emailAcc equals to DEFAULT_EMAIL_ACC
        defaultDmCqBhxhShouldBeFound("emailAcc.equals=" + DEFAULT_EMAIL_ACC);

        // Get all the dmCqBhxhList where emailAcc equals to UPDATED_EMAIL_ACC
        defaultDmCqBhxhShouldNotBeFound("emailAcc.equals=" + UPDATED_EMAIL_ACC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByEmailAccIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where emailAcc not equals to DEFAULT_EMAIL_ACC
        defaultDmCqBhxhShouldNotBeFound("emailAcc.notEquals=" + DEFAULT_EMAIL_ACC);

        // Get all the dmCqBhxhList where emailAcc not equals to UPDATED_EMAIL_ACC
        defaultDmCqBhxhShouldBeFound("emailAcc.notEquals=" + UPDATED_EMAIL_ACC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByEmailAccIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where emailAcc in DEFAULT_EMAIL_ACC or UPDATED_EMAIL_ACC
        defaultDmCqBhxhShouldBeFound("emailAcc.in=" + DEFAULT_EMAIL_ACC + "," + UPDATED_EMAIL_ACC);

        // Get all the dmCqBhxhList where emailAcc equals to UPDATED_EMAIL_ACC
        defaultDmCqBhxhShouldNotBeFound("emailAcc.in=" + UPDATED_EMAIL_ACC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByEmailAccIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where emailAcc is not null
        defaultDmCqBhxhShouldBeFound("emailAcc.specified=true");

        // Get all the dmCqBhxhList where emailAcc is null
        defaultDmCqBhxhShouldNotBeFound("emailAcc.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByEmailAccContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where emailAcc contains DEFAULT_EMAIL_ACC
        defaultDmCqBhxhShouldBeFound("emailAcc.contains=" + DEFAULT_EMAIL_ACC);

        // Get all the dmCqBhxhList where emailAcc contains UPDATED_EMAIL_ACC
        defaultDmCqBhxhShouldNotBeFound("emailAcc.contains=" + UPDATED_EMAIL_ACC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByEmailAccNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where emailAcc does not contain DEFAULT_EMAIL_ACC
        defaultDmCqBhxhShouldNotBeFound("emailAcc.doesNotContain=" + DEFAULT_EMAIL_ACC);

        // Get all the dmCqBhxhList where emailAcc does not contain UPDATED_EMAIL_ACC
        defaultDmCqBhxhShouldBeFound("emailAcc.doesNotContain=" + UPDATED_EMAIL_ACC);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByPhoneNumericIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where phoneNumeric equals to DEFAULT_PHONE_NUMERIC
        defaultDmCqBhxhShouldBeFound("phoneNumeric.equals=" + DEFAULT_PHONE_NUMERIC);

        // Get all the dmCqBhxhList where phoneNumeric equals to UPDATED_PHONE_NUMERIC
        defaultDmCqBhxhShouldNotBeFound("phoneNumeric.equals=" + UPDATED_PHONE_NUMERIC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPhoneNumericIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where phoneNumeric not equals to DEFAULT_PHONE_NUMERIC
        defaultDmCqBhxhShouldNotBeFound("phoneNumeric.notEquals=" + DEFAULT_PHONE_NUMERIC);

        // Get all the dmCqBhxhList where phoneNumeric not equals to UPDATED_PHONE_NUMERIC
        defaultDmCqBhxhShouldBeFound("phoneNumeric.notEquals=" + UPDATED_PHONE_NUMERIC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPhoneNumericIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where phoneNumeric in DEFAULT_PHONE_NUMERIC or UPDATED_PHONE_NUMERIC
        defaultDmCqBhxhShouldBeFound("phoneNumeric.in=" + DEFAULT_PHONE_NUMERIC + "," + UPDATED_PHONE_NUMERIC);

        // Get all the dmCqBhxhList where phoneNumeric equals to UPDATED_PHONE_NUMERIC
        defaultDmCqBhxhShouldNotBeFound("phoneNumeric.in=" + UPDATED_PHONE_NUMERIC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPhoneNumericIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where phoneNumeric is not null
        defaultDmCqBhxhShouldBeFound("phoneNumeric.specified=true");

        // Get all the dmCqBhxhList where phoneNumeric is null
        defaultDmCqBhxhShouldNotBeFound("phoneNumeric.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByPhoneNumericContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where phoneNumeric contains DEFAULT_PHONE_NUMERIC
        defaultDmCqBhxhShouldBeFound("phoneNumeric.contains=" + DEFAULT_PHONE_NUMERIC);

        // Get all the dmCqBhxhList where phoneNumeric contains UPDATED_PHONE_NUMERIC
        defaultDmCqBhxhShouldNotBeFound("phoneNumeric.contains=" + UPDATED_PHONE_NUMERIC);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPhoneNumericNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where phoneNumeric does not contain DEFAULT_PHONE_NUMERIC
        defaultDmCqBhxhShouldNotBeFound("phoneNumeric.doesNotContain=" + DEFAULT_PHONE_NUMERIC);

        // Get all the dmCqBhxhList where phoneNumeric does not contain UPDATED_PHONE_NUMERIC
        defaultDmCqBhxhShouldBeFound("phoneNumeric.doesNotContain=" + UPDATED_PHONE_NUMERIC);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByStatusIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where status equals to DEFAULT_STATUS
        defaultDmCqBhxhShouldBeFound("status.equals=" + DEFAULT_STATUS);

        // Get all the dmCqBhxhList where status equals to UPDATED_STATUS
        defaultDmCqBhxhShouldNotBeFound("status.equals=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByStatusIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where status not equals to DEFAULT_STATUS
        defaultDmCqBhxhShouldNotBeFound("status.notEquals=" + DEFAULT_STATUS);

        // Get all the dmCqBhxhList where status not equals to UPDATED_STATUS
        defaultDmCqBhxhShouldBeFound("status.notEquals=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByStatusIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where status in DEFAULT_STATUS or UPDATED_STATUS
        defaultDmCqBhxhShouldBeFound("status.in=" + DEFAULT_STATUS + "," + UPDATED_STATUS);

        // Get all the dmCqBhxhList where status equals to UPDATED_STATUS
        defaultDmCqBhxhShouldNotBeFound("status.in=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByStatusIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where status is not null
        defaultDmCqBhxhShouldBeFound("status.specified=true");

        // Get all the dmCqBhxhList where status is null
        defaultDmCqBhxhShouldNotBeFound("status.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByStatusContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where status contains DEFAULT_STATUS
        defaultDmCqBhxhShouldBeFound("status.contains=" + DEFAULT_STATUS);

        // Get all the dmCqBhxhList where status contains UPDATED_STATUS
        defaultDmCqBhxhShouldNotBeFound("status.contains=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByStatusNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where status does not contain DEFAULT_STATUS
        defaultDmCqBhxhShouldNotBeFound("status.doesNotContain=" + DEFAULT_STATUS);

        // Get all the dmCqBhxhList where status does not contain UPDATED_STATUS
        defaultDmCqBhxhShouldBeFound("status.doesNotContain=" + UPDATED_STATUS);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate equals to DEFAULT_ACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("activeDate.equals=" + DEFAULT_ACTIVE_DATE);

        // Get all the dmCqBhxhList where activeDate equals to UPDATED_ACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("activeDate.equals=" + UPDATED_ACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate not equals to DEFAULT_ACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("activeDate.notEquals=" + DEFAULT_ACTIVE_DATE);

        // Get all the dmCqBhxhList where activeDate not equals to UPDATED_ACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("activeDate.notEquals=" + UPDATED_ACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate in DEFAULT_ACTIVE_DATE or UPDATED_ACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("activeDate.in=" + DEFAULT_ACTIVE_DATE + "," + UPDATED_ACTIVE_DATE);

        // Get all the dmCqBhxhList where activeDate equals to UPDATED_ACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("activeDate.in=" + UPDATED_ACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate is not null
        defaultDmCqBhxhShouldBeFound("activeDate.specified=true");

        // Get all the dmCqBhxhList where activeDate is null
        defaultDmCqBhxhShouldNotBeFound("activeDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate is greater than or equal to DEFAULT_ACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("activeDate.greaterThanOrEqual=" + DEFAULT_ACTIVE_DATE);

        // Get all the dmCqBhxhList where activeDate is greater than or equal to UPDATED_ACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("activeDate.greaterThanOrEqual=" + UPDATED_ACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate is less than or equal to DEFAULT_ACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("activeDate.lessThanOrEqual=" + DEFAULT_ACTIVE_DATE);

        // Get all the dmCqBhxhList where activeDate is less than or equal to SMALLER_ACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("activeDate.lessThanOrEqual=" + SMALLER_ACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsLessThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate is less than DEFAULT_ACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("activeDate.lessThan=" + DEFAULT_ACTIVE_DATE);

        // Get all the dmCqBhxhList where activeDate is less than UPDATED_ACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("activeDate.lessThan=" + UPDATED_ACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByActiveDateIsGreaterThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where activeDate is greater than DEFAULT_ACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("activeDate.greaterThan=" + DEFAULT_ACTIVE_DATE);

        // Get all the dmCqBhxhList where activeDate is greater than SMALLER_ACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("activeDate.greaterThan=" + SMALLER_ACTIVE_DATE);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate equals to DEFAULT_INACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("inactiveDate.equals=" + DEFAULT_INACTIVE_DATE);

        // Get all the dmCqBhxhList where inactiveDate equals to UPDATED_INACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.equals=" + UPDATED_INACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate not equals to DEFAULT_INACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.notEquals=" + DEFAULT_INACTIVE_DATE);

        // Get all the dmCqBhxhList where inactiveDate not equals to UPDATED_INACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("inactiveDate.notEquals=" + UPDATED_INACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate in DEFAULT_INACTIVE_DATE or UPDATED_INACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("inactiveDate.in=" + DEFAULT_INACTIVE_DATE + "," + UPDATED_INACTIVE_DATE);

        // Get all the dmCqBhxhList where inactiveDate equals to UPDATED_INACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.in=" + UPDATED_INACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate is not null
        defaultDmCqBhxhShouldBeFound("inactiveDate.specified=true");

        // Get all the dmCqBhxhList where inactiveDate is null
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate is greater than or equal to DEFAULT_INACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("inactiveDate.greaterThanOrEqual=" + DEFAULT_INACTIVE_DATE);

        // Get all the dmCqBhxhList where inactiveDate is greater than or equal to UPDATED_INACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.greaterThanOrEqual=" + UPDATED_INACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate is less than or equal to DEFAULT_INACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("inactiveDate.lessThanOrEqual=" + DEFAULT_INACTIVE_DATE);

        // Get all the dmCqBhxhList where inactiveDate is less than or equal to SMALLER_INACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.lessThanOrEqual=" + SMALLER_INACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsLessThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate is less than DEFAULT_INACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.lessThan=" + DEFAULT_INACTIVE_DATE);

        // Get all the dmCqBhxhList where inactiveDate is less than UPDATED_INACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("inactiveDate.lessThan=" + UPDATED_INACTIVE_DATE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByInactiveDateIsGreaterThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where inactiveDate is greater than DEFAULT_INACTIVE_DATE
        defaultDmCqBhxhShouldNotBeFound("inactiveDate.greaterThan=" + DEFAULT_INACTIVE_DATE);

        // Get all the dmCqBhxhList where inactiveDate is greater than SMALLER_INACTIVE_DATE
        defaultDmCqBhxhShouldBeFound("inactiveDate.greaterThan=" + SMALLER_INACTIVE_DATE);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhChaIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbhCha equals to DEFAULT_MA_CQBH_CHA
        defaultDmCqBhxhShouldBeFound("maCqbhCha.equals=" + DEFAULT_MA_CQBH_CHA);

        // Get all the dmCqBhxhList where maCqbhCha equals to UPDATED_MA_CQBH_CHA
        defaultDmCqBhxhShouldNotBeFound("maCqbhCha.equals=" + UPDATED_MA_CQBH_CHA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhChaIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbhCha not equals to DEFAULT_MA_CQBH_CHA
        defaultDmCqBhxhShouldNotBeFound("maCqbhCha.notEquals=" + DEFAULT_MA_CQBH_CHA);

        // Get all the dmCqBhxhList where maCqbhCha not equals to UPDATED_MA_CQBH_CHA
        defaultDmCqBhxhShouldBeFound("maCqbhCha.notEquals=" + UPDATED_MA_CQBH_CHA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhChaIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbhCha in DEFAULT_MA_CQBH_CHA or UPDATED_MA_CQBH_CHA
        defaultDmCqBhxhShouldBeFound("maCqbhCha.in=" + DEFAULT_MA_CQBH_CHA + "," + UPDATED_MA_CQBH_CHA);

        // Get all the dmCqBhxhList where maCqbhCha equals to UPDATED_MA_CQBH_CHA
        defaultDmCqBhxhShouldNotBeFound("maCqbhCha.in=" + UPDATED_MA_CQBH_CHA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhChaIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbhCha is not null
        defaultDmCqBhxhShouldBeFound("maCqbhCha.specified=true");

        // Get all the dmCqBhxhList where maCqbhCha is null
        defaultDmCqBhxhShouldNotBeFound("maCqbhCha.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhChaContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbhCha contains DEFAULT_MA_CQBH_CHA
        defaultDmCqBhxhShouldBeFound("maCqbhCha.contains=" + DEFAULT_MA_CQBH_CHA);

        // Get all the dmCqBhxhList where maCqbhCha contains UPDATED_MA_CQBH_CHA
        defaultDmCqBhxhShouldNotBeFound("maCqbhCha.contains=" + UPDATED_MA_CQBH_CHA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByMaCqbhChaNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where maCqbhCha does not contain DEFAULT_MA_CQBH_CHA
        defaultDmCqBhxhShouldNotBeFound("maCqbhCha.doesNotContain=" + DEFAULT_MA_CQBH_CHA);

        // Get all the dmCqBhxhList where maCqbhCha does not contain UPDATED_MA_CQBH_CHA
        defaultDmCqBhxhShouldBeFound("maCqbhCha.doesNotContain=" + UPDATED_MA_CQBH_CHA);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByNguoiKyIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where nguoiKy equals to DEFAULT_NGUOI_KY
        defaultDmCqBhxhShouldBeFound("nguoiKy.equals=" + DEFAULT_NGUOI_KY);

        // Get all the dmCqBhxhList where nguoiKy equals to UPDATED_NGUOI_KY
        defaultDmCqBhxhShouldNotBeFound("nguoiKy.equals=" + UPDATED_NGUOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNguoiKyIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where nguoiKy not equals to DEFAULT_NGUOI_KY
        defaultDmCqBhxhShouldNotBeFound("nguoiKy.notEquals=" + DEFAULT_NGUOI_KY);

        // Get all the dmCqBhxhList where nguoiKy not equals to UPDATED_NGUOI_KY
        defaultDmCqBhxhShouldBeFound("nguoiKy.notEquals=" + UPDATED_NGUOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNguoiKyIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where nguoiKy in DEFAULT_NGUOI_KY or UPDATED_NGUOI_KY
        defaultDmCqBhxhShouldBeFound("nguoiKy.in=" + DEFAULT_NGUOI_KY + "," + UPDATED_NGUOI_KY);

        // Get all the dmCqBhxhList where nguoiKy equals to UPDATED_NGUOI_KY
        defaultDmCqBhxhShouldNotBeFound("nguoiKy.in=" + UPDATED_NGUOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNguoiKyIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where nguoiKy is not null
        defaultDmCqBhxhShouldBeFound("nguoiKy.specified=true");

        // Get all the dmCqBhxhList where nguoiKy is null
        defaultDmCqBhxhShouldNotBeFound("nguoiKy.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByNguoiKyContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where nguoiKy contains DEFAULT_NGUOI_KY
        defaultDmCqBhxhShouldBeFound("nguoiKy.contains=" + DEFAULT_NGUOI_KY);

        // Get all the dmCqBhxhList where nguoiKy contains UPDATED_NGUOI_KY
        defaultDmCqBhxhShouldNotBeFound("nguoiKy.contains=" + UPDATED_NGUOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNguoiKyNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where nguoiKy does not contain DEFAULT_NGUOI_KY
        defaultDmCqBhxhShouldNotBeFound("nguoiKy.doesNotContain=" + DEFAULT_NGUOI_KY);

        // Get all the dmCqBhxhList where nguoiKy does not contain UPDATED_NGUOI_KY
        defaultDmCqBhxhShouldBeFound("nguoiKy.doesNotContain=" + UPDATED_NGUOI_KY);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByChucDanhIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where chucDanh equals to DEFAULT_CHUC_DANH
        defaultDmCqBhxhShouldBeFound("chucDanh.equals=" + DEFAULT_CHUC_DANH);

        // Get all the dmCqBhxhList where chucDanh equals to UPDATED_CHUC_DANH
        defaultDmCqBhxhShouldNotBeFound("chucDanh.equals=" + UPDATED_CHUC_DANH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByChucDanhIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where chucDanh not equals to DEFAULT_CHUC_DANH
        defaultDmCqBhxhShouldNotBeFound("chucDanh.notEquals=" + DEFAULT_CHUC_DANH);

        // Get all the dmCqBhxhList where chucDanh not equals to UPDATED_CHUC_DANH
        defaultDmCqBhxhShouldBeFound("chucDanh.notEquals=" + UPDATED_CHUC_DANH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByChucDanhIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where chucDanh in DEFAULT_CHUC_DANH or UPDATED_CHUC_DANH
        defaultDmCqBhxhShouldBeFound("chucDanh.in=" + DEFAULT_CHUC_DANH + "," + UPDATED_CHUC_DANH);

        // Get all the dmCqBhxhList where chucDanh equals to UPDATED_CHUC_DANH
        defaultDmCqBhxhShouldNotBeFound("chucDanh.in=" + UPDATED_CHUC_DANH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByChucDanhIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where chucDanh is not null
        defaultDmCqBhxhShouldBeFound("chucDanh.specified=true");

        // Get all the dmCqBhxhList where chucDanh is null
        defaultDmCqBhxhShouldNotBeFound("chucDanh.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByChucDanhContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where chucDanh contains DEFAULT_CHUC_DANH
        defaultDmCqBhxhShouldBeFound("chucDanh.contains=" + DEFAULT_CHUC_DANH);

        // Get all the dmCqBhxhList where chucDanh contains UPDATED_CHUC_DANH
        defaultDmCqBhxhShouldNotBeFound("chucDanh.contains=" + UPDATED_CHUC_DANH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByChucDanhNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where chucDanh does not contain DEFAULT_CHUC_DANH
        defaultDmCqBhxhShouldNotBeFound("chucDanh.doesNotContain=" + DEFAULT_CHUC_DANH);

        // Get all the dmCqBhxhList where chucDanh does not contain UPDATED_CHUC_DANH
        defaultDmCqBhxhShouldBeFound("chucDanh.doesNotContain=" + UPDATED_CHUC_DANH);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenNoiKyIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where tenNoiKy equals to DEFAULT_TEN_NOI_KY
        defaultDmCqBhxhShouldBeFound("tenNoiKy.equals=" + DEFAULT_TEN_NOI_KY);

        // Get all the dmCqBhxhList where tenNoiKy equals to UPDATED_TEN_NOI_KY
        defaultDmCqBhxhShouldNotBeFound("tenNoiKy.equals=" + UPDATED_TEN_NOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenNoiKyIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where tenNoiKy not equals to DEFAULT_TEN_NOI_KY
        defaultDmCqBhxhShouldNotBeFound("tenNoiKy.notEquals=" + DEFAULT_TEN_NOI_KY);

        // Get all the dmCqBhxhList where tenNoiKy not equals to UPDATED_TEN_NOI_KY
        defaultDmCqBhxhShouldBeFound("tenNoiKy.notEquals=" + UPDATED_TEN_NOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenNoiKyIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where tenNoiKy in DEFAULT_TEN_NOI_KY or UPDATED_TEN_NOI_KY
        defaultDmCqBhxhShouldBeFound("tenNoiKy.in=" + DEFAULT_TEN_NOI_KY + "," + UPDATED_TEN_NOI_KY);

        // Get all the dmCqBhxhList where tenNoiKy equals to UPDATED_TEN_NOI_KY
        defaultDmCqBhxhShouldNotBeFound("tenNoiKy.in=" + UPDATED_TEN_NOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenNoiKyIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where tenNoiKy is not null
        defaultDmCqBhxhShouldBeFound("tenNoiKy.specified=true");

        // Get all the dmCqBhxhList where tenNoiKy is null
        defaultDmCqBhxhShouldNotBeFound("tenNoiKy.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByTenNoiKyContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where tenNoiKy contains DEFAULT_TEN_NOI_KY
        defaultDmCqBhxhShouldBeFound("tenNoiKy.contains=" + DEFAULT_TEN_NOI_KY);

        // Get all the dmCqBhxhList where tenNoiKy contains UPDATED_TEN_NOI_KY
        defaultDmCqBhxhShouldNotBeFound("tenNoiKy.contains=" + UPDATED_TEN_NOI_KY);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByTenNoiKyNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where tenNoiKy does not contain DEFAULT_TEN_NOI_KY
        defaultDmCqBhxhShouldNotBeFound("tenNoiKy.doesNotContain=" + DEFAULT_TEN_NOI_KY);

        // Get all the dmCqBhxhList where tenNoiKy does not contain UPDATED_TEN_NOI_KY
        defaultDmCqBhxhShouldBeFound("tenNoiKy.doesNotContain=" + UPDATED_TEN_NOI_KY);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive equals to DEFAULT_IS_ACTIVE
        defaultDmCqBhxhShouldBeFound("isActive.equals=" + DEFAULT_IS_ACTIVE);

        // Get all the dmCqBhxhList where isActive equals to UPDATED_IS_ACTIVE
        defaultDmCqBhxhShouldNotBeFound("isActive.equals=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive not equals to DEFAULT_IS_ACTIVE
        defaultDmCqBhxhShouldNotBeFound("isActive.notEquals=" + DEFAULT_IS_ACTIVE);

        // Get all the dmCqBhxhList where isActive not equals to UPDATED_IS_ACTIVE
        defaultDmCqBhxhShouldBeFound("isActive.notEquals=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive in DEFAULT_IS_ACTIVE or UPDATED_IS_ACTIVE
        defaultDmCqBhxhShouldBeFound("isActive.in=" + DEFAULT_IS_ACTIVE + "," + UPDATED_IS_ACTIVE);

        // Get all the dmCqBhxhList where isActive equals to UPDATED_IS_ACTIVE
        defaultDmCqBhxhShouldNotBeFound("isActive.in=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive is not null
        defaultDmCqBhxhShouldBeFound("isActive.specified=true");

        // Get all the dmCqBhxhList where isActive is null
        defaultDmCqBhxhShouldNotBeFound("isActive.specified=false");
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive is greater than or equal to DEFAULT_IS_ACTIVE
        defaultDmCqBhxhShouldBeFound("isActive.greaterThanOrEqual=" + DEFAULT_IS_ACTIVE);

        // Get all the dmCqBhxhList where isActive is greater than or equal to UPDATED_IS_ACTIVE
        defaultDmCqBhxhShouldNotBeFound("isActive.greaterThanOrEqual=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive is less than or equal to DEFAULT_IS_ACTIVE
        defaultDmCqBhxhShouldBeFound("isActive.lessThanOrEqual=" + DEFAULT_IS_ACTIVE);

        // Get all the dmCqBhxhList where isActive is less than or equal to SMALLER_IS_ACTIVE
        defaultDmCqBhxhShouldNotBeFound("isActive.lessThanOrEqual=" + SMALLER_IS_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsLessThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive is less than DEFAULT_IS_ACTIVE
        defaultDmCqBhxhShouldNotBeFound("isActive.lessThan=" + DEFAULT_IS_ACTIVE);

        // Get all the dmCqBhxhList where isActive is less than UPDATED_IS_ACTIVE
        defaultDmCqBhxhShouldBeFound("isActive.lessThan=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByIsActiveIsGreaterThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where isActive is greater than DEFAULT_IS_ACTIVE
        defaultDmCqBhxhShouldNotBeFound("isActive.greaterThan=" + DEFAULT_IS_ACTIVE);

        // Get all the dmCqBhxhList where isActive is greater than SMALLER_IS_ACTIVE
        defaultDmCqBhxhShouldBeFound("isActive.greaterThan=" + SMALLER_IS_ACTIVE);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByPathIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where path equals to DEFAULT_PATH
        defaultDmCqBhxhShouldBeFound("path.equals=" + DEFAULT_PATH);

        // Get all the dmCqBhxhList where path equals to UPDATED_PATH
        defaultDmCqBhxhShouldNotBeFound("path.equals=" + UPDATED_PATH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPathIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where path not equals to DEFAULT_PATH
        defaultDmCqBhxhShouldNotBeFound("path.notEquals=" + DEFAULT_PATH);

        // Get all the dmCqBhxhList where path not equals to UPDATED_PATH
        defaultDmCqBhxhShouldBeFound("path.notEquals=" + UPDATED_PATH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPathIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where path in DEFAULT_PATH or UPDATED_PATH
        defaultDmCqBhxhShouldBeFound("path.in=" + DEFAULT_PATH + "," + UPDATED_PATH);

        // Get all the dmCqBhxhList where path equals to UPDATED_PATH
        defaultDmCqBhxhShouldNotBeFound("path.in=" + UPDATED_PATH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPathIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where path is not null
        defaultDmCqBhxhShouldBeFound("path.specified=true");

        // Get all the dmCqBhxhList where path is null
        defaultDmCqBhxhShouldNotBeFound("path.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByPathContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where path contains DEFAULT_PATH
        defaultDmCqBhxhShouldBeFound("path.contains=" + DEFAULT_PATH);

        // Get all the dmCqBhxhList where path contains UPDATED_PATH
        defaultDmCqBhxhShouldNotBeFound("path.contains=" + UPDATED_PATH);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByPathNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where path does not contain DEFAULT_PATH
        defaultDmCqBhxhShouldNotBeFound("path.doesNotContain=" + DEFAULT_PATH);

        // Get all the dmCqBhxhList where path does not contain UPDATED_PATH
        defaultDmCqBhxhShouldBeFound("path.doesNotContain=" + UPDATED_PATH);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa equals to DEFAULT_NGAY_KHOA
        defaultDmCqBhxhShouldBeFound("ngayKhoa.equals=" + DEFAULT_NGAY_KHOA);

        // Get all the dmCqBhxhList where ngayKhoa equals to UPDATED_NGAY_KHOA
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.equals=" + UPDATED_NGAY_KHOA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa not equals to DEFAULT_NGAY_KHOA
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.notEquals=" + DEFAULT_NGAY_KHOA);

        // Get all the dmCqBhxhList where ngayKhoa not equals to UPDATED_NGAY_KHOA
        defaultDmCqBhxhShouldBeFound("ngayKhoa.notEquals=" + UPDATED_NGAY_KHOA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa in DEFAULT_NGAY_KHOA or UPDATED_NGAY_KHOA
        defaultDmCqBhxhShouldBeFound("ngayKhoa.in=" + DEFAULT_NGAY_KHOA + "," + UPDATED_NGAY_KHOA);

        // Get all the dmCqBhxhList where ngayKhoa equals to UPDATED_NGAY_KHOA
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.in=" + UPDATED_NGAY_KHOA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa is not null
        defaultDmCqBhxhShouldBeFound("ngayKhoa.specified=true");

        // Get all the dmCqBhxhList where ngayKhoa is null
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.specified=false");
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa is greater than or equal to DEFAULT_NGAY_KHOA
        defaultDmCqBhxhShouldBeFound("ngayKhoa.greaterThanOrEqual=" + DEFAULT_NGAY_KHOA);

        // Get all the dmCqBhxhList where ngayKhoa is greater than or equal to UPDATED_NGAY_KHOA
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.greaterThanOrEqual=" + UPDATED_NGAY_KHOA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa is less than or equal to DEFAULT_NGAY_KHOA
        defaultDmCqBhxhShouldBeFound("ngayKhoa.lessThanOrEqual=" + DEFAULT_NGAY_KHOA);

        // Get all the dmCqBhxhList where ngayKhoa is less than or equal to SMALLER_NGAY_KHOA
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.lessThanOrEqual=" + SMALLER_NGAY_KHOA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsLessThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa is less than DEFAULT_NGAY_KHOA
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.lessThan=" + DEFAULT_NGAY_KHOA);

        // Get all the dmCqBhxhList where ngayKhoa is less than UPDATED_NGAY_KHOA
        defaultDmCqBhxhShouldBeFound("ngayKhoa.lessThan=" + UPDATED_NGAY_KHOA);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayKhoaIsGreaterThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayKhoa is greater than DEFAULT_NGAY_KHOA
        defaultDmCqBhxhShouldNotBeFound("ngayKhoa.greaterThan=" + DEFAULT_NGAY_KHOA);

        // Get all the dmCqBhxhList where ngayKhoa is greater than SMALLER_NGAY_KHOA
        defaultDmCqBhxhShouldBeFound("ngayKhoa.greaterThan=" + SMALLER_NGAY_KHOA);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsBySoQdTlIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where soQdTl equals to DEFAULT_SO_QD_TL
        defaultDmCqBhxhShouldBeFound("soQdTl.equals=" + DEFAULT_SO_QD_TL);

        // Get all the dmCqBhxhList where soQdTl equals to UPDATED_SO_QD_TL
        defaultDmCqBhxhShouldNotBeFound("soQdTl.equals=" + UPDATED_SO_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsBySoQdTlIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where soQdTl not equals to DEFAULT_SO_QD_TL
        defaultDmCqBhxhShouldNotBeFound("soQdTl.notEquals=" + DEFAULT_SO_QD_TL);

        // Get all the dmCqBhxhList where soQdTl not equals to UPDATED_SO_QD_TL
        defaultDmCqBhxhShouldBeFound("soQdTl.notEquals=" + UPDATED_SO_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsBySoQdTlIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where soQdTl in DEFAULT_SO_QD_TL or UPDATED_SO_QD_TL
        defaultDmCqBhxhShouldBeFound("soQdTl.in=" + DEFAULT_SO_QD_TL + "," + UPDATED_SO_QD_TL);

        // Get all the dmCqBhxhList where soQdTl equals to UPDATED_SO_QD_TL
        defaultDmCqBhxhShouldNotBeFound("soQdTl.in=" + UPDATED_SO_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsBySoQdTlIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where soQdTl is not null
        defaultDmCqBhxhShouldBeFound("soQdTl.specified=true");

        // Get all the dmCqBhxhList where soQdTl is null
        defaultDmCqBhxhShouldNotBeFound("soQdTl.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsBySoQdTlContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where soQdTl contains DEFAULT_SO_QD_TL
        defaultDmCqBhxhShouldBeFound("soQdTl.contains=" + DEFAULT_SO_QD_TL);

        // Get all the dmCqBhxhList where soQdTl contains UPDATED_SO_QD_TL
        defaultDmCqBhxhShouldNotBeFound("soQdTl.contains=" + UPDATED_SO_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsBySoQdTlNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where soQdTl does not contain DEFAULT_SO_QD_TL
        defaultDmCqBhxhShouldNotBeFound("soQdTl.doesNotContain=" + DEFAULT_SO_QD_TL);

        // Get all the dmCqBhxhList where soQdTl does not contain UPDATED_SO_QD_TL
        defaultDmCqBhxhShouldBeFound("soQdTl.doesNotContain=" + UPDATED_SO_QD_TL);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl equals to DEFAULT_NGAY_QD_TL
        defaultDmCqBhxhShouldBeFound("ngayQdTl.equals=" + DEFAULT_NGAY_QD_TL);

        // Get all the dmCqBhxhList where ngayQdTl equals to UPDATED_NGAY_QD_TL
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.equals=" + UPDATED_NGAY_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl not equals to DEFAULT_NGAY_QD_TL
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.notEquals=" + DEFAULT_NGAY_QD_TL);

        // Get all the dmCqBhxhList where ngayQdTl not equals to UPDATED_NGAY_QD_TL
        defaultDmCqBhxhShouldBeFound("ngayQdTl.notEquals=" + UPDATED_NGAY_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl in DEFAULT_NGAY_QD_TL or UPDATED_NGAY_QD_TL
        defaultDmCqBhxhShouldBeFound("ngayQdTl.in=" + DEFAULT_NGAY_QD_TL + "," + UPDATED_NGAY_QD_TL);

        // Get all the dmCqBhxhList where ngayQdTl equals to UPDATED_NGAY_QD_TL
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.in=" + UPDATED_NGAY_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl is not null
        defaultDmCqBhxhShouldBeFound("ngayQdTl.specified=true");

        // Get all the dmCqBhxhList where ngayQdTl is null
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.specified=false");
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl is greater than or equal to DEFAULT_NGAY_QD_TL
        defaultDmCqBhxhShouldBeFound("ngayQdTl.greaterThanOrEqual=" + DEFAULT_NGAY_QD_TL);

        // Get all the dmCqBhxhList where ngayQdTl is greater than or equal to UPDATED_NGAY_QD_TL
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.greaterThanOrEqual=" + UPDATED_NGAY_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl is less than or equal to DEFAULT_NGAY_QD_TL
        defaultDmCqBhxhShouldBeFound("ngayQdTl.lessThanOrEqual=" + DEFAULT_NGAY_QD_TL);

        // Get all the dmCqBhxhList where ngayQdTl is less than or equal to SMALLER_NGAY_QD_TL
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.lessThanOrEqual=" + SMALLER_NGAY_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsLessThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl is less than DEFAULT_NGAY_QD_TL
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.lessThan=" + DEFAULT_NGAY_QD_TL);

        // Get all the dmCqBhxhList where ngayQdTl is less than UPDATED_NGAY_QD_TL
        defaultDmCqBhxhShouldBeFound("ngayQdTl.lessThan=" + UPDATED_NGAY_QD_TL);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByNgayQdTlIsGreaterThanSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where ngayQdTl is greater than DEFAULT_NGAY_QD_TL
        defaultDmCqBhxhShouldNotBeFound("ngayQdTl.greaterThan=" + DEFAULT_NGAY_QD_TL);

        // Get all the dmCqBhxhList where ngayQdTl is greater than SMALLER_NGAY_QD_TL
        defaultDmCqBhxhShouldBeFound("ngayQdTl.greaterThan=" + SMALLER_NGAY_QD_TL);
    }


    @Test
    @Transactional
    public void getAllDmCqBhxhsByCqKyQdIsEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where cqKyQd equals to DEFAULT_CQ_KY_QD
        defaultDmCqBhxhShouldBeFound("cqKyQd.equals=" + DEFAULT_CQ_KY_QD);

        // Get all the dmCqBhxhList where cqKyQd equals to UPDATED_CQ_KY_QD
        defaultDmCqBhxhShouldNotBeFound("cqKyQd.equals=" + UPDATED_CQ_KY_QD);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByCqKyQdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where cqKyQd not equals to DEFAULT_CQ_KY_QD
        defaultDmCqBhxhShouldNotBeFound("cqKyQd.notEquals=" + DEFAULT_CQ_KY_QD);

        // Get all the dmCqBhxhList where cqKyQd not equals to UPDATED_CQ_KY_QD
        defaultDmCqBhxhShouldBeFound("cqKyQd.notEquals=" + UPDATED_CQ_KY_QD);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByCqKyQdIsInShouldWork() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where cqKyQd in DEFAULT_CQ_KY_QD or UPDATED_CQ_KY_QD
        defaultDmCqBhxhShouldBeFound("cqKyQd.in=" + DEFAULT_CQ_KY_QD + "," + UPDATED_CQ_KY_QD);

        // Get all the dmCqBhxhList where cqKyQd equals to UPDATED_CQ_KY_QD
        defaultDmCqBhxhShouldNotBeFound("cqKyQd.in=" + UPDATED_CQ_KY_QD);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByCqKyQdIsNullOrNotNull() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where cqKyQd is not null
        defaultDmCqBhxhShouldBeFound("cqKyQd.specified=true");

        // Get all the dmCqBhxhList where cqKyQd is null
        defaultDmCqBhxhShouldNotBeFound("cqKyQd.specified=false");
    }
                @Test
    @Transactional
    public void getAllDmCqBhxhsByCqKyQdContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where cqKyQd contains DEFAULT_CQ_KY_QD
        defaultDmCqBhxhShouldBeFound("cqKyQd.contains=" + DEFAULT_CQ_KY_QD);

        // Get all the dmCqBhxhList where cqKyQd contains UPDATED_CQ_KY_QD
        defaultDmCqBhxhShouldNotBeFound("cqKyQd.contains=" + UPDATED_CQ_KY_QD);
    }

    @Test
    @Transactional
    public void getAllDmCqBhxhsByCqKyQdNotContainsSomething() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        // Get all the dmCqBhxhList where cqKyQd does not contain DEFAULT_CQ_KY_QD
        defaultDmCqBhxhShouldNotBeFound("cqKyQd.doesNotContain=" + DEFAULT_CQ_KY_QD);

        // Get all the dmCqBhxhList where cqKyQd does not contain UPDATED_CQ_KY_QD
        defaultDmCqBhxhShouldBeFound("cqKyQd.doesNotContain=" + UPDATED_CQ_KY_QD);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultDmCqBhxhShouldBeFound(String filter) throws Exception {
        restDmCqBhxhMockMvc.perform(get("/api/dm-cq-bhxhs?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dmCqBhxh.getId().intValue())))
            .andExpect(jsonPath("$.[*].maCqbh").value(hasItem(DEFAULT_MA_CQBH)))
            .andExpect(jsonPath("$.[*].ten").value(hasItem(DEFAULT_TEN)))
            .andExpect(jsonPath("$.[*].diaChi").value(hasItem(DEFAULT_DIA_CHI)))
            .andExpect(jsonPath("$.[*].maXa").value(hasItem(DEFAULT_MA_XA)))
            .andExpect(jsonPath("$.[*].maHuyen").value(hasItem(DEFAULT_MA_HUYEN)))
            .andExpect(jsonPath("$.[*].maTinh").value(hasItem(DEFAULT_MA_TINH)))
            .andExpect(jsonPath("$.[*].emailAcc").value(hasItem(DEFAULT_EMAIL_ACC)))
            .andExpect(jsonPath("$.[*].phoneNumeric").value(hasItem(DEFAULT_PHONE_NUMERIC)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].activeDate").value(hasItem(DEFAULT_ACTIVE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].maCqbhCha").value(hasItem(DEFAULT_MA_CQBH_CHA)))
            .andExpect(jsonPath("$.[*].nguoiKy").value(hasItem(DEFAULT_NGUOI_KY)))
            .andExpect(jsonPath("$.[*].chucDanh").value(hasItem(DEFAULT_CHUC_DANH)))
            .andExpect(jsonPath("$.[*].tenNoiKy").value(hasItem(DEFAULT_TEN_NOI_KY)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE.intValue())))
            .andExpect(jsonPath("$.[*].path").value(hasItem(DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].ngayKhoa").value(hasItem(DEFAULT_NGAY_KHOA.intValue())))
            .andExpect(jsonPath("$.[*].soQdTl").value(hasItem(DEFAULT_SO_QD_TL)))
            .andExpect(jsonPath("$.[*].ngayQdTl").value(hasItem(DEFAULT_NGAY_QD_TL.intValue())))
            .andExpect(jsonPath("$.[*].cqKyQd").value(hasItem(DEFAULT_CQ_KY_QD)));

        // Check, that the count call also returns 1
        restDmCqBhxhMockMvc.perform(get("/api/dm-cq-bhxhs/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultDmCqBhxhShouldNotBeFound(String filter) throws Exception {
        restDmCqBhxhMockMvc.perform(get("/api/dm-cq-bhxhs?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restDmCqBhxhMockMvc.perform(get("/api/dm-cq-bhxhs/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    public void getNonExistingDmCqBhxh() throws Exception {
        // Get the dmCqBhxh
        restDmCqBhxhMockMvc.perform(get("/api/dm-cq-bhxhs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDmCqBhxh() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        int databaseSizeBeforeUpdate = dmCqBhxhRepository.findAll().size();

        // Update the dmCqBhxh
        DmCqBhxh updatedDmCqBhxh = dmCqBhxhRepository.findById(dmCqBhxh.getId()).get();
        // Disconnect from session so that the updates on updatedDmCqBhxh are not directly saved in db
        em.detach(updatedDmCqBhxh);
        updatedDmCqBhxh
            .maCqbh(UPDATED_MA_CQBH)
            .ten(UPDATED_TEN)
            .diaChi(UPDATED_DIA_CHI)
            .maXa(UPDATED_MA_XA)
            .maHuyen(UPDATED_MA_HUYEN)
            .maTinh(UPDATED_MA_TINH)
            .emailAcc(UPDATED_EMAIL_ACC)
            .phoneNumeric(UPDATED_PHONE_NUMERIC)
            .status(UPDATED_STATUS)
            .activeDate(UPDATED_ACTIVE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .maCqbhCha(UPDATED_MA_CQBH_CHA)
            .nguoiKy(UPDATED_NGUOI_KY)
            .chucDanh(UPDATED_CHUC_DANH)
            .tenNoiKy(UPDATED_TEN_NOI_KY)
            .isActive(UPDATED_IS_ACTIVE)
            .path(UPDATED_PATH)
            .ngayKhoa(UPDATED_NGAY_KHOA)
            .soQdTl(UPDATED_SO_QD_TL)
            .ngayQdTl(UPDATED_NGAY_QD_TL)
            .cqKyQd(UPDATED_CQ_KY_QD);
        DmCqBhxhDTO dmCqBhxhDTO = dmCqBhxhMapper.toDto(updatedDmCqBhxh);

        restDmCqBhxhMockMvc.perform(put("/api/dm-cq-bhxhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqBhxhDTO)))
            .andExpect(status().isOk());

        // Validate the DmCqBhxh in the database
        List<DmCqBhxh> dmCqBhxhList = dmCqBhxhRepository.findAll();
        assertThat(dmCqBhxhList).hasSize(databaseSizeBeforeUpdate);
        DmCqBhxh testDmCqBhxh = dmCqBhxhList.get(dmCqBhxhList.size() - 1);
        assertThat(testDmCqBhxh.getMaCqbh()).isEqualTo(UPDATED_MA_CQBH);
        assertThat(testDmCqBhxh.getTen()).isEqualTo(UPDATED_TEN);
        assertThat(testDmCqBhxh.getDiaChi()).isEqualTo(UPDATED_DIA_CHI);
        assertThat(testDmCqBhxh.getMaXa()).isEqualTo(UPDATED_MA_XA);
        assertThat(testDmCqBhxh.getMaHuyen()).isEqualTo(UPDATED_MA_HUYEN);
        assertThat(testDmCqBhxh.getMaTinh()).isEqualTo(UPDATED_MA_TINH);
        assertThat(testDmCqBhxh.getEmailAcc()).isEqualTo(UPDATED_EMAIL_ACC);
        assertThat(testDmCqBhxh.getPhoneNumeric()).isEqualTo(UPDATED_PHONE_NUMERIC);
        assertThat(testDmCqBhxh.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testDmCqBhxh.getActiveDate()).isEqualTo(UPDATED_ACTIVE_DATE);
        assertThat(testDmCqBhxh.getInactiveDate()).isEqualTo(UPDATED_INACTIVE_DATE);
        assertThat(testDmCqBhxh.getMaCqbhCha()).isEqualTo(UPDATED_MA_CQBH_CHA);
        assertThat(testDmCqBhxh.getNguoiKy()).isEqualTo(UPDATED_NGUOI_KY);
        assertThat(testDmCqBhxh.getChucDanh()).isEqualTo(UPDATED_CHUC_DANH);
        assertThat(testDmCqBhxh.getTenNoiKy()).isEqualTo(UPDATED_TEN_NOI_KY);
        assertThat(testDmCqBhxh.getIsActive()).isEqualTo(UPDATED_IS_ACTIVE);
        assertThat(testDmCqBhxh.getPath()).isEqualTo(UPDATED_PATH);
        assertThat(testDmCqBhxh.getNgayKhoa()).isEqualTo(UPDATED_NGAY_KHOA);
        assertThat(testDmCqBhxh.getSoQdTl()).isEqualTo(UPDATED_SO_QD_TL);
        assertThat(testDmCqBhxh.getNgayQdTl()).isEqualTo(UPDATED_NGAY_QD_TL);
        assertThat(testDmCqBhxh.getCqKyQd()).isEqualTo(UPDATED_CQ_KY_QD);

        // Validate the DmCqBhxh in Elasticsearch
        verify(mockDmCqBhxhSearchRepository, times(1)).save(testDmCqBhxh);
    }

    @Test
    @Transactional
    public void updateNonExistingDmCqBhxh() throws Exception {
        int databaseSizeBeforeUpdate = dmCqBhxhRepository.findAll().size();

        // Create the DmCqBhxh
        DmCqBhxhDTO dmCqBhxhDTO = dmCqBhxhMapper.toDto(dmCqBhxh);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDmCqBhxhMockMvc.perform(put("/api/dm-cq-bhxhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqBhxhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DmCqBhxh in the database
        List<DmCqBhxh> dmCqBhxhList = dmCqBhxhRepository.findAll();
        assertThat(dmCqBhxhList).hasSize(databaseSizeBeforeUpdate);

        // Validate the DmCqBhxh in Elasticsearch
        verify(mockDmCqBhxhSearchRepository, times(0)).save(dmCqBhxh);
    }

    @Test
    @Transactional
    public void deleteDmCqBhxh() throws Exception {
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);

        int databaseSizeBeforeDelete = dmCqBhxhRepository.findAll().size();

        // Delete the dmCqBhxh
        restDmCqBhxhMockMvc.perform(delete("/api/dm-cq-bhxhs/{id}", dmCqBhxh.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DmCqBhxh> dmCqBhxhList = dmCqBhxhRepository.findAll();
        assertThat(dmCqBhxhList).hasSize(databaseSizeBeforeDelete - 1);

        // Validate the DmCqBhxh in Elasticsearch
        verify(mockDmCqBhxhSearchRepository, times(1)).deleteById(dmCqBhxh.getId());
    }

    @Test
    @Transactional
    public void searchDmCqBhxh() throws Exception {
        // Configure the mock search repository
        // Initialize the database
        dmCqBhxhRepository.saveAndFlush(dmCqBhxh);
        when(mockDmCqBhxhSearchRepository.search(queryStringQuery("id:" + dmCqBhxh.getId()), PageRequest.of(0, 20)))
            .thenReturn(new PageImpl<>(Collections.singletonList(dmCqBhxh), PageRequest.of(0, 1), 1));

        // Search the dmCqBhxh
        restDmCqBhxhMockMvc.perform(get("/api/_search/dm-cq-bhxhs?query=id:" + dmCqBhxh.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dmCqBhxh.getId().intValue())))
            .andExpect(jsonPath("$.[*].maCqbh").value(hasItem(DEFAULT_MA_CQBH)))
            .andExpect(jsonPath("$.[*].ten").value(hasItem(DEFAULT_TEN)))
            .andExpect(jsonPath("$.[*].diaChi").value(hasItem(DEFAULT_DIA_CHI)))
            .andExpect(jsonPath("$.[*].maXa").value(hasItem(DEFAULT_MA_XA)))
            .andExpect(jsonPath("$.[*].maHuyen").value(hasItem(DEFAULT_MA_HUYEN)))
            .andExpect(jsonPath("$.[*].maTinh").value(hasItem(DEFAULT_MA_TINH)))
            .andExpect(jsonPath("$.[*].emailAcc").value(hasItem(DEFAULT_EMAIL_ACC)))
            .andExpect(jsonPath("$.[*].phoneNumeric").value(hasItem(DEFAULT_PHONE_NUMERIC)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].activeDate").value(hasItem(DEFAULT_ACTIVE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].maCqbhCha").value(hasItem(DEFAULT_MA_CQBH_CHA)))
            .andExpect(jsonPath("$.[*].nguoiKy").value(hasItem(DEFAULT_NGUOI_KY)))
            .andExpect(jsonPath("$.[*].chucDanh").value(hasItem(DEFAULT_CHUC_DANH)))
            .andExpect(jsonPath("$.[*].tenNoiKy").value(hasItem(DEFAULT_TEN_NOI_KY)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE.intValue())))
            .andExpect(jsonPath("$.[*].path").value(hasItem(DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].ngayKhoa").value(hasItem(DEFAULT_NGAY_KHOA.intValue())))
            .andExpect(jsonPath("$.[*].soQdTl").value(hasItem(DEFAULT_SO_QD_TL)))
            .andExpect(jsonPath("$.[*].ngayQdTl").value(hasItem(DEFAULT_NGAY_QD_TL.intValue())))
            .andExpect(jsonPath("$.[*].cqKyQd").value(hasItem(DEFAULT_CQ_KY_QD)));
    }
}
