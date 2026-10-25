package Polynomial;

import java.util.ArrayList;

public class Polynomial {
	ArrayList<Mononomial> arr=new ArrayList<Mononomial>();

	public Polynomial() {
	}
	public Polynomial(String equation) {
		StringSeparation(equation);
	}	
	public void StringSeparation(String equation) {
		ArrayList <String> newExArr1=new ArrayList<String>();
		StringBuilder str=null;
		equation=equation.replace(" ", "");
		boolean triger=false;
		if (equation.charAt(0)=='-') {
			triger=true;
			str=new StringBuilder(equation);
			str.setCharAt(0, ' ');
			equation=str.toString();
		}
		
		equation=equation.replace(" ", "");
		equation=equation.replace("+", "+$");
		equation=equation.replace("-", "-#");
		String exArr1[]=equation.split("\\+|-");
			
		for (int i=0; i<exArr1.length;i++) {
			exArr1[i]=exArr1[i].replace("$", "+");
			exArr1[i]=exArr1[i].replace("#", "-");
		}
		if (triger) {
			exArr1[0]="-"+exArr1[0];
		}
		for (int i=0; i<exArr1.length;i++)
		newExArr1.add(i,exArr1[i]);
		
		for (int i=0 ; i<newExArr1.size();i++){
			if (!newExArr1.get(i).contains("x")) {
				newExArr1.set(i, newExArr1.get(i) + "x^0");
			}
			if ((!newExArr1.get(i).contains("^")) && (newExArr1.get(i).contains("x"))){
				newExArr1.set(i, newExArr1.get(i) + "^1");
			}
		}
		exArr1=new String[newExArr1.size()];
		for (int i=0; i<newExArr1.size(); i++)
			exArr1[i]=newExArr1.get(i);
		String exArr2[];
		for (String item : exArr1) {
			Mononomial object=new Mononomial();
			exArr2=item.split("x\\^");
			if (exArr2[0].equals("") || exArr2[0].equals("+"))
				exArr2[0]="1";
			else if(exArr2[0].equals("-"))
				exArr2[0]="-1";
			object.coeff=Double.parseDouble(exArr2[0]);
			object.power=Double.parseDouble(exArr2[1]);
			arr.add(object);
		}
	}
	
	public Polynomial subtraction(Polynomial otherPoly) {
		Polynomial otherpoly=new Polynomial();
		for (Mononomial m: otherPoly.arr) {
			Mononomial copy=new Mononomial();
			copy.coeff=m.coeff*-1;
			copy.power=m.power;
			otherpoly.arr.add(copy);
		}
		Polynomial p=new Polynomial();
		p=this.addition(otherpoly);
		return p;
	}
	
	public Polynomial addition(Polynomial otherPoly) {
		ArrayList<Mononomial> newArr=new ArrayList<Mononomial>();
		for (Mononomial p: arr)
			newArr.add(p);
		for (Mononomial p:otherPoly.arr)
			newArr.add(p);
		Polynomial p=new Polynomial();
		p= additionFunction(newArr);
		for (int i=p.arr.size()-1; i>=0;i--) {
			if (p.arr.get(i).coeff==0)
				p.arr.remove(i);
		}
		return p;
	}

	public Polynomial additionFunction(ArrayList<Mononomial> newArr) {
		for (int i=0 ; i<newArr.size() ; i++) {
			for (int j=newArr.size()-1; j>i ; j--) {
				if (newArr.get(i).power==newArr.get(j).power) {
					newArr.get(i).coeff=newArr.get(i).coeff+newArr.get(j).coeff;
					newArr.remove(j);
				}
			}
		}
		newArr=sortByPower(newArr);
		arr=newArr;
		return this;
	}
	
	public ArrayList<Mononomial> sortByPower(ArrayList<Mononomial> arr2) {
		for (int i=0;i<arr2.size();i++) {
			for (int j=i+1;j<arr2.size();j++) {
				if (arr2.get(i).power<arr2.get(j).power) {
					Mononomial temp=arr2.get(i);
					arr2.set(i, arr2.get(j));
					arr2.set(j, temp);
				}
			}
		}
		return arr2;
	}
	
	public Polynomial multiply(Polynomial otherPoly) {
		ArrayList <Mononomial> newArr=new ArrayList<Mononomial>();
		for (int i=0; i<arr.size();i++) {
			for (int j=0; j<otherPoly.arr.size();j++) {
				Mononomial mono=new Mononomial();
				mono.coeff=arr.get(i).coeff*otherPoly.arr.get(j).coeff;
				mono.power=arr.get(i).power+otherPoly.arr.get(j).power;
				newArr.add(mono);
			}
		}
		Polynomial p=new Polynomial();
		p=additionFunction(newArr);
		for (int i=p.arr.size()-1; i>=0;i--) {
			if (p.arr.get(i).coeff==0)
				p.arr.remove(i);
		}

		return p;
	}

	public Polynomial division(Polynomial otherPoly) {
		ArrayList <Mononomial> quotient=new ArrayList<Mononomial>();
		this.arr=sortByPower(this.arr);
		otherPoly.arr=sortByPower(otherPoly.arr);
		if (this.arr.get(0).power<otherPoly.arr.get(0).power) {
			System.out.println("quotient = 0");
			return this;
		}
		
		else {
			int i=0;
			menuloop:while (true) {
				if (arr.size()!=0) {
			if (arr.get(0).power<otherPoly.arr.get(0).power) {
				break menuloop;
			}
				}
				if (arr.size()==0) {
					Mononomial p=new Mononomial();
					p.coeff=0;
					p.power=0;
					arr.add(p);
					break menuloop;
				}
				Mononomial m=new Mononomial();
				m.coeff=arr.get(0).coeff/otherPoly.arr.get(0).coeff;
				m.power=arr.get(0).power-otherPoly.arr.get(0).power;
				quotient.add(m);
				Polynomial T=new Polynomial();
				T.arr.add(quotient.get(i));
				T=T.multiply(otherPoly);
				T=this.subtraction(T);
				arr=T.arr;
				/*if (arr.get(0).coeff==0) {
					arr.get(0).power=0;
					if (arr.get(0).coeff==0 && arr.get(0).power==0 && arr.size()!=0) {
						arr.remove(0);
					}
				}*/
				i++;
			}			
		}
		for (int j=quotient.size()-1; j>=0;j--) {
			if (quotient.get(j).coeff==0)
				quotient.remove(j);
		}
		System.out.println("Quotient is: " + quotient);
		
		return this;
	}
	
	public double evaluate(double x) {
		double sum=0;
		for (Mononomial p: arr)
			sum+=p.coeff* Math.pow(x, p.power);
		return sum;
	}
	
	@Override
	public String toString() {
		String res="";
		for (Mononomial m:arr) {
			res+=m;
		}
		return res;
	}	
}
	
	