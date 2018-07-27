package com.sunjian.chatroom_plus;
/**
 * 该接口用于定义协议字符
 * 
 * @author jack
 *
 */
public interface CrazyitProtocol {

	//定义协议字符串的长度
	int PROTOCOL_LEN = 2;
	//下面是一些协议字符串，服务器端和客户端交换的信息
	//都因该在前、后添加这种特殊字符串
	String MSG_ROUND = "§Y";
	String USER_ROUND = "ΙΙΣ";
	String LOGIN_SUCCESS = "1";
	String NAME_REP = "-1";
	String PRIVATE_ROUND = "★【";
	String SPLIT_SIGN = "※";
}
