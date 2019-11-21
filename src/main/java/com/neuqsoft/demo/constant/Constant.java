package com.neuqsoft.demo.constant;

import com.neuqsoft.commons.spring.exception.GlobalException;

/**
 * @Author: chensz
 * @CreateTime: 2019-11-19 10:29
 * @Description:
 */
public class Constant {

    public static class ExceptionRepo {

        public static final GlobalException USER_EXIST = new GlobalException("-1101", "用户已存在，请直接登陆");
        public static final GlobalException PASSWORD_NOT_EQUAL = new GlobalException("-1102", "原密码不正确，请先输入正确的密码");
        public static final GlobalException USER_NOT_EXIST = new GlobalException("-1103", "该人员不存在");
        public static final GlobalException FILE_ERROR = new GlobalException("-1", "文件空");
        public static final GlobalException EXCEL_FILE_TYPE_ERROR = new GlobalException("-1117", "excel文件类型不是xlsx");
        public static final GlobalException EXCEL_READ_ERROR = new GlobalException("-1118", "读取Excel数据出错");
        public static final GlobalException EXCEL_COL_ERROR = new GlobalException("-1119", "导入报错，请确认导入的Excel和模板列数是否一致！");
        public static final GlobalException EXCEL_ROW_LESS = new GlobalException("-1120", "导入报错，数据量不足！");
        public static final GlobalException NUMBER_NOT_NULL = new GlobalException("-1121", "员工号不能为空");
        public static final GlobalException NAME_NOT_NULL = new GlobalException("-1122", "姓名不能为空");
        public static final GlobalException SEX_NOT_NULL = new GlobalException("-1123", "性别不能为空");
        public static final GlobalException IDCARD_NOT_NULL = new GlobalException("-1124", "身份证号不能为空");
        public static final GlobalException MOBILE_NOT_NULL = new GlobalException("-1125", "手机号不能为空");
        public static final GlobalException DEP_NOT_NULL = new GlobalException("-1126", "部门不能为空");
        public static final GlobalException POSITION_NOT_NULL = new GlobalException("-1127", "职位不能为空");
        public static final GlobalException STARTTIME_NOT_NULL = new GlobalException("-1128", "入职时间不能为空");
        public static final GlobalException MAIL_NOT_NULL = new GlobalException("-1129", "邮箱不能为空");
    }
}
