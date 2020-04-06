/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Racun;
import util.EdunovaException;

/**
 *
 * @author marko
 */
public class ObradaRacun extends Obrada<Racun>{

    
    
    
    
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
    public List<Racun> getPodaci() {
        return session.createQuery("from Racun").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
        
    }
    
}
