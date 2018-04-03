package com.ability.emp.mobile.entity;

public class MobileLoginEntity {
	
	//用户登录凭证（有效期五分钟）
	//开发者需要在开发者服务器后台调用 api，使用 code 换取 openid 和 session_key 等信息
	private String code;
	//包括敏感数据在内的完整用户信息的加密数据
	private String encrypteData;
	//加密算法的初始向量
	private String iv;
	
	

	public String getEncrypteData() {
		return encrypteData;
	}

	public void setEncrypteData(String encrypteData) {
		this.encrypteData = encrypteData;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
}
