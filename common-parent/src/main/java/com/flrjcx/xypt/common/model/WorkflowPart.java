package com.flrjcx.xypt.common.model;

import lombok.Data;

@Data
/**t_workflow_form_field表部分字段*/
public class WorkflowPart {
    private String formId;
    private String fieldKey;
    private int fieldTypeId;
    private int fieldValueLength;
    private int fieldValueUnique;
}
