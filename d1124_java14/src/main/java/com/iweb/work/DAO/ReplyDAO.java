package com.iweb.work.DAO;

import com.iweb.work.entity.Reply;

import java.util.List;

/**
 * @author wmn
 * @date 2023/11/24 16:08
 */
public interface ReplyDAO {
    /**从数据库获取对应的全部回复
     * @param receive 从用户处收到的消息
     * @return 对应消息的回复
     */
    List<Reply> replyList(String receive);
}
