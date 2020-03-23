/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Pice;
import util.EdunovaException;

/**
 *
 * @author marko
 */
public class ObradaPice extends Obrada<Pice>{

    public ObradaPice(Pice entitet) {
        super(entitet);
    }

    public ObradaPice() {
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
    public List<Pice> getPodaci() {
        return session.createQuery("from Pice").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
        
    }
    
}
