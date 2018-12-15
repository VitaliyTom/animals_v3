package dto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Modelmapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
