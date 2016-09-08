package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.VersionResult;
import net.bus.web.controller.dto.VersionUrlItem;
import org.apache.commons.lang.StringUtils;
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

    @Value("#{versionProperties['minimumVersionAndroid']}")
    private String _minimumVersionAndroid;
    @Value("#{versionProperties['minimumVersionIos']}")
    private String _minimumVersionIos;

    @Value("#{versionProperties['currentVersionAndroid']}")
    private String _currentVersionAndroid;
    @Value("#{versionProperties['currentVersionIos']}")
    private String _currentVersionIos;

    @Value("#{versionProperties['backVersionAndroid']}")
    private String _backVersionAndroid;
    @Value("#{versionProperties['backVersionIos']}")
    private String _backVersionIos;

    @Value("#{versionProperties['offVersionsAndroid']}")
    private String _offVersionsAndroid;
    @Value("#{versionProperties['offVersionsIos']}")
    private String _offVersionsIos;

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

        String minimumVersion;
        String currentVersion;
        String backVersion;
        String offVersions;
        String versionUrl;
        if(platform.toLowerCase().equals("android")){
            minimumVersion = _minimumVersionAndroid;
            currentVersion = _currentVersionAndroid;
            backVersion = _backVersionAndroid;
            offVersions = _offVersionsAndroid;
            versionUrl = _versionUrlAndroid;
        }else{
            minimumVersion = _minimumVersionIos;
            currentVersion = _currentVersionIos;
            backVersion = _backVersionIos;
            offVersions = _offVersionsIos;
            versionUrl = _versionUrlIos;
        }

        //当下载地址未正确配置时
        if(StringUtils.isBlank(versionUrl)){
            result.setResult("error");
            return result;
        }

        result.setResult("success");
        result.setMinimum_version(minimumVersion);
        result.setCurrent_version(currentVersion);
        result.setBack_version(backVersion);

        if(!StringUtils.isBlank(offVersions)){
            List<String> listOffVersion = new ArrayList<String>();
            String[] offVersionsStr = offVersions.split("\\|");
            for (String version:offVersionsStr){
                listOffVersion.add(version);
            }
            result.setOff_versions(listOffVersion);
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
