package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FacadeQuizApplication;
import view.QuizOverviewView;

public class QuizCatalogusController {
	private QuizOverviewView theView;
	private FacadeQuizApplication theModel;
	
	public QuizCatalogusController(QuizOverviewView theView,FacadeQuizApplication theModel){
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.retrieveDataListener(new RetrieveListener());
	}
	class RetrieveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
}
