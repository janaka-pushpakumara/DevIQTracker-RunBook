
package com.iit.deviqtracker.projectservice.dto.contributors;

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
    "w",
    "a",
    "d",
    "c"
})
@Generated("jsonschema2pojo")
public class Week {

    @JsonProperty("w")
    private Integer w;
    @JsonProperty("a")
    private Integer a;
    @JsonProperty("d")
    private Integer d;
    @JsonProperty("c")
    private Integer c;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("w")
    public Integer getW() {
        return w;
    }

    @JsonProperty("w")
    public void setW(Integer w) {
        this.w = w;
    }

    @JsonProperty("a")
    public Integer getA() {
        return a;
    }

    @JsonProperty("a")
    public void setA(Integer a) {
        this.a = a;
    }

    @JsonProperty("d")
    public Integer getD() {
        return d;
    }

    @JsonProperty("d")
    public void setD(Integer d) {
        this.d = d;
    }

    @JsonProperty("c")
    public Integer getC() {
        return c;
    }

    @JsonProperty("c")
    public void setC(Integer c) {
        this.c = c;
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
