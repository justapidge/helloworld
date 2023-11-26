package com.iweb.DAO;

import com.iweb.entity.Grade;

import java.util.List;

/**
 * @author wmn
 * @date 2023/11/15 18:26
 */
public interface GradeDAO {
    /** 根据学生的id获取成绩
     * @param sid 学生id
     * @return id对应的学生的成绩
     */
    List<Grade> listBySid(Integer sid);

}
