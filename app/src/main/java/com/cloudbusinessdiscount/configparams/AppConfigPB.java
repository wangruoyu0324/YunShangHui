/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p/>
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.cloudbusinessdiscount.configparams;

import android.content.Context;

import java.io.Serializable;

/**
 * app全局参数设置
 */
public class AppConfigPB extends PreferenceBeanHelper implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /* vip主表*/
    public static final String VIP = "vip";//json字符串获取当前用户的数据
    private String vip = "";
    public static final String INITTIME = "inittime";//用戶下載使用APP的時間
    private String inittime = "";
    public static final String DACCOUNT = "daccount";//代注册账号
    private String daccount = "";
    public static final String ACCOUNT = "account";//帐号  自动生成唯一帐号
    private String account = "";
    public static final String PASSWD = "passwd";//密码  Md5(3des(string),32)
    private String passwd = "";
    public static final String PASSWORD = "password";//密码  明文
    private String password = "";
    public static final String PHONE = "phone";//手机号
    private String phone = "";
    public static final String RTIME = "rtime";//注册时间戳
    private String rtime = "";
    public static final String LTIME = "ltime";//最近登录时间
    private String ltime = "";
    public static final String CHK = "chk";//登录限制  1（允许登录）0（拒绝登录）
    private String chk = "1";
    public static final String RPLATFORM = "rplatform";//注册平台
    private String rplatform = "1";
    public static final String LPLATFORM = "lplatform";//登录平台
    private String lplatform = "1";
    //    public static final String LPLATFORMID = "lplatformid";//登录平台ID
