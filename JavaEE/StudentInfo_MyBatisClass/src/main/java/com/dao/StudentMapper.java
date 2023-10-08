package com.dao;

import com.poji.Clas;
import com.poji.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Select("select * from s_student where id = #{id}")
    Student selectStudent(int id);

    @Update("update s_student set name=#{name},age=#{age} where id = #{id}")
    int updateStudent(Student student);

    @Select("select * from s_student where cid = #{id}")
    List<Student> find2(Clas clas);

    @Select("select * from s_student where cid=#{id} ")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "classname",property = "classname")
    })
    List<Student> selectStudentByCid(int cid);

}
