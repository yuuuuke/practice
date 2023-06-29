package com.example.floatbutton.net

import com.example.floatbutton.function13.DoctorBean
import retrofit2.http.GET

interface DoctorService {
    @GET("guest.inquiry.doctor.randomDoctors")
    suspend fun getHotArticle(): DoctorBean
}