//    private String lplatformid = "";
    public static final String OPENIDWX = "openidWx";//微信授权id
    private String openidWx = "";
    public static final String OPENIDQQ = "openidQq";//QQ授权id
    private String openidQq = "";
    public static final String OPENIDSINA = "openidSina";//新浪授权id
    private String openidSina = "";
    public static final String PHOTO = "photo";//用户头像
    private String photo = "";
    public static final String PHOTOS = "photos";//用户头像集合
    private String photos = "";
    public static final String BGIMG = "bgimg";//背景图片
    private String bgimg = "";


    public static final String MYVIDEO = "myVideo";//我的视频
    private String myVideo = "";
    public static final String MONOLOGUE = "monologue";//爱情独白
    private String monologue = "";


    public static final String SCORE = "score";//分数
    private int score = 0;
    public static final String LEVEL = "level";//等级
    private int level = 1;
    public static final String WEIGHT = "weight";//体重
    private String weight = "-1";


    /* vip_base基本信息表*/
    public static final String UNAME = "uname";//昵称
    private String uname = "";
    public static final String NAME = "name";//姓名  身份证认证后自动保存
    private String name = "";
    public static final String IMG = "img";//头像
    private String img = "";
    public static final String TAG = "tag";//用户标签
    private String tag = "";
    public static final String WED = "wed";//婚姻状态
    private int wed = -1;
    public static final String SIGN = "sign";//签名
    private String sign = "";
    public static final String JOB = "job";//职位
    private String job = "";
    public static final String COMPANY = "company";//公司名称
    private String company = "";
    public static final String WAGES = "wages";//薪资（起）
    private int wages = -1;
    public static final String WAGEN = "wagen";//薪资（终）
    private int wagen = -1;
    public static final String WAGES_MATEDEMANDS = "wages_matedemands";//择偶要求薪资（起）
    private int wages_matedemands = -1;
    public static final String WAGEN_MATEDEMANDS = "wagen_matedemands";//择偶要求薪资（终）
    private int wagen_matedemands = -1;
    public static final String AGES_MATEDEMANDS = "ages";//择偶要求年龄（起）
    private int ages = -1;
    public static final String AGEN_MATEDEMANDS = "agen";//择偶要求年龄（终）
    private int agen = -1;
    public static final String EDU_MATEDEMANDS = "edu_matedemands";//择偶要求学历
    private int edu_matedemands = -1;
    public static final String EDU = "edu";//学历
    private int edu = -1;
    public static final String NATION = "nation";//民族
    private String nation = "";
    public static final String HEIGHT = "height";//身高（cm）
    private int height = -1;
    public static final String SEX = "sex";//性别
    private int sex = -1;
    public static final String BIR = "bir";//生日
    private String bir = "";
    public static final String SMOKE = "smoke";//吸烟
    private int smoke = -1;
    public static final String WINE = "wine";//喝酒
    private int wine = -1;
    public static final String SMOKE_MATEDEMANDS = "smoke_matedemands";//择偶要求吸烟
    private int smoke_matedemands = -1;
    public static final String WINE_MATEDEMANDS = "wine_matedemands";//择偶要求喝酒
    private int wine_matedemands = -1;
    public static final String HOUSEWORK_MATEDEMANDS = "housework_matedemands";//择偶要求家务
    private int housework_matedemands = -1;
    public static final String COOKING_MATEDEMANDS = "cooking_matedemands";//择偶要求厨艺
    private int cooking_matedemands = -1;
    public static final String HOUSEWORK = "housework";//家务
    private int housework = -1;
    public static final String COOKING = "cooking";//厨艺
    private int cooking = -1;
    public static final String EXERCISE = "exercise";//锻炼
    private int exercise = -1;
    public static final String HOBBY = "hobby";//爱好
    private String hobby = "";
    public static final String PET = "pet";//宠物
    private int pet = -1;
    public static final String HOBBY_MATEDEMANDS = "hobby_matedemands";//择偶要求爱好
    private String hobby_matedemands = "";
    public static final String REMARK_MATEDEMANDS = "remark_matedemands";//择偶要求备注
    private String remark_matedemands = "";
    public static final String ADDRESS = "address";//所在地
    private String address = "";
    public static final String HADDRESS = "haddress";//家乡
    private String haddress = "";
    public static final String HOUSECHK = "houseChk";//是否有房
    private int houseChk = 0;
    public static final String CARCHK = "carChk";//是否有车
    private int carChk = 0;
    public static final String IDCARDCHK = "idcardChk";//是否上传了身份证
    private int idcardChk = 0;
    public static final String HOUSE_MATEDEMANDS = "house_matedemands";//择偶要求是否有房
    private int house_matedemands = 0;
    public static final String CAR_MATEDEMANDS = "car_matedemands";//择偶要求是否有车
    private int car_matedemands = 0;
    public static final String MARRY = "marry";//婚姻迫切度
    private int marry = -1;
    public static final String ZHIMAAUTH = "zhimaAuth";//芝麻信用认证
    private int zhimaAuth = 0;
    public static final String HOUSEAUTH = "houseAuth";//房产认证
    private int houseAuth = 0;
    public static final String CARAUTH = "carAuth";//汽车认证
    private int carAuth = 0;
    public static final String IDCARDAUTH = "idcardAuth";//身份证认证
    private int idcardAuth = 0;
    public static final String RELATIVEAUTH = "relativeAuth";//亲友团认证
    private int relativeAuth = 0;
    public static final String PLATFORMAUTH = "platformAuth";//平台签约认证
    private int platformAuth = 0;
    public static final String COMPANYAUTH = "companyAuth";//单位认证
    private int companyAuth = 0;
    public static final String HOUSEAUTHCONT = "houseauthcont";//房产认证信息
    private String houseauthcont = "";
    public static final String CARAUTHCONT = "carauthcont";//汽车认证信息
    private String carauthcont = "";
    public static final String IDCARDAUTHCONT = "idcardauthcont";//身份证认证信息
    private String idcardauthcont = "";
    public static final String FRIENDSAUTHCONT = "friendsauthcont";//亲友团认证信息
    private String friendsauthcont = "";
    public static final String PLATFORMAUTHCONT = "platformauthcont";//平台认证信息
    private String platformauthcont = "";
    public static final String UNITAUTHCONT = "unitauthcont";//单位认证信息
    private String unitauthcont = "";

    /* vip_spouse  择偶要求表*/
    public static final String INDUSTRY = "industry";//职业编号
    private String industry = "";
    public static final String HEIGHTS_MATEDEMANDS = "heights";//择偶要求身高（起）
    private int heights = -1;
    public static final String HEIGHTN_MATEDEMANDS = "heightn";//择偶要求身高（终）
    private int heightn = -1;


    /* vip_spouse  兴趣表*/
    public static final String INTEREST = "interest";//兴趣（json格式）
    private String interest = "";
    public static final String DEMAND = "demand";//择偶信息（json格式）
    private String demand = "";

    /* vip_spouse  认证表*/
    public static final String ID = "id";//唯一识别
    private int id = 0;
    public static final String CONT = "cont";//认证信息（json格式）
    private String cont = "";
    public static final String WAY_AUTHO = "way_autho";//认证类型  idcard（身份证）    house（房产）   car（汽车） company（企业）   platform（平台合同）
    private String way_autho = "";
    public static final String STIME_AUTHO = "stime_autho";//认证时间
    private String stime_autho = "";

    /* vip_spouse  关系表*/
    public static final String WAY_RELATIONSHIP = "way";//关系类型
    private String way = "";
    public static final String STIME_RELATIONSHIP = "stime_relationship";//成为对应关系的时间
    private String stime_relationship = "";

    /* vip_spouse 推荐表*/
    public static final String CODE = "code";//推荐码（json格式）
    private String code = "";


    public static final String COMPANYACCOUNT = "companyaccount";//企业账号
    private String companyaccount = "";
    public static final String COMPANYTITLE = "companytitle";//企业名称
    private String companytitle = "";
    public static final String COMPANYINFO = "companyinfo";//企业介绍
    private String companyinfo = "";
    public static final String COMPANYBGIMG = "companybgimg";//企业背景
    private String companybgimg = "";
    public static final String COMPANYADDRESS = "companyaddress";//企业地址
    private String companyaddress = "";
    public static final String COMPANYTELEPHONE = "companytelephone";//企业电话
    private String companytelephone = "";
    public static final String COMPANYINDUSTRY = "companyindustry";//企业所属行业
    private String companyindustry = "";
    public static final String COMPANYLOGO = "companylogo";//企业LOGO
    private String companylogo = "";
    public static final String COMPANYBUSLIC = "companybuslic";//企业营业执照
    private String companybuslic = "";
    public static final String CURRENTCITY = "currentcity";//当前城市
    private String currentcity = "";
    public static final String LONGITUDE = "longitude";//当前位置经度
    private String longitude = "";
    public static final String LATITUDE = "latitude";//当前位置纬度
    private String latitude = "";
    public static final String CURRENTADDRESS = "currentaddress";//当前位置
    private String currentaddress = "";
    public static final String CURRENTDISTRICT = "currentdistrict";//当前区
    private String currentdistrict = "";
    public static final String CURRENTSTREET = "currentstreet";//当前街道
    private String currentstreet = "";
    public static final String CURRENTSTREETNUM = "currentstreetnum";//当前街道号
    private String currentstreetnum = "";


    public static final String COMPANYALBUM = "companyalbum";//企业相册
    private String companyalbum = "";
    public static final String COMPANYREGISTERTIME = "companyregistertime";//企业注册时间
    private String companyregistertime = "";
    public static final String COMPANYMANAGER = "companymanager";//是否是企业管理员
    private String companymanager = "";
    public static final String MYCOMPANYAUTH = "mycompanyauth";//注册企业是否后台审核通过
    private String mycompanyauth = "";
    public static final String MYCOMPANYFAIL = "mycompanyfail";//注册企业后台审核失败原因
    private String mycompanyfail = "";
    public static final String IMPRESSION_LABELS = "impression_labels";//系统标签印象
    private String impression_labels = "";
    public static final String IMPRESSION_TEXT = "impression_text";//文字印象
    private String impression_text = "";
    public static final String IMPRESSION_VOICE = "impression_voice";//语音印象
    private String impression_voice = "";
    public static final String IMPRESSION_VEDIO = "impression_vedio";//视频印象
    private String impression_vedio = "";

    public static final String LEVAUTH = "levauth";//认证状态 0/1
    private String levauth = "";
    //    public static final String LEVFATE = "level";//寻缘权限 0/1
