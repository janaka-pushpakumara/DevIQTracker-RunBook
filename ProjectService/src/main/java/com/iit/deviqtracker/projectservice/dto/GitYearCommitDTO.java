
package com.iit.deviqtracker.projectservice.dto;

import java.util.LinkedHashMap;
import java.util.List;
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
    "days",
    "total",
    "week"
})
@Generated("jsonschema2pojo")
public class GitYearCommitDTO {

    @JsonProperty("days")
    private List<Integer> days;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("week")
    private Integer week;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("days")
    public List<Integer> getDays() {
        return days;
    }

    @JsonProperty("days")
    public void setDays(List<Integer> days) {
        this.days = days;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("week")
    public Integer getWeek() {
        return week;
    }

    @JsonProperty("week")
    public void setWeek(Integer week) {
        this.week = week;
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
