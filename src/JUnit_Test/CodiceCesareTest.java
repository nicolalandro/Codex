package JUnit_Test;

import org.junit.*;

import Util.CifrarioCesare;

public class CodiceCesareTest {
	private CifrarioCesare cifrario;
	@Before
	public void init(){
		cifrario = new CifrarioCesare();
	}
	
	@Test
	public void firstTest(){
		assert(cifrario!=null);
	}
	@Test
	public void cifraEdecifra(){
		String s = "stringa di prova";
		assert (s.equals(cifrario.deCript(cifrario.cript(s))));
	}
}
