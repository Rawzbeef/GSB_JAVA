import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.gsb.modele.ModeleBDD;


public class TestModeleBDD {
	
	private String mois;
	private String id;
	
	@Before
	public void setUp() throws Exception {
		mois = "201810";
		id = "a17";
	}

	@Test
	public void testConnexion() {
		assertEquals("La connexion a échoué.", true, ModeleBDD.connexionComptable("vgaspar", "1"));
	}
	
	@Test
	public void testGetFraisHorsForfait() {
		assertTrue("Aucun frais hors forfait", ModeleBDD.getLesFraisHorsForfaits(mois, id).size() > 0);
	}
	
	@Test
	public void testNbMois() {
		assertEquals("Le nombre de mois est incorrect", 2, ModeleBDD.getLesMois().size());
	}

}
