package com.wisdomleaf.assignment.commonClass;

public class JsonConstants {
    private static JsonConstants soleInstance = null;

    public static JsonConstants getInstance() {
        if (soleInstance == null) {
            soleInstance = new JsonConstants();
        }
        return soleInstance;
    }

    public static final String INTERNET_CHECK_URL = "https://www.google.co.in/";

    public static final String BASE_URL = "https://picsum.photos/v2/";


    public static final String SUBURL = "list?page=2&amp;limit=20";//post
    public static final String VALIDDATEUSEROTPFORLOGIN = "validateUserOTPForLogin";//post
    public static final String INSERTUSER = "insertUser";//post
    public static final String ADDUSERLOCATION = "addUserLocation";//post
    public static final String REMOVEUSERLOCATION = "removeUserLocation";//post
    public static final String GETUSERLOCATIONS = "getUserLocationsByUserId";//getUserLocationsByUserId?userId=1
    public static final String ADDNEWROUTE = "addNewRoute";//post
    public static final String GETROUTES = "getRoutes";//getRoutes?userId=1
    public static final String GETNEWROUTESPAYMENTCALCULATION = "getNewRoutesWithPaymentCalculations";//post








}
