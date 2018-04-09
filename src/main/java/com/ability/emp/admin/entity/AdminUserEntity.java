package com.ability.emp.admin.entity;

public class AdminUserEntity {
    private String id;//主键

    private String nickName;//昵称

    private String userName;//中文名

    private String phone;//电话

    private String openid;//唯一标识
    
    private String taskid;//任务ID

    private String isAppoint;//是否被指派任务
    
    private String del;
    
    
    
    /**
     * 汉字转换
     * @return
     */
    private String isAppointName;
    
    

    public String getIsAppointName() {
		return isAppointName;
	}

	public void setIsAppointName(String isAppointName) {
		this.isAppointName = isAppointName;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getIsAppoint() {
		return isAppoint;
	}

	public void setIsAppoint(String isAppoint) {
		this.isAppoint = isAppoint;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
}