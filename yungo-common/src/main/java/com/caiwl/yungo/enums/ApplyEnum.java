package com.caiwl.yungo.enums;

/**
 * @author caiwl
 * @date 2019/1/24 20:49
 */
public class ApplyEnum {
    public enum ApplyStatus {
        WAIT_AUTH(0),
        FINISH_AUTH(10),
        WAIT_AUTO_AUDIT(20),
        WAIT_I_AUDIT(20),
        WAIT_II_AUDIT(20),
        FINISH_AUDIT(30),
        WAIT_LOAN(30),
        WAIT_REPAY(30),
        OVERDUE(30),
        ;

        private int applyStatus;

        ApplyStatus(int applyStatus) {
            this.applyStatus = applyStatus;
        }

        public int getApplyStatus() {
            return applyStatus;
        }
    }
}
