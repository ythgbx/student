package net.bus.web.context;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by Edifi_000 on 2016-09-17.
 */
public class AlipayHisContext {

    private String _head = "AlipayHis-";

    private static AlipayHisContext _instance;

    private Cache _cache = null;
    private CacheManager _cacheManager = null;

    private final int HASH_LENGTH = 9;

    public static AlipayHisContext getInstance() {

        if (_instance == null) {
            synchronized (BusesTracksContext.class) {
                if (_instance == null) {
                    _instance = new AlipayHisContext();
                }
            }
        }
        return _instance;
    }

    private AlipayHisContext()
    {
        _cacheManager = CacheManager.create();
        _cache=_cacheManager.getCache("alipayHisCache");
    }

    public void saveAlipayHis(String tradeNo,AlipayCallBack alipay)
    {
        String key = _head + tradeNo;
        Element element = new Element(key, alipay);
        _cache.put(element);
    }

    public AlipayCallBack getAlipayHis(String tradeNo)
    {
        String key = _head + tradeNo;
        if(_cache.isElementInMemory(key))
        {
            Object alipay = _cache.get(key).getObjectValue();
            if(alipay!=null)
            {
                return (AlipayCallBack)alipay;
            }
        }
        return null;
    }
}
