
package com.iit.deviqtracker.projectservice.dto.common;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ownerId",
    "repoId",
    "weekId",
    "commitCountOwner",
    "commitCountAll",
    "commitPercentage",
    "additionCount",
    "deletionCount"
})
@Generated("jsonschema2pojo")
public class SummaryDTO {

    @JsonProperty("ownerId")
    private String ownerId;
    @JsonProperty("repoId")
    private String repoId;
    @JsonProperty("weekId")
    private String weekId;
    @JsonProperty("commitCountOwner")
    private String commitCountOwner;
    @JsonProperty("commitCountAll")
    private String commitCountAll;
    @JsonProperty("commitPercentage")
    private String commitPercentage;
    @JsonProperty("additionCount")
    private String additionCount;
    @JsonProperty("deletionCount")
    private String deletionCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("ownerId")
    public String getOwnerId() {
        return ownerId;
    }

    @JsonProperty("ownerId")
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @JsonProperty("repoId")
    public String getRepoId() {
        return repoId;
    }

    @JsonProperty("repoId")
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    @JsonProperty("weekId")
    public String getWeekId() {
        return weekId;
    }

    @JsonProperty("weekId")
    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }

    @JsonProperty("commitCountOwner")
    public String getCommitCountOwner() {
        return commitCountOwner;
    }

    @JsonProperty("commitCountOwner")
    public void setCommitCountOwner(String commitCountOwner) {
        this.commitCountOwner = commitCountOwner;
    }

    @JsonProperty("commitCountAll")
    public String getCommitCountAll() {
        return commitCountAll;
    }

    @JsonProperty("commitCountAll")
    public void setCommitCountAll(String commitCountAll) {
        this.commitCountAll = commitCountAll;
    }

    @JsonProperty("commitPercentage")
    public String getCommitPercentage() {
        return commitPercentage;
    }

    @JsonProperty("commitPercentage")
    public void setCommitPercentage(String commitPercentage) {
        this.commitPercentage = commitPercentage;
    }

    @JsonProperty("additionCount")
    public String getAdditionCount() {
        return additionCount;
    }

    @JsonProperty("additionCount")
    public void setAdditionCount(String additionCount) {
        this.additionCount = additionCount;
    }

    @JsonProperty("deletionCount")
    public String getDeletionCount() {
        return deletionCount;
    }

    @JsonProperty("deletionCount")
    public void setDeletionCount(String deletionCount) {
        this.deletionCount = deletionCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//--------- schema ------------
//{
//	  "ownerId":"",
//	  "repoId":"",
//	  "weekId":"",
//	  "commitCountOwner":"",
//	  "commitCountAll":"",
//	  "commitPercentage":"",
//	  "additionCount":"",
//	  "deletionCount":""
//	}
