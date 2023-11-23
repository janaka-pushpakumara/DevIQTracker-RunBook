
package com.iit.deviqtracker.projectservice.dto.repo;

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
    "admin",
    "maintain",
    "push",
    "triage",
    "pull"
})
@Generated("jsonschema2pojo")
public class Permissions {

    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("maintain")
    private Boolean maintain;
    @JsonProperty("push")
    private Boolean push;
    @JsonProperty("triage")
    private Boolean triage;
    @JsonProperty("pull")
    private Boolean pull;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @JsonProperty("maintain")
    public Boolean getMaintain() {
        return maintain;
    }

    @JsonProperty("maintain")
    public void setMaintain(Boolean maintain) {
        this.maintain = maintain;
    }

    @JsonProperty("push")
    public Boolean getPush() {
        return push;
    }

    @JsonProperty("push")
    public void setPush(Boolean push) {
        this.push = push;
    }

    @JsonProperty("triage")
    public Boolean getTriage() {
        return triage;
    }

    @JsonProperty("triage")
    public void setTriage(Boolean triage) {
        this.triage = triage;
    }

    @JsonProperty("pull")
    public Boolean getPull() {
        return pull;
    }

    @JsonProperty("pull")
    public void setPull(Boolean pull) {
        this.pull = pull;
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
