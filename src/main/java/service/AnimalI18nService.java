package service;

import dto.AnimalDtoByteMedia;
import dto.AnimalI18nDto;

public interface AnimalI18nService {

    AnimalDtoByteMedia getIdAjaxI18n(long animalId, String locale);

}
