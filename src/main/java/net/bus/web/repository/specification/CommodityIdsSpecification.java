package net.bus.web.repository.specification;

import net.bus.web.model.CommodityExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-11.
 */
public class CommodityIdsSpecification  implements ISpecification<CommodityExample> {

    protected List<Long> _ids;

    public CommodityIdsSpecification(List<Long> ids){
        this._ids = ids;
    }

    public CommodityExample createExample()
    {
        if(_ids.isEmpty())
            return null;

        CommodityExample example = new CommodityExample();
        CommodityExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andIdIn(_ids);
        return example;
    }
}
