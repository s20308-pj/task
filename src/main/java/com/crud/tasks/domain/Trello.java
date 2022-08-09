package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trello {

    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;
}
