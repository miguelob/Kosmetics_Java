package icai.dtc.isw.domain;

import java.util.HashMap;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


public class Survey {
	
	private HashMap<Question,int[]> survey;
    
	public Survey(){
    	this.survey = new HashMap<Question,int[]>();
	}
	
	public void put(Question question ,int yes,int no,int yesNo) {
		int[] puntuation=new int[3];
		puntuation[0]=yes;
		puntuation[0]=no;
		puntuation[0]=yesNo;
		
		survey.put(question, puntuation );

	}
	
	
	public Collection<Question> getQuestions() {
		/*Set<String> questions = new HashSet<String>();
		Iterator it = survey.keySet().iterator();
        
		while(it.hasNext())
        {
            Set question = (Set) it.next();
            questions.add(question[config]);
        }
		
		return questions;*/
		
		/*Set<String> questions = new HashSet<String>();
		
		for(HashMap<String,String> it: survey.keySet()) {
			if (config==0)
				questions.add(it.keySet().toArray()[0]);
			elsif(config==1)
				return survey.keySet().getValue();
		}
			
		else
			System.out.print("Valor de configuraci�n invalido.");
			
			*/
		return survey.keySet();
	}
	
	public String getAnswer(Question question) {
		int[] puntuation=survey.get(question);
		
		if (puntuation[0]>=puntuation[1])
			return "yes";
		else
			return "no";
	}
	
	public int[] getResult(Question question) {
		int[] puntuation=survey.get(question);
		int numParticipants=0;
		int results[]=new int[3];
		
		for(int i=0;i<puntuation.length;i++) {
			numParticipants=puntuation[i]+numParticipants;
		}
		
		for(int i=0;i<puntuation.length;i++) {
			results[i]=puntuation[i]/numParticipants*100;
		}
		
		return results;
	}
}
