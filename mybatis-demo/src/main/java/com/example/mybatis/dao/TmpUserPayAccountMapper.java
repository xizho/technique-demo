package com.example.mybatis.dao;

import com.example.mybatis.model.TmpUserPayAccount;

import java.util.List;

public interface TmpUserPayAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmp_user_pay_account
     *
     * @mbg.generated
     */
    int insert(TmpUserPayAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tmp_user_pay_account
     *
     * @mbg.generated
     */
    List<TmpUserPayAccount> selectAll();
}