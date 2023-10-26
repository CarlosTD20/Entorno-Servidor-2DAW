package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.director.DirectorCreateWEB;
import com.fpmislata.movies.controller.model.director.DirectorDetailWEB;
import com.fpmislata.movies.controller.model.director.DirectorListWEB;
import com.fpmislata.movies.controller.model.director.DirectorUpdateWEB;
import com.fpmislata.movies.domain.entity.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper mapper = Mappers.getMapper(DirectorMapper.class);

    Director toDirector(DirectorCreateWEB directorCreateWeb);
    Director toDirector(DirectorUpdateWEB directorUpdateWeb);

    DirectorListWEB toDirectorListWEB(Director director);
    DirectorDetailWEB toDirectorDetailWEB(Director director);
}
