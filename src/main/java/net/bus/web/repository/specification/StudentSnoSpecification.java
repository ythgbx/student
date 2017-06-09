package net.bus.web.repository.specification;

import net.bus.web.model.StudentExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/11/29.
 */
public class StudentSnoSpecification implements ISpecification<StudentExample> {

    private String college;

    private String profession;

    private String classname;

    private String name;

    public StudentSnoSpecification(String college, String profession, String classname,String name) {
        this.college = college;
        this.profession = profession;
        this.classname = classname;
        this.name = name;
    }

    /**
     * 多条件查询
     * @return 返回查询条件的集合类
     */

    public StudentExample createExample() {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentCri = studentExample.createCriteria();
        if (this.classname!=null){
            studentCri.andClassnameEqualTo(classname);
        }
        if (this.college!=null){
            studentCri.andCollegeEqualTo(college);
        }
        if (this.profession!=null){
            studentCri.andProfessionEqualTo(profession);
        }
        if (this.name!=null){
            studentCri.andSnameEqualTo(name);
        }
        return studentExample;
    }


}
