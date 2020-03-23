/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Zaposlenik;
import util.EdunovaException;
import util.Pomocno;

/**
 *
 * @author marko
 */
public class ObradaZaposlenik extends Obrada<Zaposlenik>{

    public ObradaZaposlenik(Zaposlenik entitet) {
        super(entitet);
    }

    public ObradaZaposlenik() {
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
    
    private void kontrolaOib() throws EdunovaException{
        if(!Pomocno.isOibValjan(entitet.getOib())){
            throw new EdunovaException("OIB nije valjan");
        }
    }
    

    @Override
    public List<Zaposlenik> getPodaci() {
        return session.createQuery("from Zaposlenik").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
        
    }
    
     protected void kontrolaEmail()  throws EdunovaException{
       
    }
    
}
