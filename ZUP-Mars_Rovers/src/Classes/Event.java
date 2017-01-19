package Classes;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

//Essa classe tem como objetivo delegar uma sequencia de comandos quando ocorrer um evento
import View.View;

public class Event {
	
	private View view;
	
	public Event(View view){
		setView(view);
	}

	public void Action(){
		getView().UpdateScene();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private View getView() {
		return view;
	}

	private void setView(View view) {
		this.view = view;
	}
}
