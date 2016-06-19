package net.bus.web.mapper;

import net.bus.web.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface UserMapper {

    ArrayList<User> getAllUsers ();
}
