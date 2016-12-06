package net.bus.web.repository;

import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.mapper.PoorBuildMapper;
import net.bus.web.model.PoorBuild;
import net.bus.web.model.PoorBuildExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/12/6.
 */
@Repository
public class PoorBuildRespositiory {
    @Autowired
    private PoorBuildMapper poorBuildMapper;

    public List<PoorBuild> getAllUsers() {
        PoorBuildExample example = new PoorBuildExample();
        return poorBuildMapper.selectByExample(example);
    }

    public List<PoorBuild> getAllStudents(int page,int limit) {
        PoorBuildExample example = new PoorBuildExample();
        return poorBuildMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<PoorBuild> getAllStudentsByExample(ISpecification specification,int page,int limit) {
        return poorBuildMapper.selectByExampleWithRowbounds((PoorBuildExample)specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<PoorBuild> getItems(ISpecification specification) {
        PoorBuildExample example = (PoorBuildExample)specification.createExample();
        if(example==null)
            return new ArrayList<PoorBuild>();

        List<PoorBuild> list= poorBuildMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<PoorBuild>();
    }


    public PoorBuild getStudent(ISpecification specification)
    {
        List<PoorBuild> list= poorBuildMapper.selectByExample((PoorBuildExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public PoorBuild getStudent(String sno) {
        return poorBuildMapper.selectByPrimaryKey(sno);
    }

    public int insertStudent(PoorBuildDto poorBuildDto)
    {
        PoorBuild poorBuild = new PoorBuild();
        poorBuild.setId(poorBuildDto.getId());
        poorBuild.setApplicationdate(poorBuildDto.getApplicationDate());
        poorBuild.setInsurance(poorBuildDto.getInsurance());
        poorBuild.setCode(poorBuildDto.getCode());
        poorBuild.setEconomicsources(poorBuildDto.getEconomicsources());
        poorBuild.setFamilyincome(poorBuildDto.getFamilyincome());
        poorBuild.setIsloan(poorBuildDto.getIsloan());
        poorBuild.setFworkplace(poorBuildDto.getFworkplace());
        poorBuild.setFearning(poorBuildDto.getFearning());
        poorBuild.setMworkplace(poorBuildDto.getMworkplace());
        poorBuild.setMearning(poorBuildDto.getMearning());
        poorBuild.setPopulation(poorBuildDto.getPopulation());
        poorBuild.setApplication(poorBuildDto.getApplication());
        poorBuild.setPoorprove(poorBuildDto.getPoorprove());
        poorBuild.setRetireprove(poorBuildDto.getRetireprove());
        poorBuild.setDeformityprove(poorBuildDto.getDeformityprove());
        poorBuild.setEfficiencyprove(poorBuildDto.getEfficiencyprove());
        poorBuild.setConditionprove(poorBuildDto.getConditionprove());
        poorBuild.setAwardsprove(poorBuildDto.getAwardsprove());
        poorBuild.setTappraisal(poorBuildDto.getTappraisal());
        poorBuild.setTsign(poorBuildDto.getTsign());
        poorBuild.setTsigndate(poorBuildDto.getTsigndate());
        poorBuild.setDgrades(poorBuildDto.getDgrades());
        poorBuild.setDsign(poorBuildDto.getDsign());
        poorBuild.setDsigndate(poorBuildDto.getDsigndate());
        poorBuild.setSgrades(poorBuildDto.getSgrades());
        poorBuild.setSsign(poorBuildDto.getSsign());
        poorBuild.setSsigndate(poorBuildDto.getSsigndate());
        poorBuild.setTreviewed(poorBuildDto.getTreviewed());
        poorBuild.setDreviewed(poorBuildDto.getDreviewed());
        poorBuild.setSreviewed(poorBuildDto.getSreviewed());
        poorBuild.setM1(poorBuildDto.getM1());
        poorBuild.setM1name(poorBuildDto.getM1name());
        poorBuild.setM1workplace(poorBuildDto.getM1workplace());
        poorBuild.setM1earning(poorBuildDto.getM1earning());
        poorBuild.setM2(poorBuildDto.getM2());
        poorBuild.setM2name(poorBuildDto.getM2name());
        poorBuild.setM2wordpress(poorBuildDto.getM2wordpress());
        poorBuild.setM2earning(poorBuildDto.getM2earning());
        poorBuild.setM3(poorBuildDto.getM3());
        poorBuild.setM3name(poorBuildDto.getM3name());
        poorBuild.setM3wordpress(poorBuildDto.getM3wordpress());
        poorBuild.setM3earning(poorBuildDto.getM3earning());
        return poorBuildMapper.insert(poorBuild);
    }

    public int updateStudent(PoorBuild student)
    {
        return poorBuildMapper.updateByPrimaryKey(student);
    }

    public int Count(){
        return poorBuildMapper.countByExample(null);
    }

    public int CountByExample(ISpecification specification){
        return poorBuildMapper.countByExample((PoorBuildExample)specification.createExample());
    }

    public int deleteByPrimaryKey(String sno){
        return  poorBuildMapper.deleteByPrimaryKey(sno);
    }

    public int deleteByExample(ISpecification specification){
        return  poorBuildMapper.deleteByExample((PoorBuildExample) specification.createExample());
    }
}
