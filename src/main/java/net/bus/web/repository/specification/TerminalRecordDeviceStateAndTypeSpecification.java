package net.bus.web.repository.specification;

import net.bus.web.model.TerminalRecordExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-11-21.
 */
public class TerminalRecordDeviceStateAndTypeSpecification implements ISpecification<TerminalRecordExample> {

    protected String _device;
    protected int _state;
    protected int _type;

    public TerminalRecordDeviceStateAndTypeSpecification(String device,int state,int type)
    {
        this._device = device;
        this._state = state;
        this._type = type;
    }

    public TerminalRecordExample createExample()
    {
        TerminalRecordExample example = new TerminalRecordExample();
        TerminalRecordExample.Criteria criteria= example.createCriteria();
        criteria.andDeviceEqualTo(_device).andStateEqualTo(_state).andTypeEqualTo(_type);
        return example;
    }
}
