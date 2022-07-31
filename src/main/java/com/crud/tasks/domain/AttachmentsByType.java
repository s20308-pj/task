package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentsByType {
    @JsonProperty("trello")
    private Trello trello;
}
