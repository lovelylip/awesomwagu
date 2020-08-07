package com.silk.awesomeagu.service;

import com.silk.awesomeagu.service.dto.DmCqBhxhDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.silk.awesomeagu.domain.DmCqBhxh}.
 */
public interface DmCqBhxhService {

    /**
     * Save a dmCqBhxh.
     *
     * @param dmCqBhxhDTO the entity to save.
     * @return the persisted entity.
     */
    DmCqBhxhDTO save(DmCqBhxhDTO dmCqBhxhDTO);

    /**
     * Get all the dmCqBhxhs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DmCqBhxhDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dmCqBhxh.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DmCqBhxhDTO> findOne(Long id);

    /**
     * Delete the "id" dmCqBhxh.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the dmCqBhxh corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DmCqBhxhDTO> search(String query, Pageable pageable);
}
