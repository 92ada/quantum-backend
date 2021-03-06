package com.techncat.quantum.app.common.voenhance.vo;

public class EnhancedVO {
    private String index;
    private Object value;
    private String type;

    private Object[] options;
    private String option_url;

    private Boolean require;
    private Boolean editable = true;

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

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object[] getOptions() {
        return options;
    }

    public void setOptions(Object[] options) {
        this.options = options;
    }

    public String getOption_url() {
        return option_url;
    }

    public void setOption_url(String option_url) {
        this.option_url = option_url;
    }

    public Boolean getRequire() {
        return require;
    }

    public void setRequire(Boolean require) {
        this.require = require;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    @Override
    public String toString() {
        String optionsStr = "";
        if (options != null) {
            for (Object option : options) {
                optionsStr += option + " ";
            }
        }
        return "EnhancedVO{" +
                "index='" + index + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", options=[" + optionsStr + ']' +
                ", option_url='" + option_url + '\'' +
                ", require=" + require +
                ", editable=" + editable +
                '}';
    }
}
