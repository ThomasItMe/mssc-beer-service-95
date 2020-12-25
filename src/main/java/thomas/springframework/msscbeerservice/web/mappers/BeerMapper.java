package thomas.springframework.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;
import thomas.springframework.msscbeerservice.domain.Beer;
import thomas.springframework.msscbeerservice.web.model.BeerDto;

/**
 * @author vvthuy on 12/25/2020
 * @project mssc-beer-service
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
