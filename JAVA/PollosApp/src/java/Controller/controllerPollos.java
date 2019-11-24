/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ControllerDatabase.PolloFacade;
import Entitys.Pollo;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Dell
 */
@ViewScoped
@ManagedBean
public class controllerPollos implements Serializable{
    @EJB
    PolloFacade controllerPollo;
    
    private List<Pollo> pollo;
    private float gramo;
    private float libra;
    private float pesoPollos;
    private int total;
    private int prePollo;
    private String nomCli;
    private String estado;
    
    public static Pollo polloEditado;

    public List<Pollo> getPollo() {
        return pollo;
    }

    public void setPollo(List<Pollo> pollo) {
        this.pollo = pollo;
    }

    public float getGramo() {
        return gramo;
    }

    public void setGramo(float gramo) {
        this.gramo = gramo;
    }

    public float getLibra() {
        return libra;
    }

    public void setLibra(float libra) {
        this.libra = libra;
    }

    public float getPesoPollos() {
        return pesoPollos;
    }

    public void setPesoPollos(float pesoPollos) {
        this.pesoPollos = pesoPollos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrePollo() {
        return prePollo;
    }

    public void setPrePollo(int prePollo) {
        this.prePollo = prePollo;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void calcular(){
        DecimalFormat formato1 = new DecimalFormat("#.00");
        setGramo(gramo);
        setLibra(getGramo() / 500);
        setTotal((int) (getLibra() * 3800));
        System.out.println("libras: " + getLibra());
        System.out.println("TOTAL: " + getTotal());
    }
    public void create(){
        try {
            Pollo obj =  new Pollo();
            
            setGramo(gramo);
            obj.setNomCli(nomCli);
            obj.setPesoPollo(getGramo() / 500);
            obj.setPrePollo((int) (obj.getPesoPollo() * 3800));
            obj.setEstado(estado);
            controllerPollo.create(obj);
            System.out.println("CREADO");
        } catch (Exception e) {
        }
    }
    public void list(){
        pollo = controllerPollo.findAll();
    }
    
    public void remove(Pollo temp){
        controllerPollo.remove(temp);
        System.out.println("borrado");
    }
    
    public String verDatosEditados(Pollo obj){
        setPolloEditado(obj);
        System.out.println("----->" + this.polloEditado);
        return "pollosEdit.xhtml";
    }
        public void verDatosEditar() throws IOException {
        //redireccion
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        System.out.println("aaaaaaaaa");
        System.out.println("2--->" + this.polloEditado);
        controllerPollo.edit(this.polloEditado);
        ctx.redirect(ctxPath + "/faces/Pollos/listPollos.xhtml");

    }
    
    
    
    public String llamarList(){
        return "./Pollos/listPollos.xhtml";
    }
      public String llamarIndex(){
        return "../index.xhtml";
    }

    public Pollo getPolloEditado() {
        return polloEditado;
    }

    public void setPolloEditado(Pollo polloEditado) {
        this.polloEditado = polloEditado;
    }
}
