package org.sample.springmvc.extra;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiRecord {
    @Autowired SqlSessionFactory sqlSessionFactory;
    
    @RequestMapping("/list")
    public ModelAndView execute() {
        
        ModelAndView mav = new ModelAndView("list");
        
        // 引数なしのopenSession()はauto-commitがfalse
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(session.getConfiguration().getDatabaseId());
        
        SqlMapper mapper = session.getMapper(SqlMapper.class);
        
        List<TestTable> list = mapper.selectTestTables(1, "false", "a");
        mav.addObject("data", list);
        
        return mav;
    }

}
