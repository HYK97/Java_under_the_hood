package io.nio_serializable;

import java.io.Serializable;
import java.math.BigDecimal;

public class SerialDto implements Serializable {
    static final long serialVersionUID = 1L;
    private String userName;
    private String userId;
    /**
     * 예약어 transient 를 지정한 field 는 직렬화작업에서 제외된다
     * ex) 비밀번호 같이 보안에 민감한 데이터일경우
     */
    transient private BigDecimal userMoney;

    private String userAddress;

    public SerialDto(String userName, String userId, BigDecimal userMoney, String userAddress) {
        this.userName = userName;
        this.userId = userId;
        this.userMoney = userMoney;
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "SerialDto{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userMoney=" + userMoney +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
