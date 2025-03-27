package com.example.carronas.Models.Mappers;

import com.example.carronas.Models.Cidade;
import com.example.carronas.Models.DTOs.CidadeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CidadeMapper {
    Cidade toEntity(CidadeDto cidadeDto);

    CidadeDto toDto(Cidade cidade);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cidade partialUpdate(CidadeDto cidadeDto, @MappingTarget Cidade cidade);
}