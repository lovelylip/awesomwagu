package com.silk.awesomeagu.service.mapper;


import com.silk.awesomeagu.domain.*;
import com.silk.awesomeagu.service.dto.DmCqBhxhDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DmCqBhxh} and its DTO {@link DmCqBhxhDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DmCqBhxhMapper extends EntityMapper<DmCqBhxhDTO, DmCqBhxh> {



    default DmCqBhxh fromId(Long id) {
        if (id == null) {
            return null;
        }
        DmCqBhxh dmCqBhxh = new DmCqBhxh();
        dmCqBhxh.setId(id);
        return dmCqBhxh;
    }
}
