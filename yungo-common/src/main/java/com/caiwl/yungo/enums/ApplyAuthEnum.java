package com.caiwl.yungo.enums;

/**
 * @author caiwl
 * @date 2019/1/24 19:01
 */
public class ApplyAuthEnum {
    public enum DataType {
        ID_CARD(0),
        MX_CARRIER(10),
        INFO(20),
        MX_WAND(30),
        MX_SCORE(40),
        ;

        private int dataType;
        DataType(int dataType) {
            this.dataType = dataType;
        }

        public int getDataType() {
            return dataType;
        }
    }
}