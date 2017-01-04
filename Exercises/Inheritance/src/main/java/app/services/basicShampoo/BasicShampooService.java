package app.services.basicShampoo;

import app.domain.dto.shampooDtos.BasicShampooDto;

public interface BasicShampooService {

    void createPinkPanther();

    void createFreshNuke();

    void createCustomFreshNuke(BasicShampooDto basicShampooDto);
}