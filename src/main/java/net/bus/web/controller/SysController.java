package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.VersionResult;
import net.bus.web.controller.dto.VersionUrlItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Edifi_000 on 2016-09-07.
 */
@Controller
@RequestMapping("/sys")
public class SysController {

    @Value("#{versionProperties['minimumVersion']}")
    private String _minimumVersion;
    @Value("#{versionProperties['currentVersion']}")
    private String _currentVersion;
    @Value("#{versionProperties['backVersion']}")
    private String _backVersion;
    @Value("#{versionProperties['offVersions']}")
    private String _offVersions;
    @Value("#{versionProperties['forcedUpdate']}")
    private boolean _forcedUpdate;
    @Value("#{versionProperties['versionUrlAndroid']}")
    private String _versionUrlAndroid;
    @Value("#{versionProperties['versionUrlIos']}")
    private String _versionUrlIos;

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ApiOperation(value = "获取应用版本信息", httpMethod = "GET", response = VersionResult.class, notes = "获取应用版本信息(platform ios|android)")
    public IResult version(@ApiParam(required = true, name = "platform", value = "平台")@RequestParam(value = "platform", required = true, defaultValue = "ios")String platform){
        VersionResult result = new VersionResult();
        result.setResult("success");
        result.setMinimum_version(_minimumVersion);
        result.setCurrent_version(_currentVersion);
        result.setBack_version(_backVersion);
        result.setForced_update(_forcedUpdate);

        List<String> offVersions = new ArrayList<String>();
        String[] offVersionsStr = _offVersions.split("\\|");
        for (String version:offVersionsStr){
            offVersions.add(version);
        }
        result.setOff_versions(offVersions);

        String versionUrl;
        if(platform.toLowerCase().equals("android")){
            versionUrl = _versionUrlAndroid;
        }else{
            versionUrl = _versionUrlIos;
        }

        List<VersionUrlItem> updateUrls = new ArrayList<VersionUrlItem>();
        String[] versionUrls = versionUrl.split("\\|");
        for (String versionInfo:versionUrls){
            String[] details = versionInfo.split("\\$");
            VersionUrlItem item = new VersionUrlItem(){};
            if(details.length>0){
                item.setVersion(details[0]);
                if(details.length>1){
                    item.setFull_url(details[1]);
                    if(details.length>2){
                        item.setIncrement_url(details[2]);
                    }
                }
                updateUrls.add(item);
            }
        }
        result.setUpdate_urls(updateUrls);
        return result;
    }
}
