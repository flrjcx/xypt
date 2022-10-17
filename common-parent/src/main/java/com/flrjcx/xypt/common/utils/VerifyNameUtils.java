package com.flrjcx.xypt.common.utils;

import com.flrjcx.xypt.common.constants.*;
import com.flrjcx.xypt.common.enums.FieldExceedEnum;
import com.flrjcx.xypt.common.enums.MessageHintEnum;

public class VerifyNameUtils {
    public static Integer minusLength = -1;
    public static String verifyIllegalStr(String illegal) {
        int malakaQ = illegal.indexOf(".");
        if (malakaQ != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(malakaQ);
        }
        int i = malakaQ = illegal.indexOf("!");
        if (i != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i);
        }
        int i1 = malakaQ = illegal.indexOf("@");
        if (i1 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i1);
        }
        int i2 = malakaQ = illegal.indexOf("#");
        if (i2 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i2);
        }
        int $ = malakaQ = illegal.indexOf("$");
        if ($ != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt($);
        }
        int i3 = malakaQ = illegal.indexOf("%");
        if (i3 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i3);
        }
        int i4 = malakaQ = illegal.indexOf("……");
        if (i4 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i4);
        }
        int ￥ = malakaQ = illegal.indexOf("￥");
        if (￥ != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(￥);
        }
        int i5 = malakaQ = illegal.indexOf("…");
        if (i5 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i5);
        }
        int i6 = malakaQ = illegal.indexOf("^");
        if (i6 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i6);
        }
        int i7 = malakaQ = illegal.indexOf("&");
        if (i7 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i7);
        }
        int i8 = malakaQ = illegal.indexOf("&");
        if (i8 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i8);
        }
        int i9 = malakaQ = illegal.indexOf("*");
        if (i9 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i9);
        }
        int i10 = malakaQ = illegal.indexOf("*");
        if (i10 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i10);
        }
        int i11 = malakaQ = illegal.indexOf("(");
        if (i11 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i11);
        }
        int i12 = malakaQ = illegal.indexOf("+");
        if (i12 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i12);
        }
        int i13 = malakaQ = illegal.indexOf("=");
        if (i13 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i13);
        }
        int i14 = malakaQ = illegal.indexOf("-");
        if (i14 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i14);
        }
        int i15 = malakaQ = illegal.indexOf("/");
        if (i15 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i15);
        }
        int i16 = malakaQ = illegal.indexOf("<");
        if (i16 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i16);
        }
        int i17 = malakaQ = illegal.indexOf(">");
        if (i17 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i17);
        }
        int i18 = malakaQ = illegal.indexOf("?");
        if (i18 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i18);
        }
        int i19 = malakaQ = illegal.indexOf("|");
        if (i19 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i19);
        }
        int i20 = malakaQ = illegal.indexOf(")");
        if (i != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i);
        }
        int i21 = malakaQ = illegal.indexOf("·");
        if (i21 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i21);
        }
        int i22 = malakaQ = illegal.indexOf(";");
        if (i22 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i22);
        }
        int i23 = malakaQ = illegal.indexOf("；");
        if (i23 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i23);
        }
        int i24 = malakaQ = illegal.indexOf("：");
        if (i24 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i24);
        }
        int i25 = malakaQ = illegal.indexOf("’");
        if (i25 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i25);
        }
        int i26 = malakaQ = illegal.indexOf("‘");
        if (i26 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i26);
        }
        int i27 = malakaQ = illegal.indexOf("【");
        if (i27 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i27);
        }
        int i28 = malakaQ = illegal.indexOf("[");
        if (i28 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i28);
        }
        int i29 = malakaQ = illegal.indexOf("]");
        if (i29 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i29);
        }
        int i30 = malakaQ = illegal.indexOf("】");
        if (i30 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i30);
        }
        int i31 = malakaQ = illegal.indexOf("{");
        if (i31 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i31);
        }
        int i32 = malakaQ = illegal.indexOf("}");
        if (i32 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i32);
        }
        int i33 = malakaQ = illegal.indexOf("|");
        if (i33 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i33);
        }
        int i34 = malakaQ = illegal.indexOf("\\");
        if (i34 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i34);
        }
        int i35 = malakaQ = illegal.indexOf("“");
        if (i35 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i35);
        }
        int i36 = malakaQ = illegal.indexOf("”");
        if (i36 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i36);
        }
        int i37 = malakaQ = illegal.indexOf("'");
        if (i37 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i37);
        }
        int i38 = malakaQ = illegal.indexOf("、");
        if (i38 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i38);
        }
        int i39 = malakaQ = illegal.indexOf("（");
        if (i39 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i39);
        }
        int i40 = malakaQ = illegal.indexOf("）");
        if (i40 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i40);
        }
        int i41 = malakaQ = illegal.indexOf("—");
        if (i41 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i41);
        }
        int i42 = malakaQ = illegal.indexOf(" ");
        if (i42 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i42);
        }
        int i43 = malakaQ = illegal.indexOf("，");
        if (i43 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i43);
        }
        int i44 = malakaQ = illegal.indexOf("。");
        if (i44 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i44);
        }
        int i45 = malakaQ = illegal.indexOf("、");
        if (i45 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i45);
        }
        int i46 = malakaQ = illegal.indexOf("；");
        if (i46 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i46);
        }
        int i47 = malakaQ = illegal.indexOf(";");
        if (i47 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i47);
        }
        int i48 = malakaQ = illegal.indexOf(",");
        if (i48 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i48);
        }
        int i49 = malakaQ = illegal.indexOf("`");
        if (i49 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i49);
        }
        int i50 = malakaQ = illegal.indexOf("·");
        if (i50 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(i50);
        }
        int nm = malakaQ = illegal.indexOf("你妈");
        if (nm != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(nm);
        }
        int sb = malakaQ = illegal.indexOf("sb");
        if (sb != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(sb);
        }
        int cnsb = malakaQ = illegal.indexOf("傻逼");
        if (cnsb != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(cnsb);
        }
        int shag = malakaQ = illegal.indexOf("傻狗");
        if (shag != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(shag);
        }
        int shabi = malakaQ = illegal.indexOf("shabi");
        if (shabi != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(shabi);
        }
        int nmsl = malakaQ = illegal.indexOf("nmsl");
        if (nmsl != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(nmsl);
        }
        int nm111 = malakaQ = illegal.indexOf("你娘");
        if (nm111 != minusLength) {
            return MessageConstants.REGISTER_NAME_ERROR+"非法字符为：" + illegal.charAt(nm111);
        }
        return MessageConstants.VERIFY_NAME_RESULT_MSG;
    }

    public static String verifyRegisterMsg(String name,String passName,String password,String email,String passEmail,String address,long phone){
        // 用户名为空
        if (null == name || MessageHintEnum.StrIsNull.getMessage().equals(name)) {
            return  MessageConstants.REGISTER_NAME_NULL;
        }
//        用户名长度
        if (name.length() > FieldExceedEnum.NameLengthExceed.getCode()) {
            return MessageConstants.REGISTER_TXT_EXCEED;
        }
        //用户名已存在
        if (name.equals(passName)) {
            return MessageConstants.REGISTER_USERNAME_EXIST;
        }
//        校验用户名中是否含有非法字符
        String verifyIllegalStr = VerifyNameUtils.verifyIllegalStr(name);
        if (!MessageHintEnum.UserNamePass.getMessage().equals(verifyIllegalStr)) {
            return MessageConstants.REGISTER_NAME_ERROR+verifyIllegalStr;
        }
        // 密码为空
        if (null == password || MessageHintEnum.StrIsNull.getMessage().equals(password)) {
            return MessageConstants.REGISTER_PASSWORD_NULL;
        }
//        验证密码长度
        if (password.length() > FieldExceedEnum.NameLengthExceed.getCode()) {
            return MessageConstants.REGISTER_PASSWORD_EXCEED;
        }
        // 邮箱为空
        if (null == email || MessageHintEnum.StrIsNull.getMessage().equals(email)) {
            return MessageConstants.REGISTER_EMAIL_NULL;
        }
//        验证邮箱格式
        if (!CheckAllUsersUtils.verifyEmail(email)) {
            return MessageConstants.REGISTER_EMAIL_ERROR;
        }
        //邮箱已被绑定
        if (email.equals(passEmail)) {
            return MessageConstants.REGISTER_EMAIL_EXIST;
        }
//       验证地址长度
        if (address.length() > FieldExceedEnum.AddressLengthExceed.getCode()) {
            return MessageConstants.REGISTER_ADDRESS_EXCEED;
        }
//        校验手机号格式
        String strPhone = String.valueOf(phone);
        Boolean regexPhone = CheckAllUsersUtils.regexPhone((strPhone));
        if (!regexPhone) {
            return MessageConstants.REGISTER_PHONE_EXCEED;
        }
        return MessageConstants.VERIFY_NAME_RESULT_MSG;
    }
}
