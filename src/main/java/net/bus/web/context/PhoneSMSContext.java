package net.bus.web.context;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by Edifi_000 on 2016-07-19.
 */
public class PhoneSMSContext {

    private static PhoneSMSContext _instance;

    private String _head = "phonesms-";
    private Cache _cache = null;;
    private CacheManager _cacheManager = null;

    public static PhoneSMSContext getInstance() {

        if (_instance == null) {
            synchronized (PhoneSMSContext.class) {
                if (_instance == null) {
                    _instance = new PhoneSMSContext();
                }
            }
        }
        return _instance;
    }

    private PhoneSMSContext()
    {
        _cacheManager = CacheManager.create();
        _cache=_cacheManager.getCache("smsCache");
    }

    public boolean checkPhone(String phone)
    {
        String key = _head + phone;

        if(_cache.isElementInMemory(key)&&_cache.get(key)!=null){
                return true;
        }else{
            return false;
        }
    }

    public void savePhonesSmsCode(String phone,String code)
    {
        String key = _head + phone;
        Element element = new Element(key, code);
        _cache.put(element);
    }

    public boolean checkPhonesSmsCode(String phone,String code)
    {
        String key = _head + phone;
        if(_cache.isElementInMemory(key))
        {
            Object smsCode = _cache.get(key).getObjectValue();
            if(smsCode!=null&&smsCode.toString().equals(code))
            {
                return true;
            }
        }
        return false;
    }
}
