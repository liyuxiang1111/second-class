package com.example.demo.Mapper;

import com.example.demo.model.UserApply;
import com.example.demo.model.UserApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserApplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    long countByExample(UserApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int deleteByExample(UserApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int deleteByPrimaryKey(Long uapId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int insert(UserApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int insertSelective(UserApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    List<UserApply> selectByExample(UserApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    UserApply selectByPrimaryKey(Long uapId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int updateByExampleSelective(@Param("record") UserApply record, @Param("example") UserApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int updateByExample(@Param("record") UserApply record, @Param("example") UserApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int updateByPrimaryKeySelective(UserApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_apply
     *
     * @mbg.generated Thu Sep 12 16:59:01 CST 2024
     */
    int updateByPrimaryKey(UserApply record);
}