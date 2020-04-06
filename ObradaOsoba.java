/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Osoba;
import util.EdunovaException;
import util.Pomocno;

/**
 *
 * @author marko
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T>{
    
    public ObradaOsoba(T entitet) {
        super(entitet);
    }  

    public ObradaOsoba() {
        super();
    }
    
    

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaOib();
        kontrolaEmail();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    private void kontrolaOib() throws EdunovaException{
        if(!Pomocno.isOibValjan(entitet.getOib())){
            throw new EdunovaException("OIB nije valjan");
        }
    }

    protected void kontrolaEmail()  throws EdunovaException{
       
    }

    
    
}
