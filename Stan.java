import java.util.Date;
import java.text.SimpleDateFormat;

public class Stan  {
	private Date data;
	private String tekst;
	
	/**
	 * @param data
	 * @param tekst
	 */
	public Stan(String tekst) {
		this.data = new Date(System.currentTimeMillis());
		this.tekst = tekst;
	}
	
	/**
	 * @return the autor
	 */
	public String getTekst() {
		return this.tekst;
	}

	@Override
	public String toString() {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		return 
    sdf1.format(data) + " " + tekst;
	}
	
}
