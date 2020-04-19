/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.ObradaOperater;
import controller.ObradaPice;
import controller.ObradaRacun;
import controller.ObradaStavka;
import controller.ObradaZaposlenik;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import model.Operater;
import model.Pice;
import model.Racun;
import model.Stavka;
import model.Zaposlenik;
import net.bytebuddy.description.type.TypeDescription;
import org.mindrot.jbcrypt.BCrypt;
import view.ViewZaposlenik;

/**
 *
 * @author marko
 */
public class Pomocno {
    
    public static Operater LOGIRAN;
    
    public final static DecimalFormat df=df();
    
    public static String getNazivAplikacije(){
        return "Caffe Bar Application";
    }
    
    public static void pocetniInsert(){
        
        
        Operater o = new Operater();
        o.setEmail("marko.grbes1@gmail.com");
        o.setIme("Marko");
        o.setPrezime("Grbes");
        o.setLozinka(BCrypt.hashpw("m", BCrypt.gensalt()));
        
        
        ObradaOperater obradaOperater = new ObradaOperater(o);
        try {
            obradaOperater.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        Zaposlenik z=new Zaposlenik();
        z.setIme("Josip");
        z.setPrezime("Raguz");
        z.setOib("59273583375");
        z.setEmail("jraguz@gmail.com");
        z.setBrojUgovora("255");
        
        
        ObradaZaposlenik oz= new ObradaZaposlenik(z);
        try {
            oz.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Pice p=new Pice();
        p.setNaziv("Pan");
        p.setCijena(new BigDecimal(10));
        p.setKolicina(4);
        p.setVrsta("Pivo");
        
        ObradaPice obradaPice=new ObradaPice(p);
        
        try {
            obradaPice.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Pice p1=new Pice();
        p1.setNaziv("Jack Daniels");
        p1.setCijena(new BigDecimal(12));
        p1.setKolicina(4);
        p1.setVrsta("Strana Žesta");
        
        ObradaPice obradaPice1=new ObradaPice(p1);
        
        try {
            obradaPice1.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        Pice p2=new Pice();
        p2.setNaziv("Čaj od šumskog voća");
        p2.setCijena(new BigDecimal(6));
        p2.setKolicina(4);
        p2.setVrsta("Čaj");
        
        ObradaPice obradaPice2=new ObradaPice(p2);
        
        try {
            obradaPice2.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Pice p3=new Pice();
        p3.setNaziv("Medica");
        p3.setCijena(new BigDecimal(8));
        p3.setKolicina(4);
        p3.setVrsta("Domaća Žesta");
        
        ObradaPice obradaPice3=new ObradaPice(p3);
        
        try {
            obradaPice3.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        Racun racun=new Racun();
        racun.setBrojRacuna(1);
        racun.setDatVrijeme(new Date());
        racun.setPdv(25);
        racun.setZaposlenik(z);
        
        ObradaRacun obradaRacun=new ObradaRacun();
        obradaRacun.setEntitet(racun);
        
        try {
            obradaRacun.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Stavka stavka=new Stavka();
        stavka.setPice(p);
        stavka.setPice(p2);
        
        
        ObradaStavka obradaStavka=new ObradaStavka();
        obradaStavka.setEntitet(stavka);
        try {
            obradaStavka.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
    }
    
    public static boolean isOibValjan(String oib) {
        
        if(oib==null){
            return false;
        }
            
            

        if (oib.length() != 11)
            return false;

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i+1));
            a = a % 10;
            if (a == 0)
                a = 10;
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10)
            kontrolni = 0;

        return kontrolni == Integer.parseInt(oib.substring(10));
    }
    
     private static DecimalFormat df(){
        NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr","HR"));
         DecimalFormat dfl = (DecimalFormat) nf;
         dfl.applyPattern("#,###.00");
    return dfl;
    }
     
      public static String getGenOIB() {
        
        try{
        URL u = new URL("http://oib.itcentrala.com/oib-generator/");
        InputStream in = u.openStream();
            String s = new String(in.readAllBytes(), 
                    StandardCharsets.UTF_8);
           // System.out.println(s);
            int pocIndex=s.indexOf("<div class=\"oib\"><span>HR</span>")+32;
            // Napredniji rad s html je HTMLCleaner (maven) i pojam xpath
            return s.substring(pocIndex,pocIndex+11);
        }catch(Exception e){
            return "";
        }
        
    }
      
      public static ViewZaposlenik.Osoba getgenIP() {
        try {
            Gson gson = new Gson(); 
        Type userListType = new TypeToken<ArrayList<ViewZaposlenik.Osoba>>(){}.getType();
        URL url = new URL("https://vit.hr/GIP/API/1/json/prvaSlovaVelika");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        List<ViewZaposlenik.Osoba> lista=gson.fromJson(reader, userListType);;
        return lista.get(0);
         } 
        catch (Exception e) {
            return null;
        }
        
    }

      public static String getFormatCijelogBroja(long i){
        //https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
      
      
      public static int getCijeliBrojIzStringa(String s){
         try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
      
       public static String getFormatDecimalniBroj(BigDecimal b){
       
        return df.format(b);
    }
    
        public static BigDecimal getDecimalniBrojIzStringa(String s){
        try {
            return new BigDecimal(df.parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
           
    }
        
         public static void dodajZaposlenika(int ukupno){
             ObradaZaposlenik oz=new ObradaZaposlenik();
             Zaposlenik z;
             ViewZaposlenik.Osoba o;
        for(int i=0;i<ukupno;i++){
            z= new Zaposlenik();
            o=getgenIP();
            z.setIme(o.getIme());
            z.setPrezime(o.getPrezime());
            z.setOib(getGenOIB());
            try {
                oz.setEntitet(z);
                oz.create();
            } catch (Exception e) {
            }
        }
    }
       
}
