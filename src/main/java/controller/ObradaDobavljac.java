/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Dobavljac;
import util.EdunovaException;

/**
 *
 * @author marko
 */
public class ObradaDobavljac extends Obrada<Dobavljac>{

    public ObradaDobavljac(Dobavljac entitet) {
        super(entitet);
    }

    public ObradaDobavljac() {
        super();
    }

    
    
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
      
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    @Override
    public List<Dobavljac> getPodaci() {
       return session.createQuery("from Dobavljac").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
       
    }
    
}
