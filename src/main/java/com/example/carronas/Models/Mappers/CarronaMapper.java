package com.example.carronas.Models.Mappers;

import com.example.carronas.Models.Carrona;
import com.example.carronas.Models.DTOs.CarronaDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarronaMapper {
    Carrona toEntity(CarronaDto carronaDto);

    @AfterMapping
    default void linkPassageiros(@MappingTarget Carrona carrona) {
        carrona.getPassageiros().forEach(passageiro -> passageiro.setCarronaAtual(carrona));
    }

    CarronaDto toDto(Carrona carrona);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Carrona partialUpdate(CarronaDto carronaDto, @MappingTarget Carrona carrona);
}