
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
    "ratio",
    "additionCount",
    "deletionCount"
})
@Generated("jsonschema2pojo")
public class WeekCommitActivitySummaryDTO {

    @JsonProperty("ownerId")
    private String ownerId;
    @JsonProperty("repoId")
    private String repoId;
    @JsonProperty("weekId")
    private String weekId;
    @JsonProperty("ratio")
    private String ratio;
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

    @JsonProperty("ratio")
    public String getRatio() {
        return ratio;
    }

    @JsonProperty("ratio")
    public void setRatio(String ratio) {
        this.ratio = ratio;
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
