package com.example.rabbit.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class TestEntity {
    @JsonDeserialize(using = CustomDateSerializer.class)
    private Date date1;
    @JsonDeserialize(using = CustomDateSerializer.class)
    private Date date2;
    @Pattern(regexp = "^1|2|3|4")
    private Integer integer;
}
