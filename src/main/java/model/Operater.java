/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author marko
 */
@Entity
@Table(name = "operater")
public class Operater extends Zaposlenik{
    
    private String lozinka;
    
    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}