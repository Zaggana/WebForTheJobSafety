package com.safetyjoblet.joblet;

import java.util.List;

import com.safetyjoblet.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;
import org.web4thejob.joblet.base.AbstractORMTest;

/**
 * <p>
 * Type your tests here.
 * <p>
 * Switch to the <strong>example</strong> branch or visit <a href=
 * "https://github.com/web4thejob/joblet-builder/blob/example/src/test/java/org/web4thejob/joblet/ORMTest.java"
 * >github</a> for an example.
 */
public class ORMTestJava extends AbstractORMTest {

	@Test
	public void test1() {
		//Create a Managing Company
		ManagingCompanies managingCompany = new ManagingCompanies();
		managingCompany.setAssetName("ManagingCompany4");
		managingCompany.setMngcImoNumber("1231");

		//Create an Owning Company
		OwnerCompanies ownCompany = new OwnerCompanies();
		ownCompany.setOwncDesc("owncCompany1");
		ownCompany.setManagingCompanies(managingCompany);
		
		//Create a Vessel Type
		VesselTypes vessType = new VesselTypes();
		vessType.setVstpDesc("VesselType");
		
		//Create a Vessel
		Vessels vessel = new Vessels();
		vessel.setAssetName("vessel");
		vessel.setVessImoNumber("vessImoNumberr");
		vessel.setOwnerCompanies(ownCompany);
		vessel.setVesselTypes(vessType);
		
		// Type your test here.
	    SessionFactory sessionFactory;
        ServiceRegistry serviceRegistry;

        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        List<ManagingCompanies> list = session.createQuery("from "+ ManagingCompanies.class.getName() +" c where c.assetCode = 18").list(); // here should be something else than list()
        ManagingCompanies value= (list.isEmpty() ? null : list.get(0));  
        String a= value.getManagingCompaniesLastPerformance().toString();
        session.beginTransaction();
        session.save(managingCompany);
        session.save(ownCompany);
        session.save(vessType);
        session.save(vessel);
        
        
        session.getTransaction().commit();
		
      
		  session.close();
		 
	}

}