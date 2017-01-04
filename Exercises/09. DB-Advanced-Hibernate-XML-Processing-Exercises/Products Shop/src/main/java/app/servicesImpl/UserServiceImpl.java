package app.servicesImpl;

import app.domain.dto.jsonExport.SellerDto;
import app.domain.dto.jsonExport.UserDto;
import app.domain.dto.jsonExport.UserStatusDto;
import app.domain.dto.jsonImport.UserJsonDto;
import app.domain.models.User;
import app.parser.ModelParser;
import app.repositories.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(UserJsonDto userJsonDto) {
        User user = this.modelParser.convert(userJsonDto, User.class);
        if(this.userRepository.count() > 0){
            long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);
            User randomUser = this.userRepository.findOne(randomId);
            user.getFriends().add(randomUser);
        }

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public List<SellerDto> findWithMoreThanOneBuyer() {
        List<User> sellers = this.userRepository.findWithMoreThanOneBuyer();
        List<SellerDto> sellerDtos = this.modelParser.convert(sellers, SellerDto.class);

        return sellerDtos;
    }

    @Override
    public UserStatusDto usersWithProductsSold() {
        UserStatusDto userStatusDto = new UserStatusDto();
        userStatusDto.setUsersCount(this.userRepository.count());
        List<User> users = this.userRepository.usersWithProductsSoldOrdered();
        List<UserDto> userDtos = this.modelParser.convert(users, UserDto.class);
        for (UserDto userDto : userDtos) {
            int productsCount = userDto.getSoldProducts().getProducts().size();
            userDto.getSoldProducts().setCount(productsCount);
        }

        userStatusDto.setUsers(userDtos);

        return userStatusDto;
    }
}