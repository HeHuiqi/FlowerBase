package com.hhq.hq.HqSpringDI;

import org.springframework.beans.factory.annotation.Autowired;

public class HqAutoHello {

    @Autowired
    private HqAutoSpeak spellChecker;

//    @Autowired
//    public void setSpellChecker( HqAutoSpeak spellChecker ){
//        this.spellChecker = spellChecker;
//    }
    public HqAutoSpeak getSpellChecker( ) {
        return spellChecker;
    }
    public void spellCheck() {
        System.out.println("1HqAutoHello-spellCheck" );

        spellChecker.checkSpelling();
    }
}
