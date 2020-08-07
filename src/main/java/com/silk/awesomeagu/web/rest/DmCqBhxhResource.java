package com.silk.awesomeagu.web.rest;

import com.silk.awesomeagu.service.DmCqBhxhService;
import com.silk.awesomeagu.web.rest.errors.BadRequestAlertException;
import com.silk.awesomeagu.service.dto.DmCqBhxhDTO;
import com.silk.awesomeagu.service.dto.DmCqBhxhCriteria;
import com.silk.awesomeagu.service.DmCqBhxhQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing {@link com.silk.awesomeagu.domain.DmCqBhxh}.
 */
@RestController
@RequestMapping("/api")
public class DmCqBhxhResource {

    private final Logger log = LoggerFactory.getLogger(DmCqBhxhResource.class);

    private static final String ENTITY_NAME = "dmCqBhxh";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DmCqBhxhService dmCqBhxhService;

    private final DmCqBhxhQueryService dmCqBhxhQueryService;

    public DmCqBhxhResource(DmCqBhxhService dmCqBhxhService, DmCqBhxhQueryService dmCqBhxhQueryService) {
        this.dmCqBhxhService = dmCqBhxhService;
        this.dmCqBhxhQueryService = dmCqBhxhQueryService;
    }

    /**
     * {@code POST  /dm-cq-bhxhs} : Create a new dmCqBhxh.
     *
     * @param dmCqBhxhDTO the dmCqBhxhDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dmCqBhxhDTO, or with status {@code 400 (Bad Request)} if the dmCqBhxh has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dm-cq-bhxhs")
    public ResponseEntity<DmCqBhxhDTO> createDmCqBhxh(@Valid @RequestBody DmCqBhxhDTO dmCqBhxhDTO) throws URISyntaxException {
        log.debug("REST request to save DmCqBhxh : {}", dmCqBhxhDTO);
        if (dmCqBhxhDTO.getId() != null) {
            throw new BadRequestAlertException("A new dmCqBhxh cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DmCqBhxhDTO result = dmCqBhxhService.save(dmCqBhxhDTO);
        return ResponseEntity.created(new URI("/api/dm-cq-bhxhs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dm-cq-bhxhs} : Updates an existing dmCqBhxh.
     *
     * @param dmCqBhxhDTO the dmCqBhxhDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmCqBhxhDTO,
     * or with status {@code 400 (Bad Request)} if the dmCqBhxhDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dmCqBhxhDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dm-cq-bhxhs")
    public ResponseEntity<DmCqBhxhDTO> updateDmCqBhxh(@Valid @RequestBody DmCqBhxhDTO dmCqBhxhDTO) throws URISyntaxException {
        log.debug("REST request to update DmCqBhxh : {}", dmCqBhxhDTO);
        if (dmCqBhxhDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DmCqBhxhDTO result = dmCqBhxhService.save(dmCqBhxhDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmCqBhxhDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dm-cq-bhxhs} : get all the dmCqBhxhs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dmCqBhxhs in body.
     */
    @GetMapping("/dm-cq-bhxhs")
    public ResponseEntity<List<DmCqBhxhDTO>> getAllDmCqBhxhs(DmCqBhxhCriteria criteria, Pageable pageable) {
        log.debug("REST request to get DmCqBhxhs by criteria: {}", criteria);
        Page<DmCqBhxhDTO> page = dmCqBhxhQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dm-cq-bhxhs/count} : count all the dmCqBhxhs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/dm-cq-bhxhs/count")
    public ResponseEntity<Long> countDmCqBhxhs(DmCqBhxhCriteria criteria) {
        log.debug("REST request to count DmCqBhxhs by criteria: {}", criteria);
        return ResponseEntity.ok().body(dmCqBhxhQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /dm-cq-bhxhs/:id} : get the "id" dmCqBhxh.
     *
     * @param id the id of the dmCqBhxhDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dmCqBhxhDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dm-cq-bhxhs/{id}")
    public ResponseEntity<DmCqBhxhDTO> getDmCqBhxh(@PathVariable Long id) {
        log.debug("REST request to get DmCqBhxh : {}", id);
        Optional<DmCqBhxhDTO> dmCqBhxhDTO = dmCqBhxhService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dmCqBhxhDTO);
    }

    /**
     * {@code DELETE  /dm-cq-bhxhs/:id} : delete the "id" dmCqBhxh.
     *
     * @param id the id of the dmCqBhxhDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dm-cq-bhxhs/{id}")
    public ResponseEntity<Void> deleteDmCqBhxh(@PathVariable Long id) {
        log.debug("REST request to delete DmCqBhxh : {}", id);
        dmCqBhxhService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/dm-cq-bhxhs?query=:query} : search for the dmCqBhxh corresponding
     * to the query.
     *
     * @param query the query of the dmCqBhxh search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/dm-cq-bhxhs")
    public ResponseEntity<List<DmCqBhxhDTO>> searchDmCqBhxhs(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of DmCqBhxhs for query {}", query);
        Page<DmCqBhxhDTO> page = dmCqBhxhService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
