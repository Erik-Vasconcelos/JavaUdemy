
module sg.matricula {
	requires java.sql;
	requires org.junit.jupiter.api;
	
	exports br.com.marttech.sg.matricula
		to sg.aplicacao, sg.application;
}