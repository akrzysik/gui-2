import java.util.ArrayList;

public class ListaStanow  {
	private int indeks;
  ArrayList<Stan> stany;
	
	/**
	 * @param data
	 * @param tekst
	 */
	public ListaStanow(Stan stan) {
    this.indeks = 1;
    ArrayList<Stan> s = new ArrayList<Stan>();
		s.add(stan);
    this.stany = s;
	}

  public void change(Stan stan) {
    if (this.indeks == this.stany.size()) {
      this.stany.add(stan);
    }
    else 
    {
      // zresetuj dalsze akcje "ponow"
      // jezeli nowa edycja po cofnięciu
      ArrayList<Stan> nowa = new ArrayList<Stan>();
      for (int i = 0; i <= this.indeks; i++) {
        nowa.add(this.stany.get(i));
      }
      nowa.add(stan);
      this.stany = nowa;
    }
    this.indeks++;
  }

  public String undo() {
    if (this.indeks > 0) {
      this.indeks--;
    }
    return this.stany.get(this.indeks).getTekst();
  }

  public String redo() {
    if (this.indeks < this.stany.size() - 1) {
      this.indeks++;
    }
    return this.stany.get(this.indeks).getTekst();
  }

	@Override
	public String toString() {
    String sum = "";
    for (Stan s: this.stany) {  
      sum += s.toString() + "\n";
    }	
    return sum;
	}
	
}
