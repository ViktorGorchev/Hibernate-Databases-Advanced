package app.services;

import app.domain.dto.jsonExport.SellerDto;
import app.domain.dto.jsonExport.UserStatusDto;
import app.domain.dto.jsonImport.UserJsonDto;

import java.util.List;

public interface UserService {

    void create(UserJsonDto userJsonDto);

    List<SellerDto> findWithMoreThanOneBuyer();

    UserStatusDto usersWithProductsSold();
}
