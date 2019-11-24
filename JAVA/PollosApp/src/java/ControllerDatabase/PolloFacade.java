/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDatabase;

import Entitys.Pollo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class PolloFacade extends AbstractFacade<Pollo> {

    @PersistenceContext(unitName = "PollosAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PolloFacade() {
        super(Pollo.class);
    }
    
}
