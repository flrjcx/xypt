package com.flrjcx.xypt.common.model.param.comment;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * 评论实体类
 *
 * @author Yyyyyyy
 *
 */

@Data
public class Comment implements Serializable {

    private static final long serialVersionUID = 6732007467136712741L;
    @ApiModelProperty(value = "主键id", name = "commentId")
    private Long commentId;
    @ApiModelProperty(value = "帖子id", name = "commentBbsId")
    private Long commentBbsId;
    @ApiModelProperty(value = "用户id", name = "commentUserId")
    private Long commentUserId;
    @ApiModelProperty(value = "评论内容", name = "commentContext")
    private String commentContext;
    @ApiModelProperty(value = "评论时间", name = "commentCreateTime")
    private Date commentCreateTime;
    @ApiModelProperty(value = "评论等级", name = "level")
    private Integer level;
    @ApiModelProperty(value = "评论楼层", name = "commentFloor")
    private Integer commentFloor;
    @ApiModelProperty(value = "父评论id", name = "commentParentId")
    private Long commentParentId;
    @ApiModelProperty(value = "子评论", name = "children")
    private List <Comment> children;


}
