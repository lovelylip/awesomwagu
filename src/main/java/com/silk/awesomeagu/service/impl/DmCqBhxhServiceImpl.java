package com.silk.awesomeagu.service.impl;

import com.silk.awesomeagu.service.DmCqBhxhService;
import com.silk.awesomeagu.domain.DmCqBhxh;
import com.silk.awesomeagu.repository.DmCqBhxhRepository;
import com.silk.awesomeagu.repository.search.DmCqBhxhSearchRepository;
import com.silk.awesomeagu.service.dto.DmCqBhxhDTO;
import com.silk.awesomeagu.service.mapper.DmCqBhxhMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link DmCqBhxh}.
 */
@Service
@Transactional
public class DmCqBhxhServiceImpl implements DmCqBhxhService {

    private final Logger log = LoggerFactory.getLogger(DmCqBhxhServiceImpl.class);

    private final DmCqBhxhRepository dmCqBhxhRepository;

    private final DmCqBhxhMapper dmCqBhxhMapper;

    private final DmCqBhxhSearchRepository dmCqBhxhSearchRepository;

    public DmCqBhxhServiceImpl(DmCqBhxhRepository dmCqBhxhRepository, DmCqBhxhMapper dmCqBhxhMapper, DmCqBhxhSearchRepository dmCqBhxhSearchRepository) {
        this.dmCqBhxhRepository = dmCqBhxhRepository;
        this.dmCqBhxhMapper = dmCqBhxhMapper;
        this.dmCqBhxhSearchRepository = dmCqBhxhSearchRepository;
    }

    @Override
    public DmCqBhxhDTO save(DmCqBhxhDTO dmCqBhxhDTO) {
        log.debug("Request to save DmCqBhxh : {}", dmCqBhxhDTO);
        DmCqBhxh dmCqBhxh = dmCqBhxhMapper.toEntity(dmCqBhxhDTO);
        dmCqBhxh = dmCqBhxhRepository.save(dmCqBhxh);
        DmCqBhxhDTO result = dmCqBhxhMapper.toDto(dmCqBhxh);
        dmCqBhxhSearchRepository.save(dmCqBhxh);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DmCqBhxhDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DmCqBhxhs");
        return dmCqBhxhRepository.findAll(pageable)
            .map(dmCqBhxhMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<DmCqBhxhDTO> findOne(Long id) {
        log.debug("Request to get DmCqBhxh : {}", id);
        return dmCqBhxhRepository.findById(id)
            .map(dmCqBhxhMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DmCqBhxh : {}", id);
        dmCqBhxhRepository.deleteById(id);
        dmCqBhxhSearchRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DmCqBhxhDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of DmCqBhxhs for query {}", query);
        return dmCqBhxhSearchRepository.search(queryStringQuery(query), pageable)
            .map(dmCqBhxhMapper::toDto);
    }
}
