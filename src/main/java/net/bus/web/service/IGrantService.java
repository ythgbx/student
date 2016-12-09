package net.bus.web.service;

import net.bus.web.controller.dto.GrantDto;
import net.bus.web.model.Grant;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 16/12/9.
 */

public interface IGrantService {
    boolean insert(GrantDto grantDto);

    Grant getStudent(String id);
}
