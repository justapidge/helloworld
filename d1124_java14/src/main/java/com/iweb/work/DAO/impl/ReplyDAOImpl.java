package com.iweb.work.DAO.impl;

import com.iweb.work.DAO.ReplyDAO;
import com.iweb.work.DBUtil;
import com.iweb.work.entity.Reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/24 16:12
 */
public class ReplyDAOImpl implements ReplyDAO {
    @Override
    public List<Reply> replyList(String receive) {
        List<Reply> responses = new ArrayList<>();
        String sql = "Select * from reply where receive = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,receive);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Reply reply = new Reply();
                reply.setId(rs.getInt("id"));
                reply.setResponse(rs.getString("response"));
                responses.add(reply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(responses.isEmpty()){
            sql = "select * from defaultreply";
            try (Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Reply reply = new Reply();
                    reply.setId(rs.getInt("id"));
                    reply.setResponse(rs.getString("response"));
                    responses.add(reply);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return responses;
    }
}
