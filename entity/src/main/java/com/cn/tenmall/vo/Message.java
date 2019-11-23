/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Message
 * Author:   Administrator
 * Date:     2019/11/23 12:03
 * Description: 返回状态
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.vo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回状态〉
 *
 * @author Administrator
 * @create 2019/11/23
 * @since 1.0.0
 */

import lombok.Data;

@Data
public class Message{
    private String code;
    private String message;

    public Message(){}
    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }
}