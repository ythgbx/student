package net.bus.web.service;

import net.bus.web.model.Line;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface ILineService {

    List<Line> getAroundLines(double lat,double lng,int page);

    List<Line> getUserLines(Long userid,int page);

    List<Line> getAllLines(int page);

    Line getLineDetails(Long id);
}
