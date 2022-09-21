package byfayzullayev.startup.service;
import byfayzullayev.startup.model.response.ApiResponse;

public interface BaseService {

    ApiResponse SUCCESS = new ApiResponse("muvafaqiyatli bajarildi", true, 0);
    ApiResponse NOT_FOUND = new ApiResponse("muvafaqiyatSIZ bajarildi !!", false, -101);
    ApiResponse EXSIST = new ApiResponse("uje bor", false, -101);
}
