package com.neuqsoft.demo.api;

import com.neuqsoft.commons.spring.message.GlobalMessage;
import com.neuqsoft.demo.dto.UserInfoDTO;
import com.neuqsoft.demo.entity.UserEntity;
import com.neuqsoft.demo.service.HRService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-21 13:38
 * @Description:
 */
@RestController
@RequestMapping("/api/hr")
public class HRApi {

    @Autowired
    private HRService hrService;

    @ApiOperation("查看员工信息")
    @GetMapping("/staff")
    public List<UserEntity> getUserInfo() {
        return hrService.getUserInfo();
    }

    @ApiOperation("添加员工信息")
    @PostMapping("/staff")
    public GlobalMessage addUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        return hrService.addUserInfo(userInfoDTO);
    }

    @ApiOperation("删除员工信息")
    @DeleteMapping("/staff/{id}")
    public GlobalMessage deleteUserInfo(@PathVariable String id) {
        return hrService.deleteUserInfo(id);
    }

    @ApiOperation("修改员工信息")
    @PostMapping("staff/{id}")
    public GlobalMessage setUserInfo(@PathVariable String id, @RequestBody UserInfoDTO userInfoDTO) {
        return hrService.setUserInfo(id, userInfoDTO);
    }

    @ApiOperation("批量导入excel")
    @PostMapping("/staff/excel")
    public GlobalMessage addUserInfoList(@RequestParam MultipartFile mf) throws ParserConfigurationException, OpenXML4JException, SAXException, IOException {
        return hrService.addUserInfoList(mf);
    }
}
