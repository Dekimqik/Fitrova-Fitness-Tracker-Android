package com.fitness.fitrova.model;

/**
 * Created by lion on 4/6/16.
 */
public class FTConst {

    public static final String SERVER_REMOTE_URL = "http://192.168.99.230/";

    /**
     * ******************************* Admin Server *************************************
     */

    public static final String KEY_FLAG      = "flag";
    public static final String KEY_RESULT    = "result";
    public static final String KEY_ERROR     = "error";
    public static final String KEY_URL       = "url";

    public static final String KEY_CATEGORY_ID          = "cid";
    public static final String KEY_CATEGORY_NAME        = "c_name";

    public static final String KEY_TONE_ID              = "t_id";
    public static final String KEY_TONE_TITLE           = "t_title";
    public static final String KEY_TONE_DESCRIPTION     = "t_description";
    public static final String KEY_TONE_PATH            = "t_path";
    public static final String KEY_TONE_EXPIRE          = "t_expired";

    /**
     * ******************************* User Fields *************************************
     */

    public static final String KEY_USER_ID      = "uid";
    public static final String KEY_USER_NAME    = "user_name";
    public static final String KEY_USER_EMAIL   = "user_email";
    public static final String KEY_USER_PHONE     = "user_phone";
    public static final String KEY_USER_COUNTRY   = "user_country";
    public static final String KEY_USER_COUPON    = "user_d_coupon";
    public static final String KEY_USER_PASSWORD  = "user_password";
    public static final String KEY_USER_PROFILE   = "user_profile";

    public static final String KEY_USER_INFO    = "key_user_info";

    /**
     * ******************************* Local Info *************************************
     */

    public static final String KEY_CATEGORY_RECEIVE      = "key_category_receive";

    /**
     * ******************************* App API'S *************************************
     */

    public static final String API_GET_CATEGORY = "api/get_category";
    public static final String API_USER_REGISTER  = "api/register";
    public static final String API_USER_LOGIN   = "api/login";
    public static final String API_GET_TONE     = "api/getTone";

    public static final String API_GET_USER     = "api/get-user-data";
    public static final String API_ADD_NUMBER   = "api/add-number";
    public static final String API_DEL_NUMBER   = "api/del-number";
    public static final String API_TOP_INFO     = "api/top-ap-info";
    public static final String API_TOP_UP       = "api/top-ap/";

    /**
     * ******************************* NSNOTIFICATION'S *************************************
     */

    public static final String NOTIFICATION_MENU_LOGIN = "menu_login";

    //*******************Constants store***********************
    public static final int STATUS_OK = 200;
    //********************roll id*******************

    public static final int LOGIN_FOR_ACCOUNT    = 0;
    public static final int LOGIN_FOR_TOPUP      = 1;
    public static final int LOGIN_FOR_MINUTE     = 2;


    public static final int FLAG_OK     = 1;
}
