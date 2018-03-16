package com.zheng.upms.dao.model;

import java.io.Serializable;

public class UpmsUserIp implements Serializable {
    private Integer usersipid;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Integer userid;

    /**
     * 用户IP
     *
     * @mbg.generated
     */
    private String userip4;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Long ctime;

    private static final long serialVersionUID = 1L;

    public Integer getUsersipid() {
        return usersipid;
    }

    public void setUsersipid(Integer usersipid) {
        this.usersipid = usersipid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserip4() {
        return userip4;
    }

    public void setUserip4(String userip4) {
        this.userip4 = userip4;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usersipid=").append(usersipid);
        sb.append(", userid=").append(userid);
        sb.append(", userip4=").append(userip4);
        sb.append(", ctime=").append(ctime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UpmsUserIp other = (UpmsUserIp) that;
        return (this.getUsersipid() == null ? other.getUsersipid() == null : this.getUsersipid().equals(other.getUsersipid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUserip4() == null ? other.getUserip4() == null : this.getUserip4().equals(other.getUserip4()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsersipid() == null) ? 0 : getUsersipid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUserip4() == null) ? 0 : getUserip4().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        return result;
    }
}