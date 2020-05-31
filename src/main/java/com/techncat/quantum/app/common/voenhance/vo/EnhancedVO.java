package com.techncat.quantum.app.common.voenhance.vo;

import lombok.Data;

import java.util.Arrays;

@Data
public class EnhancedVO {
    private String index;
    private Object value;
    private String type;

    private Object[] options;
    private String option_url;

    private Boolean required;
    private Boolean editable = true;
    private Boolean hidden = false;

    public EnhancedVO(String index, Object value, String type) {
        this.index = index;
        this.type = type;
        if (value != null)
            this.value = value;
    }

    public EnhancedVO(String index, Object value, String type, Object[] options) {
        this(index, value, type);
        this.options = options;
    }

    public EnhancedVO(String index, Object value, String type, String option_url) {
        this(index, value, type);
        this.option_url = option_url;
    }

    @Override
    public String toString() {
        return "EnhancedVO{" +
                "index='" + index + '\'' +
                ", value=" + value +
                ", type='" + type + '\'' +
                ", options=" + Arrays.toString(options) +
                ", option_url='" + option_url + '\'' +
                ", required=" + required +
                ", editable=" + editable +
                ", hidden=" + hidden +
                '}';
    }
}
