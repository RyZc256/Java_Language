package com.dao;

import com.poji.Clas;
import com.poji.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassMapper {
    @Select("select * from c_class where classname = #{name}")
    Clas selectClass(String name);

    @Select("select * from c_class where id=#{id} ")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "classname", property = "classname"),
            @Result(column = "id", property = "studentList",
                    many = @Many(select =
                            "com.dao.StudentMapper.selectStudentByCid"))})
    Clas selectClassById(int id);
}
