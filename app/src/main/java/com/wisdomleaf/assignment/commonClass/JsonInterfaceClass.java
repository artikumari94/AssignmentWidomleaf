package com.wisdomleaf.assignment.commonClass;

import com.wisdomleaf.assignment.modal.ResponseBody;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonInterfaceClass {

    @GET(JsonConstants.SUBURL)
    //@Headers({"Content-Type: application/json"})
   Call<ArrayList<ResponseBody>> getData();
  //  Call<ResponseBody> getData(@Query("titleId") String titleId);

//    @POST(JsonConstants.SENDUSEROTPVALIDATION)
//    @Headers({"Content-Type: application/json"})
//    Call<CommonResponse> sendUserOtpValidation(@Body SendUserOtp sendUserOtp);
//
//    @POST(JsonConstants.VALIDDATEUSEROTPFORLOGIN)
//    @Headers({"Content-Type: application/json"})
//    Call<ValidateOTPResponse> validdateUserLogin(@Body UserOTPForLogin userOTPForLogin);
//
//    @POST(JsonConstants.INSERTUSER)
//    @Headers({"Content-Type: application/json"})
//    Call<CommonResponse> insertUser(@Body InsertUser insertUser);
//
//    @POST(JsonConstants.ADDUSERLOCATION)
//    @Headers({"Content-Type: application/json"})
//    Call<CommonResponse> addUserLocation(@Body AddUserLocation addUserLocation);
//
//    @GET(JsonConstants.GETUSERLOCATIONS)
//    @Headers({"Content-Type: application/json"})
//    Call<GetUserLocations> getUserLocation(@Query("userId") String userId);
//
//    @POST(JsonConstants.REMOVEUSERLOCATION)
//    @Headers({"Content-Type: application/json"})
//    Call<CommonResponse> removeUserLocation(@Body SendUserOtp sendUserOtp);
//
//    @POST(JsonConstants.ADDNEWROUTE)
//    @Headers({"Content-Type: application/json"})
//    Call<CommonResponse> addNewRoute(@Body AddNewRoute addNewRoute);
//
//  //  Call<BooksDetailsResponse> booksDetails(@Query("titleId") String titleId);
//    @GET(JsonConstants.GETROUTES)
//    @Headers({"Content-Type: application/json"})
//    Call<GetRoutes> getRoutes(@Query("userId") String userId);
//
//
//    @POST(JsonConstants.GETNEWROUTESPAYMENTCALCULATION)
//    @Headers({"Content-Type: application/json"})
//    Call<UserCalculation> getCalculation(@Body Calculation calculationRequest);

}
