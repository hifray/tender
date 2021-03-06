package com.woostar.tender.mapper;

import com.woostar.tender.model.ProjectDetail;
import com.woostar.tender.model.example.ProjectDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IProjectDetailMapper extends IBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    long countByExample(ProjectDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int deleteByExample(ProjectDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int insert(ProjectDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int insertSelective(ProjectDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    List<ProjectDetail> selectByExample(ProjectDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    ProjectDetail selectByPrimaryKey(String projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ProjectDetail record, @Param("example") ProjectDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ProjectDetail record, @Param("example") ProjectDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ProjectDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tender_project_detail
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProjectDetail record);
}