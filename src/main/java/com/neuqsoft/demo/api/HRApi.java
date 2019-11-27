package com.neuqsoft.demo.api;

import com.neuqsoft.commons.spring.message.GlobalMessage;
import com.neuqsoft.demo.dto.UserInfoDTO;
import com.neuqsoft.demo.entity.UserEntity;
import com.neuqsoft.demo.service.HRService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
    public Page<UserEntity> getUserInfo(@RequestParam(required = false) String userNum,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String dep,
                                        @RequestParam(required = false, defaultValue = "0") int pageNo,
                                        @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return hrService.getStaff(userNum, name, dep, pageNo, pageSize);
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
    public GlobalMessage addUserInfoList(@RequestParam MultipartFile mf) {
        return hrService.addUserInfoList(mf);
    }

    @ApiOperation(value = "批量导出excel")
    @GetMapping(value = "staff/excel")
    public void Excel(HttpServletResponse response) {
        XSSFWorkbook wb = hrService.showUserInfo();
        String fileName = "员工基本信息表.xlsx";
        OutputStream outputStream = null;
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
