package com.exercise.autotesting.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseAppProperty {

    @Value("${webDriverPath}")
    private String webDriverPath;
    @Value("${searchURL}")
    private String searchURL;
    @Value("${visitResult}")
    private String visitResult;
    @Value("${visitResultId}")
    private String visitResultId;
    @Value("${basedImagePath}")
    private String basedImagePath;
    @Value("${fileOutPutPath}")
    private String fileOutPutPath;

    @Value("${selectImageLink}")
    private String selectImageLink;
    @Value("${selectSearchByImg}")
    private String selectSearchByImg;
    @Value("${selectUploadBut}")
    private String selectUploadBut;
    @Value("${selectUploadFromLocal}")
    private String selectUploadFromLocal;
    @Value("${selectSizeMsg}")
    private String selectSizeMsg;
    @Value("${foundWord}")
    private String foundWord;
    @Value("${selectUploadKeys}")
    private String selectUploadKeys;

    public String getWebDriverPath() {
        return webDriverPath;
    }

    public void setWebDriverPath(String webDriverPath) {
        this.webDriverPath = webDriverPath;
    }

    public String getSearchURL() {
        return searchURL;
    }

    public void setSearchURL(String searchURL) {
        this.searchURL = searchURL;
    }

    public String getVisitResult() {
        return visitResult;
    }

    public void setVisitResult(String visitResult) {
        this.visitResult = visitResult;
    }

    public String getVisitResultId() {
        return visitResultId;
    }

    public void setVisitResultId(String visitResultId) {
        this.visitResultId = visitResultId;
    }

    public String getBasedImagePath() {
        return basedImagePath;
    }

    public void setBasedImagePath(String basedImagePath) {
        this.basedImagePath = basedImagePath;
    }

    public String getFileOutPutPath() {
        return fileOutPutPath;
    }

    public void setFileOutPutPath(String fileOutPutPath) {
        this.fileOutPutPath = fileOutPutPath;
    }

    public String getSelectImageLink() {
        return selectImageLink;
    }

    public void setSelectImageLink(String selectImageLink) {
        this.selectImageLink = selectImageLink;
    }

    public String getSelectUploadBut() {
        return selectUploadBut;
    }

    public void setSelectUploadBut(String selectUploadBut) {
        this.selectUploadBut = selectUploadBut;
    }

    public String getSelectUploadFromLocal() {
        return selectUploadFromLocal;
    }

    public void setSelectUploadFromLocal(String selectUploadFromLocal) {
        this.selectUploadFromLocal = selectUploadFromLocal;
    }

    public String getSelectSearchByImg() {
        return selectSearchByImg;
    }

    public void setSelectSearchByImg(String selectSearchByImg) {
        this.selectSearchByImg = selectSearchByImg;
    }

    public String getSelectSizeMsg() {
        return selectSizeMsg;
    }

    public void setSelectSizeMsg(String selectSizeMsg) {
        this.selectSizeMsg = selectSizeMsg;
    }

    public String getFoundWord() {
        return foundWord;
    }

    public void setFoundWord(String foundWord) {
        this.foundWord = foundWord;
    }

    public String getSelectUploadKeys() {
        return selectUploadKeys;
    }

    public void setSelectUploadKeys(String selectUploadKeys) {
        this.selectUploadKeys = selectUploadKeys;
    }
}
