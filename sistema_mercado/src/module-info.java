module sistema_mercado {
	
	//HIBERNATE package opening requirement for Reflection
	requires java.persistence;
	requires java.sql;
	requires org.hibernate.orm.core;
	
	opens br.com.ifrn.portal.sm.models.entities;
	
	//JAVAFX package opening requirement for Reflection
	requires javafx.controls;
	requires javafx.fxml;
	
	opens br.com.ifrn.portal.sm.views to javafx.graphics, javafx.fxml;
	opens br.com.ifrn.portal.sm.controllers to javafx.graphics, javafx.fxml;
}
