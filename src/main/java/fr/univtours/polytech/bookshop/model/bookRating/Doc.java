
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
    "author_key",
    "author_name",
    "title",
    "first_sentence",
    "ratings_average",
    "ratings_count"
})
@Generated("jsonschema2pojo")
public class Doc {

    @JsonProperty("author_key")
    @Valid
    private List<String> authorKey;
    @JsonProperty("author_name")
    @Valid
    private List<String> authorName;
    @JsonProperty("title")
    private String title;
    @JsonProperty("first_sentence")
    @Valid
    private List<String> firstSentence;
    @JsonProperty("ratings_average")
    private Double ratingsAverage;
    @JsonProperty("ratings_count")
    private Integer ratingsCount;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("author_key")
    public List<String> getAuthorKey() {
        return authorKey;
    }

    @JsonProperty("author_key")
    public void setAuthorKey(List<String> authorKey) {
        this.authorKey = authorKey;
    }

    @JsonProperty("author_name")
    public List<String> getAuthor_name() {
        return authorName;
    }

    @JsonProperty("author_name")
    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("first_sentence")
    public List<String> getFirstSentence() {
        return firstSentence;
    }

    @JsonProperty("first_sentence")
    public void setFirstSentence(List<String> firstSentence) {
        this.firstSentence = firstSentence;
    }

    @JsonProperty("ratings_average")
    public Double getRatings_average() {
        if (ratingsAverage != null)
        {
            return ratingsAverage;
        }
        return 42.00;
    }

    @JsonProperty("ratings_average")
    public void setRatingsAverage(Double ratingsAverage) {
        this.ratingsAverage = ratingsAverage;
    }

    @JsonProperty("ratings_count")
    public Integer getRatings_count() {
        if (ratingsCount != null) 
        {
            return ratingsCount;
        }
        return 47;
    }

    @JsonProperty("ratings_count")
    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
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
