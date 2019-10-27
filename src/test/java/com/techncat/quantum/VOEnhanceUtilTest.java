package com.techncat.quantum;

import com.techncat.quantum.app.common.VOEnhanceUtil;
import com.techncat.quantum.app.common.vo.EnhancedVO;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeoplePostdoctoral;
import com.techncat.quantum.app.vos.people.PeoplePostdoctoralVO;
import com.techncat.quantum.app.vos.people.PeopleVO;

import java.util.Date;
import java.util.List;

public class VOEnhanceUtilTest {
    public static void main(String[] args) throws IllegalAccessException {
        VOEnhanceUtil util = new VOEnhanceUtil();
        People people = new People();
        people.setBirthDate(new Date());
        people.setEmail("11510000@mail.sustech.edu.cn");
        people.setGender(People.Gender.female);
        people.setId(001l);

        PeoplePostdoctoral peoplePostdoctoral = new PeoplePostdoctoral();

        PeopleVO peopleVO = new PeopleVO(people);
        PeoplePostdoctoralVO peoplePostdoctoralVO = new PeoplePostdoctoralVO(people, peoplePostdoctoral);

        List<EnhancedVO> vos = util.enhance(peopleVO);
        pr(vos);
        System.out.println("---------------");
        System.out.println(peopleVO);


        System.out.println("---------------");
        List<EnhancedVO> vos_update = util.enhance(peoplePostdoctoralVO);
        pr(vos_update);
        System.out.println("---------------");
        System.out.println(peoplePostdoctoralVO);

    }

    private static void pr(List<EnhancedVO> voList) {
        for (EnhancedVO vo: voList) {
            System.out.println(vo);
        }
    }
}
