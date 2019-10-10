package com.springboot.springbootswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Version: 1.0
 * @Desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户演示类", description = "请求参数类")
public class User {
    @ApiModelProperty(example = "1")
    private Long id;
    @ApiModelProperty(example = "geekdigging")
    private String nickName;
    @ApiModelProperty(example = "1570689455000")
    private Date createDate;
    @ApiModelProperty(example = "18")
    private Integer age;
}
