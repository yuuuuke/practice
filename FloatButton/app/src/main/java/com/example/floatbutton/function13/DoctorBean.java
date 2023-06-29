package com.example.floatbutton.function13;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DoctorBean implements Serializable {
    @SerializedName("code")
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @SerializedName("result")
    private ResultDTO result;
    @SerializedName("msg")
    private Object msg;

    public static class ResultDTO {
        @SerializedName("rowCount")
        private Integer rowCount;

        public Integer getRowCount() {
            return rowCount;
        }

        public void setRowCount(Integer rowCount) {
            this.rowCount = rowCount;
        }

        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public Integer getReturnCount() {
            return returnCount;
        }

        public void setReturnCount(Integer returnCount) {
            this.returnCount = returnCount;
        }

        public List<DatalistDTO> getDatalist() {
            return datalist;
        }

        public void setDatalist(List<DatalistDTO> datalist) {
            this.datalist = datalist;
        }

        @SerializedName("pageCount")
        private Integer pageCount;
        @SerializedName("returnCount")
        private Integer returnCount;
        @SerializedName("datalist")
        private List<DatalistDTO> datalist;

        public static class DatalistDTO {
            @SerializedName("id")
            private Integer id;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getActive() {
                return active;
            }

            public void setActive(Integer active) {
                this.active = active;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getHalflengthUrl() {
                return halflengthUrl;
            }

            public void setHalflengthUrl(String halflengthUrl) {
                this.halflengthUrl = halflengthUrl;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getHospitalName() {
                return hospitalName;
            }

            public void setHospitalName(String hospitalName) {
                this.hospitalName = hospitalName;
            }

            public Integer getDepartmentid() {
                return departmentid;
            }

            public void setDepartmentid(Integer departmentid) {
                this.departmentid = departmentid;
            }

            public String getIdPath() {
                return idPath;
            }

            public void setIdPath(String idPath) {
                this.idPath = idPath;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public String getIconUrlMini() {
                return iconUrlMini;
            }

            public void setIconUrlMini(String iconUrlMini) {
                this.iconUrlMini = iconUrlMini;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public Integer getDictStatus() {
                return dictStatus;
            }

            public void setDictStatus(Integer dictStatus) {
                this.dictStatus = dictStatus;
            }

            public Integer getDictReceiveStatus() {
                return dictReceiveStatus;
            }

            public void setDictReceiveStatus(Integer dictReceiveStatus) {
                this.dictReceiveStatus = dictReceiveStatus;
            }

            public Integer getDictBoolOpenVideo() {
                return dictBoolOpenVideo;
            }

            public void setDictBoolOpenVideo(Integer dictBoolOpenVideo) {
                this.dictBoolOpenVideo = dictBoolOpenVideo;
            }

            public Integer getDictBoolVideo() {
                return dictBoolVideo;
            }

            public void setDictBoolVideo(Integer dictBoolVideo) {
                this.dictBoolVideo = dictBoolVideo;
            }

            public String getAuthExpireTime() {
                return authExpireTime;
            }

            public void setAuthExpireTime(String authExpireTime) {
                this.authExpireTime = authExpireTime;
            }

            public Integer getDictOnlineStatus() {
                return dictOnlineStatus;
            }

            public void setDictOnlineStatus(Integer dictOnlineStatus) {
                this.dictOnlineStatus = dictOnlineStatus;
            }

            public String getHospitalGrade() {
                return hospitalGrade;
            }

            public void setHospitalGrade(String hospitalGrade) {
                this.hospitalGrade = hospitalGrade;
            }

            public String getVideoPrice() {
                return videoPrice;
            }

            public void setVideoPrice(String videoPrice) {
                this.videoPrice = videoPrice;
            }

            public Double getVoicePrice() {
                return voicePrice;
            }

            public void setVoicePrice(Double voicePrice) {
                this.voicePrice = voicePrice;
            }

            public Double getImgTextPrice() {
                return imgTextPrice;
            }

            public void setImgTextPrice(Double imgTextPrice) {
                this.imgTextPrice = imgTextPrice;
            }

            public Integer getDoctorScore() {
                return doctorScore;
            }

            public void setDoctorScore(Integer doctorScore) {
                this.doctorScore = doctorScore;
            }

            public String getSpeciality() {
                return speciality;
            }

            public void setSpeciality(String speciality) {
                this.speciality = speciality;
            }

            public Integer getDictBoolInquiryDisease() {
                return dictBoolInquiryDisease;
            }

            public void setDictBoolInquiryDisease(Integer dictBoolInquiryDisease) {
                this.dictBoolInquiryDisease = dictBoolInquiryDisease;
            }

            public Integer getDictBoolVoice() {
                return dictBoolVoice;
            }

            public void setDictBoolVoice(Integer dictBoolVoice) {
                this.dictBoolVoice = dictBoolVoice;
            }

            public Integer getDictBoolImgText() {
                return dictBoolImgText;
            }

            public void setDictBoolImgText(Integer dictBoolImgText) {
                this.dictBoolImgText = dictBoolImgText;
            }

            public Integer getSortno() {
                return sortno;
            }

            public void setSortno(Integer sortno) {
                this.sortno = sortno;
            }

            public Integer getDictDoctorTitleType() {
                return dictDoctorTitleType;
            }

            public void setDictDoctorTitleType(Integer dictDoctorTitleType) {
                this.dictDoctorTitleType = dictDoctorTitleType;
            }

            public String getHospitalCity() {
                return hospitalCity;
            }

            public void setHospitalCity(String hospitalCity) {
                this.hospitalCity = hospitalCity;
            }

            public Integer getFavoriteId() {
                return favoriteId;
            }

            public void setFavoriteId(Integer favoriteId) {
                this.favoriteId = favoriteId;
            }

            public String getCertificateAge() {
                return certificateAge;
            }

            public void setCertificateAge(String certificateAge) {
                this.certificateAge = certificateAge;
            }

            public Double getScore() {
                return score;
            }

            public void setScore(Double score) {
                this.score = score;
            }

            public String getNumberPatients() {
                return numberPatients;
            }

            public void setNumberPatients(String numberPatients) {
                this.numberPatients = numberPatients;
            }

            public String getHospitalAddress() {
                return hospitalAddress;
            }

            public void setHospitalAddress(String hospitalAddress) {
                this.hospitalAddress = hospitalAddress;
            }

            public String getTimeEntry() {
                return timeEntry;
            }

            public void setTimeEntry(String timeEntry) {
                this.timeEntry = timeEntry;
            }

            public Double getSubsequentVideoPrice() {
                return subsequentVideoPrice;
            }

            public void setSubsequentVideoPrice(Double subsequentVideoPrice) {
                this.subsequentVideoPrice = subsequentVideoPrice;
            }

            public Double getSubsequentVoicePrice() {
                return subsequentVoicePrice;
            }

            public void setSubsequentVoicePrice(Double subsequentVoicePrice) {
                this.subsequentVoicePrice = subsequentVoicePrice;
            }

            public Double getSubsequentImgTextPrice() {
                return subsequentImgTextPrice;
            }

            public void setSubsequentImgTextPrice(Double subsequentImgTextPrice) {
                this.subsequentImgTextPrice = subsequentImgTextPrice;
            }

            public Integer getBoolSubsequentVideo() {
                return boolSubsequentVideo;
            }

            public void setBoolSubsequentVideo(Integer boolSubsequentVideo) {
                this.boolSubsequentVideo = boolSubsequentVideo;
            }

            public Integer getBoolSubsequentVoice() {
                return boolSubsequentVoice;
            }

            public void setBoolSubsequentVoice(Integer boolSubsequentVoice) {
                this.boolSubsequentVoice = boolSubsequentVoice;
            }

            public Integer getBoolSubsequentImgText() {
                return boolSubsequentImgText;
            }

            public void setBoolSubsequentImgText(Integer boolSubsequentImgText) {
                this.boolSubsequentImgText = boolSubsequentImgText;
            }

            public String getSelfIntroduction() {
                return selfIntroduction;
            }

            public void setSelfIntroduction(String selfIntroduction) {
                this.selfIntroduction = selfIntroduction;
            }

            public Double getDistance() {
                return distance;
            }

            public void setDistance(Double distance) {
                this.distance = distance;
            }

            public String getHospitalName2() {
                return hospitalName2;
            }

            public void setHospitalName2(String hospitalName2) {
                this.hospitalName2 = hospitalName2;
            }

            public String getDictOnlineStatusName() {
                return dictOnlineStatusName;
            }

            public void setDictOnlineStatusName(String dictOnlineStatusName) {
                this.dictOnlineStatusName = dictOnlineStatusName;
            }

            public String getDictReceiveStatusName() {
                return dictReceiveStatusName;
            }

            public void setDictReceiveStatusName(String dictReceiveStatusName) {
                this.dictReceiveStatusName = dictReceiveStatusName;
            }

            @SerializedName("active")
            private Integer active;
            @SerializedName("create_time")
            private String createTime;
            @SerializedName("halflength_url")
            private String halflengthUrl;
            @SerializedName("avatar_url")
            private String avatarUrl;
            @SerializedName("real_name")
            private String realName;
            @SerializedName("title")
            private String title;
            @SerializedName("hospital_name")
            private String hospitalName;
            @SerializedName("departmentid")
            private Integer departmentid;
            @SerializedName("id_path")
            private String idPath;
            @SerializedName("department_name")
            private String departmentName;
            @SerializedName("icon_url_mini")
            private String iconUrlMini;
            @SerializedName("icon_url")
            private String iconUrl;
            @SerializedName("dict_status")
            private Integer dictStatus;
            @SerializedName("dict_receive_status")
            private Integer dictReceiveStatus;
            @SerializedName("dict_bool_open_video")
            private Integer dictBoolOpenVideo;
            @SerializedName("dict_bool_video")
            private Integer dictBoolVideo;
            @SerializedName("auth_expire_time")
            private String authExpireTime;
            @SerializedName("dict_online_status")
            private Integer dictOnlineStatus;
            @SerializedName("hospital_grade")
            private String hospitalGrade;
            @SerializedName("video_price")
            private String videoPrice;
            @SerializedName("voice_price")
            private Double voicePrice;
            @SerializedName("img_text_price")
            private Double imgTextPrice;
            @SerializedName("doctor_score")
            private Integer doctorScore;
            @SerializedName("speciality")
            private String speciality;
            @SerializedName("dict_bool_inquiry_disease")
            private Integer dictBoolInquiryDisease;
            @SerializedName("dict_bool_voice")
            private Integer dictBoolVoice;
            @SerializedName("dict_bool_img_text")
            private Integer dictBoolImgText;
            @SerializedName("sortno")
            private Integer sortno;
            @SerializedName("dict_doctor_title_type")
            private Integer dictDoctorTitleType;
            @SerializedName("hospital_city")
            private String hospitalCity;
            @SerializedName("favorite_id")
            private Integer favoriteId;
            @SerializedName("certificate_age")
            private String certificateAge;
            @SerializedName("score")
            private Double score;
            @SerializedName("number_patients")
            private String numberPatients;
            @SerializedName("hospital_address")
            private String hospitalAddress;
            @SerializedName("time_entry")
            private String timeEntry;
            @SerializedName("subsequent_video_price")
            private Double subsequentVideoPrice;
            @SerializedName("subsequent_voice_price")
            private Double subsequentVoicePrice;
            @SerializedName("subsequent_img_text_price")
            private Double subsequentImgTextPrice;
            @SerializedName("bool_subsequent_video")
            private Integer boolSubsequentVideo;
            @SerializedName("bool_subsequent_voice")
            private Integer boolSubsequentVoice;
            @SerializedName("bool_subsequent_img_text")
            private Integer boolSubsequentImgText;
            @SerializedName("self_introduction")
            private String selfIntroduction;
            @SerializedName("distance")
            private Double distance;
            @SerializedName("hospital_name2")
            private String hospitalName2;
            @SerializedName("dict_online_status_name")
            private String dictOnlineStatusName;
            @SerializedName("dict_receive_status_name")
            private String dictReceiveStatusName;
        }
    }
}


