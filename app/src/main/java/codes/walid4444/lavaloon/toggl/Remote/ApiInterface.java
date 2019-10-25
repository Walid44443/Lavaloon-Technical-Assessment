package codes.walid4444.lavaloon.toggl.Remote;


import java.util.List;

import codes.walid4444.lavaloon.toggl.CONST;
import codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel.DetailsItemResponse;
import codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel.LoginResponseModel;
import codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel.TimeEntriesResponseModel;
import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET(CONST.API_PATH_URL+"/me")
    Call<LoginResponseModel> LoginRequest();

    @GET(CONST.API_PATH_URL+"/time_entries")
    Call<List<TimeEntryModel>> getTimeEntriesRequest(@Header("Authorization") String authToken, @Query("start_date") String start_date, @Query("end_date") String end_date);

    @GET(CONST.API_PATH_URL+"/time_entries/{id}")
    Call<DetailsItemResponse> getTimeDetailsRequest(@Header("Authorization") String authToken, @Path("id") int id);


}
