import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.gsb.vue.VueMessage;


public class TestVueMessage {

	private VueMessage vue; 
	
	@Before
	public void setUp() throws Exception {
		this.vue = new VueMessage();
	}

	@Test
	public void testAddLabel() {
		Assert.assertEquals(this.vue.getText(), "<html>");
	}

}