//    private String level = "";
//    public static final String LEVHOME = "level";//首页推送权限 0/1
//    private String level = "";
    public static final String LEVHMOM = "levhmom";//红娘推荐权限 0/1
    private String levhmom = "";
    public static final String DBLOGIN = "dblogin";//是否多处登录 0/1
    private String dblogin = "";
    public static final String OPEN = "open";//是否授权登录成功 0/1
    private String open = "";
    public static final String CIRCLEAUTH = "circleauth";//圈子认证状态 0/1
    private String circleauth = "";


    public static final String SITEADDRESS_API = "siteAddress_Api";
    private String siteAddress_Api = "";
    public static final String SITEADDRESS_HOME = "siteAddress_Home";
    private String siteAddress_Home = "";
    public static final String SITEADDRESS_VIP = "siteAddress_Vip";
    private String siteAddress_Vip = "";
    public static final String SITEADDRESS_SCORE = "siteAddress_Score";
    private String siteAddress_Score = "";
    public static final String SITEADDRESS_HELP = "siteAddress_Help";
    private String siteAddress_Help = "";
    public static final String SITEADDRESS_DYN = "siteAddress_Dyn";
    private String siteAddress_Dyn = "";
    public static final String SITEADDRESS_COM = "siteAddress_Com";
    private String siteAddress_Com = "";
    public static final String SITEADDRESS_ITRT = "siteAddress_Itrt";
    private String siteAddress_Itrt = "";
    public static final String SITEADDRESS_CHAT = "siteAddress_Chat";
    private String siteAddress_Chat = "";
    public static final String SITEADDRESS_MSG = "siteAddress_Msg";
    private String siteAddress_Msg = "";
    public static final String SITEADDRESS_FILE = "siteAddress_File";
    private String siteAddress_File = "";
    public static final String SITEADDRESS_DATA = "siteAddress_Data";
    private String siteAddress_Data = "";
    public static final String SITEADDRESS_SHOP = "siteAddress_Shop";
    private String siteAddress_Shop = "";
    public static final String SITEADDRESS_FATE = "siteAddress_Fate";
    private String siteAddress_Fate = "";
    public static final String SITEADDRESS_LOG = "siteAddress_Log";
    private String siteAddress_Log = "";
    public static final String SITEADDRESS_UPLOAD = "siteAddress_Upload";
    private String siteAddress_Upload = "";


    public static final String UPLOADSTATUS = "uploadstatus";//后台是否正在上传文件  0：未上传 1：图片  2：视频  3：心情（也是图片）
    private String uploadstatus = "";
    public static final String UPLOADSCREENSHOT = "uploadscreenshot";//后台正在上传视频的截图
    private String uploadscreenshot = "";

    public static final String ISSHOWIDCARD_LEAKAUTH = "isShowIdcard_LeakAuth";
    private String isShowIdcard_LeakAuth = "";


    public static final String ISSHOWGUIDEVIEW_STROLLFRAGMENT_ONE = "isshowguideview_strollfragment_one";//逛逛第一个指示
    private String isshowguideview_strollfragment_one = "";
    public static final String ISSHOWGUIDEVIEW_STROLLFRAGMENT_TWO = "isshowguideview_strollfragment_two";//逛逛第二个指示
    private String isshowguideview_strollfragment_two = "";
    public static final String ISSHOWGUIDEVIEW_STROLLFRAGMENT_THREE = "isshowguideview_strollfragment_three";//逛逛第三个指示
    private String isshowguideview_strollfragment_three = "";
    public static final String ISSHOWGUIDEVIEW_STROLLFRAGMENT_FOUR = "isshowguideview_strollfragment_four";//逛逛第四个指示
    private String isshowguideview_strollfragment_four = "";
    public static final String ISSHOWGUIDEVIEW_FINDFATEFRAGMENT_AVATAR = "isshowguideview_findfatefragment_avatar";//寻缘用户头像指示
    private String isshowguideview_findfatefragment_avatar = "";
    public static final String ISSHOWGUIDEVIEW_FINDFATEFRAGMENT_RELATIVE = "isshowguideview_findfatefragment_relative";//寻缘用户关联指示
    private String isshowguideview_findfatefragment_relative = "";
    public static final String ISSHOWGUIDEVIEW_FINDFATEFRAGMENT_FILTER = "isshowguideview_findfatefragment_filter";//寻缘用户筛选指示
    private String isshowguideview_findfatefragment_filter = "";
    public static final String ISSHOWGUIDEVIEW_DYNAMICFRAGMENT = "isshowguideview_dynamicfragment";//动态发布指示
    private String isshowguideview_dynamicfragment = "";
    public static final String ISSHOWGUIDEVIEW_INTERACTIONFRAGMENT = "isshowguideview_interactionfragment";//互动发布指示
    private String isshowguideview_interactionfragment = "";
    public static final String ISSHOWGUIDEVIEW_MINEFRAGMENT_PUBLISHDYNAMIC = "isshowguideview_minefragment_publishdynamic";//我的发布动态指示（有权限）
    private String isshowguideview_minefragment_publishdynamic = "";
    public static final String ISSHOWGUIDEVIEW_MINEFRAGMENT_REPLACEREGISTER = "isshowguideview_minefragment_replaceregister";//我的代注册指示（有权限）
    private String isshowguideview_minefragment_replaceregister = "";
    public static final String ISSHOWGUIDEVIEW_MINEFRAGMENT_REGISTERCODE = "isshowguideview_minefragment_registercode";//我的推荐注册码指示（有权限）
    private String isshowguideview_minefragment_registercode = "";
    public static final String ISSHOWGUIDEVIEW_MINEFRAGMENT_PERFECTINFO = "isshowguideview_minefragment_perfectinfo";//我的完善资料指示（无权限）
    private String isshowguideview_minefragment_perfectinfo = "";
    public static final String ISSHOWGUIDEVIEW_MINEFRAGMENT_ADDCIRCLE = "isshowguideview_minefragment_addcircle";//我的添加圈子指示（无权限）
    private String isshowguideview_minefragment_addcircle = "";
    public static final String ISSHOWGUIDEVIEW_PERSONALAVATAR_LEFT = "isshowguideview_personalavatar_left";//头像页面左侧添加按钮指示
    private String isshowguideview_personalavatar_left = "";
    public static final String ISSHOWGUIDEVIEW_PERSONALAVATAR_RIGHT = "isshowguideview_personalavatar_right";//头像页面右侧会话按钮指示
    private String isshowguideview_personalavatar_right = "";

    public String getIsShowIdcard_LeakAuth() {
        return isShowIdcard_LeakAuth;
    }

    public void setIsShowIdcard_LeakAuth(String isShowIdcard_LeakAuth) {
        this.isShowIdcard_LeakAuth = isShowIdcard_LeakAuth;
    }


    public void init(Context context) {
        super.init(context);
        try {
            loadFromPref();
        } catch (Exception e) {
            LogFactory.createLog().error(e);
        }
    }

    public void initNoSync(Context context) {
        super.init(context);
    }

    public boolean isDataInvalid() {
        if (id == 0) {
            return true;
        } else
            return false;
    }

    public void setDataInvalid() {//设置本地数据无效，清除本地数据（退出账号时）
        this.id = 0;
        try {
            clearPref();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void updateAll() {//更新所有本地数据
        try {
            super.updatePreferAll();
        } catch (Exception e) {
            LogFactory.createLog().error(e);
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenidWx() {
        return openidWx;
    }

    public void setOpenidWx(String openidWx) {
        this.openidWx = openidWx;
    }

    public String getOpenidQq() {
        return openidQq;
    }

    public void setOpenidQq(String openidQq) {
        this.openidQq = openidQq;
    }

    public String getOpenidSina() {
        return openidSina;
    }

    public void setOpenidSina(String openidSina) {
        this.openidSina = openidSina;
    }

    public String getCircleauth() {
        return circleauth;
    }

    public void setCircleauth(String circleauth) {
        this.circleauth = circleauth;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWed() {
        return wed;
    }

    public void setWed(int wed) {
        this.wed = wed;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }

    public int getWagen() {
        return wagen;
    }

    public void setWagen(int wagen) {
        this.wagen = wagen;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }

    public int getAgen() {
        return agen;
    }

    public void setAgen(int agen) {
        this.agen = agen;
    }

    public int getEdu() {
        return edu;
    }

    public void setEdu(int edu) {
        this.edu = edu;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChk() {
        return chk;
    }

    public void setChk(String chk) {
        this.chk = chk;
    }

    public int getCarChk() {
        return carChk;
    }

    public void setCarChk(int carChk) {
        this.carChk = carChk;
    }

    public int getHouseChk() {
        return houseChk;
    }

    public void setHouseChk(int houseChk) {
        this.houseChk = houseChk;
    }

    public int getMarry() {
        return marry;
    }

    public void setMarry(int marry) {
        this.marry = marry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getWages_matedemands() {
        return wages_matedemands;
    }

    public void setWages_matedemands(int wages_matedemands) {
        this.wages_matedemands = wages_matedemands;
    }

    public int getWagen_matedemands() {
        return wagen_matedemands;
    }

    public void setWagen_matedemands(int wagen_matedemands) {
        this.wagen_matedemands = wagen_matedemands;
    }

    public int getEdu_matedemands() {
        return edu_matedemands;
    }

    public void setEdu_matedemands(int edu_matedemands) {
        this.edu_matedemands = edu_matedemands;
    }

    public int getCar_matedemands() {
        return car_matedemands;
    }

    public void setCar_matedemands(int car_matedemands) {
        this.car_matedemands = car_matedemands;
    }

    public int getHouse_matedemands() {
        return house_matedemands;
    }

    public void setHouse_matedemands(int house_matedemands) {
        this.house_matedemands = house_matedemands;
    }

    public int getSmoke_matedemands() {
        return smoke_matedemands;
    }

    public void setSmoke_matedemands(int smoke_matedemands) {
        this.smoke_matedemands = smoke_matedemands;
    }

    public int getWine_matedemands() {
        return wine_matedemands;
    }

    public void setWine_matedemands(int wine_matedemands) {
        this.wine_matedemands = wine_matedemands;
    }

    public int getHousework_matedemands() {
        return housework_matedemands;
    }

    public void setHousework_matedemands(int housework_matedemands) {
        this.housework_matedemands = housework_matedemands;
    }

    public int getCooking_matedemands() {
        return cooking_matedemands;
    }

    public void setCooking_matedemands(int cooking_matedemands) {
        this.cooking_matedemands = cooking_matedemands;
    }

    public String getHobby_matedemands() {
        return hobby_matedemands;
    }

    public void setHobby_matedemands(String hobby_matedemands) {
        this.hobby_matedemands = hobby_matedemands;
    }

    public String getRemark_matedemands() {
        return remark_matedemands;
    }

    public void setRemark_matedemands(String remark_matedemands) {
        this.remark_matedemands = remark_matedemands;
    }

    public int getHeights() {
        return heights;
    }

    public void setHeights(int heights) {
        this.heights = heights;
    }

    public int getHeightn() {
        return heightn;
    }

    public void setHeightn(int heightn) {
        this.heightn = heightn;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getWine() {
        return wine;
    }

    public void setWine(int wine) {
        this.wine = wine;
    }

    public int getSmoke() {
        return smoke;
    }

    public void setSmoke(int smoke) {
        this.smoke = smoke;
    }

    public int getHousework() {
        return housework;
    }

    public void setHousework(int housework) {
        this.housework = housework;
    }

    public int getCooking() {
        return cooking;
    }

    public void setCooking(int cooking) {
        this.cooking = cooking;
    }

    public int getExercise() {
        return exercise;
    }

    public void setExercise(int exercise) {
        this.exercise = exercise;
    }

    public int getPet() {
        return pet;
    }

    public void setPet(int pet) {
        this.pet = pet;
    }

    public int getPlatformAuth() {
        return platformAuth;
    }

    public void setPlatformAuth(int platformAuth) {
        this.platformAuth = platformAuth;
    }

    public int getRelativeAuth() {
        return relativeAuth;
    }

    public void setRelativeAuth(int relativeAuth) {
        this.relativeAuth = relativeAuth;
    }

    public int getIdcardAuth() {
        return idcardAuth;
    }

    public void setIdcardAuth(int idcardAuth) {
        this.idcardAuth = idcardAuth;
    }

    public int getCompanyAuth() {
        return companyAuth;
    }

    public void setCompanyAuth(int companyAuth) {
        this.companyAuth = companyAuth;
    }

    public int getCarAuth() {
        return carAuth;
    }

    public void setCarAuth(int carAuth) {
        this.carAuth = carAuth;
    }

    public int getHouseAuth() {
        return houseAuth;
    }

    public void setHouseAuth(int houseAuth) {
        this.houseAuth = houseAuth;
    }

    public int getZhimaAuth() {
        return zhimaAuth;
    }

    public void setZhimaAuth(int zhimaAuth) {
        this.zhimaAuth = zhimaAuth;
    }

    public String getHouseauthcont() {
        return houseauthcont;
    }

    public void setHouseauthcont(String houseauthcont) {
        this.houseauthcont = houseauthcont;
    }

    public String getCarauthcont() {
        return carauthcont;
    }

    public void setCarauthcont(String carauthcont) {
        this.carauthcont = carauthcont;
    }

    public String getIdcardauthcont() {
        return idcardauthcont;
    }

    public void setIdcardauthcont(String idcardauthcont) {
        this.idcardauthcont = idcardauthcont;
    }

    public String getFriendsauthcont() {
        return friendsauthcont;
    }

    public void setFriendsauthcont(String friendsauthcont) {
        this.friendsauthcont = friendsauthcont;
    }

    public String getPlatformauthcont() {
        return platformauthcont;
    }

    public void setPlatformauthcont(String platformauthcont) {
        this.platformauthcont = platformauthcont;
    }

    public String getUnitauthcont() {
        return unitauthcont;
    }

    public void setUnitauthcont(String unitauthcont) {
        this.unitauthcont = unitauthcont;
    }

    public String getCompanyaccount() {
        return companyaccount;
    }

    public void setCompanyaccount(String companyaccount) {
        this.companyaccount = companyaccount;
    }

    public String getCompanytitle() {
        return companytitle;
    }

    public void setCompanytitle(String companytitle) {
        this.companytitle = companytitle;
    }

    public String getCompanyinfo() {
        return companyinfo;
    }

    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo;
    }

    public String getCompanybgimg() {
        return companybgimg;
    }

    public void setCompanybgimg(String companybgimg) {
        this.companybgimg = companybgimg;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getCompanytelephone() {
        return companytelephone;
    }

    public void setCompanytelephone(String companytelephone) {
        this.companytelephone = companytelephone;
    }

    public String getCompanyindustry() {
        return companyindustry;
    }

    public void setCompanyindustry(String companyindustry) {
        this.companyindustry = companyindustry;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public String getCompanybuslic() {
        return companybuslic;
    }

    public void setCompanybuslic(String companybuslic) {
        this.companybuslic = companybuslic;
    }

    public String getCompanyalbum() {
        return companyalbum;
    }

    public void setCompanyalbum(String companyalbum) {
        this.companyalbum = companyalbum;
    }

    public String getCompanyregistertime() {
        return companyregistertime;
    }

    public void setCompanyregistertime(String companyregistertime) {
        this.companyregistertime = companyregistertime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCurrentcity() {
        return currentcity;
    }

    public void setCurrentcity(String currentcity) {
        this.currentcity = currentcity;
    }

    public String getCurrentaddress() {
        return currentaddress;
    }

    public void setCurrentaddress(String currentaddress) {
        this.currentaddress = currentaddress;
    }

    public String getCurrentdistrict() {
        return currentdistrict;
    }

    public void setCurrentdistrict(String currentdistrict) {
        this.currentdistrict = currentdistrict;
    }

    public String getCurrentstreet() {
        return currentstreet;
    }

    public void setCurrentstreet(String currentstreet) {
        this.currentstreet = currentstreet;
    }

    public String getCurrentstreetnum() {
        return currentstreetnum;
    }

    public void setCurrentstreetnum(String currentstreetnum) {
        this.currentstreetnum = currentstreetnum;
    }

    public String getBgimg() {
        return bgimg;
    }

    public void setBgimg(String bgimg) {
        this.bgimg = bgimg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImpression_labels() {
        return impression_labels;
    }

    public void setImpression_labels(String impression_labels) {
        this.impression_labels = impression_labels;
    }

    public String getImpression_text() {
        return impression_text;
    }

    public void setImpression_text(String impression_text) {
        this.impression_text = impression_text;
    }

    public String getImpression_voice() {
        return impression_voice;
    }

    public void setImpression_voice(String impression_voice) {
        this.impression_voice = impression_voice;
    }

    public String getImpression_vedio() {
        return impression_vedio;
    }

    public void setImpression_vedio(String impression_vedio) {
        this.impression_vedio = impression_vedio;
    }

//    public String getLplatformid() {
//        return lplatformid;
//    }
//
//    public void setLplatformid(String lplatformid) {
//        this.lplatformid = lplatformid;
//    }

    public String getLplatform() {
        return lplatform;
    }

    public void setLplatform(String lplatform) {
        this.lplatform = lplatform;
    }

    public String getRplatform() {
        return rplatform;
    }

    public void setRplatform(String rplatform) {
        this.rplatform = rplatform;
    }

    public String getCompanymanager() {
        return companymanager;
    }

    public void setCompanymanager(String companymanager) {
        this.companymanager = companymanager;
    }

    public String getMycompanyauth() {
        return mycompanyauth;
    }

    public void setMycompanyauth(String mycompanyauth) {
        this.mycompanyauth = mycompanyauth;
    }

    public String getMycompanyfail() {
        return mycompanyfail;
    }

    public void setMycompanyfail(String mycompanyfail) {
        this.mycompanyfail = mycompanyfail;
    }

    public String getInittime() {
        return inittime;
    }

    public void setInittime(String inittime) {
        this.inittime = inittime;
    }

    public String getDaccount() {
        return daccount;
    }

    public void setDaccount(String daccount) {
        this.daccount = daccount;
    }

    public String getLevauth() {
        return levauth;
    }

    public void setLevauth(String levauth) {
        this.levauth = levauth;
    }

    public String getLevhmom() {
        return levhmom;
    }

    public void setLevhmom(String levhmom) {
        this.levhmom = levhmom;
    }

    public String getDblogin() {
        return dblogin;
    }

    public void setDblogin(String dblogin) {
        this.dblogin = dblogin;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public int getIdcardChk() {
        return idcardChk;
    }

    public void setIdcardChk(int idcardChk) {
        this.idcardChk = idcardChk;
    }


    public String getSiteAddress_Api() {
        return siteAddress_Api;
    }

    public void setSiteAddress_Api(String siteAddress_Api) {
        this.siteAddress_Api = siteAddress_Api;
    }

    public String getSiteAddress_Home() {
        return siteAddress_Home;
    }

    public void setSiteAddress_Home(String siteAddress_Home) {
        this.siteAddress_Home = siteAddress_Home;
    }

    public String getSiteAddress_Vip() {
        return siteAddress_Vip;
    }

    public void setSiteAddress_Vip(String siteAddress_Vip) {
        this.siteAddress_Vip = siteAddress_Vip;
    }

    public String getSiteAddress_Score() {
        return siteAddress_Score;
    }

    public void setSiteAddress_Score(String siteAddress_Score) {
        this.siteAddress_Score = siteAddress_Score;
    }

    public String getSiteAddress_Help() {
        return siteAddress_Help;
    }

    public void setSiteAddress_Help(String siteAddress_Help) {
        this.siteAddress_Help = siteAddress_Help;
    }

    public String getSiteAddress_Dyn() {
        return siteAddress_Dyn;
    }

    public void setSiteAddress_Dyn(String siteAddress_Dyn) {
        this.siteAddress_Dyn = siteAddress_Dyn;
    }

    public String getSiteAddress_Com() {
        return siteAddress_Com;
    }

    public void setSiteAddress_Com(String siteAddress_Com) {
        this.siteAddress_Com = siteAddress_Com;
    }

    public String getSiteAddress_Itrt() {
        return siteAddress_Itrt;
    }

    public void setSiteAddress_Itrt(String siteAddress_Itrt) {
        this.siteAddress_Itrt = siteAddress_Itrt;
    }

    public String getSiteAddress_Chat() {
        return siteAddress_Chat;
    }

    public void setSiteAddress_Chat(String siteAddress_Chat) {
        this.siteAddress_Chat = siteAddress_Chat;
    }

    public String getSiteAddress_Msg() {
        return siteAddress_Msg;
    }

    public void setSiteAddress_Msg(String siteAddress_Msg) {
        this.siteAddress_Msg = siteAddress_Msg;
    }

    public String getSiteAddress_File() {
        return siteAddress_File;
    }

    public void setSiteAddress_File(String siteAddress_File) {
        this.siteAddress_File = siteAddress_File;
    }

    public String getSiteAddress_Data() {
        return siteAddress_Data;
    }

    public void setSiteAddress_Data(String siteAddress_Data) {
        this.siteAddress_Data = siteAddress_Data;
    }

    public String getSiteAddress_Shop() {
        return siteAddress_Shop;
    }

    public void setSiteAddress_Shop(String siteAddress_Shop) {
        this.siteAddress_Shop = siteAddress_Shop;
    }

    public String getSiteAddress_Fate() {
        return siteAddress_Fate;
    }

    public void setSiteAddress_Fate(String siteAddress_Fate) {
        this.siteAddress_Fate = siteAddress_Fate;
    }

    public String getSiteAddress_Log() {
        return siteAddress_Log;
    }

    public void setSiteAddress_Log(String siteAddress_Log) {
        this.siteAddress_Log = siteAddress_Log;
    }

    public String getSiteAddress_Upload() {
        return siteAddress_Upload;
    }

    public void setSiteAddress_Upload(String siteAddress_Upload) {
        this.siteAddress_Upload = siteAddress_Upload;
    }

    public String getMyVideo() {
        return myVideo;
    }

    public void setMyVideo(String myVideo) {
        this.myVideo = myVideo;
    }

    public String getMonologue() {
        return monologue;
    }

    public void setMonologue(String monologue) {
        this.monologue = monologue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUploadstatus() {
        return uploadstatus;
    }

    public void setUploadstatus(String uploadstatus) {
        this.uploadstatus = uploadstatus;
    }

    public String getUploadscreenshot() {
        return uploadscreenshot;
    }

    public void setUploadscreenshot(String uploadscreenshot) {
        this.uploadscreenshot = uploadscreenshot;
    }


    public String getIsshowguideview_strollfragment_one() {
        return isshowguideview_strollfragment_one;
    }

    public void setIsshowguideview_strollfragment_one(String isshowguideview_strollfragment_one) {
        this.isshowguideview_strollfragment_one = isshowguideview_strollfragment_one;
    }

    public String getIsshowguideview_strollfragment_two() {
        return isshowguideview_strollfragment_two;
    }

    public void setIsshowguideview_strollfragment_two(String isshowguideview_strollfragment_two) {
        this.isshowguideview_strollfragment_two = isshowguideview_strollfragment_two;
    }

    public String getIsshowguideview_strollfragment_three() {
        return isshowguideview_strollfragment_three;
    }

    public void setIsshowguideview_strollfragment_three(String isshowguideview_strollfragment_three) {
        this.isshowguideview_strollfragment_three = isshowguideview_strollfragment_three;
    }

    public String getIsshowguideview_strollfragment_four() {
        return isshowguideview_strollfragment_four;
    }

    public void setIsshowguideview_strollfragment_four(String isshowguideview_strollfragment_four) {
        this.isshowguideview_strollfragment_four = isshowguideview_strollfragment_four;
    }

    public String getIsshowguideview_findfatefragment_avatar() {
        return isshowguideview_findfatefragment_avatar;
    }

    public void setIsshowguideview_findfatefragment_avatar(String isshowguideview_findfatefragment_avatar) {
        this.isshowguideview_findfatefragment_avatar = isshowguideview_findfatefragment_avatar;
    }

    public String getIsshowguideview_findfatefragment_relative() {
        return isshowguideview_findfatefragment_relative;
    }

    public void setIsshowguideview_findfatefragment_relative(String isshowguideview_findfatefragment_relative) {
        this.isshowguideview_findfatefragment_relative = isshowguideview_findfatefragment_relative;
    }

    public String getIsshowguideview_findfatefragment_filter() {
        return isshowguideview_findfatefragment_filter;
    }

    public void setIsshowguideview_findfatefragment_filter(String isshowguideview_findfatefragment_filter) {
        this.isshowguideview_findfatefragment_filter = isshowguideview_findfatefragment_filter;
    }

    public String getIsshowguideview_dynamicfragment() {
        return isshowguideview_dynamicfragment;
    }

    public void setIsshowguideview_dynamicfragment(String isshowguideview_dynamicfragment) {
        this.isshowguideview_dynamicfragment = isshowguideview_dynamicfragment;
    }

    public String getIsshowguideview_interactionfragment() {
        return isshowguideview_interactionfragment;
    }

    public void setIsshowguideview_interactionfragment(String isshowguideview_interactionfragment) {
        this.isshowguideview_interactionfragment = isshowguideview_interactionfragment;
    }

    public String getIsshowguideview_minefragment_publishdynamic() {
        return isshowguideview_minefragment_publishdynamic;
    }

    public void setIsshowguideview_minefragment_publishdynamic(String isshowguideview_minefragment_publishdynamic) {
        this.isshowguideview_minefragment_publishdynamic = isshowguideview_minefragment_publishdynamic;
    }

    public String getIsshowguideview_minefragment_replaceregister() {
        return isshowguideview_minefragment_replaceregister;
    }

    public void setIsshowguideview_minefragment_replaceregister(String isshowguideview_minefragment_replaceregister) {
        this.isshowguideview_minefragment_replaceregister = isshowguideview_minefragment_replaceregister;
    }

    public String getIsshowguideview_minefragment_registercode() {
        return isshowguideview_minefragment_registercode;
    }

    public void setIsshowguideview_minefragment_registercode(String isshowguideview_minefragment_registercode) {
        this.isshowguideview_minefragment_registercode = isshowguideview_minefragment_registercode;
    }

    public String getIsshowguideview_minefragment_perfectinfo() {
        return isshowguideview_minefragment_perfectinfo;
    }

    public void setIsshowguideview_minefragment_perfectinfo(String isshowguideview_minefragment_perfectinfo) {
        this.isshowguideview_minefragment_perfectinfo = isshowguideview_minefragment_perfectinfo;
    }

    public String getIsshowguideview_minefragment_addcircle() {
        return isshowguideview_minefragment_addcircle;
    }

    public void setIsshowguideview_minefragment_addcircle(String isshowguideview_minefragment_addcircle) {
        this.isshowguideview_minefragment_addcircle = isshowguideview_minefragment_addcircle;
    }

    public String getIsshowguideview_personalavatar_left() {
        return isshowguideview_personalavatar_left;
    }

    public void setIsshowguideview_personalavatar_left(String isshowguideview_personalavatar_left) {
        this.isshowguideview_personalavatar_left = isshowguideview_personalavatar_left;
    }

    public String getIsshowguideview_personalavatar_right() {
        return isshowguideview_personalavatar_right;
    }

    public void setIsshowguideview_personalavatar_right(String isshowguideview_personalavatar_right) {
        this.isshowguideview_personalavatar_right = isshowguideview_personalavatar_right;
    }
}
