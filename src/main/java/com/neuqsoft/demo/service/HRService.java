package com.neuqsoft.demo.service;

import com.neuqsoft.commons.spring.log.LogAnnotation;
import com.neuqsoft.commons.spring.message.GlobalMessage;
import com.neuqsoft.commons.util.UUIDUtils;
import com.neuqsoft.demo.XLSXCovertCSVReader;
import com.neuqsoft.demo.constant.Constant;
import com.neuqsoft.demo.dto.UserInfoDTO;
import com.neuqsoft.demo.entity.UserEntity;
import com.neuqsoft.demo.repository.UserRepo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-21 09:21
 * @Description:
 */
@Service
public class HRService {

    @Autowired
    private UserRepo userRepo;

    @LogAnnotation(value = "查看人员信息", params = true, result = true)
    public Page<UserEntity> getStaff(String userNum, String name, String dep, int pageNo, int pageSize) {
        return userRepo.findAll((root, query, cb) -> {
            Predicate predicate = cb.conjunction();
            List<Expression<Boolean>> expressions = predicate.getExpressions();

            if (!StringUtils.isEmpty(userNum)) {
                expressions.add(cb.equal(root.<String>get("userNum"), userNum));
            }

            if (!StringUtils.isEmpty(name)) {
                expressions.add(cb.like(root.<String>get("name"), "%" + name + "%"));
            }
            if (!StringUtils.isEmpty(dep)) {
                expressions.add(cb.equal(root.<String>get("dep"), dep));
            }
            return predicate;
        }, PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, "userNum"));
    }

    @LogAnnotation(value = "删除人员信息", params = true, result = true)
    public GlobalMessage deleteUserInfo(String id) {
        UserEntity userEntity = userRepo.findAllById(id);
        if (userEntity == null) {
            throw Constant.ExceptionRepo.USER_NOT_EXIST;
        }
        userRepo.delete(userEntity);
        return new GlobalMessage("0", "操作成功");
    }

    @LogAnnotation(value = "添加人员信息", params = true, result = true)
    public GlobalMessage addUserInfo(UserInfoDTO userInfoDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userInfoDTO, userEntity);
        userEntity.setId(UUIDUtils.uuid32());
        userEntity.setPassword("123456");
        userRepo.save(userEntity);
        return new GlobalMessage("0", "操作成功");
    }

    @LogAnnotation(value = "修改人员的信息", params = true, result = true)
    public GlobalMessage setUserInfo(String id, UserInfoDTO userInfoDTO) {
        UserEntity userEntity = userRepo.findAllById(id);
        if (userEntity == null) {
            throw Constant.ExceptionRepo.USER_NOT_EXIST;
        }
        BeanUtils.copyProperties(userInfoDTO, userEntity);
        userRepo.save(userEntity);
        return new GlobalMessage("0", "操作成功");
    }

    @LogAnnotation(value = "人员基本信息的导入", params = true, result = true)
    public GlobalMessage addUserInfoList(MultipartFile mf)  {
        if (mf.isEmpty()) {
            throw Constant.ExceptionRepo.FILE_ERROR;
        }
        String fileName = mf.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        try {
            if (fileType.equals("xlsx")) {
                List<String[]> list;
                try {
                    list = XLSXCovertCSVReader.readerExcel(mf.getInputStream(), "1", 9);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw Constant.ExceptionRepo.EXCEL_READ_ERROR;
                }
                List<UserEntity> userEntityList = new ArrayList<>();
                if (list.size() > 1) {
                    for (int i = 1; i < list.size(); i++) {
                        String[] record = list.get(i);
                        if (record[0] == null || record[0].equals("")) {
                            throw Constant.ExceptionRepo.NUMBER_NOT_NULL;
                        }
                        if (record[1] == null || record[1].equals("")) {
                            throw Constant.ExceptionRepo.NAME_NOT_NULL;
                        }
                        if (record[2] == null || record[2].equals("")) {
                            throw Constant.ExceptionRepo.SEX_NOT_NULL;
                        }
                        if (record[3] == null || record[3].equals("")) {
                            throw Constant.ExceptionRepo.IDCARD_NOT_NULL;
                        }
                        if (record[4] == null || record[4].equals("")) {
                            throw Constant.ExceptionRepo.MOBILE_NOT_NULL;
                        }
                        if (record[5] == null || record[5].equals("")) {
                            throw Constant.ExceptionRepo.DEP_NOT_NULL;
                        }
                        if (record[6] == null || record[6].equals("")) {
                            throw Constant.ExceptionRepo.POSITION_NOT_NULL;
                        }
                        if (record[7] == null || record[7].equals("")) {
                            throw Constant.ExceptionRepo.STARTTIME_NOT_NULL;
                        }
                        if (record[8] == null || record[8].equals("")) {
                            throw Constant.ExceptionRepo.MAIL_NOT_NULL;
                        }
                        String number = record[0].replace("\"", "").trim();
                        String name = record[1].replace("\"", "").trim();
                        String sex = record[2].replace("\"", "").trim();
                        String idcard = record[3].replace("\"", "").trim();
                        String mobile = record[4].replace("\"", "").trim();
                        String dep = record[5].replace("\"", "").trim();
                        String position = record[6].replace("\"", "").trim();
                        String startTime = record[7].replace("\"", "").trim();
                        String mail = record[8].replace("\"", "").trim();
                        String id = UUIDUtils.uuid32();
                        UserEntity userEntity1 = new UserEntity();
                        userEntity1.setId(id);
                        userEntity1.setUserNum(number);
                        userEntity1.setName(name);
                        userEntity1.setSex(Integer.valueOf(sex));
                        userEntity1.setIdcard(idcard);
                        userEntity1.setMobile(mobile);
                        userEntity1.setDep(dep);
                        userEntity1.setPosition(position);
                        userEntity1.setStartTime(startTime);
                        userEntity1.setMail(mail);
                        userEntity1.setPassword("123456");
                        userEntityList.add(userEntity1);
                    }
                    userRepo.saveAll(userEntityList);
                } else {
                    throw Constant.ExceptionRepo.EXCEL_ROW_LESS;
                }
            } else {
                throw Constant.ExceptionRepo.EXCEL_FILE_TYPE_ERROR;
            }
            return new GlobalMessage("0", "操作成功");
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            throw Constant.ExceptionRepo.EXCEL_COL_ERROR;
        }
    }

    @LogAnnotation(value = "绩效考核结果导出", params = true, result = true)
    public XSSFWorkbook showUserInfo() {
        List<UserEntity> userEntityList = userRepo.findAll();
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("员工基本信息");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("员工号");//第一列
        titleRow.createCell(1).setCellValue("员工姓名");
        titleRow.createCell(2).setCellValue("性别");
        titleRow.createCell(3).setCellValue("身份证号");
        titleRow.createCell(4).setCellValue("手机号");
        titleRow.createCell(5).setCellValue("部门");
        titleRow.createCell(6).setCellValue("职位");
        titleRow.createCell(7).setCellValue("入司时间");
        titleRow.createCell(8).setCellValue("邮箱");
        int cell = 1;
        for (UserEntity userEntity : userEntityList) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(userEntity.getUserNum());
            row.createCell(1).setCellValue(userEntity.getName());//将数据库的数据遍历出来
            row.createCell(2).setCellValue(userEntity.getSex());
            row.createCell(3).setCellValue(userEntity.getIdcard());
            row.createCell(4).setCellValue(userEntity.getMobile());
            row.createCell(5).setCellValue(userEntity.getDep());
            row.createCell(6).setCellValue(userEntity.getPosition());
            row.createCell(7).setCellValue(userEntity.getStartTime());
            row.createCell(8).setCellValue(userEntity.getMail());
            cell++;
        }
        return wb;
    }
}

