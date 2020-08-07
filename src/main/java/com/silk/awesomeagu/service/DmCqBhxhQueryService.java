package com.silk.awesomeagu.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.silk.awesomeagu.domain.DmCqBhxh;
import com.silk.awesomeagu.domain.*; // for static metamodels
import com.silk.awesomeagu.repository.DmCqBhxhRepository;
import com.silk.awesomeagu.repository.search.DmCqBhxhSearchRepository;
import com.silk.awesomeagu.service.dto.DmCqBhxhCriteria;
import com.silk.awesomeagu.service.dto.DmCqBhxhDTO;
import com.silk.awesomeagu.service.mapper.DmCqBhxhMapper;

/**
 * Service for executing complex queries for {@link DmCqBhxh} entities in the database.
 * The main input is a {@link DmCqBhxhCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link DmCqBhxhDTO} or a {@link Page} of {@link DmCqBhxhDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class DmCqBhxhQueryService extends QueryService<DmCqBhxh> {

    private final Logger log = LoggerFactory.getLogger(DmCqBhxhQueryService.class);

    private final DmCqBhxhRepository dmCqBhxhRepository;

    private final DmCqBhxhMapper dmCqBhxhMapper;

    private final DmCqBhxhSearchRepository dmCqBhxhSearchRepository;

    public DmCqBhxhQueryService(DmCqBhxhRepository dmCqBhxhRepository, DmCqBhxhMapper dmCqBhxhMapper, DmCqBhxhSearchRepository dmCqBhxhSearchRepository) {
        this.dmCqBhxhRepository = dmCqBhxhRepository;
        this.dmCqBhxhMapper = dmCqBhxhMapper;
        this.dmCqBhxhSearchRepository = dmCqBhxhSearchRepository;
    }

    /**
     * Return a {@link List} of {@link DmCqBhxhDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<DmCqBhxhDTO> findByCriteria(DmCqBhxhCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<DmCqBhxh> specification = createSpecification(criteria);
        return dmCqBhxhMapper.toDto(dmCqBhxhRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link DmCqBhxhDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<DmCqBhxhDTO> findByCriteria(DmCqBhxhCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<DmCqBhxh> specification = createSpecification(criteria);
        return dmCqBhxhRepository.findAll(specification, page)
            .map(dmCqBhxhMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(DmCqBhxhCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<DmCqBhxh> specification = createSpecification(criteria);
        return dmCqBhxhRepository.count(specification);
    }

    /**
     * Function to convert {@link DmCqBhxhCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<DmCqBhxh> createSpecification(DmCqBhxhCriteria criteria) {
        Specification<DmCqBhxh> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), DmCqBhxh_.id));
            }
            if (criteria.getMaCqbh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMaCqbh(), DmCqBhxh_.maCqbh));
            }
            if (criteria.getTen() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTen(), DmCqBhxh_.ten));
            }
            if (criteria.getDiaChi() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDiaChi(), DmCqBhxh_.diaChi));
            }
            if (criteria.getMaXa() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMaXa(), DmCqBhxh_.maXa));
            }
            if (criteria.getMaHuyen() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMaHuyen(), DmCqBhxh_.maHuyen));
            }
            if (criteria.getMaTinh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMaTinh(), DmCqBhxh_.maTinh));
            }
            if (criteria.getEmailAcc() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmailAcc(), DmCqBhxh_.emailAcc));
            }
            if (criteria.getPhoneNumeric() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPhoneNumeric(), DmCqBhxh_.phoneNumeric));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), DmCqBhxh_.status));
            }
            if (criteria.getActiveDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getActiveDate(), DmCqBhxh_.activeDate));
            }
            if (criteria.getInactiveDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInactiveDate(), DmCqBhxh_.inactiveDate));
            }
            if (criteria.getMaCqbhCha() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMaCqbhCha(), DmCqBhxh_.maCqbhCha));
            }
            if (criteria.getNguoiKy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNguoiKy(), DmCqBhxh_.nguoiKy));
            }
            if (criteria.getChucDanh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getChucDanh(), DmCqBhxh_.chucDanh));
            }
            if (criteria.getTenNoiKy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTenNoiKy(), DmCqBhxh_.tenNoiKy));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIsActive(), DmCqBhxh_.isActive));
            }
            if (criteria.getPath() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPath(), DmCqBhxh_.path));
            }
            if (criteria.getNgayKhoa() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNgayKhoa(), DmCqBhxh_.ngayKhoa));
            }
            if (criteria.getSoQdTl() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSoQdTl(), DmCqBhxh_.soQdTl));
            }
            if (criteria.getNgayQdTl() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNgayQdTl(), DmCqBhxh_.ngayQdTl));
            }
            if (criteria.getCqKyQd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCqKyQd(), DmCqBhxh_.cqKyQd));
            }
        }
        return specification;
    }
}
