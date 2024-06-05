
package fr.univtours.polytech.bookshop.model.bookRating;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "numFound",
    "start",
    "numFoundExact",
    "docs",
    "num_found",
    "q",
    "offset"
})
@Generated("jsonschema2pojo")
public class Book {

    @JsonProperty("numFound")
    private Integer numFound;
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("numFoundExact")
    private Boolean numFoundExact;
    @JsonProperty("docs")
    @Valid
    private List<Doc> docs;
    @JsonProperty("num_found")
    private Integer numFounds;
    @JsonProperty("q")
    private String q;
    @JsonProperty("offset")
    private Object offset;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("numFound")
    public Integer getNumFound() {
        return numFound;
    }

    @JsonProperty("numFound")
    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    @JsonProperty("start")
    public Integer getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Integer start) {
        this.start = start;
    }

    @JsonProperty("numFoundExact")
    public Boolean getNumFoundExact() {
        return numFoundExact;
    }

    @JsonProperty("numFoundExact")
    public void setNumFoundExact(Boolean numFoundExact) {
        this.numFoundExact = numFoundExact;
    }

    @JsonProperty("docs")
    public List<Doc> getDocs() {
        return docs;
    }

    @JsonProperty("docs")
    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    @JsonProperty("num_found")
    public Integer getNumFounds() {
        return numFounds;
    }

    @JsonProperty("num_found")
    public void setNumFounds(Integer numFounds) {
        this.numFounds = numFounds;
    }

    @JsonProperty("q")
    public String getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(String q) {
        this.q = q;
    }

    @JsonProperty("offset")
    public Object getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Object offset) {
        this.offset = offset;
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
