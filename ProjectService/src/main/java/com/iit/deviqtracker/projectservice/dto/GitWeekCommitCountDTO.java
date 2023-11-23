
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
    "all",
    "owner"
})
@Generated("jsonschema2pojo")
public class GitWeekCommitCountDTO {

    @JsonProperty("all")
    private List<Integer> all;
    @JsonProperty("owner")
    private List<Integer> owner;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("all")
    public List<Integer> getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(List<Integer> all) {
        this.all = all;
    }

    @JsonProperty("owner")
    public List<Integer> getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(List<Integer> owner) {
        this.owner = owner;
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
