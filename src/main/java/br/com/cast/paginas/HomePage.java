package br.com.cast.paginas;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.SetModel;

import br.com.cast.service.DistanciaService;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 6549174137742813178L;
	private Label distanciaLabel;
	private DistanciaService service = new DistanciaService();
	
	public HomePage(){
	
		
		distanciaLabel = new Label("distancia");
		//distanciaLabel.setDefaultModel(Model.of(service.calcularDistanciaKm()));
		add(distanciaLabel);
		
	}
}
